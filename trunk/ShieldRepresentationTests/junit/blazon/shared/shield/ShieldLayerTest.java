package blazon.shared.shield;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static blazon.shared.shield.tinctures.IsSameTincturesAs.sameTincturesAs;
import static blazon.shared.shield.IsSameShieldLayerAs.sameShieldLayerAs;

import org.junit.Test;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

public class ShieldLayerTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullThrowsIllegalArgumentException() {
		ShieldLayer.buildUndividedShieldLayer(null);
	}
	
	@Test
	public void testThatBuildSetsNextLayerToNull() {
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		assertThat(layer.getNextLayer(), is(nullValue()));
	}
	
	@Test
	public void testThatBuildWithEmptyTincturesSetsTincturesToBeEmpty() {
		Tinctures t = new Tinctures();
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(t);
		assertThat(layer.getTinctures(), is(sameTincturesAs(t)));
	}
	
	@Test
	public void testThatBuildWithTincturesWithOrAndVairSetsTincturesToContainOrAndVair() 
			throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		t.addTincture(t.getTincture("or"));
		t.addTincture(t.getTincture("vair"));
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(t);
		assertThat(layer.getTinctures(), is(sameTincturesAs(t)));
	}
	
	@Test
	public void testThatBuildWithShieldDivisionNoneSetsShieldDivisionToNone()
			throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		t.addTincture(t.getTincture("or"));
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType divType = division.getDivisionType("NONE");
		ShieldLayer layer = ShieldLayer.buildDividedShieldLayer(t, divType);
		assertThat(layer.getShieldDivision(), is(equalTo(divType)));
	}
	
	@Test
	public void testThatBuildWithShieldDivisionFessSetsShieldDivisionToFess()
			throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		t.addTincture(t.getTincture("or"));
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType divType = division.getDivisionType("FESS");
		ShieldLayer layer = ShieldLayer.buildDividedShieldLayer(t, divType);
		assertThat(layer.getShieldDivision(), is(equalTo(divType)));
	}
	
	@Test
	public void testThatAddNextLayerSetsNextLayerCorrectly()
			throws UnknownTinctureException {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.getTincture("or"));
		tinctures1.addTincture(tinctures1.getTincture("vair"));
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(tinctures1);
		
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.getTincture("gules"));
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(tinctures2);
		
		layer1.addNextLayer(layer2);
		assertThat(layer1.getNextLayer(), is(sameShieldLayerAs(layer2)));
	}
	
	@Test
	public void testThatAddNextLayerSetsNextLayerChainingCorrectly()
			throws UnknownTinctureException {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.getTincture("or"));
		tinctures1.addTincture(tinctures1.getTincture("vair"));
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(tinctures1);
		
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.getTincture("gules"));
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(tinctures2);
		
		Tinctures tinctures3 = new Tinctures();
		tinctures3.addTincture(tinctures3.getTincture("sable"));
		ShieldLayer layer3 = ShieldLayer.buildUndividedShieldLayer(tinctures3);
		
		layer1.addNextLayer(layer2);
		assertThat(layer1.getNextLayer(), is(sameShieldLayerAs(layer2)));
		layer1.addNextLayer(layer3);
		assertThat(layer1.getNextLayer(), is(sameShieldLayerAs(layer2)));
		assertThat(layer2.getNextLayer(), is(sameShieldLayerAs(layer3)));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithEmptyTincturesAndLayers() {
		Tinctures tinctures = new Tinctures();
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithNonEmptyTincturesAndEmptyLayers()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithEmptyTincturesAndNonEmptyLayers() {
		Tinctures tinctures = new Tinctures();
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		Tinctures tinctures2 = new Tinctures();
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(tinctures2);
		layer.addNextLayer(layer2);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithNonEmptyTincturesAndLayers()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		Tinctures tinctures2 = new Tinctures();
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(tinctures2);
		layer.addNextLayer(layer2);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
}
