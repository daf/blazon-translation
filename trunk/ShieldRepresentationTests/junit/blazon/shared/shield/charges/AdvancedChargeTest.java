package blazon.shared.shield.charges;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

public class AdvancedChargeTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithAllNullThrowsIllegalArgumentException() {
		AdvancedCharge.build(null, null, null, null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullNameThrowsIllegalArgumentException() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		AdvancedCharge.build(null, "rampant", null,	tinctures.getTincture("or"), null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyNameThrowsIllegalArgumentException() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		AdvancedCharge.build("", "rampant", null,	tinctures.getTincture("or"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullAttitudeThrowsIllegalArgumentException() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		AdvancedCharge.build("lion", null, null,	tinctures.getTincture("or"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithEmptyAttitudeThrowsIllegalArgumentException() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		AdvancedCharge.build("lion", "", null,	tinctures.getTincture("or"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildWithNullTinctureThrowsIllegalArgumentException() throws UnknownTinctureException {
		AdvancedCharge.build("lion", "rampant", null, null, null);
	}
	
	@Test
	public void testThatBuildSetsNameCorrectly() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		String name = "lion";
		AdvancedCharge charge = AdvancedCharge.build(name, "rampant", null, tinctures.getTincture("or"), null);
		assertThat(charge.getName(), is(equalTo(name)));
	}
	
	@Test
	public void testThatBuildSetsAttitudeCorrectly() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		String attitude = "rampant";
		AdvancedCharge charge = AdvancedCharge.build("lion", attitude, null, tinctures.getTincture("or"), null);
		assertThat(charge.getAttitude(), is(equalTo(attitude)));
	}
	
	@Test
	public void testThatBuildWithoutModifierSetsModifierToNull() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", null, tinctures.getTincture("or"), null);
		assertNull(charge.getAttitudeModifier());
	}
	
	@Test
	public void testThatBuildSetsTinctureCorrectly() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture tincture = tinctures.getTincture("or");
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", null, tincture, null);
		assertThat(charge.getTincture(), is(equalTo(tincture)));
	}
	
	
	@Test
	public void testThatBuildWithModifierSetsModifierCorrectly() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		String attMod = "guardant";
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", attMod, tinctures.getTincture("or"), null);
		assertThat(charge.getAttitudeModifier(), is(equalTo(attMod)));
	}
	
	@Test
	public void testThatBuildWithoutBodyParthSetsBodyPartsToNull() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", null, tinctures.getTincture("or"), null);
		assertNull(charge.getSpecifiedBodyParts());
	}
	
	@Test
	public void testThatBuildWithEmptyBodyPartsSetsBodyPartsToEmpty() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", "guardant", tinctures.getTincture("or"), new HashMap<String, Tincture>());
		assertThat(charge.getSpecifiedBodyParts().size(), is(0));
	}
	
	@Test
	public void testThatBuildWithBodyPartsSetsBodyPartsCorrectly() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Map<String, Tincture> bodyParts = new HashMap<String, Tincture>();
		bodyParts.put("langued", tinctures.getTincture("gules"));
		bodyParts.put("armed", tinctures.getTincture("argent"));
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", "guardant", tinctures.getTincture("or"), bodyParts);
		assertThat(charge.getSpecifiedBodyParts(), is(equalTo(bodyParts)));
	}
	
	@Test
	public void testThatNewlyBuiltChargeDoesNotHaveASource() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Map<String, Tincture> bodyParts = new HashMap<String, Tincture>();
		bodyParts.put("langued", tinctures.getTincture("gules"));
		bodyParts.put("armed", tinctures.getTincture("argent"));
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", "guardant", tinctures.getTincture("or"), bodyParts);
		assertFalse(charge.hasSource());
		assertNull(charge.getSource());
	}
	
	@Test
	public void testThatAfterSourceIsSetItCanBeReturned() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Map<String, Tincture> bodyParts = new HashMap<String, Tincture>();
		bodyParts.put("langued", tinctures.getTincture("gules"));
		bodyParts.put("armed", tinctures.getTincture("argent"));
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", "guardant", tinctures.getTincture("or"), bodyParts);
		assertFalse(charge.hasSource());
		assertNull(charge.getSource());
		String source = "http://shielddrawing.appspot.com";
		charge.setSource(source);
		assertTrue(charge.hasSource());
		assertThat(charge.getSource(), is(equalTo(source)));
	}
	
	@Test
	public void testThatAfterSourceIsSetItCanNotBeChanged() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Map<String, Tincture> bodyParts = new HashMap<String, Tincture>();
		bodyParts.put("langued", tinctures.getTincture("gules"));
		bodyParts.put("armed", tinctures.getTincture("argent"));
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", "guardant", tinctures.getTincture("or"), bodyParts);
		assertFalse(charge.hasSource());
		assertNull(charge.getSource());
		String source = "http://shielddrawing.appspot.com";
		assertTrue(charge.setSource(source));
		assertTrue(charge.hasSource());
		assertThat(charge.getSource(), is(equalTo(source)));
		assertFalse(charge.setSource("http://someother.webaddress.com"));
		assertTrue(charge.hasSource());
		assertThat(charge.getSource(), is(equalTo(source)));
	}
	
	@Test
	public void testThatTextDescriptionWithoutBodyPartsIsAsExpected() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", "guardant", tinctures.getTincture("or"), null);
		String expectedTextDescription = "'lion rampant guardant or'";
		assertThat(charge.getTextDescription(), is(equalTo(expectedTextDescription)));
	}
	
	@Test
	public void testThatTextDescriptionWithEmptyBodyPartsIsAsExpected() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", "guardant", tinctures.getTincture("or"), new HashMap<String, Tincture>());
		String expectedTextDescription = "'lion rampant guardant or'";
		assertThat(charge.getTextDescription(), is(equalTo(expectedTextDescription)));
	}
	
	@Test
	public void testThatTextDescriptionWithBodyPartsIsAsExpected() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Map<String, Tincture> bodyParts = new HashMap<String, Tincture>();
		bodyParts.put("langued", tinctures.getTincture("gules"));
		bodyParts.put("armed", tinctures.getTincture("argent"));
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", "guardant", tinctures.getTincture("or"), bodyParts);
		String expectedTextDescription = "'lion rampant guardant or langued gules armed argent'";
		assertThat(charge.getTextDescription(), is(equalTo(expectedTextDescription)));
	}
	
	@Test
	public void testThatTextDescriptionWithoutAttitudeModifierIsAsExpected() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Map<String, Tincture> bodyParts = new HashMap<String, Tincture>();
		bodyParts.put("langued", tinctures.getTincture("gules"));
		bodyParts.put("armed", tinctures.getTincture("argent"));
		AdvancedCharge charge = AdvancedCharge.build("lion", "rampant", null, tinctures.getTincture("or"), bodyParts);
		String expectedTextDescription = "'lion rampant or langued gules armed argent'";
		assertThat(charge.getTextDescription(), is(equalTo(expectedTextDescription)));
	}
}
