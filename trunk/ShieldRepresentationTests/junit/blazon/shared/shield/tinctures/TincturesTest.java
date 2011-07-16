package blazon.shared.shield.tinctures;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static blazon.shared.shield.tinctures.IsSameTinctureAs.sameTinctureAs;

import java.util.Iterator;

import org.junit.Test;


public class TincturesTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCreateTinctureWithNullThrowsIllegalArgumentException() {
		Tinctures tinctures = new Tinctures();
		tinctures.createTincture(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatCreateTinctureWithEmptyStringThrowsIllegalArgumentException() {
		Tinctures tinctures = new Tinctures();
		tinctures.createTincture("");
	}
	
	@Test
	public void testThatCreateTinctureReturnsNullForUnknownFur() {
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.createTincture("foo"), is(nullValue()));
	}
	
	@Test
	public void testThatCreateTinctureReturnsOrTincture() {
		Tincture expected = Metal.build("or", "gold");
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.createTincture("or");
		assertThat(or, is(sameTinctureAs(expected)));
	}
	
	@Test
	public void testThatCreateTinctureReturnsCounterPotentTincture() {
		Tincture expected = Fur.build("counter-potent", "blue", "white");
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.createTincture("counter-potent");
		assertThat(or, is(sameTinctureAs(expected)));
	}
	
	@Test
	public void testThatCreateTinctureReturnsGulesTincture() {
		Tincture expected = Colour.build("gules", "red");
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.createTincture("gules");
		assertThat(or, is(sameTinctureAs(expected)));
	}
	
	
	@Test
	public void testThatAddNullTinctureReturnsFalse() {
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.addTincture(null), is(false));
	}
	
	@Test
	public void testThatAddTinctureReturnsTrue() {
		Tinctures tinctures = new Tinctures();
		Tincture t = tinctures.createTincture("or");
		assertThat(tinctures.addTincture(t), is(true));
	}
	
	@Test
	public void testThatGetTincturesOnLayerIteratorIsEmptyIfNoneAdded() {
		Tinctures tinctures = new Tinctures();
		Iterator<Tincture> iterator = tinctures.getTincturesOnLayerIterator();
		assertThat(iterator.hasNext(), is(false));
	}
	
	@Test
	public void testThatGetTincturesOnLayerIteratorHasOrWhenOrHasBeenAdded() {
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.createTincture("or");
		tinctures.addTincture(or);
		Iterator<Tincture> iterator = tinctures.getTincturesOnLayerIterator();
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), is(sameTinctureAs(or)));
		assertThat(iterator.hasNext(), is(false));
	}
	
	@Test
	public void testThatGetTincturesOnLayerIteratorHasOrAndVertWhenOrAndVertHaveBeenAdded() {
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.createTincture("or");
		Tincture vert = tinctures.createTincture("vert");
		tinctures.addTincture(or);
		tinctures.addTincture(vert);
		Iterator<Tincture> iterator = tinctures.getTincturesOnLayerIterator();
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), is(sameTinctureAs(or)));
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), is(sameTinctureAs(vert)));
		assertThat(iterator.hasNext(), is(false));
	}
	
	@Test
	public void testThatTinctureWithNoItemsHasToStringWithEmptyLayerList() {
		Tinctures tinctures = new Tinctures();
		String expectedToString = "Tinctures:tincturesOnLayer=[]";
		assertThat(tinctures.toString(), is(equalTo(expectedToString)));
	}
	
	@Test
	public void testThatTinctureWithOrHasToStringWithOrToStringInLayerList() {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.createTincture("or"));
		String expectedToString = "Tinctures:tincturesOnLayer=[Tincture:name=or:fillText=gold]";
		assertThat(tinctures.toString(), is(equalTo(expectedToString)));
	}
	
	@Test
	public void testThatTinctureWithOrAndCounterVairHasToStringWithOrAndCounterVairToStringInLayerList() {
		Tinctures tinctures = new Tinctures();
		tinctures.addTincture(tinctures.createTincture("or"));
		tinctures.addTincture(tinctures.createTincture("counter-vair"));
		String expectedToString = "Tinctures:tincturesOnLayer=[Tincture:name=or:fillText=gold, Tincture:name=counter-vair:fillText=url(#counter-vair)]";
		assertThat(tinctures.toString(), is(equalTo(expectedToString)));
	}

}
