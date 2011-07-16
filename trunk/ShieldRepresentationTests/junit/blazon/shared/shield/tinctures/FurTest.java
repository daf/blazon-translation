package blazon.shared.shield.tinctures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FurTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullNameAndColoursThrowsIllegalArgumentException() {
		Fur.build(null, null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullNameThrowsIllegalArgumentException() {
		Fur.build(null, "blue", "silver");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullColour1ThrowsIllegalArgumentException() {
		Fur.build("fur", null, "silver");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullColour2ThrowsIllegalArgumentException() {
		Fur.build("fur", "blue", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullNameAndColour1ThrowsIllegalArgumentException() {
		Fur.build(null, null, "silver");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullNameAndColour2ThrowsIllegalArgumentException() {
		Fur.build(null, "silver", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullColour1AndColour2ThrowsIllegalArgumentException() {
		Fur.build("fur", null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyNameAndColoursThrowsIllegalArgumentException() {
		Fur.build("", "", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyNameThrowsIllegalArgumentException() {
		Fur.build("", "blue", "silver");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyColour1ThrowsIllegalArgumentException() {
		Fur.build("fur", "", "silver");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyColour2ThrowsIllegalArgumentException() {
		Fur.build("fur", "blue", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyNameAndColour1ThrowsIllegalArgumentException() {
		Fur.build("", "", "silver");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyNameAndColour2ThrowsIllegalArgumentException() {
		Fur.build("", "silver", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyColour1AndColour2ThrowsIllegalArgumentException() {
		Fur.build("fur", "", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithUnknownFurNameThrowsIllegalArgumentException() {
		Fur.build("fur", "blue", "silver");
	}
	
	@Test
	public void testThatBuildSetsFurNameToVair() {
		String furName = "vair";
		Fur f = (Fur) Fur.build(furName, "blue", "silver");
		assertThat(f.getName(), is(equalTo(furName)));
	}
	
	@Test
	public void testThatBuildSetsFurNameToCounterPotent() {
		String furName = "counter-potent";
		Fur f = (Fur) Fur.build(furName, "blue", "silver");
		assertThat(f.getName(), is(equalTo(furName)));
	}
	
	@Test
	public void testThatBuildSetsColour1ToBlue() {
		String colour1 = "blue";
		Fur f = (Fur) Fur.build("vair", colour1, "silver");
		assertThat(f.getColour1(), is(equalTo(colour1)));
	}
	
	@Test
	public void testThatBuildSetsColour1ToSilver() {
		String colour2 = "silver";
		Fur f = (Fur) Fur.build("vair", "blue", colour2);
		assertThat(f.getColour2(), is(equalTo(colour2)));
	}
	
	@Test
	public void testThatBuildSetsFurTypeToVair() {
		String furType = "vair";
		Fur f = (Fur) Fur.build("vair", "blue", "silver");
		assertThat(f.getFurType(), is(equalTo(furType)));
	}
	
	@Test
	public void testThatBuildSetsFurTypeToPotent() {
		String furType = "potent";
		Fur f = (Fur) Fur.build("potent-en-point", "blue", "silver");
		assertThat(f.getFurType(), is(equalTo(furType)));
	}
	
	@Test
	public void testThatBuildErminoisSetsFurTypeToErmine() {
		String furType = "ermine";
		Fur f = (Fur) Fur.build("erminois", "yellow", "black");
		assertThat(f.getFurType(), is(equalTo(furType)));
	}
	
	@Test
	public void testThatBuildPeanSetsFurTypeToErmine() {
		String furType = "ermine";
		Fur f = (Fur) Fur.build("pean", "black", "yellow");
		assertThat(f.getFurType(), is(equalTo(furType)));
	}
	
	@Test
	public void testThatBuildSetsFillTextToUrlHashErmine() {
		String fillText = "url(#ermines)";
		Fur f = (Fur) Fur.build("ermines", "black", "silver");
		assertThat(f.getFillText(), is(equalTo(fillText)));
	}
	
	@Test
	public void testThatBuildSetsFillTextToUrlHashVairEnPale() {
		String fillText = "url(#vair-en-pale)";
		Fur f = (Fur) Fur.build("vair-en-pale", "blue", "white");
		assertThat(f.getFillText(), is(equalTo(fillText)));
	}
	
	@Test
	public void testThatFurToStringForPeanIsAsExpected() {
		String toString = "Tincture:name=vair-en-pale:fillText=url(#vair-en-pale)";
		Fur f = (Fur) Fur.build("vair-en-pale", "blue", "white");
		assertThat(f.toString(), is(equalTo(toString)));
	}
}
