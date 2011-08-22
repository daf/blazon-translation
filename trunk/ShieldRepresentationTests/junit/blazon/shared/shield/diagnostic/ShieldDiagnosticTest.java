package blazon.shared.shield.diagnostic;

import org.junit.Test;

import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShieldDiagnosticTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildingAShieldDiagnosticWithNullLogLevelAndException() {
		ShieldDiagnostic.build(null, (Exception)null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildingAShieldDiagnosticWithNullLogLevelAndMessage() {
		ShieldDiagnostic.build(null, (String)null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildingAShieldDiagnosticWithNullLogLevelButValidException() {
		ShieldDiagnostic.build(null, new Exception("hello"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildingAShieldDiagnosticWithNullLogLevelButValidMessage() {
		ShieldDiagnostic.build(null, "hello");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildingAShieldDiagnosticWithNullException() {
		ShieldDiagnostic.build(LogLevel.ERROR, (Exception)null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildingAShieldDiagnosticWithNullMessage() {
		ShieldDiagnostic.build(LogLevel.ERROR, (String)null);
	}
	
	@Test
	public void testThatYouCanRetrieveTheLogLevelFromABuiltShieldDiagnostic() {
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.WARN, new Exception("hello"));
		assertThat(diag.getSeverity(), is(equalTo(LogLevel.WARN)));
	}
	
	@Test
	public void testThatYouCanRetrieveTheMessageFromAShieldDiagnosticBuiltWithAMessage() {
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		assertThat(diag.getMessage(), is(equalTo("hello")));
	}
	
	@Test
	public void testThatYouCanRetrieveTheMessageFromAShieldDiagnosticBuiltWithAnException() {
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.INFO, new Exception("hello"));
		assertThat(diag.getMessage(), is(equalTo("hello")));
	}
}
