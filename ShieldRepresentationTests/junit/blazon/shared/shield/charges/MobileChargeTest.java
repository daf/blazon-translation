package blazon.shared.shield.charges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

public class MobileChargeTest {

	@Test
	public void testThatRoundelHasSourceReturnsTrue() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("roundel", t, null);
		assertTrue(ordinary.hasSource());
	}
	
	@Test
	public void testThatMulletHasSourceReturnsTrue() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("mullet", t, null);
		assertTrue(ordinary.hasSource());
	}
	
	@Test
	public void testThatRoundelGetSourceReturnsNull() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("roundel", t, null);
		assertNull(ordinary.getSource());
	}
	
	@Test
	public void testThatMulletGetSourceReturnsNull() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("mullet", t, null);
		assertNull(ordinary.getSource());
	}
	
	@Test
	public void testThatMulletSetSourceWithNullReturnsFalse() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("mullet", t, null);
		assertFalse(ordinary.setSource(null));
	}
	
	@Test
	public void testThatMulletSetSourceWithEmptyStringReturnsFalse() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("mullet", t, null);
		assertFalse(ordinary.setSource(""));
	}
	
	@Test
	public void testThatMulletSetSourceWithSomeURLStringReturnsFalse() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("mullet", t, null);
		assertFalse(ordinary.setSource("http://shielddrawing.appspot.com"));
	}
	
	@Test
	public void testThatRoundelGetNameReturnsRoundel() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("roundel", t, null);
		assertThat(ordinary.getName(), is(equalTo("roundel")));
	}
	
	@Test
	public void testThatRoundelGetTextDescriptionReturnsAsExpected() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("roundel", t, null);
		assertThat(ordinary.getTextDescription(), is(equalTo("'roundel or'")));
	}
	
	@Test
	public void testThatMulletGetNameReturnsMullet() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("mullet", t, null);
		assertThat(ordinary.getName(), is(equalTo("mullet")));
	}
	
	@Test
	public void testThatMulletGetTextDescriptionReturnsAsExpected() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("gules");
		GeometricCharge ordinary = GeometricCharge.build("mullet", t, null);
		assertThat(ordinary.getTextDescription(), is(equalTo("'mullet gules'")));
	}
	
	@Test
	public void testThatMobileChargeIsNotEqualToNull() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge mobileCharge = GeometricCharge.build("mullet", t, null);
		assertThat(mobileCharge.equals(null), is(false));
	}
	
	@Test
	public void testThatMobileChargeIsNotEqualToAnObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge mobileCharge = GeometricCharge.build("mullet", t, null);
		assertThat(mobileCharge.equals(new Object()), is(false));
	}
	
	@Test
	public void testThatMobileChargeIsEqualToItselfConsistently() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge mobileCharge = GeometricCharge.build("mullet", t, null);
		assertThat(mobileCharge.equals(mobileCharge), is(true));
		assertEquals(mobileCharge.hashCode(), mobileCharge.hashCode());
		assertThat(mobileCharge.equals(mobileCharge), is(true));
		assertEquals(mobileCharge.hashCode(), mobileCharge.hashCode());
	}
	
	@Test
	public void testThatMobileChargeIsEqualToOtherConstructedTheSameWay() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge mobileCharge1 = GeometricCharge.build("mullet", t, null);
		GeometricCharge mobileCharge2 = GeometricCharge.build("mullet", t, null);

		assertThat(mobileCharge1.equals(mobileCharge2), is(true));
		assertEquals(mobileCharge1.hashCode(), mobileCharge2.hashCode());

	}
	
	@Test
	public void testThatMobileChargeIsEqualToOtherConstructedTheSameWaySymmetrically() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge mobileCharge1 = GeometricCharge.build("mullet", t, null);
		GeometricCharge mobileCharge2 = GeometricCharge.build("mullet", t, null);

		assertThat(mobileCharge1.equals(mobileCharge2), is(true));
		assertEquals(mobileCharge1.hashCode(), mobileCharge2.hashCode());
		assertThat(mobileCharge2.equals(mobileCharge1), is(true));
		assertEquals(mobileCharge2.hashCode(), mobileCharge1.hashCode());

	}
	
	@Test
	public void testThatMobileChargeIsEqualToOtherConstructedTheSameWayTransitively() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge mobileCharge1 = GeometricCharge.build("mullet", t, null);
		GeometricCharge mobileCharge2 = GeometricCharge.build("mullet", t, null);
		GeometricCharge mobileCharge3 = GeometricCharge.build("mullet", t, null);

		assertThat(mobileCharge1.equals(mobileCharge2), is(true));
		assertEquals(mobileCharge1.hashCode(), mobileCharge2.hashCode());
		assertThat(mobileCharge2.equals(mobileCharge3), is(true));
		assertEquals(mobileCharge2.hashCode(), mobileCharge3.hashCode());
		assertThat(mobileCharge1.equals(mobileCharge3), is(true));
		assertEquals(mobileCharge1.hashCode(), mobileCharge3.hashCode());

	}
	
	@Test
	public void testThatOrdinariesWithDifferentNamesAreNotEqual() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge mobileCharge1 = GeometricCharge.build("mullet", t, null);
		GeometricCharge mobileCharge2 = GeometricCharge.build("roundel", t, null);

		assertThat(mobileCharge1.equals(mobileCharge2), is(false));
	}
	
	@Test
	public void testThatOrdinariesWithDifferentTincturesAreNotEqual() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture t1 = tinctures.getTincture("or");
		Tincture t2 = tinctures.getTincture("gules");
		GeometricCharge mobileCharge1 = GeometricCharge.build("mullet", t1, null);
		GeometricCharge mobileCharge2 = GeometricCharge.build("mullet", t2, null);

		assertThat(mobileCharge1.equals(mobileCharge2), is(false));
	}
	
	@Test
	public void testThatMobileChargeToStringIsAsExpected() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("mullet", t, null);
		String expected = "MobileCharge{tincture=Tincture{name=or:fillText=gold}:name=MULLET}";
		assertThat(ordinary.toString(), is(equalTo(expected)));
	}
}
