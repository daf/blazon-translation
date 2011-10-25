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
		assertThat(diags.get(0).getMessage(), is(equalTo("Unknown geometric charge 'BLAH'. No geometric charge used.")));
	}
	
	@Test
	public void testThatOrdinaryToStringIsAsExpected() throws UnknownTinctureException {
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
		GeometricCharge ordinary1 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinary2 = GeometricCharge.build("bend sinister", t, null);

		assertThat(ordinary1.equals(ordinary2), is(true));
		assertEquals(ordinary1.hashCode(), ordinary2.hashCode());

	}
	
	@Test
	public void testThatOrdinaryIsEqualToOtherConstructedTheSameWaySymmetrically() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary1 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinary2 = GeometricCharge.build("bend sinister", t, null);

		assertThat(ordinary1.equals(ordinary2), is(true));
		assertEquals(ordinary1.hashCode(), ordinary2.hashCode());
		assertThat(ordinary2.equals(ordinary1), is(true));
		assertEquals(ordinary2.hashCode(), ordinary1.hashCode());

	}
	
	@Test
	public void testThatOrdinaryIsEqualToOtherConstructedTheSameWayTransitively() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary1 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinary2 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinary3 = GeometricCharge.build("bend sinister", t, null);

		assertThat(ordinary1.equals(ordinary2), is(true));
		assertEquals(ordinary1.hashCode(), ordinary2.hashCode());
		assertThat(ordinary2.equals(ordinary3), is(true));
		assertEquals(ordinary2.hashCode(), ordinary3.hashCode());
		assertThat(ordinary1.equals(ordinary3), is(true));
		assertEquals(ordinary1.hashCode(), ordinary3.hashCode());

	}
	
	@Test
	public void testThatOrdinariesWithDifferentNamesAreNotEqual() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge ordinary1 = GeometricCharge.build("bend sinister", t, null);
		GeometricCharge ordinary2 = GeometricCharge.build("bend", t, null);

		assertThat(ordinary1.equals(ordinary2), is(false));
	}
	
	@Test
	public void testThatOrdinariesWithDifferentTincturesAreNotEqual() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture t1 = tinctures.getTincture("or");
		Tincture t2 = tinctures.getTincture("gules");
		GeometricCharge ordinary1 = GeometricCharge.build("bend sinister", t1, null);
		GeometricCharge ordinary2 = GeometricCharge.build("bend sinister", t2, null);

		assertThat(ordinary1.equals(ordinary2), is(false));
	}
}
