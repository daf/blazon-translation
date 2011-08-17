package blazon.shared.shield.tinctures;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.junit.Test;


public class TincturesTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCreateTinctureWithNullThrowsIllegalArgumentException()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.getTincture(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCreateTinctureWithEmptyStringThrowsIllegalArgumentException()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.getTincture("");
	}
	
	@Test(expected=UnknownTinctureException.class)
	public void testThatCreateTinctureReturnsNullForUnknownFur()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.getTincture("foo");
	}
	
	@Test
	public void testThatCreateTinctureReturnsOrTincture()
			throws UnknownTinctureException {
		Tincture expected = Metal.build("or", "gold");
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.getTincture("or");
		assertThat(or, is(equalTo(expected)));
	}
	
	@Test
	public void testThatCreateTinctureReturnsCounterPotentTincture()
			throws UnknownTinctureException {
		Tincture expected = Fur.build("counter-potent", "blue", "white");
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.getTincture("counter-potent");
		assertThat(or, is(equalTo(expected)));
	}
	
	@Test
	public void testThatCreateTinctureReturnsGulesTincture()
			throws UnknownTinctureException {
		Tincture expected = Colour.build("gules", "red");
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.getTincture("gules");
		assertThat(or, is(equalTo(expected)));
	}
	
	
	@Test
	public void testThatAddNullTinctureReturnsFalse() {
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.addTincture(null), is(false));
	}
	
	@Test
	public void testThatAddTinctureReturnsTrue()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture t = tinctures.getTincture("ermine");
		assertThat(tinctures.addTincture(t), is(true));
	}
	
	@Test
	public void testThatGetTincturesOnLayerIteratorIsEmptyIfNoneAdded() {
		Tinctures tinctures = new Tinctures();
		Iterator<Tincture> iterator = tinctures.getTincturesOnLayer().iterator();
		assertThat(iterator.hasNext(), is(false));
	}
	
	@Test
	public void testThatGetTincturesOnLayerIteratorHasPurpureWhenOrHasBeenAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture purpure = tinctures.getTincture("purpure");
		tinctures.addTincture(purpure);
		Iterator<Tincture> iterator = tinctures.getTincturesOnLayer().iterator();
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), is(equalTo(purpure)));
		assertThat(iterator.hasNext(), is(false));
	}
	
	@Test
	public void testThatGetTincturesOnLayerIteratorHasErminoisAndPeanWhenErminoisAndPeanHaveBeenAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture erminois = tinctures.getTincture("erminois");
		Tincture pean = tinctures.getTincture("pean");
		tinctures.addTincture(erminois);
		tinctures.addTincture(pean);
		Iterator<Tincture> iterator = tinctures.getTincturesOnLayer().iterator();
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), is(equalTo(erminois)));
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), is(equalTo(pean)));
		assertThat(iterator.hasNext(), is(false));
	}
	
	@Test
	public void testThatTinctureWithNoItemsHasToStringWithEmptyLayerList() {
		Tinctures tinctures = new Tinctures();
		String expectedToString = "Tinctures{tincturesOnLayer=[]}";
		assertThat(tinctures.toString(), is(equalTo(expectedToString)));
	}
	
	@Test
	public void testThatTinctureWithOrHasToStringWithOrToStringInLayerList()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		String expectedToString = "Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}]}";
		assertThat(tinctures.toString(), is(equalTo(expectedToString)));
	}
	
	@Test
	public void testThatTinctureWithOrAndCounterVairHasToStringWithOrAndCounterVairToStringInLayerList()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.getTincture("or"));
		tinctures.addTincture(tinctures.getTincture("counter-vair"));
		String expectedToString = "Tinctures{tincturesOnLayer=[Tincture{name=or:fillText=gold}, Tincture{name=counter-vair:fillText=url(#counter-vair)}]}";
		assertThat(tinctures.toString(), is(equalTo(expectedToString)));
	}
	
	@Test
	public void testThatTincturesObjectEqualsNullReturnsFalse() {
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.equals(null), is(false));
	}
	
	@Test
	public void testThatTincturesObjectEqualsSelfReturnsTrue() {
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.equals(tinctures), is(true));
		assertThat(tinctures.hashCode(), is(equalTo(tinctures.hashCode())));
	}

	@Test
	public void testThatTwoTincturesWithNoTincturesOnLayerEqualsReturnsTrueSymmetrically() {
		Tinctures tinctures1 = new Tinctures();
		Tinctures tinctures2 = new Tinctures();
		assertThat(tinctures1.equals(tinctures2), is(true));
		assertThat(tinctures2.equals(tinctures1), is(true));
		assertThat(tinctures1.hashCode(), is(equalTo(tinctures2.hashCode())));
		assertThat(tinctures2.hashCode(), is(equalTo(tinctures1.hashCode())));
	}
	
	@Test
	public void testThatTwoTincturesWithNoTincturesOnLayerEqualsReturnsTrueConsistently() {
		Tinctures tinctures1 = new Tinctures();
		Tinctures tinctures2 = new Tinctures();
		assertThat(tinctures1.equals(tinctures2), is(true));
		assertThat(tinctures1.equals(tinctures2), is(true));
		assertThat(tinctures1.equals(tinctures2), is(true));
		assertThat(tinctures1.hashCode(), is(equalTo(tinctures2.hashCode())));
		assertThat(tinctures1.hashCode(), is(equalTo(tinctures2.hashCode())));
		assertThat(tinctures1.hashCode(), is(equalTo(tinctures2.hashCode())));
	}
	
	@Test
	public void testThatTwoTincturesWithErmineOnLayerEqualsReturnsTrue() throws UnknownTinctureException {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.getTincture("ermine"));
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.getTincture("ermine"));
		assertThat(tinctures1.equals(tinctures2), is(true));
		assertThat(tinctures1.hashCode(), is(equalTo(tinctures2.hashCode())));
	}
	
	@Test
	public void testThatTincturesWithGulesOnLayerEqualsReturnsTrueTransitively() throws UnknownTinctureException {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.getTincture("gules"));
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.getTincture("gules"));
		Tinctures tinctures3 = new Tinctures();
		tinctures3.addTincture(tinctures3.getTincture("gules"));
		assertThat(tinctures1.equals(tinctures2), is(true));
		assertThat(tinctures2.equals(tinctures3), is(true));
		assertThat(tinctures1.equals(tinctures3), is(true));
		assertThat(tinctures1.hashCode(), is(equalTo(tinctures2.hashCode())));
		assertThat(tinctures2.hashCode(), is(equalTo(tinctures3.hashCode())));
		assertThat(tinctures1.hashCode(), is(equalTo(tinctures3.hashCode())));
	}
	
	@Test
	public void testThatTwoTincturesWithDifferentTincturesOnLayerEqualsReturnsFalse() throws UnknownTinctureException {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.getTincture("gules"));
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.getTincture("argent"));
		assertThat(tinctures1.equals(tinctures2), is(false));
	}
	
	@Test
	public void testThatTwoTincturesWithDifferentTincturesOnLayerEqualsReturnsFalseConsistently() throws UnknownTinctureException {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.getTincture("gules"));
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.getTincture("argent"));
		assertThat(tinctures1.equals(tinctures2), is(false));
		assertThat(tinctures1.equals(tinctures2), is(false));
	}
	
	@Test
	public void testThatTwoTincturesWithSameTincturesInDifferentOrderOnLayerEqualsReturnsFalse() throws UnknownTinctureException {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.getTincture("argent"));
		tinctures1.addTincture(tinctures1.getTincture("gules"));
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.getTincture("gules"));
		tinctures2.addTincture(tinctures2.getTincture("argent"));
		assertThat(tinctures1.equals(tinctures2), is(false));
	}
	
	@Test
	public void testThatTwoTincturesWithSameTincturesInSameOrderOnLayerEqualsReturnsTrue() throws UnknownTinctureException {
		Tinctures tinctures1 = new Tinctures();
		tinctures1.addTincture(tinctures1.getTincture("gules"));
		tinctures1.addTincture(tinctures1.getTincture("argent"));
		Tinctures tinctures2 = new Tinctures();
		tinctures2.addTincture(tinctures2.getTincture("gules"));
		tinctures2.addTincture(tinctures2.getTincture("argent"));
		assertThat(tinctures1.equals(tinctures2), is(true));
	}
}
