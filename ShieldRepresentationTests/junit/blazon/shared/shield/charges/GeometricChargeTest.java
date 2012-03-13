package blazon.shared.shield.charges;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GeometricChargeTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatGettingGeometricChargeWithNullNameThrowsIllegalArgumentException() throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		GeometricCharge.build(null, t.getTincture("or"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatGettingGeometricChargeWithEmptyNameThrowsIllegalArgumentException() throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		GeometricCharge.build("", t.getTincture("or"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatGettingGeometricChargeWithNullTinctureThrowsIllegalArgumentException() throws UnknownTinctureException {
		GeometricCharge.build("pall", null, null);
	}
	
	@Test
	public void testThatGettingGeometricChargeWithUnknownNameReturnsNullAndGivesShieldDiagnostic() throws UnknownTinctureException {
		Tinctures t = new Tinctures();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		assertThat(GeometricCharge.build("blah", t.getTincture("or"), diags), is(nullValue()));
		assertThat(diags.size(), is(equalTo(1)));
		assertThat(diags.get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.WARNING));
		assertThat(diags.get(0).getMessage(), is(equalTo("Unknown geometric charge 'BLAH'. No geometric charge used.")));
	}
	
}
