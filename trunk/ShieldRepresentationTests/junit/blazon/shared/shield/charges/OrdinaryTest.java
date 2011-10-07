package blazon.shared.shield.charges;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import blazon.shared.shield.charges.Ordinary.OrdinaryType;
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
		Ordinary ordinary = new Ordinary();
		Tinctures t = new Tinctures();
		ordinary.getOrdinaryType(null, t.getTincture("or"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatGettingOrdinaryTypeWithEmptyNameThrowsIllegalArgumentException() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tinctures t = new Tinctures();
		ordinary.getOrdinaryType("", t.getTincture("or"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatGettingOrdinaryTypeWithNullTinctureThrowsIllegalArgumentException() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		ordinary.getOrdinaryType("cross", null, null);
	}
	
	@Test
	public void testThatGettingCrossWithTinctureGulesReturnsCorrectOrdinaryObject() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("gules");
		OrdinaryType ordinaryType = ordinary.getOrdinaryType("cross", t, null);
		assertThat(ordinaryType.getName(), is(equalTo("CROSS")));
		assertThat(ordinaryType.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingCrossWithTinctureOrReturnsCorrectOrdinaryObject() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType = ordinary.getOrdinaryType("cross", t, null);
		assertThat(ordinaryType.getName(), is(equalTo("CROSS")));
		assertThat(ordinaryType.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingBendSinisterWithTinctureGulesReturnsCorrectOrdinaryObject() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("gules");
		OrdinaryType ordinaryType = ordinary.getOrdinaryType("bend sinister", t, null);
		assertThat(ordinaryType.getName(), is(equalTo("BEND_SINISTER")));
		assertThat(ordinaryType.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingBendSinisterWithTinctureOrReturnsCorrectOrdinaryObject() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType = ordinary.getOrdinaryType("bend sinister", t, null);
		assertThat(ordinaryType.getName(), is(equalTo("BEND_SINISTER")));
		assertThat(ordinaryType.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingBlahReturnsNoneOrdinaryObjectAndHasWarningInErrorsList() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		OrdinaryType ordinaryType = ordinary.getOrdinaryType("blah", t, diags);
		assertThat(ordinaryType.getName(), is(equalTo("NONE")));
		assertThat(ordinaryType.getTincture(), is(nullValue()));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is(equalTo("Unknown Ordinary 'BLAH'. No ordinary used.")));
	}
	
	@Test
	public void testThatOrdinaryTypeToStringIsAsExpected() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType = ordinary.getOrdinaryType("bend sinister", t, null);
		String expected = "OrdinaryType{tincture=Tincture{name=or:fillText=gold}:name=BEND_SINISTER}";
		assertThat(ordinaryType.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatOrdinaryIsNotEqualToNull() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType = ordinary.getOrdinaryType("bend sinister", t, null);
		assertThat(ordinaryType.equals(null), is(false));
	}
	
	@Test
	public void testThatOrdinaryIsNotEqualToAnObject() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType = ordinary.getOrdinaryType("bend sinister", t, null);
		assertThat(ordinaryType.equals(new Object()), is(false));
	}
	
	@Test
	public void testThatOrdinaryIsEqualToItselfConsistently() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType = ordinary.getOrdinaryType("bend sinister", t, null);
		assertThat(ordinaryType.equals(ordinaryType), is(true));
		assertEquals(ordinaryType.hashCode(), ordinaryType.hashCode());
		assertThat(ordinaryType.equals(ordinaryType), is(true));
		assertEquals(ordinaryType.hashCode(), ordinaryType.hashCode());
	}
	
	@Test
	public void testThatOrdinaryIsEqualToOtherConstructedTheSameWay() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType1 = ordinary.getOrdinaryType("bend sinister", t, null);
		OrdinaryType ordinaryType2 = ordinary.getOrdinaryType("bend sinister", t, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(true));
		assertEquals(ordinaryType1.hashCode(), ordinaryType2.hashCode());

	}
	
	@Test
	public void testThatOrdinaryIsEqualToOtherConstructedTheSameWaySymmetrically() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType1 = ordinary.getOrdinaryType("bend sinister", t, null);
		OrdinaryType ordinaryType2 = ordinary.getOrdinaryType("bend sinister", t, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(true));
		assertEquals(ordinaryType1.hashCode(), ordinaryType2.hashCode());
		assertThat(ordinaryType2.equals(ordinaryType1), is(true));
		assertEquals(ordinaryType2.hashCode(), ordinaryType1.hashCode());

	}
	
	@Test
	public void testThatOrdinaryIsEqualToOtherConstructedTheSameWayTransitively() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType1 = ordinary.getOrdinaryType("bend sinister", t, null);
		OrdinaryType ordinaryType2 = ordinary.getOrdinaryType("bend sinister", t, null);
		OrdinaryType ordinaryType3 = ordinary.getOrdinaryType("bend sinister", t, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(true));
		assertEquals(ordinaryType1.hashCode(), ordinaryType2.hashCode());
		assertThat(ordinaryType2.equals(ordinaryType3), is(true));
		assertEquals(ordinaryType2.hashCode(), ordinaryType3.hashCode());
		assertThat(ordinaryType1.equals(ordinaryType3), is(true));
		assertEquals(ordinaryType1.hashCode(), ordinaryType3.hashCode());

	}
	
	@Test
	public void testThatOrdinariesWithDifferentNamesAreNotEqual() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tincture t = new Tinctures().getTincture("or");
		OrdinaryType ordinaryType1 = ordinary.getOrdinaryType("bend sinister", t, null);
		OrdinaryType ordinaryType2 = ordinary.getOrdinaryType("bend", t, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(false));
	}
	
	@Test
	public void testThatOrdinariesWithDifferentTincturesAreNotEqual() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tinctures tinctures = new Tinctures();
		Tincture t1 = tinctures.getTincture("or");
		Tincture t2 = tinctures.getTincture("gules");
		OrdinaryType ordinaryType1 = ordinary.getOrdinaryType("bend sinister", t1, null);
		OrdinaryType ordinaryType2 = ordinary.getOrdinaryType("bend sinister", t2, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(false));
	}
	
	@Test
	public void testThatInvalidOrdinariesWithDifferentTincturesAreEqual() throws UnknownTinctureException {
		Ordinary ordinary = new Ordinary();
		Tinctures tinctures = new Tinctures();
		Tincture t1 = tinctures.getTincture("or");
		Tincture t2 = tinctures.getTincture("gules");
		OrdinaryType ordinaryType1 = ordinary.getOrdinaryType("blah", t1, null);
		OrdinaryType ordinaryType2 = ordinary.getOrdinaryType("blah", t2, null);

		assertThat(ordinaryType1.equals(ordinaryType2), is(true));
		assertEquals(ordinaryType1.hashCode(), ordinaryType2.hashCode());
	}
}
