
import org.antlr.gunit.gUnitBaseTest;

public class TestBlazon extends gUnitBaseTest {
	
	public void setUp() {
		this.packagePath = "./blazon/server/grammar";
		this.lexerPath = "blazon.server.grammar.BlazonLexer";
		this.parserPath = "blazon.server.grammar.BlazonParser";
	}

	public void testDIV1() throws Exception {
		// gunit test on line 9
		Object retval = execLexer("DIV", 9, "fess", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testDIV2() throws Exception {
		// gunit test on line 10
		Object retval = execLexer("DIV", 10, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testDIV3() throws Exception {
		// gunit test on line 11
		Object retval = execLexer("DIV", 11, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testDIV4() throws Exception {
		// gunit test on line 12
		Object retval = execLexer("DIV", 12, "cross", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testDIV5() throws Exception {
		// gunit test on line 13
		Object retval = execLexer("DIV", 13, "saltire", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testDIV6() throws Exception {
		// gunit test on line 14
		Object retval = execLexer("DIV", 14, "chevron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testDIV7() throws Exception {
		// gunit test on line 15
		Object retval = execLexer("DIV", 15, "pall", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testDIV8() throws Exception {
		// gunit test on line 16
		Object retval = execLexer("DIV", 16, "pairle", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testDIV9() throws Exception {
		// gunit test on line 17
		Object retval = execLexer("DIV", 17, "bend sinister", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testDIV10() throws Exception {
		// gunit test on line 18
		Object retval = execLexer("DIV", 18, "gyronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIV", expecting, actual);
	}

	public void testTIERCED1() throws Exception {
		// gunit test on line 20
		Object retval = execLexer("TIERCED", 20, "tierced", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testTIERCED2() throws Exception {
		// gunit test on line 21
		Object retval = execLexer("TIERCED", 21, "tierc", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testMODIFIER1() throws Exception {
		// gunit test on line 24
		Object retval = execLexer("MODIFIER", 24, "reversed", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER2() throws Exception {
		// gunit test on line 25
		Object retval = execLexer("MODIFIER", 25, "sinister", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER3() throws Exception {
		// gunit test on line 26
		Object retval = execLexer("MODIFIER", 26, "reversey", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testGYRONNY1() throws Exception {
		// gunit test on line 29
		Object retval = execLexer("GYRONNY", 29, "gyronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"GYRONNY", expecting, actual);
	}

	public void testGYRONNY2() throws Exception {
		// gunit test on line 30
		Object retval = execLexer("GYRONNY", 30, "gyron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"GYRONNY", expecting, actual);
	}

	public void testPARTYPER1() throws Exception {
		// gunit test on line 33
		Object retval = execLexer("PARTYPER", 33, "per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER2() throws Exception {
		// gunit test on line 34
		Object retval = execLexer("PARTYPER", 34, "party per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER3() throws Exception {
		// gunit test on line 35
		Object retval = execLexer("PARTYPER", 35, "parted per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER4() throws Exception {
		// gunit test on line 36
		Object retval = execLexer("PARTYPER", 36, "part per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testCOLOUR1() throws Exception {
		// gunit test on line 38
		Object retval = execLexer("COLOUR", 38, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR2() throws Exception {
		// gunit test on line 39
		Object retval = execLexer("COLOUR", 39, "sable", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR3() throws Exception {
		// gunit test on line 40
		Object retval = execLexer("COLOUR", 40, "vert", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR4() throws Exception {
		// gunit test on line 41
		Object retval = execLexer("COLOUR", 41, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR5() throws Exception {
		// gunit test on line 42
		Object retval = execLexer("COLOUR", 42, "purpure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR6() throws Exception {
		// gunit test on line 43
		Object retval = execLexer("COLOUR", 43, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR7() throws Exception {
		// gunit test on line 44
		Object retval = execLexer("COLOUR", 44, "blue", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testMETAL1() throws Exception {
		// gunit test on line 46
		Object retval = execLexer("METAL", 46, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL2() throws Exception {
		// gunit test on line 47
		Object retval = execLexer("METAL", 47, "argent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL3() throws Exception {
		// gunit test on line 48
		Object retval = execLexer("METAL", 48, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL4() throws Exception {
		// gunit test on line 49
		Object retval = execLexer("METAL", 49, "gold", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testFUR1() throws Exception {
		// gunit test on line 51
		Object retval = execLexer("FUR", 51, "ermine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR2() throws Exception {
		// gunit test on line 52
		Object retval = execLexer("FUR", 52, "ermines", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR3() throws Exception {
		// gunit test on line 53
		Object retval = execLexer("FUR", 53, "erminois", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR4() throws Exception {
		// gunit test on line 54
		Object retval = execLexer("FUR", 54, "pean", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR5() throws Exception {
		// gunit test on line 55
		Object retval = execLexer("FUR", 55, "vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR6() throws Exception {
		// gunit test on line 56
		Object retval = execLexer("FUR", 56, "counter-vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR7() throws Exception {
		// gunit test on line 57
		Object retval = execLexer("FUR", 57, "vair-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR8() throws Exception {
		// gunit test on line 58
		Object retval = execLexer("FUR", 58, "vair-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR9() throws Exception {
		// gunit test on line 59
		Object retval = execLexer("FUR", 59, "potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR10() throws Exception {
		// gunit test on line 60
		Object retval = execLexer("FUR", 60, "counter-potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR11() throws Exception {
		// gunit test on line 61
		Object retval = execLexer("FUR", 61, "potent-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR12() throws Exception {
		// gunit test on line 62
		Object retval = execLexer("FUR", 62, "potent-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR13() throws Exception {
		// gunit test on line 63
		Object retval = execLexer("FUR", 63, "pean-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR14() throws Exception {
		// gunit test on line 64
		Object retval = execLexer("FUR", 64, "ermine-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR15() throws Exception {
		// gunit test on line 65
		Object retval = execLexer("FUR", 65, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testAND1() throws Exception {
		// gunit test on line 67
		Object retval = execLexer("AND", 67, "and", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND2() throws Exception {
		// gunit test on line 68
		Object retval = execLexer("AND", 68, "&", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND3() throws Exception {
		// gunit test on line 69
		Object retval = execLexer("AND", 69, "+", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testOF1() throws Exception {
		// gunit test on line 71
		Object retval = execLexer("OF", 71, "of", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testOF2() throws Exception {
		// gunit test on line 72
		Object retval = execLexer("OF", 72, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testDIGITS1() throws Exception {
		// gunit test on line 74
		Object retval = execLexer("DIGITS", 74, "1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS2() throws Exception {
		// gunit test on line 75
		Object retval = execLexer("DIGITS", 75, "12", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS3() throws Exception {
		// gunit test on line 76
		Object retval = execLexer("DIGITS", 76, "1234567890", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS4() throws Exception {
		// gunit test on line 77
		Object retval = execLexer("DIGITS", 77, "0.1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS5() throws Exception {
		// gunit test on line 78
		Object retval = execLexer("DIGITS", 78, "", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS6() throws Exception {
		// gunit test on line 79
		Object retval = execLexer("DIGITS", 79, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testNUMWORDS1() throws Exception {
		// gunit test on line 82
		Object retval = execLexer("NUMWORDS", 82, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS2() throws Exception {
		// gunit test on line 83
		Object retval = execLexer("NUMWORDS", 83, "eleven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS3() throws Exception {
		// gunit test on line 84
		Object retval = execLexer("NUMWORDS", 84, "two", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS4() throws Exception {
		// gunit test on line 85
		Object retval = execLexer("NUMWORDS", 85, "twelve", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS5() throws Exception {
		// gunit test on line 86
		Object retval = execLexer("NUMWORDS", 86, "three", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS6() throws Exception {
		// gunit test on line 87
		Object retval = execLexer("NUMWORDS", 87, "thirteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS7() throws Exception {
		// gunit test on line 88
		Object retval = execLexer("NUMWORDS", 88, "four", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS8() throws Exception {
		// gunit test on line 89
		Object retval = execLexer("NUMWORDS", 89, "fourteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS9() throws Exception {
		// gunit test on line 90
		Object retval = execLexer("NUMWORDS", 90, "five", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS10() throws Exception {
		// gunit test on line 91
		Object retval = execLexer("NUMWORDS", 91, "fifteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS11() throws Exception {
		// gunit test on line 92
		Object retval = execLexer("NUMWORDS", 92, "six", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS12() throws Exception {
		// gunit test on line 93
		Object retval = execLexer("NUMWORDS", 93, "sixteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS13() throws Exception {
		// gunit test on line 94
		Object retval = execLexer("NUMWORDS", 94, "seven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS14() throws Exception {
		// gunit test on line 95
		Object retval = execLexer("NUMWORDS", 95, "seventeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS15() throws Exception {
		// gunit test on line 96
		Object retval = execLexer("NUMWORDS", 96, "eight", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS16() throws Exception {
		// gunit test on line 97
		Object retval = execLexer("NUMWORDS", 97, "eighteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS17() throws Exception {
		// gunit test on line 98
		Object retval = execLexer("NUMWORDS", 98, "nine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS18() throws Exception {
		// gunit test on line 99
		Object retval = execLexer("NUMWORDS", 99, "nineteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS19() throws Exception {
		// gunit test on line 100
		Object retval = execLexer("NUMWORDS", 100, "twenty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS20() throws Exception {
		// gunit test on line 101
		Object retval = execLexer("NUMWORDS", 101, "thirty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS21() throws Exception {
		// gunit test on line 102
		Object retval = execLexer("NUMWORDS", 102, "fourty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS22() throws Exception {
		// gunit test on line 103
		Object retval = execLexer("NUMWORDS", 103, "fifty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS23() throws Exception {
		// gunit test on line 104
		Object retval = execLexer("NUMWORDS", 104, "sixty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS24() throws Exception {
		// gunit test on line 105
		Object retval = execLexer("NUMWORDS", 105, "seventy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS25() throws Exception {
		// gunit test on line 106
		Object retval = execLexer("NUMWORDS", 106, "eighty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS26() throws Exception {
		// gunit test on line 107
		Object retval = execLexer("NUMWORDS", 107, "ninety", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS27() throws Exception {
		// gunit test on line 108
		Object retval = execLexer("NUMWORDS", 108, "hundred", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS28() throws Exception {
		// gunit test on line 109
		Object retval = execLexer("NUMWORDS", 109, "thousand", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS29() throws Exception {
		// gunit test on line 110
		Object retval = execLexer("NUMWORDS", 110, "million", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS30() throws Exception {
		// gunit test on line 111
		Object retval = execLexer("NUMWORDS", 111, "billion", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS31() throws Exception {
		// gunit test on line 112
		Object retval = execLexer("NUMWORDS", 112, "oneteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS32() throws Exception {
		// gunit test on line 113
		Object retval = execLexer("NUMWORDS", 113, "fiveteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS33() throws Exception {
		// gunit test on line 114
		Object retval = execLexer("NUMWORDS", 114, "zero", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS34() throws Exception {
		// gunit test on line 115
		Object retval = execLexer("NUMWORDS", 115, "minus", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS35() throws Exception {
		// gunit test on line 116
		Object retval = execLexer("NUMWORDS", 116, "seventyeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testWS1() throws Exception {
		// gunit test on line 118
		Object retval = execLexer("WS", 118, " ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS2() throws Exception {
		// gunit test on line 119
		Object retval = execLexer("WS", 119, "    ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS3() throws Exception {
		// gunit test on line 120
		Object retval = execLexer("WS", 120, "\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS4() throws Exception {
		// gunit test on line 121
		Object retval = execLexer("WS", 121, "\t\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS5() throws Exception {
		// gunit test on line 122
		Object retval = execLexer("WS", 122, "\t \t   ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}



}