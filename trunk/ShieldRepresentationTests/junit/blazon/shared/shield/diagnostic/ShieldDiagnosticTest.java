package blazon.shared.shield.diagnostic;

import org.junit.Test;

import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShieldDiagnosticTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildingAShieldDiagnosticWithNullLogLevelAndMessage() {
		ShieldDiagnostic.build(null, (String)null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildingAShieldDiagnosticWithNullLogLevelButValidMessage() {
		ShieldDiagnostic.build(null, "hello");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatBuildingAShieldDiagnosticWithNullMessage() {
		ShieldDiagnostic.build(LogLevel.ERROR, (String)null);
	}
	
	@Test
	public void testThatYouCanRetrieveTheMessageHelloFromAShieldDiagnostic() {
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.WARNING, "hello");
		assertThat(diag.getMessage(), is(equalTo("hello")));
	}
	
	@Test
	public void testThatYouCanRetrieveTheMessageHelloWorldFromAShieldDiagnostic() {
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.INFO, "hello world");
		assertThat(diag.getMessage(), is(equalTo("hello world")));
	}
	
	@Test
	public void testThatYouCanRetrieveErrorSeverityLevelFromAShieldDiagnostic() {
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		assertThat(diag.getSeverity(), is(equalTo(LogLevel.ERROR)));
	}
	
	@Test
	public void testThatYouCanRetrieveWarningSeverityLevelFromAShieldDiagnostic() {
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.WARNING, "hello");
		assertThat(diag.getSeverity(), is(equalTo(LogLevel.WARNING)));
	}
	
	@Test
	public void testThatShieldDiagnosticWithErrorSeverityLevelAndHelloAsMessageHasExpectedToString() {
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		String expected = "ERROR: hello";
		assertThat(diag.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void testThatShieldDiagnosticLogLevelParsesInfoToCorrectEnumValue() {
		LogLevel logLevel = LogLevel.valueOf("INFO");
		assertThat(logLevel, is(equalTo(LogLevel.INFO)));
	}
	
	@Test
	public void testThatShieldDiagnosticLogLevelParsesWarnToCorrectEnumValue() {
		LogLevel logLevel = LogLevel.valueOf("WARNING");
		assertThat(logLevel, is(equalTo(LogLevel.WARNING)));
	}
	
	@Test
	public void testThatShieldDiagnosticLogLevelParsesErrorToCorrectEnumValue() {
		LogLevel logLevel = LogLevel.valueOf("ERROR");
		assertThat(logLevel, is(equalTo(LogLevel.ERROR)));
	}
}
