package blazon.shared.shield.charges;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;


public class OrdinaryTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatGettingOrdinaryTypeWithNullNameThrowsIllegalArgumentException() throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		GeometricCharge.build(null, t.getTincture("or"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatGettingOrdinaryTypeWithEmptyNameThrowsIllegalArgumentException() throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		GeometricCharge.build("", t.getTincture("or"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatGettingOrdinaryTypeWithNullTinctureThrowsIllegalArgumentException() throws UnknownTinctureException {
		GeometricCharge.build("cross", null, null);
	}
	
	@Test
	public void testThatGettingCrossWithTinctureGulesReturnsCorrectOrdinaryObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("gules");
		GeometricCharge ordinary = GeometricCharge.build("cross", t, null);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingCrossWithTinctureOrReturnsCorrectOrdinaryObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("cross", t, null);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingBendSinisterWithTinctureGulesReturnsCorrectOrdinaryObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("gules");
		GeometricCharge ordinary = GeometricCharge.build("bend sinister", t, null);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND_SINISTER)));
		assertThat(ordinary.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingBendSinisterWithTinctureOrReturnsCorrectOrdinaryObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("bend sinister", t, null);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND_SINISTER)));
		assertThat(ordinary.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingBlahReturnsNullAndHasWarningInErrorsList() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		GeometricCharge ordinary = GeometricCharge.build("blah", t, diags);
		assertThat(ordinary, is(nullValue()));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is(equalTo("Unknown Ordinary 'BLAH'. No ordinary used.")));
	}
	
	@Test
	public void testThatOrdinaryTypeToStringIsAsExpected() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("bend sinister", t, null);
		String expected = "Ordinary{tincture=Tincture{name=or:fillText=gold}:name=BEND_SINISTER}";
		assertThat(ordinary.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatOrdinaryIsNotEqualToNull() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("bend sinister", t, null);
		assertThat(ordinary.equals(null), is(false));
	}
	
	@Test
	public void testThatOrdinaryIsNotEqualToAnObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("bend sinister", t, null);
		assertThat(ordinary.equals(new Object()), is(false));
	}
	
	@Test
	public void testThatOrdinaryIsEqualToItselfConsistently() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary = GeometricCharge.build("bend sinister", t, null);
		assertThat(ordinary.equals(ordinary), is(true));
		assertEquals(ordinary.hashCode(), ordinary.hashCode());
		assertThat(ordinary.equals(ordinary), is(true));
		assertEquals(ordinary.hashCode(), ordinary.hashCode());
	}
	
	@Test
	public void testThatOrdinaryIsEqualToOtherConstructedTheSameWay() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinaryType1 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinaryType2 = GeometricCharge.build("bend sinister", t, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(true));
		assertEquals(ordinaryType1.hashCode(), ordinaryType2.hashCode());

	}
	
	@Test
	public void testThatOrdinaryIsEqualToOtherConstructedTheSameWaySymmetrically() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinaryType1 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinaryType2 = GeometricCharge.build("bend sinister", t, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(true));
		assertEquals(ordinaryType1.hashCode(), ordinaryType2.hashCode());
		assertThat(ordinaryType2.equals(ordinaryType1), is(true));
		assertEquals(ordinaryType2.hashCode(), ordinaryType1.hashCode());

	}
	
	@Test
	public void testThatOrdinaryIsEqualToOtherConstructedTheSameWayTransitively() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinaryType1 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinaryType2 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinaryType3 = GeometricCharge.build("bend sinister", t, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(true));
		assertEquals(ordinaryType1.hashCode(), ordinaryType2.hashCode());
		assertThat(ordinaryType2.equals(ordinaryType3), is(true));
		assertEquals(ordinaryType2.hashCode(), ordinaryType3.hashCode());
		assertThat(ordinaryType1.equals(ordinaryType3), is(true));
		assertEquals(ordinaryType1.hashCode(), ordinaryType3.hashCode());

	}
	
	@Test
	public void testThatOrdinariesWithDifferentNamesAreNotEqual() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinaryType1 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinaryType2 = GeometricCharge.build("bend", t, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(false));
	}
	
	@Test
	public void testThatOrdinariesWithDifferentTincturesAreNotEqual() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture t1 = tinctures.getTincture("or");
		Tincture t2 = tinctures.getTincture("gules");
		GeometricCharge ordinaryType1 = GeometricCharge.build("bend sinister", t1, null);
		GeometricCharge ordinaryType2 = GeometricCharge.build("bend sinister", t2, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(false));
	}
}
