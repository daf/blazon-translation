package blazon.server.grammar;

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

	public void testTIERCED3() throws Exception {
		// gunit test on line 22
		Object retval = execLexer("TIERCED", 22, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testDIV_MODIFIER1() throws Exception {
		// gunit test on line 25
		Object retval = execLexer("DIV_MODIFIER", 25, "reversed", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV_MODIFIER", expecting, actual);
	}

	public void testDIV_MODIFIER2() throws Exception {
		// gunit test on line 26
		Object retval = execLexer("DIV_MODIFIER", 26, "sinister", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIV_MODIFIER", expecting, actual);
	}

	public void testDIV_MODIFIER3() throws Exception {
		// gunit test on line 27
		Object retval = execLexer("DIV_MODIFIER", 27, "reversey", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIV_MODIFIER", expecting, actual);
	}

	public void testDIV_MODIFIER4() throws Exception {
		// gunit test on line 28
		Object retval = execLexer("DIV_MODIFIER", 28, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIV_MODIFIER", expecting, actual);
	}

	public void testQUARTER1() throws Exception {
		// gunit test on line 31
		Object retval = execLexer("QUARTER", 31, "quarterly", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER2() throws Exception {
		// gunit test on line 32
		Object retval = execLexer("QUARTER", 32, "quartered", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER3() throws Exception {
		// gunit test on line 33
		Object retval = execLexer("QUARTER", 33, "quarter", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER4() throws Exception {
		// gunit test on line 34
		Object retval = execLexer("QUARTER", 34, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testCONTINUOUS_DIV1() throws Exception {
		// gunit test on line 37
		Object retval = execLexer("CONTINUOUS_DIV", 37, "chequy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testCONTINUOUS_DIV2() throws Exception {
		// gunit test on line 38
		Object retval = execLexer("CONTINUOUS_DIV", 38, "lozengy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testCONTINUOUS_DIV3() throws Exception {
		// gunit test on line 39
		Object retval = execLexer("CONTINUOUS_DIV", 39, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV1() throws Exception {
		// gunit test on line 42
		Object retval = execLexer("VARIABLE_DIV", 42, "gyronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV2() throws Exception {
		// gunit test on line 43
		Object retval = execLexer("VARIABLE_DIV", 43, "barry", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV3() throws Exception {
		// gunit test on line 44
		Object retval = execLexer("VARIABLE_DIV", 44, "bendy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV4() throws Exception {
		// gunit test on line 45
		Object retval = execLexer("VARIABLE_DIV", 45, "paly", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV5() throws Exception {
		// gunit test on line 46
		Object retval = execLexer("VARIABLE_DIV", 46, "chevronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV6() throws Exception {
		// gunit test on line 47
		Object retval = execLexer("VARIABLE_DIV", 47, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV7() throws Exception {
		// gunit test on line 48
		Object retval = execLexer("VARIABLE_DIV", 48, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV8() throws Exception {
		// gunit test on line 49
		Object retval = execLexer("VARIABLE_DIV", 49, "gyron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV9() throws Exception {
		// gunit test on line 50
		Object retval = execLexer("VARIABLE_DIV", 50, "random", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testPARTYPER1() throws Exception {
		// gunit test on line 53
		Object retval = execLexer("PARTYPER", 53, "per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER2() throws Exception {
		// gunit test on line 54
		Object retval = execLexer("PARTYPER", 54, "party per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER3() throws Exception {
		// gunit test on line 55
		Object retval = execLexer("PARTYPER", 55, "parted per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER4() throws Exception {
		// gunit test on line 56
		Object retval = execLexer("PARTYPER", 56, "partie per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER5() throws Exception {
		// gunit test on line 57
		Object retval = execLexer("PARTYPER", 57, "part per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testCOLOUR1() throws Exception {
		// gunit test on line 59
		Object retval = execLexer("COLOUR", 59, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR2() throws Exception {
		// gunit test on line 60
		Object retval = execLexer("COLOUR", 60, "sable", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR3() throws Exception {
		// gunit test on line 61
		Object retval = execLexer("COLOUR", 61, "vert", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR4() throws Exception {
		// gunit test on line 62
		Object retval = execLexer("COLOUR", 62, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR5() throws Exception {
		// gunit test on line 63
		Object retval = execLexer("COLOUR", 63, "purpure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR6() throws Exception {
		// gunit test on line 64
		Object retval = execLexer("COLOUR", 64, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR7() throws Exception {
		// gunit test on line 65
		Object retval = execLexer("COLOUR", 65, "blue", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testMETAL1() throws Exception {
		// gunit test on line 67
		Object retval = execLexer("METAL", 67, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL2() throws Exception {
		// gunit test on line 68
		Object retval = execLexer("METAL", 68, "argent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL3() throws Exception {
		// gunit test on line 69
		Object retval = execLexer("METAL", 69, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL4() throws Exception {
		// gunit test on line 70
		Object retval = execLexer("METAL", 70, "gold", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testFUR1() throws Exception {
		// gunit test on line 72
		Object retval = execLexer("FUR", 72, "ermine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR2() throws Exception {
		// gunit test on line 73
		Object retval = execLexer("FUR", 73, "ermines", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR3() throws Exception {
		// gunit test on line 74
		Object retval = execLexer("FUR", 74, "erminois", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR4() throws Exception {
		// gunit test on line 75
		Object retval = execLexer("FUR", 75, "pean", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR5() throws Exception {
		// gunit test on line 76
		Object retval = execLexer("FUR", 76, "vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR6() throws Exception {
		// gunit test on line 77
		Object retval = execLexer("FUR", 77, "counter-vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR7() throws Exception {
		// gunit test on line 78
		Object retval = execLexer("FUR", 78, "vair-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR8() throws Exception {
		// gunit test on line 79
		Object retval = execLexer("FUR", 79, "vair-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR9() throws Exception {
		// gunit test on line 80
		Object retval = execLexer("FUR", 80, "potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR10() throws Exception {
		// gunit test on line 81
		Object retval = execLexer("FUR", 81, "counter-potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR11() throws Exception {
		// gunit test on line 82
		Object retval = execLexer("FUR", 82, "potent-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR12() throws Exception {
		// gunit test on line 83
		Object retval = execLexer("FUR", 83, "potent-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR13() throws Exception {
		// gunit test on line 84
		Object retval = execLexer("FUR", 84, "pean-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR14() throws Exception {
		// gunit test on line 85
		Object retval = execLexer("FUR", 85, "ermine-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR15() throws Exception {
		// gunit test on line 86
		Object retval = execLexer("FUR", 86, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testAND1() throws Exception {
		// gunit test on line 88
		Object retval = execLexer("AND", 88, "and", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND2() throws Exception {
		// gunit test on line 89
		Object retval = execLexer("AND", 89, "&", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND3() throws Exception {
		// gunit test on line 90
		Object retval = execLexer("AND", 90, "+", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testOF1() throws Exception {
		// gunit test on line 92
		Object retval = execLexer("OF", 92, "of", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testOF2() throws Exception {
		// gunit test on line 93
		Object retval = execLexer("OF", 93, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testDIGITS1() throws Exception {
		// gunit test on line 95
		Object retval = execLexer("DIGITS", 95, "1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS2() throws Exception {
		// gunit test on line 96
		Object retval = execLexer("DIGITS", 96, "12", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS3() throws Exception {
		// gunit test on line 97
		Object retval = execLexer("DIGITS", 97, "1234567890", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS4() throws Exception {
		// gunit test on line 98
		Object retval = execLexer("DIGITS", 98, "0.1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS5() throws Exception {
		// gunit test on line 99
		Object retval = execLexer("DIGITS", 99, "", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS6() throws Exception {
		// gunit test on line 100
		Object retval = execLexer("DIGITS", 100, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testNUMWORDS1() throws Exception {
		// gunit test on line 103
		Object retval = execLexer("NUMWORDS", 103, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS2() throws Exception {
		// gunit test on line 104
		Object retval = execLexer("NUMWORDS", 104, "eleven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS3() throws Exception {
		// gunit test on line 105
		Object retval = execLexer("NUMWORDS", 105, "two", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS4() throws Exception {
		// gunit test on line 106
		Object retval = execLexer("NUMWORDS", 106, "twelve", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS5() throws Exception {
		// gunit test on line 107
		Object retval = execLexer("NUMWORDS", 107, "three", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS6() throws Exception {
		// gunit test on line 108
		Object retval = execLexer("NUMWORDS", 108, "thirteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS7() throws Exception {
		// gunit test on line 109
		Object retval = execLexer("NUMWORDS", 109, "four", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS8() throws Exception {
		// gunit test on line 110
		Object retval = execLexer("NUMWORDS", 110, "fourteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS9() throws Exception {
		// gunit test on line 111
		Object retval = execLexer("NUMWORDS", 111, "five", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS10() throws Exception {
		// gunit test on line 112
		Object retval = execLexer("NUMWORDS", 112, "fifteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS11() throws Exception {
		// gunit test on line 113
		Object retval = execLexer("NUMWORDS", 113, "six", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS12() throws Exception {
		// gunit test on line 114
		Object retval = execLexer("NUMWORDS", 114, "sixteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS13() throws Exception {
		// gunit test on line 115
		Object retval = execLexer("NUMWORDS", 115, "seven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS14() throws Exception {
		// gunit test on line 116
		Object retval = execLexer("NUMWORDS", 116, "seventeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS15() throws Exception {
		// gunit test on line 117
		Object retval = execLexer("NUMWORDS", 117, "eight", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS16() throws Exception {
		// gunit test on line 118
		Object retval = execLexer("NUMWORDS", 118, "eighteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS17() throws Exception {
		// gunit test on line 119
		Object retval = execLexer("NUMWORDS", 119, "nine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS18() throws Exception {
		// gunit test on line 120
		Object retval = execLexer("NUMWORDS", 120, "nineteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS19() throws Exception {
		// gunit test on line 121
		Object retval = execLexer("NUMWORDS", 121, "twenty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS20() throws Exception {
		// gunit test on line 122
		Object retval = execLexer("NUMWORDS", 122, "thirty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS21() throws Exception {
		// gunit test on line 123
		Object retval = execLexer("NUMWORDS", 123, "fourty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS22() throws Exception {
		// gunit test on line 124
		Object retval = execLexer("NUMWORDS", 124, "fifty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS23() throws Exception {
		// gunit test on line 125
		Object retval = execLexer("NUMWORDS", 125, "sixty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS24() throws Exception {
		// gunit test on line 126
		Object retval = execLexer("NUMWORDS", 126, "seventy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS25() throws Exception {
		// gunit test on line 127
		Object retval = execLexer("NUMWORDS", 127, "eighty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS26() throws Exception {
		// gunit test on line 128
		Object retval = execLexer("NUMWORDS", 128, "ninety", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS27() throws Exception {
		// gunit test on line 129
		Object retval = execLexer("NUMWORDS", 129, "hundred", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS28() throws Exception {
		// gunit test on line 130
		Object retval = execLexer("NUMWORDS", 130, "thousand", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS29() throws Exception {
		// gunit test on line 131
		Object retval = execLexer("NUMWORDS", 131, "million", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS30() throws Exception {
		// gunit test on line 132
		Object retval = execLexer("NUMWORDS", 132, "billion", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS31() throws Exception {
		// gunit test on line 133
		Object retval = execLexer("NUMWORDS", 133, "oneteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS32() throws Exception {
		// gunit test on line 134
		Object retval = execLexer("NUMWORDS", 134, "fiveteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS33() throws Exception {
		// gunit test on line 135
		Object retval = execLexer("NUMWORDS", 135, "zero", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS34() throws Exception {
		// gunit test on line 136
		Object retval = execLexer("NUMWORDS", 136, "minus", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS35() throws Exception {
		// gunit test on line 137
		Object retval = execLexer("NUMWORDS", 137, "seventyeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testWS1() throws Exception {
		// gunit test on line 139
		Object retval = execLexer("WS", 139, " ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS2() throws Exception {
		// gunit test on line 140
		Object retval = execLexer("WS", 140, "    ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS3() throws Exception {
		// gunit test on line 141
		Object retval = execLexer("WS", 141, "\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS4() throws Exception {
		// gunit test on line 142
		Object retval = execLexer("WS", 142, "\t\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS5() throws Exception {
		// gunit test on line 143
		Object retval = execLexer("WS", 143, "\t \t   ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS6() throws Exception {
		// gunit test on line 144
		Object retval = execLexer("WS", 144, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS7() throws Exception {
		// gunit test on line 145
		Object retval = execLexer("WS", 145, " a ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"WS", expecting, actual);
	}



}