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

public class ShieldLayerTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullThrowsIllegalArgumentException() {
		ShieldLayer.build(null);
	}
	
	@Test
	public void testThatBuildSetsNextLayerToNull() {
		ShieldLayer layer = ShieldLayer.build(new Tinctures());
		assertThat(layer.getNextLayer(), is(nullValue()));
	}
	
	@Test
	public void testThatBuildWithEmptyTincturesSetsTincturesToBeEmpty() {
		Tinctures t = new Tinctures();
		ShieldLayer layer = ShieldLayer.build(t);
		assertThat(layer.getTinctures(), is(sameTincturesAs(t)));
	}
	
	@Test
	public void testThatBuildWithTincturesWithOrAndVairSetsTincturesToContainOrAndVair() {
		Tinctures t = new Tinctures();
		t.addTincture(t.createTincture("or"));
		t.addTincture(t.createTincture("vair"));
		ShieldLayer layer = ShieldLayer.build(t);
		assertThat(layer.getTinctures(), is(sameTincturesAs(t)));
	}
	
	@Test
	public void testThatBuildWithShieldDivisionNoneSetsShieldDivisionToNone() {
		Tinctures t = new Tinctures();
		t.addTincture(t.createTincture("or"));
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType divType = division.getDivisionType("NONE");
		ShieldLayer layer = ShieldLayer.build(t, divType);
		assertThat(layer.getShieldDivision(), is(equalTo(divType)));
	}
	
	@Test
	public void testThatBuildWithShieldDivisionFessSetsShieldDivisionToFess() {
		Tinctures t = new Tinctures();
		t.addTincture(t.createTincture("or"));
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType divType = division.getDivisionType("FESS");
		ShieldLayer layer = ShieldLayer.build(t, divType);
		assertThat(layer.getShieldDivision(), is(equalTo(divType)));
	}
	
	@Test
	public void testThatAddNextLayerSetsNextLayerCorrectly() {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.createTincture("or"));
		tinctures1.addTincture(tinctures1.createTincture("vair"));
		ShieldLayer layer1 = ShieldLayer.build(tinctures1);
		
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.createTincture("gules"));
		ShieldLayer layer2 = ShieldLayer.build(tinctures2);
		
		layer1.addNextLayer(layer2);
		assertThat(layer1.getNextLayer(), is(sameShieldLayerAs(layer2)));
	}
	
	@Test
	public void testThatAddNextLayerSetsNextLayerChainingCorrectly() {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.createTincture("or"));
		tinctures1.addTincture(tinctures1.createTincture("vair"));
		ShieldLayer layer1 = ShieldLayer.build(tinctures1);
		
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.createTincture("gules"));
		ShieldLayer layer2 = ShieldLayer.build(tinctures2);
		
		Tinctures tinctures3 = new Tinctures();
		tinctures3.addTincture(tinctures3.createTincture("sable"));
		ShieldLayer layer3 = ShieldLayer.build(tinctures3);
		
		layer1.addNextLayer(layer2);
		assertThat(layer1.getNextLayer(), is(sameShieldLayerAs(layer2)));
		layer1.addNextLayer(layer3);
		assertThat(layer1.getNextLayer(), is(sameShieldLayerAs(layer2)));
		assertThat(layer2.getNextLayer(), is(sameShieldLayerAs(layer3)));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithEmptyTincturesAndLayers() {
		Tinctures tinctures = new Tinctures();
		ShieldLayer layer = ShieldLayer.build(tinctures);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=null}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithNonEmptyTincturesAndEmptyLayers() {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.createTincture("or"));
		ShieldLayer layer = ShieldLayer.build(tinctures);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=null}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithEmptyTincturesAndNonEmptyLayers() {
		Tinctures tinctures = new Tinctures();
		ShieldLayer layer = ShieldLayer.build(tinctures);
		Tinctures tinctures2 = new Tinctures();
		ShieldLayer layer2 = ShieldLayer.build(tinctures2);
		layer.addNextLayer(layer2);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=null}}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithNonEmptyTincturesAndLayers() {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.createTincture("or"));
		ShieldLayer layer = ShieldLayer.build(tinctures);
		Tinctures tinctures2 = new Tinctures();
		ShieldLayer layer2 = ShieldLayer.build(tinctures2);
		layer.addNextLayer(layer2);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfAllowableTinctures=1}:nextLayer=null}}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
}
