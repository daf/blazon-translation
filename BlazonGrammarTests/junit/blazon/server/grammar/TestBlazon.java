package blazon.server.grammar;

import org.antlr.gunit.gUnitBaseTest;

public class TestBlazon extends gUnitBaseTest {
	
	public void setUp() {
		this.packagePath = "./blazon/server/grammar";
		this.lexerPath = "blazon.server.grammar.BlazonLexer";
		this.parserPath = "blazon.server.grammar.BlazonParser";
	}

	public void testORDINARY_DIV1() throws Exception {
		// gunit test on line 9
		Object retval = execLexer("ORDINARY_DIV", 9, "fess", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV2() throws Exception {
		// gunit test on line 10
		Object retval = execLexer("ORDINARY_DIV", 10, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV3() throws Exception {
		// gunit test on line 11
		Object retval = execLexer("ORDINARY_DIV", 11, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV4() throws Exception {
		// gunit test on line 12
		Object retval = execLexer("ORDINARY_DIV", 12, "cross", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV5() throws Exception {
		// gunit test on line 13
		Object retval = execLexer("ORDINARY_DIV", 13, "saltire", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV6() throws Exception {
		// gunit test on line 14
		Object retval = execLexer("ORDINARY_DIV", 14, "chevron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV7() throws Exception {
		// gunit test on line 15
		Object retval = execLexer("ORDINARY_DIV", 15, "pall", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV8() throws Exception {
		// gunit test on line 16
		Object retval = execLexer("ORDINARY_DIV", 16, "bend sinister", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV9() throws Exception {
		// gunit test on line 17
		Object retval = execLexer("ORDINARY_DIV", 17, "gyronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV10() throws Exception {
		// gunit test on line 18
		Object retval = execLexer("ORDINARY_DIV", 18, "colour", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testOTHER_ORDINARY1() throws Exception {
		// gunit test on line 20
		Object retval = execLexer("OTHER_ORDINARY", 20, "base", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testOTHER_ORDINARY2() throws Exception {
		// gunit test on line 21
		Object retval = execLexer("OTHER_ORDINARY", 21, "chief", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testOTHER_ORDINARY3() throws Exception {
		// gunit test on line 22
		Object retval = execLexer("OTHER_ORDINARY", 22, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testOTHER_ORDINARY4() throws Exception {
		// gunit test on line 23
		Object retval = execLexer("OTHER_ORDINARY", 23, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testSUBORDINARY_DIV1() throws Exception {
		// gunit test on line 27
		Object retval = execLexer("SUBORDINARY_DIV", 27, "pall", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_DIV", expecting, actual);
	}

	public void testSUBORDINARY_DIV2() throws Exception {
		// gunit test on line 28
		Object retval = execLexer("SUBORDINARY_DIV", 28, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY_DIV", expecting, actual);
	}

	public void testSUBORDINARY_DIV3() throws Exception {
		// gunit test on line 29
		Object retval = execLexer("SUBORDINARY_DIV", 29, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY_DIV", expecting, actual);
	}

	public void testSUBORDINARY1() throws Exception {
		// gunit test on line 32
		Object retval = execLexer("SUBORDINARY", 32, "pile", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY2() throws Exception {
		// gunit test on line 33
		Object retval = execLexer("SUBORDINARY", 33, "quarter", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY3() throws Exception {
		// gunit test on line 34
		Object retval = execLexer("SUBORDINARY", 34, "canton", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY4() throws Exception {
		// gunit test on line 35
		Object retval = execLexer("SUBORDINARY", 35, "flaunches", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY5() throws Exception {
		// gunit test on line 36
		Object retval = execLexer("SUBORDINARY", 36, "bordure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY6() throws Exception {
		// gunit test on line 37
		Object retval = execLexer("SUBORDINARY", 37, "orle", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY7() throws Exception {
		// gunit test on line 38
		Object retval = execLexer("SUBORDINARY", 38, "tressure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY8() throws Exception {
		// gunit test on line 39
		Object retval = execLexer("SUBORDINARY", 39, "gyron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY9() throws Exception {
		// gunit test on line 40
		Object retval = execLexer("SUBORDINARY", 40, "fret", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY10() throws Exception {
		// gunit test on line 41
		Object retval = execLexer("SUBORDINARY", 41, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY11() throws Exception {
		// gunit test on line 42
		Object retval = execLexer("SUBORDINARY", 42, "pall", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY12() throws Exception {
		// gunit test on line 43
		Object retval = execLexer("SUBORDINARY", 43, "saltire", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testTIERCED1() throws Exception {
		// gunit test on line 45
		Object retval = execLexer("TIERCED", 45, "tierced", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testTIERCED2() throws Exception {
		// gunit test on line 46
		Object retval = execLexer("TIERCED", 46, "tierc", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testTIERCED3() throws Exception {
		// gunit test on line 47
		Object retval = execLexer("TIERCED", 47, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testMODIFIER1() throws Exception {
		// gunit test on line 50
		Object retval = execLexer("MODIFIER", 50, "reversed", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER2() throws Exception {
		// gunit test on line 51
		Object retval = execLexer("MODIFIER", 51, "sinister", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER3() throws Exception {
		// gunit test on line 52
		Object retval = execLexer("MODIFIER", 52, "reversey", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER4() throws Exception {
		// gunit test on line 53
		Object retval = execLexer("MODIFIER", 53, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testQUARTER1() throws Exception {
		// gunit test on line 56
		Object retval = execLexer("QUARTER", 56, "quarterly", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER2() throws Exception {
		// gunit test on line 57
		Object retval = execLexer("QUARTER", 57, "quartered", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER3() throws Exception {
		// gunit test on line 58
		Object retval = execLexer("QUARTER", 58, "quarter", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER4() throws Exception {
		// gunit test on line 59
		Object retval = execLexer("QUARTER", 59, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testCONTINUOUS_DIV1() throws Exception {
		// gunit test on line 62
		Object retval = execLexer("CONTINUOUS_DIV", 62, "chequy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testCONTINUOUS_DIV2() throws Exception {
		// gunit test on line 63
		Object retval = execLexer("CONTINUOUS_DIV", 63, "lozengy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testCONTINUOUS_DIV3() throws Exception {
		// gunit test on line 64
		Object retval = execLexer("CONTINUOUS_DIV", 64, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV1() throws Exception {
		// gunit test on line 67
		Object retval = execLexer("VARIABLE_DIV", 67, "gyronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV2() throws Exception {
		// gunit test on line 68
		Object retval = execLexer("VARIABLE_DIV", 68, "barry", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV3() throws Exception {
		// gunit test on line 69
		Object retval = execLexer("VARIABLE_DIV", 69, "bendy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV4() throws Exception {
		// gunit test on line 70
		Object retval = execLexer("VARIABLE_DIV", 70, "paly", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV5() throws Exception {
		// gunit test on line 71
		Object retval = execLexer("VARIABLE_DIV", 71, "chevronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV6() throws Exception {
		// gunit test on line 72
		Object retval = execLexer("VARIABLE_DIV", 72, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV7() throws Exception {
		// gunit test on line 73
		Object retval = execLexer("VARIABLE_DIV", 73, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV8() throws Exception {
		// gunit test on line 74
		Object retval = execLexer("VARIABLE_DIV", 74, "gyron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV9() throws Exception {
		// gunit test on line 75
		Object retval = execLexer("VARIABLE_DIV", 75, "random", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testPARTYPER1() throws Exception {
		// gunit test on line 78
		Object retval = execLexer("PARTYPER", 78, "per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER2() throws Exception {
		// gunit test on line 79
		Object retval = execLexer("PARTYPER", 79, "party per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER3() throws Exception {
		// gunit test on line 80
		Object retval = execLexer("PARTYPER", 80, "parted per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER4() throws Exception {
		// gunit test on line 81
		Object retval = execLexer("PARTYPER", 81, "partie per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER5() throws Exception {
		// gunit test on line 82
		Object retval = execLexer("PARTYPER", 82, "part per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testCOLOUR1() throws Exception {
		// gunit test on line 84
		Object retval = execLexer("COLOUR", 84, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR2() throws Exception {
		// gunit test on line 85
		Object retval = execLexer("COLOUR", 85, "sable", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR3() throws Exception {
		// gunit test on line 86
		Object retval = execLexer("COLOUR", 86, "vert", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR4() throws Exception {
		// gunit test on line 87
		Object retval = execLexer("COLOUR", 87, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR5() throws Exception {
		// gunit test on line 88
		Object retval = execLexer("COLOUR", 88, "purpure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR6() throws Exception {
		// gunit test on line 89
		Object retval = execLexer("COLOUR", 89, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR7() throws Exception {
		// gunit test on line 90
		Object retval = execLexer("COLOUR", 90, "blue", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testMETAL1() throws Exception {
		// gunit test on line 92
		Object retval = execLexer("METAL", 92, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL2() throws Exception {
		// gunit test on line 93
		Object retval = execLexer("METAL", 93, "argent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL3() throws Exception {
		// gunit test on line 94
		Object retval = execLexer("METAL", 94, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL4() throws Exception {
		// gunit test on line 95
		Object retval = execLexer("METAL", 95, "gold", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testFUR1() throws Exception {
		// gunit test on line 97
		Object retval = execLexer("FUR", 97, "ermine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR2() throws Exception {
		// gunit test on line 98
		Object retval = execLexer("FUR", 98, "ermines", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR3() throws Exception {
		// gunit test on line 99
		Object retval = execLexer("FUR", 99, "erminois", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR4() throws Exception {
		// gunit test on line 100
		Object retval = execLexer("FUR", 100, "pean", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR5() throws Exception {
		// gunit test on line 101
		Object retval = execLexer("FUR", 101, "vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR6() throws Exception {
		// gunit test on line 102
		Object retval = execLexer("FUR", 102, "counter-vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR7() throws Exception {
		// gunit test on line 103
		Object retval = execLexer("FUR", 103, "vair-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR8() throws Exception {
		// gunit test on line 104
		Object retval = execLexer("FUR", 104, "vair-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR9() throws Exception {
		// gunit test on line 105
		Object retval = execLexer("FUR", 105, "potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR10() throws Exception {
		// gunit test on line 106
		Object retval = execLexer("FUR", 106, "counter-potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR11() throws Exception {
		// gunit test on line 107
		Object retval = execLexer("FUR", 107, "potent-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR12() throws Exception {
		// gunit test on line 108
		Object retval = execLexer("FUR", 108, "potent-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR13() throws Exception {
		// gunit test on line 109
		Object retval = execLexer("FUR", 109, "pean-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR14() throws Exception {
		// gunit test on line 110
		Object retval = execLexer("FUR", 110, "ermine-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR15() throws Exception {
		// gunit test on line 111
		Object retval = execLexer("FUR", 111, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testAND1() throws Exception {
		// gunit test on line 113
		Object retval = execLexer("AND", 113, "and", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND2() throws Exception {
		// gunit test on line 114
		Object retval = execLexer("AND", 114, "&", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND3() throws Exception {
		// gunit test on line 115
		Object retval = execLexer("AND", 115, "+", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testOF1() throws Exception {
		// gunit test on line 117
		Object retval = execLexer("OF", 117, "of", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testOF2() throws Exception {
		// gunit test on line 118
		Object retval = execLexer("OF", 118, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testA1() throws Exception {
		// gunit test on line 120
		Object retval = execLexer("A", 120, "a", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"A", expecting, actual);
	}

	public void testA2() throws Exception {
		// gunit test on line 121
		Object retval = execLexer("A", 121, "and", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"A", expecting, actual);
	}

	public void testA3() throws Exception {
		// gunit test on line 122
		Object retval = execLexer("A", 122, "b", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"A", expecting, actual);
	}

	public void testDIGITS1() throws Exception {
		// gunit test on line 124
		Object retval = execLexer("DIGITS", 124, "1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS2() throws Exception {
		// gunit test on line 125
		Object retval = execLexer("DIGITS", 125, "12", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS3() throws Exception {
		// gunit test on line 126
		Object retval = execLexer("DIGITS", 126, "1234567890", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS4() throws Exception {
		// gunit test on line 127
		Object retval = execLexer("DIGITS", 127, "0.1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS5() throws Exception {
		// gunit test on line 128
		Object retval = execLexer("DIGITS", 128, "", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS6() throws Exception {
		// gunit test on line 129
		Object retval = execLexer("DIGITS", 129, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testNUMWORDS1() throws Exception {
		// gunit test on line 132
		Object retval = execLexer("NUMWORDS", 132, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS2() throws Exception {
		// gunit test on line 133
		Object retval = execLexer("NUMWORDS", 133, "eleven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS3() throws Exception {
		// gunit test on line 134
		Object retval = execLexer("NUMWORDS", 134, "two", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS4() throws Exception {
		// gunit test on line 135
		Object retval = execLexer("NUMWORDS", 135, "twelve", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS5() throws Exception {
		// gunit test on line 136
		Object retval = execLexer("NUMWORDS", 136, "three", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS6() throws Exception {
		// gunit test on line 137
		Object retval = execLexer("NUMWORDS", 137, "thirteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS7() throws Exception {
		// gunit test on line 138
		Object retval = execLexer("NUMWORDS", 138, "four", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS8() throws Exception {
		// gunit test on line 139
		Object retval = execLexer("NUMWORDS", 139, "fourteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS9() throws Exception {
		// gunit test on line 140
		Object retval = execLexer("NUMWORDS", 140, "five", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS10() throws Exception {
		// gunit test on line 141
		Object retval = execLexer("NUMWORDS", 141, "fifteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS11() throws Exception {
		// gunit test on line 142
		Object retval = execLexer("NUMWORDS", 142, "six", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS12() throws Exception {
		// gunit test on line 143
		Object retval = execLexer("NUMWORDS", 143, "sixteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS13() throws Exception {
		// gunit test on line 144
		Object retval = execLexer("NUMWORDS", 144, "seven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS14() throws Exception {
		// gunit test on line 145
		Object retval = execLexer("NUMWORDS", 145, "seventeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS15() throws Exception {
		// gunit test on line 146
		Object retval = execLexer("NUMWORDS", 146, "eight", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS16() throws Exception {
		// gunit test on line 147
		Object retval = execLexer("NUMWORDS", 147, "eighteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS17() throws Exception {
		// gunit test on line 148
		Object retval = execLexer("NUMWORDS", 148, "nine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS18() throws Exception {
		// gunit test on line 149
		Object retval = execLexer("NUMWORDS", 149, "nineteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS19() throws Exception {
		// gunit test on line 150
		Object retval = execLexer("NUMWORDS", 150, "twenty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS20() throws Exception {
		// gunit test on line 151
		Object retval = execLexer("NUMWORDS", 151, "thirty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS21() throws Exception {
		// gunit test on line 152
		Object retval = execLexer("NUMWORDS", 152, "fourty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS22() throws Exception {
		// gunit test on line 153
		Object retval = execLexer("NUMWORDS", 153, "fifty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS23() throws Exception {
		// gunit test on line 154
		Object retval = execLexer("NUMWORDS", 154, "sixty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS24() throws Exception {
		// gunit test on line 155
		Object retval = execLexer("NUMWORDS", 155, "seventy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS25() throws Exception {
		// gunit test on line 156
		Object retval = execLexer("NUMWORDS", 156, "eighty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS26() throws Exception {
		// gunit test on line 157
		Object retval = execLexer("NUMWORDS", 157, "ninety", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS27() throws Exception {
		// gunit test on line 158
		Object retval = execLexer("NUMWORDS", 158, "hundred", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS28() throws Exception {
		// gunit test on line 159
		Object retval = execLexer("NUMWORDS", 159, "thousand", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS29() throws Exception {
		// gunit test on line 160
		Object retval = execLexer("NUMWORDS", 160, "million", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS30() throws Exception {
		// gunit test on line 161
		Object retval = execLexer("NUMWORDS", 161, "billion", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS31() throws Exception {
		// gunit test on line 162
		Object retval = execLexer("NUMWORDS", 162, "oneteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS32() throws Exception {
		// gunit test on line 163
		Object retval = execLexer("NUMWORDS", 163, "fiveteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS33() throws Exception {
		// gunit test on line 164
		Object retval = execLexer("NUMWORDS", 164, "zero", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS34() throws Exception {
		// gunit test on line 165
		Object retval = execLexer("NUMWORDS", 165, "minus", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS35() throws Exception {
		// gunit test on line 166
		Object retval = execLexer("NUMWORDS", 166, "seventyeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testWS1() throws Exception {
		// gunit test on line 168
		Object retval = execLexer("WS", 168, " ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS2() throws Exception {
		// gunit test on line 169
		Object retval = execLexer("WS", 169, "    ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS3() throws Exception {
		// gunit test on line 170
		Object retval = execLexer("WS", 170, "\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS4() throws Exception {
		// gunit test on line 171
		Object retval = execLexer("WS", 171, "\t\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS5() throws Exception {
		// gunit test on line 172
		Object retval = execLexer("WS", 172, "\t \t   ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS6() throws Exception {
		// gunit test on line 173
		Object retval = execLexer("WS", 173, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS7() throws Exception {
		// gunit test on line 174
		Object retval = execLexer("WS", 174, " a ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"WS", expecting, actual);
	}



}