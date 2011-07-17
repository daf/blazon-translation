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
}
