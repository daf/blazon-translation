package blazon.shared.shield;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;
import blazon.shared.shield.tinctures.Tinctures;

import static org.junit.Assert.assertThat;
import static blazon.shared.shield.tinctures.IsSameTincturesAs.sameTincturesAs;
import static org.hamcrest.CoreMatchers.is;

class IsSameShieldLayerAs extends TypeSafeMatcher<ShieldLayer> {

	private ShieldLayer l1;
	
	@Override
	public void describeTo(Description desc) {
		desc.appendText("same shield layer as");
	}

	@Override
	public boolean matchesSafely(ShieldLayer l2) {
		return tincturesMatch(l1, l2) && layersMatch(l1, l2); 
	}
	
	private boolean layersMatch(ShieldLayer layer1, ShieldLayer layer2) {
		if (layer1 == null ^ layer2 == null)  {
			return false;
		} 
		if (layer1 == null && layer2 == null) {
			return true;
		}
		
		if (!tincturesMatch(layer1, layer2)) {
			return false;
		} else {
			return layersMatch(layer1.getNextLayer(), layer2.getNextLayer());
		}
	}

	private boolean tincturesMatch(ShieldLayer layer1, ShieldLayer layer2) {
		Tinctures tinctures1 = layer1.getTinctures();
		Tinctures tinctures2 = layer2.getTinctures();
		assertThat(tinctures1, is(sameTincturesAs(tinctures2)));
		return true;
	}

	@Factory
	public static <T> Matcher<ShieldLayer> sameShieldLayerAs(ShieldLayer layer) {
		IsSameShieldLayerAs m = new IsSameShieldLayerAs();
		m.l1 = layer;
		return m;
	}


}
