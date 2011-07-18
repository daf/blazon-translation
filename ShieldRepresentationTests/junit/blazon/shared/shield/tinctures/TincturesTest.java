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
		Tincture t = tinctures.getTincture("or");
		assertThat(tinctures.addTincture(t), is(true));
	}
	
	@Test
	public void testThatGetTincturesOnLayerIteratorIsEmptyIfNoneAdded() {
		Tinctures tinctures = new Tinctures();
		Iterator<Tincture> iterator = tinctures.getTincturesOnLayer().iterator();
		assertThat(iterator.hasNext(), is(false));
	}
	
	@Test
	public void testThatGetTincturesOnLayerIteratorHasOrWhenOrHasBeenAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.getTincture("or");
		tinctures.addTincture(or);
		Iterator<Tincture> iterator = tinctures.getTincturesOnLayer().iterator();
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), is(equalTo(or)));
		assertThat(iterator.hasNext(), is(false));
	}
	
	@Test
	public void testThatGetTincturesOnLayerIteratorHasOrAndVertWhenOrAndVertHaveBeenAdded()
			throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.getTincture("or");
		Tincture vert = tinctures.getTincture("vert");
		tinctures.addTincture(or);
		tinctures.addTincture(vert);
		Iterator<Tincture> iterator = tinctures.getTincturesOnLayer().iterator();
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), is(equalTo(or)));
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), is(equalTo(vert)));
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

}
