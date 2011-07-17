package blazon.shared.shield;

import org.junit.Test;

import blazon.shared.shield.tinctures.Tinctures;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import static blazon.shared.shield.IsSameShieldLayerAs.sameShieldLayerAs;

public class ShieldTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullThrowsIllegalArgumentException() {
		Shield.build(null);
	}
	
	@Test
	public void testThatBuildSetsBaseToThatGivenShieldLayerWhichHasNoTincturesAdded() {
		ShieldLayer layer = ShieldLayer.build(new Tinctures());
		Shield shield = Shield.build(layer);
		assertThat(shield.getField(), is(sameShieldLayerAs(layer)));
	}
	
	@Test
	public void testThatBuildSetsBaseToThatGivenShieldLayerWhichHasTheOrTinctureAdded() {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.createTincture("or"));
		ShieldLayer layer = ShieldLayer.build(tinctures);
		Shield shield = Shield.build(layer);
		assertThat(shield.getField(), is(sameShieldLayerAs(layer)));
	}
	
	@Test
	public void testThatBuildSetsBaseToThatGivenShieldLayerWhichHasTheOrAndVairTinctureAdded() {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.createTincture("or"));
		tinctures.addTincture(tinctures.createTincture("vair"));
		ShieldLayer layer = ShieldLayer.build(tinctures);
		Shield shield = Shield.build(layer);
		assertThat(shield.getField(), is(sameShieldLayerAs(layer)));
	}
	
	@Test
	public void testThatToStringIsCorrectForShieldWithBaseWhichHasNoTincturesAdded() {
		ShieldLayer layer = ShieldLayer.build(new Tinctures());
		Shield shield = Shield.build(layer);
		String expected = "Shield{base=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=null}}";
		assertThat(shield.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsCorrectForShieldWithBaseWhichHasTheOrTinctureAdded() {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.createTincture("or"));
		ShieldLayer layer = ShieldLayer.build(tinctures);
		Shield shield = Shield.build(layer);
		String expected = "Shield{base=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=null}}";
		assertThat(shield.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsCorrectForShieldWithBaseWhichHasTheOrTinctureAddedAndBaseHasALayerWithATinctureWithVairAdded() {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.createTincture("or"));
		ShieldLayer layer1 = ShieldLayer.build(tinctures);
		tinctures = new Tinctures();
		tinctures.addTincture(tinctures.createTincture("vair"));
		ShieldLayer layer2 = ShieldLayer.build(tinctures);
		layer1.addNextLayer(layer2);
		Shield shield = Shield.build(layer1);
		String expected = "Shield{base=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=vair:fillText=url(#vair)}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=null}}}";
		assertThat(shield.toString(), is(equalTo(expected)));
	}
	
}
