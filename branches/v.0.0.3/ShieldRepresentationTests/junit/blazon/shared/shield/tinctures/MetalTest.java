package blazon.shared.shield.tinctures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MetalTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullNameAndColourThrowsIllegalArgumentException() {
			Metal.build(null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullNameThrowsIllegalArgumentException() {
			Metal.build(null, "colour");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullColourThrowsIllegalArgumentException() {
			Metal.build("name", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyNameAndColourThrowsIllegalArgumentException() {
			Metal.build("", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyNameThrowsIllegalArgumentException() {
			Metal.build("", "colour");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyColourThrowsIllegalArgumentException() {
			Metal.build("name", "");
	}
	
	@Test
	public void testThatBuildSetsNameToOr() {
		String name = "or";
		Tincture t = Metal.build(name, "yellow");
		assertThat(t.getName(), is(equalTo(name)));
	}
	
	@Test
	public void testThatBuildSetsNameToArgent() {
		String name = "argent";
		Tincture t = Metal.build(name, "silver");
		assertThat(t.getName(), is(equalTo(name)));
	}
	
	@Test
	public void testThatBuildSetsFillTextToYellow() {
		String fillText = "yellow";
		Tincture t = Metal.build("or", fillText);
		assertThat(t.getFillText(), is(equalTo(fillText)));
	}
	
	@Test
	public void testThatBuildSetsFillTextToSilver() {
		String fillText = "silver";
		Tincture t = Metal.build("argent", fillText);
		assertThat(t.getFillText(), is(equalTo(fillText)));
	}
	
	@Test
	public void testThatMetalGetTinctureTypeReturnsMetal() {
		Tincture t = Metal.build("or", "yellow");
		assertThat(t.getTinctureType(), is(TinctureType.METAL));
	}
	
	@Test
	public void testThatToStringForOrIsAsExpected() {
		String name = "or";
		String fillText = "yellow";
		Tincture t = Metal.build(name, fillText);
		String toString = "Tincture{name=or:fillText=yellow}";
		assertThat(t.toString(), is(equalTo(toString)));
	}
	
	@Test
	public void testThatEqualsReturnsFalseForNull() {
		Tincture t = Metal.build("or", "yellow");
		assertThat(t.equals(null), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsFalseWhenComparingWithObjectVariable() {
		Tincture t = Metal.build("or", "yellow");
		assertThat(t.equals(new Object()), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsTrueWhenPassingReferenceToSameObject() {
		Tincture t = Metal.build("or", "yellow");
		assertThat(t.equals(t), is(true));
	}
	
	@Test
	public void testThatEqualsReturnsTrueConstistentlyWhenPassingReferenceToSameObject() {
		Tincture t = Metal.build("or", "yellow");
		assertThat(t.equals(t), is(true));
		assertThat(t.equals(t), is(true));
		assertThat(t.equals(t), is(true));
	}
	
	@Test
	public void testThatEqualsReturnsTrueWhenPassingObjectThatWasConstructedUsingTheSameParameters() {
		Tincture t1 = Metal.build("or", "yellow");
		Tincture t2 = Metal.build("or", "yellow");
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
	}
	
	@Test
	public void testThatEqualsReturnsTrueConsistentlyWhenPassingObjectThatWasConstructedUsingTheSameParameters() {
		Tincture t1 = Metal.build("or", "yellow");
		Tincture t2 = Metal.build("or", "yellow");
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.equals(t2), is(true));
	}
	
	@Test
	public void testThatEqualsReturnsTrueSymmetricallyForObjectsConstructedTheSameWay() {
		Tincture t1 = Metal.build("or", "yellow");
		Tincture t2 = Metal.build("or", "yellow");
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
		assertThat(t2.equals(t1), is(true));
		assertThat(t2.hashCode(), is(equalTo(t1.hashCode())));
	}
	
	@Test
	public void testThatEqualsReturnsTrueTransitivelyForObjectsConstructedTheSameWay() {
		Tincture t1 = Metal.build("or", "yellow");
		Tincture t2 = Metal.build("or", "yellow");
		Tincture t3 = Metal.build("or", "yellow");
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
		assertThat(t2.equals(t3), is(true));
		assertThat(t2.hashCode(), is(equalTo(t3.hashCode())));
		assertThat(t1.equals(t3), is(true));
		assertThat(t1.hashCode(), is(equalTo(t3.hashCode())));
	}
	
	@Test
	public void testThatEqualsReturnsFalseWhenConstructedWithDifferentNames() {
		Tincture t1 = Colour.build("or", "yellow");
		Tincture t2 = Colour.build("yellow", "yellow");
		assertThat(t1.equals(t2), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsFalseConsistentlyWhenConstructedWithDifferentNames() {
		Tincture t1 = Colour.build("or", "yellow");
		Tincture t2 = Colour.build("yellow", "yellow");
		assertThat(t1.equals(t2), is(false));
		assertThat(t1.equals(t2), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsFalseWhenConstructedWithDifferentColour() {
		Tincture t1 = Colour.build("or", "yellow");
		Tincture t2 = Colour.build("or", "or");
		assertThat(t1.equals(t2), is(false));
	}
}
