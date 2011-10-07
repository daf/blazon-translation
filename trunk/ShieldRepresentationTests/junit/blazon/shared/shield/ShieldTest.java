package blazon.shared.shield;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;


public class ShieldTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullThrowsIllegalArgumentException() {
		ShieldImpl.build(null, null);
	}
	
	@Test
	public void testThatBuildSetsBaseToThatGivenShieldLayerWhichHasNoTincturesAdded() {
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer, null);
		assertThat(shield.getField(), is(equalTo(layer)));
	}
	
	@Test
	public void testThatBuildSetsBaseToThatGivenShieldLayerWhichHasTheOrTinctureAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer, null);
		assertThat(shield.getField(), is(equalTo(layer)));
	}
	
	@Test
	public void testThatBuildSetsBaseToThatGivenShieldLayerWhichHasTheOrAndVairTinctureAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		tinctures.addTincture(tinctures.getTincture("vair"));
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer, null);
		assertThat(shield.getField(), is(equalTo(layer)));
	}
	
	@Test
	public void testThatToStringIsCorrectForShieldWithBaseWhichHasNoTincturesAdded() {
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer, null);
		String expected = "ShieldImpl{field=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}}";
		assertThat(shield.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatToStringIsCorrectForShieldWithBaseWhichHasTheOrTinctureAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer, null);
		String expected = "ShieldImpl{field=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}}";
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
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer1, null);
		String expected = "ShieldImpl{field=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=ShieldLayer{tinctures=Tinctures{tincturesOnLayer=[Tincture{name=vair:fillText=url(#vair)}]}:division=ShieldDivisionType{name=NONE:numberOfSections=1:numberOfTinctures=1}:nextLayer=null}}}";
		assertThat(shield.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatShieldEqualsNullReturnsFalse() {
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer, null);
		assertThat(shield.equals(null), is(false));
	}
	
	@Test
	public void testThatShieldEqualsSelfReturnsTrue() {
		ShieldLayer layer = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield = (ShieldImpl) ShieldImpl.build(layer, null);
		assertThat(shield.equals(shield), is(true));
		assertThat(shield.hashCode(), is(equalTo(shield.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldsWithSameFieldEqualsReturnsTrue() {
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield1 = (ShieldImpl) ShieldImpl.build(layer1, null);
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield2 = (ShieldImpl) ShieldImpl.build(layer2, null);
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldsWithSameFieldEqualsReturnsTrueSymmetrically() {
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield1 = (ShieldImpl) ShieldImpl.build(layer1, null);
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield2 = (ShieldImpl) ShieldImpl.build(layer2, null);
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield2.equals(shield1), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
		assertThat(shield2.hashCode(), is(equalTo(shield1.hashCode())));
	}
	
	@Test
	public void testThatTwoShieldsWithSameFieldEqualsReturnsTrueTransitively() {
		ShieldLayer layer1 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield1 = (ShieldImpl) ShieldImpl.build(layer1, null);
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield2 = (ShieldImpl) ShieldImpl.build(layer2, null);
		ShieldLayer layer3 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield3 = (ShieldImpl) ShieldImpl.build(layer3, null);
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
		ShieldImpl shield1 = (ShieldImpl) ShieldImpl.build(layer1, null);
		ShieldLayer layer2 = ShieldLayer.buildUndividedShieldLayer(new Tinctures());
		ShieldImpl shield2 = (ShieldImpl) ShieldImpl.build(layer2, null);
		assertThat(shield1.equals(shield2), is(false));
	}
	
	@Test
	public void testThatIfYouAddANullListOfDiagnosticsToAShieldWithNoDiagnosticsGetDiagnosticsReturnsNull() {
		Shield shield = ShieldImpl.build(ShieldLayer.buildUndividedShieldLayer(new Tinctures()), null);
		shield.addDiagnostics(null);
		assertThat(shield.getShieldDiagnostics(), is(notNullValue()));
		assertTrue(shield.getShieldDiagnostics().isEmpty());
	}
	
	@Test
	public void testThatIfYouAddAnEmptyListOfDiagnosticsToAShieldWithNoDiagnosticsGetDiagnosticsReturnsNull() {
		Shield shield = ShieldImpl.build(ShieldLayer.buildUndividedShieldLayer(new Tinctures()), null);
		shield.addDiagnostics(new ArrayList<ShieldDiagnostic>());
		assertThat(shield.getShieldDiagnostics(), is(notNullValue()));
		assertTrue(shield.getShieldDiagnostics().isEmpty());

	}
	
	@Test
	public void testThatIfYouAddListOfOneDiagnosticToAShieldWithNoDiagnosticsGetDiagnosticsReturnsAListWithTheSameItems() {
		Shield shield = ShieldImpl.build(ShieldLayer.buildUndividedShieldLayer(new Tinctures()), null);
		List<ShieldDiagnostic> list = new ArrayList<ShieldDiagnostic>();
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list.add(diag);
		shield.addDiagnostics(list);
		List<ShieldDiagnostic> actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list.size())));
		assertThat(actual.get(0), is(equalTo(list.get(0))));
	}
	
	@Test
	public void testThatIfYouAddListOfTwoDiagnosticsToAShieldWithNoDiagnosticsGetDiagnosticsReturnsAListWithTheSameItems() {
		Shield shield = ShieldImpl.build(ShieldLayer.buildUndividedShieldLayer(new Tinctures()), null);
		List<ShieldDiagnostic> list = new ArrayList<ShieldDiagnostic>();
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.WARN, "hello world");
		list.add(diag);
		shield.addDiagnostics(list);
		List<ShieldDiagnostic> actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list.size())));
		assertThat(actual.size(), is(equalTo(2)));
		assertThat(actual.get(0), is(equalTo(list.get(0))));
		assertThat(actual.get(1), is(equalTo(list.get(1))));
	}
	
	@Test
	public void testThatIfYouAddANullListOfDiagnosticsToAShieldWithSomeDiagnosticsGetDiagnosticsReturnsAListWithTheSameItems() {
		Shield shield = ShieldImpl.build(ShieldLayer.buildUndividedShieldLayer(new Tinctures()), null);
		List<ShieldDiagnostic> list = new ArrayList<ShieldDiagnostic>();
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.WARN, "hello world");
		list.add(diag);
		shield.addDiagnostics(list);
		List<ShieldDiagnostic> actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list.size())));
		assertThat(actual.size(), is(equalTo(2)));
		assertThat(actual.get(0), is(equalTo(list.get(0))));
		assertThat(actual.get(1), is(equalTo(list.get(1))));
		
		shield.addDiagnostics(null);
		assertThat(actual.size(), is(equalTo(list.size())));
		assertThat(actual.size(), is(equalTo(2)));
		assertThat(actual.get(0), is(equalTo(list.get(0))));
		assertThat(actual.get(1), is(equalTo(list.get(1))));
	}
	
	@Test
	public void testThatIfYouAddAListOfTwoDiagnosticsToAShieldWithTwoDiagnosticsGetDiagnosticsReturnsAListContainingAllItems() {
		Shield shield = ShieldImpl.build(ShieldLayer.buildUndividedShieldLayer(new Tinctures()), null);
		
		List<ShieldDiagnostic> list1 = new ArrayList<ShieldDiagnostic>();
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list1.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.WARN, "hello world");
		list1.add(diag);
		shield.addDiagnostics(list1);

		List<ShieldDiagnostic> actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list1.size())));
		assertThat(actual.size(), is(equalTo(2)));
		assertThat(actual.get(0), is(equalTo(list1.get(0))));
		assertThat(actual.get(1), is(equalTo(list1.get(1))));
		
		List<ShieldDiagnostic> list2 = new ArrayList<ShieldDiagnostic>();
		diag = ShieldDiagnostic.build(LogLevel.INFO, "third item");
		list2.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.WARN, "fourth item");
		list2.add(diag);
		shield.addDiagnostics(list2);
		
		actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list1.size() + list2.size())));
		assertThat(actual.size(), is(equalTo(4)));
		assertThat(actual.get(0), is(equalTo(list1.get(0))));
		assertThat(actual.get(1), is(equalTo(list1.get(1))));
		assertThat(actual.get(2), is(equalTo(list2.get(0))));
		assertThat(actual.get(3), is(equalTo(list2.get(1))));
		
	}
}

