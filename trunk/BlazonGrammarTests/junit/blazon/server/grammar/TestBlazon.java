package blazon.server.grammar;

import org.antlr.gunit.gUnitBaseTest;

public class TestBlazon extends gUnitBaseTest {
	
	public void setUp() {
		this.packagePath = "./blazon/server/grammar";
		this.lexerPath = "blazon.server.grammar.BlazonLexer";
		this.parserPath = "blazon.server.grammar.BlazonParser";
	}

	public void testORDINARY1() throws Exception {
		// gunit test on line 9
		Object retval = execLexer("ORDINARY", 9, "fess", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testORDINARY2() throws Exception {
		// gunit test on line 10
		Object retval = execLexer("ORDINARY", 10, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testORDINARY3() throws Exception {
		// gunit test on line 11
		Object retval = execLexer("ORDINARY", 11, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testORDINARY4() throws Exception {
		// gunit test on line 12
		Object retval = execLexer("ORDINARY", 12, "cross", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testORDINARY5() throws Exception {
		// gunit test on line 13
		Object retval = execLexer("ORDINARY", 13, "saltire", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testORDINARY6() throws Exception {
		// gunit test on line 14
		Object retval = execLexer("ORDINARY", 14, "chevron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testORDINARY7() throws Exception {
		// gunit test on line 15
		Object retval = execLexer("ORDINARY", 15, "pall", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testORDINARY8() throws Exception {
		// gunit test on line 16
		Object retval = execLexer("ORDINARY", 16, "bend sinister", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testORDINARY9() throws Exception {
		// gunit test on line 17
		Object retval = execLexer("ORDINARY", 17, "gyronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testORDINARY10() throws Exception {
		// gunit test on line 18
		Object retval = execLexer("ORDINARY", 18, "colour", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY", expecting, actual);
	}

	public void testOTHER_DIV1() throws Exception {
		// gunit test on line 21
		Object retval = execLexer("OTHER_DIV", 21, "pall", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OTHER_DIV", expecting, actual);
	}

	public void testOTHER_DIV2() throws Exception {
		// gunit test on line 22
		Object retval = execLexer("OTHER_DIV", 22, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OTHER_DIV", expecting, actual);
	}

	public void testOTHER_DIV3() throws Exception {
		// gunit test on line 23
		Object retval = execLexer("OTHER_DIV", 23, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OTHER_DIV", expecting, actual);
	}

	public void testOTHER_ORDINARY1() throws Exception {
		// gunit test on line 26
		Object retval = execLexer("OTHER_ORDINARY", 26, "base", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testOTHER_ORDINARY2() throws Exception {
		// gunit test on line 27
		Object retval = execLexer("OTHER_ORDINARY", 27, "chief", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testOTHER_ORDINARY3() throws Exception {
		// gunit test on line 28
		Object retval = execLexer("OTHER_ORDINARY", 28, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testOTHER_ORDINARY4() throws Exception {
		// gunit test on line 29
		Object retval = execLexer("OTHER_ORDINARY", 29, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testTIERCED1() throws Exception {
		// gunit test on line 31
		Object retval = execLexer("TIERCED", 31, "tierced", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testTIERCED2() throws Exception {
		// gunit test on line 32
		Object retval = execLexer("TIERCED", 32, "tierc", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testTIERCED3() throws Exception {
		// gunit test on line 33
		Object retval = execLexer("TIERCED", 33, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testMODIFIER1() throws Exception {
		// gunit test on line 36
		Object retval = execLexer("MODIFIER", 36, "reversed", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER2() throws Exception {
		// gunit test on line 37
		Object retval = execLexer("MODIFIER", 37, "sinister", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER3() throws Exception {
		// gunit test on line 38
		Object retval = execLexer("MODIFIER", 38, "reversey", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER4() throws Exception {
		// gunit test on line 39
		Object retval = execLexer("MODIFIER", 39, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testQUARTER1() throws Exception {
		// gunit test on line 42
		Object retval = execLexer("QUARTER", 42, "quarterly", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER2() throws Exception {
		// gunit test on line 43
		Object retval = execLexer("QUARTER", 43, "quartered", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER3() throws Exception {
		// gunit test on line 44
		Object retval = execLexer("QUARTER", 44, "quarter", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER4() throws Exception {
		// gunit test on line 45
		Object retval = execLexer("QUARTER", 45, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testCONTINUOUS_DIV1() throws Exception {
		// gunit test on line 48
		Object retval = execLexer("CONTINUOUS_DIV", 48, "chequy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testCONTINUOUS_DIV2() throws Exception {
		// gunit test on line 49
		Object retval = execLexer("CONTINUOUS_DIV", 49, "lozengy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testCONTINUOUS_DIV3() throws Exception {
		// gunit test on line 50
		Object retval = execLexer("CONTINUOUS_DIV", 50, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV1() throws Exception {
		// gunit test on line 53
		Object retval = execLexer("VARIABLE_DIV", 53, "gyronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV2() throws Exception {
		// gunit test on line 54
		Object retval = execLexer("VARIABLE_DIV", 54, "barry", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV3() throws Exception {
		// gunit test on line 55
		Object retval = execLexer("VARIABLE_DIV", 55, "bendy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV4() throws Exception {
		// gunit test on line 56
		Object retval = execLexer("VARIABLE_DIV", 56, "paly", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV5() throws Exception {
		// gunit test on line 57
		Object retval = execLexer("VARIABLE_DIV", 57, "chevronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV6() throws Exception {
		// gunit test on line 58
		Object retval = execLexer("VARIABLE_DIV", 58, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV7() throws Exception {
		// gunit test on line 59
		Object retval = execLexer("VARIABLE_DIV", 59, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV8() throws Exception {
		// gunit test on line 60
		Object retval = execLexer("VARIABLE_DIV", 60, "gyron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV9() throws Exception {
		// gunit test on line 61
		Object retval = execLexer("VARIABLE_DIV", 61, "random", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testPARTYPER1() throws Exception {
		// gunit test on line 64
		Object retval = execLexer("PARTYPER", 64, "per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER2() throws Exception {
		// gunit test on line 65
		Object retval = execLexer("PARTYPER", 65, "party per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER3() throws Exception {
		// gunit test on line 66
		Object retval = execLexer("PARTYPER", 66, "parted per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER4() throws Exception {
		// gunit test on line 67
		Object retval = execLexer("PARTYPER", 67, "partie per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER5() throws Exception {
		// gunit test on line 68
		Object retval = execLexer("PARTYPER", 68, "part per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testCOLOUR1() throws Exception {
		// gunit test on line 70
		Object retval = execLexer("COLOUR", 70, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR2() throws Exception {
		// gunit test on line 71
		Object retval = execLexer("COLOUR", 71, "sable", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR3() throws Exception {
		// gunit test on line 72
		Object retval = execLexer("COLOUR", 72, "vert", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR4() throws Exception {
		// gunit test on line 73
		Object retval = execLexer("COLOUR", 73, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR5() throws Exception {
		// gunit test on line 74
		Object retval = execLexer("COLOUR", 74, "purpure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR6() throws Exception {
		// gunit test on line 75
		Object retval = execLexer("COLOUR", 75, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR7() throws Exception {
		// gunit test on line 76
		Object retval = execLexer("COLOUR", 76, "blue", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testMETAL1() throws Exception {
		// gunit test on line 78
		Object retval = execLexer("METAL", 78, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL2() throws Exception {
		// gunit test on line 79
		Object retval = execLexer("METAL", 79, "argent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL3() throws Exception {
		// gunit test on line 80
		Object retval = execLexer("METAL", 80, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL4() throws Exception {
		// gunit test on line 81
		Object retval = execLexer("METAL", 81, "gold", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testFUR1() throws Exception {
		// gunit test on line 83
		Object retval = execLexer("FUR", 83, "ermine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR2() throws Exception {
		// gunit test on line 84
		Object retval = execLexer("FUR", 84, "ermines", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR3() throws Exception {
		// gunit test on line 85
		Object retval = execLexer("FUR", 85, "erminois", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR4() throws Exception {
		// gunit test on line 86
		Object retval = execLexer("FUR", 86, "pean", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR5() throws Exception {
		// gunit test on line 87
		Object retval = execLexer("FUR", 87, "vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR6() throws Exception {
		// gunit test on line 88
		Object retval = execLexer("FUR", 88, "counter-vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR7() throws Exception {
		// gunit test on line 89
		Object retval = execLexer("FUR", 89, "vair-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR8() throws Exception {
		// gunit test on line 90
		Object retval = execLexer("FUR", 90, "vair-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR9() throws Exception {
		// gunit test on line 91
		Object retval = execLexer("FUR", 91, "potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR10() throws Exception {
		// gunit test on line 92
		Object retval = execLexer("FUR", 92, "counter-potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR11() throws Exception {
		// gunit test on line 93
		Object retval = execLexer("FUR", 93, "potent-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR12() throws Exception {
		// gunit test on line 94
		Object retval = execLexer("FUR", 94, "potent-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR13() throws Exception {
		// gunit test on line 95
		Object retval = execLexer("FUR", 95, "pean-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR14() throws Exception {
		// gunit test on line 96
		Object retval = execLexer("FUR", 96, "ermine-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR15() throws Exception {
		// gunit test on line 97
		Object retval = execLexer("FUR", 97, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testAND1() throws Exception {
		// gunit test on line 99
		Object retval = execLexer("AND", 99, "and", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND2() throws Exception {
		// gunit test on line 100
		Object retval = execLexer("AND", 100, "&", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND3() throws Exception {
		// gunit test on line 101
		Object retval = execLexer("AND", 101, "+", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testOF1() throws Exception {
		// gunit test on line 103
		Object retval = execLexer("OF", 103, "of", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testOF2() throws Exception {
		// gunit test on line 104
		Object retval = execLexer("OF", 104, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testA1() throws Exception {
		// gunit test on line 106
		Object retval = execLexer("A", 106, "a", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"A", expecting, actual);
	}

	public void testA2() throws Exception {
		// gunit test on line 107
		Object retval = execLexer("A", 107, "and", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"A", expecting, actual);
	}

	public void testA3() throws Exception {
		// gunit test on line 108
		Object retval = execLexer("A", 108, "b", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"A", expecting, actual);
	}

	public void testDIGITS1() throws Exception {
		// gunit test on line 110
		Object retval = execLexer("DIGITS", 110, "1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS2() throws Exception {
		// gunit test on line 111
		Object retval = execLexer("DIGITS", 111, "12", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS3() throws Exception {
		// gunit test on line 112
		Object retval = execLexer("DIGITS", 112, "1234567890", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS4() throws Exception {
		// gunit test on line 113
		Object retval = execLexer("DIGITS", 113, "0.1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS5() throws Exception {
		// gunit test on line 114
		Object retval = execLexer("DIGITS", 114, "", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS6() throws Exception {
		// gunit test on line 115
		Object retval = execLexer("DIGITS", 115, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testNUMWORDS1() throws Exception {
		// gunit test on line 118
		Object retval = execLexer("NUMWORDS", 118, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS2() throws Exception {
		// gunit test on line 119
		Object retval = execLexer("NUMWORDS", 119, "eleven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS3() throws Exception {
		// gunit test on line 120
		Object retval = execLexer("NUMWORDS", 120, "two", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS4() throws Exception {
		// gunit test on line 121
		Object retval = execLexer("NUMWORDS", 121, "twelve", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS5() throws Exception {
		// gunit test on line 122
		Object retval = execLexer("NUMWORDS", 122, "three", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS6() throws Exception {
		// gunit test on line 123
		Object retval = execLexer("NUMWORDS", 123, "thirteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS7() throws Exception {
		// gunit test on line 124
		Object retval = execLexer("NUMWORDS", 124, "four", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS8() throws Exception {
		// gunit test on line 125
		Object retval = execLexer("NUMWORDS", 125, "fourteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS9() throws Exception {
		// gunit test on line 126
		Object retval = execLexer("NUMWORDS", 126, "five", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS10() throws Exception {
		// gunit test on line 127
		Object retval = execLexer("NUMWORDS", 127, "fifteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS11() throws Exception {
		// gunit test on line 128
		Object retval = execLexer("NUMWORDS", 128, "six", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS12() throws Exception {
		// gunit test on line 129
		Object retval = execLexer("NUMWORDS", 129, "sixteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS13() throws Exception {
		// gunit test on line 130
		Object retval = execLexer("NUMWORDS", 130, "seven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS14() throws Exception {
		// gunit test on line 131
		Object retval = execLexer("NUMWORDS", 131, "seventeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS15() throws Exception {
		// gunit test on line 132
		Object retval = execLexer("NUMWORDS", 132, "eight", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS16() throws Exception {
		// gunit test on line 133
		Object retval = execLexer("NUMWORDS", 133, "eighteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS17() throws Exception {
		// gunit test on line 134
		Object retval = execLexer("NUMWORDS", 134, "nine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS18() throws Exception {
		// gunit test on line 135
		Object retval = execLexer("NUMWORDS", 135, "nineteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS19() throws Exception {
		// gunit test on line 136
		Object retval = execLexer("NUMWORDS", 136, "twenty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS20() throws Exception {
		// gunit test on line 137
		Object retval = execLexer("NUMWORDS", 137, "thirty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS21() throws Exception {
		// gunit test on line 138
		Object retval = execLexer("NUMWORDS", 138, "fourty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS22() throws Exception {
		// gunit test on line 139
		Object retval = execLexer("NUMWORDS", 139, "fifty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS23() throws Exception {
		// gunit test on line 140
		Object retval = execLexer("NUMWORDS", 140, "sixty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS24() throws Exception {
		// gunit test on line 141
		Object retval = execLexer("NUMWORDS", 141, "seventy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS25() throws Exception {
		// gunit test on line 142
		Object retval = execLexer("NUMWORDS", 142, "eighty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS26() throws Exception {
		// gunit test on line 143
		Object retval = execLexer("NUMWORDS", 143, "ninety", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS27() throws Exception {
		// gunit test on line 144
		Object retval = execLexer("NUMWORDS", 144, "hundred", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS28() throws Exception {
		// gunit test on line 145
		Object retval = execLexer("NUMWORDS", 145, "thousand", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS29() throws Exception {
		// gunit test on line 146
		Object retval = execLexer("NUMWORDS", 146, "million", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS30() throws Exception {
		// gunit test on line 147
		Object retval = execLexer("NUMWORDS", 147, "billion", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS31() throws Exception {
		// gunit test on line 148
		Object retval = execLexer("NUMWORDS", 148, "oneteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS32() throws Exception {
		// gunit test on line 149
		Object retval = execLexer("NUMWORDS", 149, "fiveteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS33() throws Exception {
		// gunit test on line 150
		Object retval = execLexer("NUMWORDS", 150, "zero", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS34() throws Exception {
		// gunit test on line 151
		Object retval = execLexer("NUMWORDS", 151, "minus", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS35() throws Exception {
		// gunit test on line 152
		Object retval = execLexer("NUMWORDS", 152, "seventyeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testWS1() throws Exception {
		// gunit test on line 154
		Object retval = execLexer("WS", 154, " ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS2() throws Exception {
		// gunit test on line 155
		Object retval = execLexer("WS", 155, "    ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS3() throws Exception {
		// gunit test on line 156
		Object retval = execLexer("WS", 156, "\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS4() throws Exception {
		// gunit test on line 157
		Object retval = execLexer("WS", 157, "\t\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS5() throws Exception {
		// gunit test on line 158
		Object retval = execLexer("WS", 158, "\t \t   ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS6() throws Exception {
		// gunit test on line 159
		Object retval = execLexer("WS", 159, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS7() throws Exception {
		// gunit test on line 160
		Object retval = execLexer("WS", 160, " a ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"WS", expecting, actual);
	}



}