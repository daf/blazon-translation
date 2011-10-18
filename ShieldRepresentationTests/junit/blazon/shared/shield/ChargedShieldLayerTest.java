package blazon.shared.shield;


import org.junit.Test;

import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ChargedShieldLayerTest {
		@Test(expected=IllegalArgumentException.class)
		public void testThatBuildWithNullTincturesThrowsIllegalArgumentException() throws UnknownTinctureException {
			GeometricCharge cross = GeometricCharge.build("cross", new Tinctures().getTincture("gules"), null);
			ChargedShieldLayer.build(null, cross);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testThatBuildWithNullOrdinaryThrowsIllegalArgumentException() throws UnknownTinctureException {
			ChargedShieldLayer.build(new Tinctures(), null);
		}
		
		@Test
		public void testThatBuildWithCrossGulesCanBeRetrieved() throws UnknownTinctureException {
			Tinctures tinctures = new Tinctures();
			Tincture gules = tinctures.getTincture("gules");
			tinctures.addTincture(gules);
			GeometricCharge cross = GeometricCharge.build("cross", gules, null);
			ChargedShieldLayer layer = ChargedShieldLayer.build(tinctures, cross);
			assertThat(layer.getOrdinary().equals(cross), is(true));
			assertThat(layer.getTinctures().equals(tinctures), is(true));
			assertThat(layer.getShieldDivision().equals(new ShieldDivision().getDivisionType("NONE", null)), is(true));
		}
		
		@Test
		public void testThatToStringIsSetCorrectlyWithEmptyTincturesAndLayers() throws UnknownTinctureException {
			Tinctures tinctures = new Tinctures();
			GeometricCharge ordinary = GeometricCharge.build("cross", tinctures.getTincture("or"), null);
			ChargedShieldLayer layer = ChargedShieldLayer.build(tinctures, ordinary);
			String expected = "ChargedShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:ordinary=Ordinary{tincture=Tincture{name=or:fillText=gold}:name=CROSS}:nextLayer=null}";
			assertThat(layer.toString(), is(equalTo(expected)));
		}
}