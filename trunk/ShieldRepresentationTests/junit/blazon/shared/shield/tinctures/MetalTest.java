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
	public void testThatToStringForOrIsAsExpected() {
		String name = "or";
		String fillText = "yellow";
		Tincture t = Metal.build(name, fillText);
		String toString = "Tincture{name=or:fillText=yellow}";
		assertThat(t.toString(), is(equalTo(toString)));
	}
	
}
