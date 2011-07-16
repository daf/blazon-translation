package blazon.shared.shield.tinctures;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

public class IsSameTinctureAs extends TypeSafeMatcher<Tincture> {

	private Tincture t1;
	
	@Override
	public void describeTo(Description desc) {
		desc.appendText("same tincture as");
	}

	@Override
	public boolean matchesSafely(Tincture t2) {
		return t1.getClass().equals(t2.getClass())
				&& t1.getName().equals(t2.getName())
				&& t1.getFillText().equals(t2.getFillText());
	}
	
	@Factory
	public static <T> Matcher<Tincture> sameTinctureAs(Tincture tincture) {
		IsSameTinctureAs m = new IsSameTinctureAs();
		m.t1 = tincture;
		return m;
	}


}
