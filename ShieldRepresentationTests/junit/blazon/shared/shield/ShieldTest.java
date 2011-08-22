package blazon.shared.shield;

import org.junit.Test;

import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class ShieldTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullThrowsIllegalArgumentException() {
		ShieldImpl.build(null);
	}
	
	@Test
	public void testThatBuildSetsBaseToThatGivenShieldLayerWhichHasNoTincturesAdded() {
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer);
		assertThat(shield.getField(), is(equalTo(layer)));
	}
	
	@Test
	public void testThatBuildSetsBaseToThatGivenShieldLayerWhichHasTheOrTinctureAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer);
		assertThat(shield.getField(), is(equalTo(layer)));
	}
	
	@Test
	public void testThatBuildSetsBaseToThatGivenShieldLayerWhichHasTheOrAndVairTinctureAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		tinctures.addTincture(tinctures.getTincture("vair"));
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer);
		assertThat(shield.getField(), is(equalTo(layer)));
	}
	
	@Test
	public void testThatToStringIsCorrectForShieldWithBaseWhichHasNoTincturesAdded() {
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer);
		String expected = "Shield{field=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}}";
		assertThat(shield.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsCorrectForShieldWithBaseWhichHasTheOrTinctureAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer);
		String expected = "Shield{field=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}}";
		assertThat(shield.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsCorrectForShieldWithBaseWhichHasTheOrTinctureAddedAndBaseHasALayerWithATinctureWithVairAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(tinctures);
		tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("vair"));
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(tinctures);
		layer1.addNextLayer(layer2);
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer1);
		String expected = "Shield{field=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=vair:fillText=url(#vair)}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}}}";
		assertThat(shield.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatShieldEqualsNullReturnsFalse() {
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer);
		assertThat(shield.equals(null), is(false));
	}
	
	@Test
	public void testThatShieldEqualsSelfReturnsTrue() {
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer);
		assertThat(shield.equals(shield), is(true));
		assertThat(shield.hashCode(), is(equalTo(shield.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldsWithSameFieldEqualsReturnsTrue() {
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield1 = (ShieldImpl) ShieldImpl.build(layer1);
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield2 = (ShieldImpl) ShieldImpl.build(layer2);
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldsWithSameFieldEqualsReturnsTrueSymmetrically() {
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield1 = (ShieldImpl) ShieldImpl.build(layer1);
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield2 = (ShieldImpl) ShieldImpl.build(layer2);
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield2.equals(shield1), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
		assertThat(shield2.hashCode(), is(equalTo(shield1.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldsWithSameFieldEqualsReturnsTrueTransitively() {
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield1 = (ShieldImpl) ShieldImpl.build(layer1);
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield2 = (ShieldImpl) ShieldImpl.build(layer2);
		ShieldLayer layer3 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield3 = (ShieldImpl) ShieldImpl.build(layer3);
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield2.equals(shield3), is(true));
		assertThat(shield1.equals(shield3), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
		assertThat(shield2.hashCode(), is(equalTo(shield3.hashCode())));
		assertThat(shield1.hashCode(), is(equalTo(shield3.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldsWithDifferentFieldSetEqualsReturnsTrue() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(tinctures);
		ShieldImpl shield1 = (ShieldImpl) ShieldImpl.build(layer1);
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield2 = (ShieldImpl) ShieldImpl.build(layer2);
		assertThat(shield1.equals(shield2), is(false));
	}
}
