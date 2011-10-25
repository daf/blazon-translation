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


public class SubordinaryTest {
	
	@Test
	public void testThatGettingpallWithTinctureGulesReturnsCorrectSubordinaryObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("gules");
		GeometricCharge subordinary = GeometricCharge.build("pall", t, null);
		assertThat(subordinary.getName(), is(equalTo(GeometricChargeNames.PALL)));
		assertThat(subordinary.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingpallWithTinctureOrReturnsCorrectSubordinaryObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary = GeometricCharge.build("pall", t, null);
		assertThat(subordinary.getName(), is(equalTo(GeometricChargeNames.PALL)));
		assertThat(subordinary.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingPileReversedWithTinctureGulesReturnsCorrectSubordinaryObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("gules");
		GeometricCharge subordinary = GeometricCharge.build("pile reversed", t, null);
		assertThat(subordinary.getName(), is(equalTo(GeometricChargeNames.PILE_REVERSED)));
		assertThat(subordinary.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingPileReversedWithTinctureOrReturnsCorrectSubordinaryObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary = GeometricCharge.build("pile reversed", t, null);
		assertThat(subordinary.getName(), is(equalTo(GeometricChargeNames.PILE_REVERSED)));
		assertThat(subordinary.getTincture(), is(equalTo(t)));
	}
	
	@Test
	public void testThatGettingBlahReturnsNullAndHasWarningInErrorsList() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		GeometricCharge subordinary = GeometricCharge.build("blah", t, diags);
		assertThat(subordinary, is(nullValue()));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is(equalTo("Unknown geometric charge 'BLAH'. No geometric charge used.")));
	}
	
	@Test
	public void testThatSubordinaryToStringIsAsExpected() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary = GeometricCharge.build("pile reversed", t, null);
		String expected = "Subordinary{tincture=Tincture{name=or:fillText=gold}:name=PILE_REVERSED}";
		assertThat(subordinary.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatSubordinaryIsNotEqualToNull() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary = GeometricCharge.build("pile reversed", t, null);
		assertThat(subordinary.equals(null), is(false));
	}
	
	@Test
	public void testThatSubordinaryIsNotEqualToAnObject() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary = GeometricCharge.build("pile reversed", t, null);
		assertThat(subordinary.equals(new Object()), is(false));
	}
	
	@Test
	public void testThatSubordinaryIsEqualToItselfConsistently() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary = GeometricCharge.build("pile reversed", t, null);
		assertThat(subordinary.equals(subordinary), is(true));
		assertEquals(subordinary.hashCode(), subordinary.hashCode());
		assertThat(subordinary.equals(subordinary), is(true));
		assertEquals(subordinary.hashCode(), subordinary.hashCode());
	}
	
	@Test
	public void testThatSubordinaryIsEqualToOtherConstructedTheSameWay() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary1 = GeometricCharge.build("pile reversed", t, null);
		GeometricCharge subordinary2 = GeometricCharge.build("pile reversed", t, null);

		assertThat(subordinary1.equals(subordinary2), is(true));
		assertEquals(subordinary1.hashCode(), subordinary2.hashCode());

	}
	
	@Test
	public void testThatSubordinaryIsEqualToOtherConstructedTheSameWaySymmetrically() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary1 = GeometricCharge.build("pile reversed", t, null);
		GeometricCharge subordinary2 = GeometricCharge.build("pile reversed", t, null);

		assertThat(subordinary1.equals(subordinary2), is(true));
		assertEquals(subordinary1.hashCode(), subordinary2.hashCode());
		assertThat(subordinary2.equals(subordinary1), is(true));
		assertEquals(subordinary2.hashCode(), subordinary1.hashCode());

	}
	
	@Test
	public void testThatSubordinaryIsEqualToOtherConstructedTheSameWayTransitively() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary1 = GeometricCharge.build("pile reversed", t, null);
		GeometricCharge subordinary2 = GeometricCharge.build("pile reversed", t, null);
		GeometricCharge subordinary3 = GeometricCharge.build("pile reversed", t, null);

		assertThat(subordinary1.equals(subordinary2), is(true));
		assertEquals(subordinary1.hashCode(), subordinary2.hashCode());
		assertThat(subordinary2.equals(subordinary3), is(true));
		assertEquals(subordinary2.hashCode(), subordinary3.hashCode());
		assertThat(subordinary1.equals(subordinary3), is(true));
		assertEquals(subordinary1.hashCode(), subordinary3.hashCode());

	}
	
	@Test
	public void testThatOrdinariesWithDifferentNamesAreNotEqual() throws UnknownTinctureException {
		Tincture t = new Tinctures().getTincture("or");
		GeometricCharge subordinary1 = GeometricCharge.build("pile reversed", t, null);
		GeometricCharge subordinary2 = GeometricCharge.build("bend", t, null);

		assertThat(subordinary1.equals(subordinary2), is(false));
	}
	
	@Test
	public void testThatOrdinariesWithDifferentTincturesAreNotEqual() throws UnknownTinctureException {
		Tinctures tinctures = new Tinctures();
		Tincture t1 = tinctures.getTincture("or");
		Tincture t2 = tinctures.getTincture("gules");
		GeometricCharge subordinary1 = GeometricCharge.build("pile reversed", t1, null);
		GeometricCharge subordinary2 = GeometricCharge.build("pile reversed", t2, null);

		assertThat(subordinary1.equals(subordinary2), is(false));
	}
}
