package blazon.shared.shield.tinctures;

import static blazon.shared.shield.tinctures.IsSameTinctureAs.sameTinctureAs;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

public class IsSameTincturesAs extends TypeSafeMatcher<Tinctures> {

	private Tinctures t1;
	
	@Override
	public void describeTo(Description desc) {
		desc.appendText("same tinctures as");
	}

	@Override
	public boolean matchesSafely(Tinctures t2) {
		Iterator<Tincture> iterator1 = t1.getTincturesOnLayer().iterator();
		Iterator<Tincture> iterator2 = t2.getTincturesOnLayer().iterator();
		
		if (iterator1.hasNext() ^ iterator2.hasNext()) {
			return false;
		}
		
		while (iterator1.hasNext() && iterator2.hasNext()) {
			Tincture tincture1 = iterator1.next();
			Tincture tincture2 = iterator2.next();
			assertThat(tincture1, is(sameTinctureAs(tincture2)));
			if (iterator1.hasNext() ^ iterator2.hasNext()) {
				return false;
			}
		}
		
		return true;
	}
	
	@Factory
	public static <T> Matcher<Tinctures> sameTincturesAs(Tinctures tincture) {
		IsSameTincturesAs m = new IsSameTincturesAs();
		m.t1 = tincture;
		return m;
	}


}
