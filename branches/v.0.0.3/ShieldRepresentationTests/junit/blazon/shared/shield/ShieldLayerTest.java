package blazon.shared.shield;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

public class ShieldLayerTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullThrowsIllegalArgumentException() {
		Field.buildUndividedShieldLayer(null);
	}
	
	@Test
	public void testThatBuildWithEmptyTincturesSetsTincturesToBeEmpty() {
		Tinctures t = new Tinctures();
		ShieldLayer layer = Field.buildUndividedShieldLayer(t);
		assertThat(layer.getTinctures(), is(equalTo(t)));
	}
	
	@Test
	public void testThatBuildWithTincturesWithOrAndVairSetsTincturesToContainOrAndVair() 
			throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		t.addTincture(t.getTincture("or"));
		t.addTincture(t.getTincture("vair"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(t);
		assertThat(layer.getTinctures(), is(equalTo(t)));
	}
	
	@Test
	public void testThatBuildWithShieldDivisionNoneSetsShieldDivisionToNone()
			throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		t.addTincture(t.getTincture("or"));
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType divType = division.getDivisionType("NONE", new ArrayList<ShieldDiagnostic>());
		ShieldLayer layer = Field.buildDividedShieldLayer(t, divType);
		assertThat(layer.getShieldDivision(), is(equalTo(divType)));
	}
	
	@Test
	public void testThatBuildWithShieldDivisionFessSetsShieldDivisionToFess()
			throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		t.addTincture(t.getTincture("or"));
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType divType = division.getDivisionType("FESS", new ArrayList<ShieldDiagnostic>());
		ShieldLayer layer = Field.buildDividedShieldLayer(t, divType);
		assertThat(layer.getShieldDivision(), is(equalTo(divType)));
	}
	
	@Test
	public void testThatGetTinctureTypeOfLayerWhenNothingOnLayerReturnsOther() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		assertThat(layer.getTinctureTypeOfLayer(), is(TinctureType.OTHER));
	}
	
	@Test
	public void testThatGetTinctureTypeOfLayerWhenOnlyAColourOnLayerReturnsColour() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("sable"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		assertThat(layer.getTinctureTypeOfLayer(), is(TinctureType.COLOUR));
	}
	
	@Test
	public void testThatGetTinctureTypeOfLayerWhenOnlyAMetalOnLayerReturnsMetal() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		assertThat(layer.getTinctureTypeOfLayer(), is(TinctureType.METAL));
	}
	
	@Test
	public void testThatGetTinctureTypeOfLayerWhenOnlyAFurOnLayerReturnsOther() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("vair"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		assertThat(layer.getTinctureTypeOfLayer(), is(TinctureType.OTHER));
	}
	
	@Test
	public void testThatGetTinctureTypeOfLayerWhen2MetalsOnLayerReturnsMetal() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		tinctures.addTincture(tinctures.getTincture("argent"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		assertThat(layer.getTinctureTypeOfLayer(), is(TinctureType.METAL));
	}
	
	@Test
	public void testThatGetTinctureTypeOfLayerWhen2ColoursOnLayerReturnsColour() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("sable"));
		tinctures.addTincture(tinctures.getTincture("gules"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		assertThat(layer.getTinctureTypeOfLayer(), is(TinctureType.COLOUR));
	}
	
	@Test
	public void testThatGetTinctureTypeOfLayerWhen1ColourAnd1MetalAreOnLayerReturnsOther() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("sable"));
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		assertThat(layer.getTinctureTypeOfLayer(), is(TinctureType.OTHER));
	}
	
	@Test
	public void testThatGetTinctureTypeOfLayerWhen1ColourAnd1FurAreOnLayerReturnsOther() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("sable"));
		tinctures.addTincture(tinctures.getTincture("vair"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		assertThat(layer.getTinctureTypeOfLayer(), is(TinctureType.OTHER));
	}
	
	@Test
	public void testThatGetTinctureTypeOfLayerWhen1MetalAnd1FurAreOnLayerReturnsOther() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		tinctures.addTincture(tinctures.getTincture("vair"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		assertThat(layer.getTinctureTypeOfLayer(), is(TinctureType.OTHER));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithEmptyTincturesAndLayers() {
		Tinctures tinctures = new Tinctures();
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsSetCorrectlyWithNonEmptyTincturesAndEmptyLayers()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer = Field.buildUndividedShieldLayer(tinctures);
		String expected = "ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}";
		assertThat(layer.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatShieldLayerEqualsNullReturnsFalse() {
		ShieldLayer layer = Field.buildUndividedShieldLayer(new Tinctures());
		assertThat(layer.equals(null), is(false));
	}
	
	@Test
	public void testThatShieldLayerEqualsSelfReturnsTrue() {
		ShieldLayer layer = Field.buildUndividedShieldLayer(new Tinctures());
		assertThat(layer.equals(layer), is(true));
		assertThat(layer.hashCode(), is(equalTo(layer.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldLayersWithNoTincturesEqualsReturnsTrue() {
		ShieldLayer layer1 = Field.buildUndividedShieldLayer(new Tinctures());
		ShieldLayer layer2 = Field.buildUndividedShieldLayer(new Tinctures());
		assertThat(layer1.equals(layer2), is(true));
		assertThat(layer1.hashCode(), is(equalTo(layer2.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldLayersWithDifferentTincturesEqualsReturnsFalse() throws UnknownTinctureException {
		Tinctures tincturesWithOr = new Tinctures();
		tincturesWithOr.addTincture(tincturesWithOr.getTincture("or"));
		ShieldLayer layer1 = Field.buildUndividedShieldLayer(tincturesWithOr);
		ShieldLayer layer2 = Field.buildUndividedShieldLayer(new Tinctures());
		assertThat(layer1.equals(layer2), is(false));
	}
	
	@Test
	public void testThatTwoShieldLayersWithDifferentDivisionTypesEqualsReturnsFalse() {
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType fess = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldLayer layer1 = Field.buildDividedShieldLayer(new Tinctures(), bend);
		ShieldLayer layer2 = Field.buildDividedShieldLayer(new Tinctures(), fess);
		assertThat(layer1.equals(layer2), is(false));
	}
	
	@Test
	public void testThatTwoShieldLayersWithDifferentDivisionTypesEqualsReturnsFalseConsistently() {
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType fess = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldLayer layer1 = Field.buildDividedShieldLayer(new Tinctures(), bend);
		ShieldLayer layer2 = Field.buildDividedShieldLayer(new Tinctures(), fess);
		assertThat(layer1.equals(layer2), is(false));
	}
	
	@Test
	public void testThatTwoShieldLayersWithSameTincturesEqualsReturnsTrue() throws UnknownTinctureException {
		Tinctures tincturesWithOr1 = new Tinctures();
		tincturesWithOr1.addTincture(tincturesWithOr1.getTincture("or"));
		Tinctures tincturesWithOr2 = new Tinctures();
		tincturesWithOr2.addTincture(tincturesWithOr2.getTincture("or"));
		ShieldLayer layer1 = Field.buildUndividedShieldLayer(tincturesWithOr1);
		ShieldLayer layer2 = Field.buildUndividedShieldLayer(tincturesWithOr2);
		assertThat(layer1.equals(layer2), is(true));
		assertThat(layer1.hashCode(), is(equalTo(layer2.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldLayersWithSameTincturesAndDivisionEqualsReturnsTrue() throws UnknownTinctureException {
		Tinctures tincturesWithOr1 = new Tinctures();
		tincturesWithOr1.addTincture(tincturesWithOr1.getTincture("or"));
		Tinctures tincturesWithOr2 = new Tinctures();
		tincturesWithOr2.addTincture(tincturesWithOr2.getTincture("or"));
		ShieldDivisionType fess1 = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType fess2 = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldLayer layer1 = Field.buildDividedShieldLayer(tincturesWithOr1, fess1);
		ShieldLayer layer2 = Field.buildDividedShieldLayer(tincturesWithOr2, fess2);
		assertThat(layer1.equals(layer2), is(true));
		assertThat(layer1.hashCode(), is(equalTo(layer2.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldLayersWithSameTincturesAndDivisionEqualsReturnsTrueSymmetrically() throws UnknownTinctureException {
		Tinctures tincturesWithOr1 = new Tinctures();
		tincturesWithOr1.addTincture(tincturesWithOr1.getTincture("or"));
		Tinctures tincturesWithOr2 = new Tinctures();
		tincturesWithOr2.addTincture(tincturesWithOr2.getTincture("or"));
		ShieldDivisionType fess1 = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType fess2 = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldLayer layer1 = Field.buildDividedShieldLayer(tincturesWithOr1, fess1);
		ShieldLayer layer2 = Field.buildDividedShieldLayer(tincturesWithOr2, fess2);
		assertThat(layer1.equals(layer2), is(true));
		assertThat(layer2.equals(layer1), is(true));
		assertThat(layer1.hashCode(), is(equalTo(layer2.hashCode())));
		assertThat(layer2.hashCode(), is(equalTo(layer1.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldLayersWithSameTincturesAndDivisionEqualsReturnsTrueConsistently() throws UnknownTinctureException {
		Tinctures tincturesWithOr1 = new Tinctures();
		tincturesWithOr1.addTincture(tincturesWithOr1.getTincture("or"));
		Tinctures tincturesWithOr2 = new Tinctures();
		tincturesWithOr2.addTincture(tincturesWithOr2.getTincture("or"));
		ShieldDivisionType fess1 = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType fess2 = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldLayer layer1 = Field.buildDividedShieldLayer(tincturesWithOr1, fess1);
		ShieldLayer layer2 = Field.buildDividedShieldLayer(tincturesWithOr2, fess2);
		assertThat(layer1.equals(layer2), is(true));
		assertThat(layer1.equals(layer2), is(true));
		assertThat(layer1.equals(layer2), is(true));
		assertThat(layer1.hashCode(), is(equalTo(layer2.hashCode())));
		assertThat(layer1.hashCode(), is(equalTo(layer2.hashCode())));
		assertThat(layer1.hashCode(), is(equalTo(layer2.hashCode())));
	}
	
	@Test
	public void testThatThreeShieldLayersWithSameTincturesAndDivisionEqualsReturnsTrueTransitively() throws UnknownTinctureException {
		Tinctures tincturesWithOr1 = new Tinctures();
		tincturesWithOr1.addTincture(tincturesWithOr1.getTincture("or"));
		Tinctures tincturesWithOr2 = new Tinctures();
		tincturesWithOr2.addTincture(tincturesWithOr2.getTincture("or"));
		Tinctures tincturesWithOr3 = new Tinctures();
		tincturesWithOr3.addTincture(tincturesWithOr3.getTincture("or"));
		ShieldDivisionType fess1 = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType fess2 = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType fess3 = new ShieldDivision().getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		ShieldLayer layer1 = Field.buildDividedShieldLayer(tincturesWithOr1, fess1);
		ShieldLayer layer2 = Field.buildDividedShieldLayer(tincturesWithOr2, fess2);
		ShieldLayer layer3 = Field.buildDividedShieldLayer(tincturesWithOr3, fess3);
		assertThat(layer1.equals(layer2), is(true));
		assertThat(layer2.equals(layer3), is(true));
		assertThat(layer1.equals(layer3), is(true));
		assertThat(layer1.hashCode(), is(equalTo(layer2.hashCode())));
		assertThat(layer2.hashCode(), is(equalTo(layer3.hashCode())));
		assertThat(layer1.hashCode(), is(equalTo(layer3.hashCode())));
	}
}
