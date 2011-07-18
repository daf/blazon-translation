package blazon.shared.shield.tinctures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class ColourTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullNameAndColourThrowsIllegalArgumentException() {
			Colour.build(null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullNameThrowsIllegalArgumentException() {
			Colour.build(null, "colour");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullColourThrowsIllegalArgumentException() {
			Colour.build("name", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyNameAndColourThrowsIllegalArgumentException() {
			Colour.build("", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyNameThrowsIllegalArgumentException() {
			Colour.build("", "colour");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyColourThrowsIllegalArgumentException() {
			Colour.build("name", "");
	}
	
	@Test
	public void testThatBuildSetsNameToGules() {
		String name = "gules";
		Tincture t = Colour.build(name, "red");
		assertThat(t.getName(), is(equalTo(name)));
	}
	
	@Test
	public void testThatBuildSetsNameToVert() {
		String name = "vert";
		Tincture t = Colour.build(name, "green");
		assertThat(t.getName(), is(equalTo(name)));
	}
	
	@Test
	public void testThatBuildSetsFillTextToRed() {
		String fillText = "red";
		Tincture t = Colour.build("gules", fillText);
		assertThat(t.getFillText(), is(equalTo(fillText)));
	}
	
	@Test
	public void testThatBuildSetsFillTextToSilver() {
		String fillText = "green";
		Tincture t = Colour.build("vert", fillText);
		assertThat(t.getFillText(), is(equalTo(fillText)));
	}
	
	@Test
	public void testThatToStringForSableIsAsExpected() {
		String name = "sable";
		String fillText = "black";
		Tincture t = Colour.build(name, fillText);
		String toString = "Tincture{name=sable:fillText=black}";
		assertThat(t.toString(), is(equalTo(toString)));
	}
	
	@Test
	public void testThatEqualsReturnsFalseForNull() {
		Tincture t = Colour.build("sable", "black");
		assertThat(t.equals(null), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsFalseWhenComparingWithObjectVariable() {
		Tincture t = Colour.build("sable", "black");
		assertThat(t.equals(new Object()), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsTrueWhenPassingReferenceToSameObject() {
		Tincture t = Colour.build("sable", "black");
		assertThat(t.equals(t), is(true));
	}
	
	@Test
	public void testThatEqualsReturnsTrueConstistentlyWhenPassingReferenceToSameObject() {
		Tincture t = Colour.build("sable", "black");
		assertThat(t.equals(t), is(true));
		assertThat(t.equals(t), is(true));
		assertThat(t.equals(t), is(true));
	}
	
	@Test
	public void testThatEqualsReturnsTrueWhenPassingObjectThatWasConstructedUsingTheSameParameters() {
		Tincture t1 = Colour.build("sable", "black");
		Tincture t2 = Colour.build("sable", "black");
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
	}
	
	@Test
	public void testThatEqualsReturnsTrueConsistentlyWhenPassingObjectThatWasConstructedUsingTheSameParameters() {
		Tincture t1 = Colour.build("sable", "black");
		Tincture t2 = Colour.build("sable", "black");
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
	}
	
	@Test
	public void testThatEqualsReturnsTrueSymmetricallyForObjectsConstructedTheSameWay() {
		Tincture t1 = Colour.build("sable", "black");
		Tincture t2 = Colour.build("sable", "black");
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
		assertThat(t2.equals(t1), is(true));
		assertThat(t2.hashCode(), is(equalTo(t1.hashCode())));
	}
	
	@Test
	public void testThatEqualsReturnsTrueTransitivelyForObjectsConstructedTheSameWay() {
		Tincture t1 = Colour.build("sable", "black");
		Tincture t2 = Colour.build("sable", "black");
		Tincture t3 = Colour.build("sable", "black");
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
		assertThat(t2.equals(t3), is(true));
		assertThat(t2.hashCode(), is(equalTo(t3.hashCode())));
		assertThat(t1.equals(t3), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
	}
	
	@Test
	public void testThatEqualsReturnsFalseWhenConstructedWithDifferentNames() {
		Tincture t1 = Colour.build("sable", "black");
		Tincture t2 = Colour.build("black", "black");
		assertThat(t1.equals(t2), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsFalseConsistentlyWhenConstructedWithDifferentNames() {
		Tincture t1 = Colour.build("sable", "black");
		Tincture t2 = Colour.build("black", "black");
		assertThat(t1.equals(t2), is(false));
		assertThat(t1.equals(t2), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsFalseWhenConstructedWithDifferentColour() {
		Tincture t1 = Colour.build("sable", "black");
		Tincture t2 = Colour.build("sable", "sable");
		assertThat(t1.equals(t2), is(false));
	}
}
