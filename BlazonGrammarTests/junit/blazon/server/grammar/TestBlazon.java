package blazon.server.grammar;

import org.antlr.gunit.gUnitBaseTest;

public class TestBlazon extends gUnitBaseTest {
	
	public void setUp() {
		this.packagePath = "./blazon/server/grammar";
		this.lexerPath = "blazon.server.grammar.BlazonLexer";
		this.parserPath = "blazon.server.grammar.BlazonParser";
	}

	public void testORDINARY_DIV1() throws Exception {
		// gunit test on line 10
		Object retval = execLexer("ORDINARY_DIV", 10, "fess", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV2() throws Exception {
		// gunit test on line 11
		Object retval = execLexer("ORDINARY_DIV", 11, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV3() throws Exception {
		// gunit test on line 12
		Object retval = execLexer("ORDINARY_DIV", 12, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV4() throws Exception {
		// gunit test on line 13
		Object retval = execLexer("ORDINARY_DIV", 13, "cross", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV5() throws Exception {
		// gunit test on line 14
		Object retval = execLexer("ORDINARY_DIV", 14, "saltire", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV6() throws Exception {
		// gunit test on line 15
		Object retval = execLexer("ORDINARY_DIV", 15, "chevron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV7() throws Exception {
		// gunit test on line 16
		Object retval = execLexer("ORDINARY_DIV", 16, "pall", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV8() throws Exception {
		// gunit test on line 17
		Object retval = execLexer("ORDINARY_DIV", 17, "bend sinister", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV9() throws Exception {
		// gunit test on line 18
		Object retval = execLexer("ORDINARY_DIV", 18, "gyronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testORDINARY_DIV10() throws Exception {
		// gunit test on line 19
		Object retval = execLexer("ORDINARY_DIV", 19, "colour", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"ORDINARY_DIV", expecting, actual);
	}

	public void testOTHER_ORDINARY1() throws Exception {
		// gunit test on line 21
		Object retval = execLexer("OTHER_ORDINARY", 21, "base", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testOTHER_ORDINARY2() throws Exception {
		// gunit test on line 22
		Object retval = execLexer("OTHER_ORDINARY", 22, "chief", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testOTHER_ORDINARY3() throws Exception {
		// gunit test on line 23
		Object retval = execLexer("OTHER_ORDINARY", 23, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testOTHER_ORDINARY4() throws Exception {
		// gunit test on line 24
		Object retval = execLexer("OTHER_ORDINARY", 24, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OTHER_ORDINARY", expecting, actual);
	}

	public void testSUBORDINARY_DIV1() throws Exception {
		// gunit test on line 28
		Object retval = execLexer("SUBORDINARY_DIV", 28, "pall", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_DIV", expecting, actual);
	}

	public void testSUBORDINARY_DIV2() throws Exception {
		// gunit test on line 29
		Object retval = execLexer("SUBORDINARY_DIV", 29, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY_DIV", expecting, actual);
	}

	public void testSUBORDINARY_DIV3() throws Exception {
		// gunit test on line 30
		Object retval = execLexer("SUBORDINARY_DIV", 30, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY_DIV", expecting, actual);
	}

	public void testSUBORDINARY1() throws Exception {
		// gunit test on line 33
		Object retval = execLexer("SUBORDINARY", 33, "pile", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY2() throws Exception {
		// gunit test on line 34
		Object retval = execLexer("SUBORDINARY", 34, "quarter", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY3() throws Exception {
		// gunit test on line 35
		Object retval = execLexer("SUBORDINARY", 35, "canton", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY4() throws Exception {
		// gunit test on line 36
		Object retval = execLexer("SUBORDINARY", 36, "flaunches", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY5() throws Exception {
		// gunit test on line 37
		Object retval = execLexer("SUBORDINARY", 37, "bordure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY6() throws Exception {
		// gunit test on line 38
		Object retval = execLexer("SUBORDINARY", 38, "orle", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY7() throws Exception {
		// gunit test on line 39
		Object retval = execLexer("SUBORDINARY", 39, "tressure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY8() throws Exception {
		// gunit test on line 40
		Object retval = execLexer("SUBORDINARY", 40, "gyron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY9() throws Exception {
		// gunit test on line 41
		Object retval = execLexer("SUBORDINARY", 41, "fret", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY10() throws Exception {
		// gunit test on line 42
		Object retval = execLexer("SUBORDINARY", 42, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY11() throws Exception {
		// gunit test on line 43
		Object retval = execLexer("SUBORDINARY", 43, "pall", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY12() throws Exception {
		// gunit test on line 44
		Object retval = execLexer("SUBORDINARY", 44, "saltire", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE1() throws Exception {
		// gunit test on line 47
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 47, "bendlet", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE2() throws Exception {
		// gunit test on line 48
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 48, "bendlets", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE3() throws Exception {
		// gunit test on line 49
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 49, "chevronel", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE4() throws Exception {
		// gunit test on line 50
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 50, "chevronels", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE5() throws Exception {
		// gunit test on line 51
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 51, "bar", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE6() throws Exception {
		// gunit test on line 52
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 52, "bars", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE7() throws Exception {
		// gunit test on line 53
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 53, "pallet", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE8() throws Exception {
		// gunit test on line 54
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 54, "pallets", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE9() throws Exception {
		// gunit test on line 55
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 55, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE10() throws Exception {
		// gunit test on line 56
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 56, "bends", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE11() throws Exception {
		// gunit test on line 57
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 57, "pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testSUBORDINARY_MULTIPLE12() throws Exception {
		// gunit test on line 58
		Object retval = execLexer("SUBORDINARY_MULTIPLE", 58, "pales", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"SUBORDINARY_MULTIPLE", expecting, actual);
	}

	public void testTIERCED1() throws Exception {
		// gunit test on line 60
		Object retval = execLexer("TIERCED", 60, "tierced", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testTIERCED2() throws Exception {
		// gunit test on line 61
		Object retval = execLexer("TIERCED", 61, "tierc", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testTIERCED3() throws Exception {
		// gunit test on line 62
		Object retval = execLexer("TIERCED", 62, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"TIERCED", expecting, actual);
	}

	public void testMODIFIER1() throws Exception {
		// gunit test on line 65
		Object retval = execLexer("MODIFIER", 65, "reversed", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER2() throws Exception {
		// gunit test on line 66
		Object retval = execLexer("MODIFIER", 66, "sinister", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER3() throws Exception {
		// gunit test on line 67
		Object retval = execLexer("MODIFIER", 67, "reversey", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testMODIFIER4() throws Exception {
		// gunit test on line 68
		Object retval = execLexer("MODIFIER", 68, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"MODIFIER", expecting, actual);
	}

	public void testQUARTER1() throws Exception {
		// gunit test on line 71
		Object retval = execLexer("QUARTER", 71, "quarterly", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER2() throws Exception {
		// gunit test on line 72
		Object retval = execLexer("QUARTER", 72, "quartered", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER3() throws Exception {
		// gunit test on line 73
		Object retval = execLexer("QUARTER", 73, "quarter", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testQUARTER4() throws Exception {
		// gunit test on line 74
		Object retval = execLexer("QUARTER", 74, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"QUARTER", expecting, actual);
	}

	public void testCONTINUOUS_DIV1() throws Exception {
		// gunit test on line 77
		Object retval = execLexer("CONTINUOUS_DIV", 77, "chequy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testCONTINUOUS_DIV2() throws Exception {
		// gunit test on line 78
		Object retval = execLexer("CONTINUOUS_DIV", 78, "lozengy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testCONTINUOUS_DIV3() throws Exception {
		// gunit test on line 79
		Object retval = execLexer("CONTINUOUS_DIV", 79, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"CONTINUOUS_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV1() throws Exception {
		// gunit test on line 82
		Object retval = execLexer("VARIABLE_DIV", 82, "gyronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV2() throws Exception {
		// gunit test on line 83
		Object retval = execLexer("VARIABLE_DIV", 83, "barry", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV3() throws Exception {
		// gunit test on line 84
		Object retval = execLexer("VARIABLE_DIV", 84, "bendy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV4() throws Exception {
		// gunit test on line 85
		Object retval = execLexer("VARIABLE_DIV", 85, "paly", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV5() throws Exception {
		// gunit test on line 86
		Object retval = execLexer("VARIABLE_DIV", 86, "chevronny", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV6() throws Exception {
		// gunit test on line 87
		Object retval = execLexer("VARIABLE_DIV", 87, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV7() throws Exception {
		// gunit test on line 88
		Object retval = execLexer("VARIABLE_DIV", 88, "bend", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV8() throws Exception {
		// gunit test on line 89
		Object retval = execLexer("VARIABLE_DIV", 89, "gyron", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testVARIABLE_DIV9() throws Exception {
		// gunit test on line 90
		Object retval = execLexer("VARIABLE_DIV", 90, "random", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"VARIABLE_DIV", expecting, actual);
	}

	public void testPARTYPER1() throws Exception {
		// gunit test on line 93
		Object retval = execLexer("PARTYPER", 93, "per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER2() throws Exception {
		// gunit test on line 94
		Object retval = execLexer("PARTYPER", 94, "party per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER3() throws Exception {
		// gunit test on line 95
		Object retval = execLexer("PARTYPER", 95, "parted per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER4() throws Exception {
		// gunit test on line 96
		Object retval = execLexer("PARTYPER", 96, "partie per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testPARTYPER5() throws Exception {
		// gunit test on line 97
		Object retval = execLexer("PARTYPER", 97, "part per", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"PARTYPER", expecting, actual);
	}

	public void testCOLOUR1() throws Exception {
		// gunit test on line 99
		Object retval = execLexer("COLOUR", 99, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR2() throws Exception {
		// gunit test on line 100
		Object retval = execLexer("COLOUR", 100, "sable", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR3() throws Exception {
		// gunit test on line 101
		Object retval = execLexer("COLOUR", 101, "vert", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR4() throws Exception {
		// gunit test on line 102
		Object retval = execLexer("COLOUR", 102, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR5() throws Exception {
		// gunit test on line 103
		Object retval = execLexer("COLOUR", 103, "purpure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR6() throws Exception {
		// gunit test on line 104
		Object retval = execLexer("COLOUR", 104, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testCOLOUR7() throws Exception {
		// gunit test on line 105
		Object retval = execLexer("COLOUR", 105, "blue", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"COLOUR", expecting, actual);
	}

	public void testMETAL1() throws Exception {
		// gunit test on line 107
		Object retval = execLexer("METAL", 107, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL2() throws Exception {
		// gunit test on line 108
		Object retval = execLexer("METAL", 108, "argent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL3() throws Exception {
		// gunit test on line 109
		Object retval = execLexer("METAL", 109, "azure", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testMETAL4() throws Exception {
		// gunit test on line 110
		Object retval = execLexer("METAL", 110, "gold", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"METAL", expecting, actual);
	}

	public void testFUR1() throws Exception {
		// gunit test on line 112
		Object retval = execLexer("FUR", 112, "ermine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR2() throws Exception {
		// gunit test on line 113
		Object retval = execLexer("FUR", 113, "ermines", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR3() throws Exception {
		// gunit test on line 114
		Object retval = execLexer("FUR", 114, "erminois", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR4() throws Exception {
		// gunit test on line 115
		Object retval = execLexer("FUR", 115, "pean", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR5() throws Exception {
		// gunit test on line 116
		Object retval = execLexer("FUR", 116, "vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR6() throws Exception {
		// gunit test on line 117
		Object retval = execLexer("FUR", 117, "counter-vair", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR7() throws Exception {
		// gunit test on line 118
		Object retval = execLexer("FUR", 118, "vair-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR8() throws Exception {
		// gunit test on line 119
		Object retval = execLexer("FUR", 119, "vair-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR9() throws Exception {
		// gunit test on line 120
		Object retval = execLexer("FUR", 120, "potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR10() throws Exception {
		// gunit test on line 121
		Object retval = execLexer("FUR", 121, "counter-potent", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR11() throws Exception {
		// gunit test on line 122
		Object retval = execLexer("FUR", 122, "potent-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR12() throws Exception {
		// gunit test on line 123
		Object retval = execLexer("FUR", 123, "potent-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR13() throws Exception {
		// gunit test on line 124
		Object retval = execLexer("FUR", 124, "pean-en-pale", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR14() throws Exception {
		// gunit test on line 125
		Object retval = execLexer("FUR", 125, "ermine-en-point", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testFUR15() throws Exception {
		// gunit test on line 126
		Object retval = execLexer("FUR", 126, "gules", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"FUR", expecting, actual);
	}

	public void testAND1() throws Exception {
		// gunit test on line 128
		Object retval = execLexer("AND", 128, "and", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND2() throws Exception {
		// gunit test on line 129
		Object retval = execLexer("AND", 129, "&", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testAND3() throws Exception {
		// gunit test on line 130
		Object retval = execLexer("AND", 130, "+", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"AND", expecting, actual);
	}

	public void testOF1() throws Exception {
		// gunit test on line 132
		Object retval = execLexer("OF", 132, "of", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testOF2() throws Exception {
		// gunit test on line 133
		Object retval = execLexer("OF", 133, "or", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"OF", expecting, actual);
	}

	public void testDETERMINER1() throws Exception {
		// gunit test on line 136
		Object retval = execLexer("DETERMINER", 136, "a", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DETERMINER", expecting, actual);
	}

	public void testDETERMINER2() throws Exception {
		// gunit test on line 137
		Object retval = execLexer("DETERMINER", 137, "an", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DETERMINER", expecting, actual);
	}

	public void testDETERMINER3() throws Exception {
		// gunit test on line 138
		Object retval = execLexer("DETERMINER", 138, "and", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DETERMINER", expecting, actual);
	}

	public void testDETERMINER4() throws Exception {
		// gunit test on line 139
		Object retval = execLexer("DETERMINER", 139, "b", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DETERMINER", expecting, actual);
	}

	public void testDIGITS1() throws Exception {
		// gunit test on line 141
		Object retval = execLexer("DIGITS", 141, "1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS2() throws Exception {
		// gunit test on line 142
		Object retval = execLexer("DIGITS", 142, "12", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS3() throws Exception {
		// gunit test on line 143
		Object retval = execLexer("DIGITS", 143, "1234567890", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS4() throws Exception {
		// gunit test on line 144
		Object retval = execLexer("DIGITS", 144, "0.1", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS5() throws Exception {
		// gunit test on line 145
		Object retval = execLexer("DIGITS", 145, "", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testDIGITS6() throws Exception {
		// gunit test on line 146
		Object retval = execLexer("DIGITS", 146, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"DIGITS", expecting, actual);
	}

	public void testNUMWORDS1() throws Exception {
		// gunit test on line 149
		Object retval = execLexer("NUMWORDS", 149, "one", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS2() throws Exception {
		// gunit test on line 150
		Object retval = execLexer("NUMWORDS", 150, "eleven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS3() throws Exception {
		// gunit test on line 151
		Object retval = execLexer("NUMWORDS", 151, "two", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS4() throws Exception {
		// gunit test on line 152
		Object retval = execLexer("NUMWORDS", 152, "twelve", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS5() throws Exception {
		// gunit test on line 153
		Object retval = execLexer("NUMWORDS", 153, "three", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS6() throws Exception {
		// gunit test on line 154
		Object retval = execLexer("NUMWORDS", 154, "thirteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS7() throws Exception {
		// gunit test on line 155
		Object retval = execLexer("NUMWORDS", 155, "four", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS8() throws Exception {
		// gunit test on line 156
		Object retval = execLexer("NUMWORDS", 156, "fourteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS9() throws Exception {
		// gunit test on line 157
		Object retval = execLexer("NUMWORDS", 157, "five", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS10() throws Exception {
		// gunit test on line 158
		Object retval = execLexer("NUMWORDS", 158, "fifteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS11() throws Exception {
		// gunit test on line 159
		Object retval = execLexer("NUMWORDS", 159, "six", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS12() throws Exception {
		// gunit test on line 160
		Object retval = execLexer("NUMWORDS", 160, "sixteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS13() throws Exception {
		// gunit test on line 161
		Object retval = execLexer("NUMWORDS", 161, "seven", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS14() throws Exception {
		// gunit test on line 162
		Object retval = execLexer("NUMWORDS", 162, "seventeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS15() throws Exception {
		// gunit test on line 163
		Object retval = execLexer("NUMWORDS", 163, "eight", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS16() throws Exception {
		// gunit test on line 164
		Object retval = execLexer("NUMWORDS", 164, "eighteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS17() throws Exception {
		// gunit test on line 165
		Object retval = execLexer("NUMWORDS", 165, "nine", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS18() throws Exception {
		// gunit test on line 166
		Object retval = execLexer("NUMWORDS", 166, "nineteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS19() throws Exception {
		// gunit test on line 167
		Object retval = execLexer("NUMWORDS", 167, "twenty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS20() throws Exception {
		// gunit test on line 168
		Object retval = execLexer("NUMWORDS", 168, "thirty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS21() throws Exception {
		// gunit test on line 169
		Object retval = execLexer("NUMWORDS", 169, "fourty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS22() throws Exception {
		// gunit test on line 170
		Object retval = execLexer("NUMWORDS", 170, "fifty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS23() throws Exception {
		// gunit test on line 171
		Object retval = execLexer("NUMWORDS", 171, "sixty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS24() throws Exception {
		// gunit test on line 172
		Object retval = execLexer("NUMWORDS", 172, "seventy", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS25() throws Exception {
		// gunit test on line 173
		Object retval = execLexer("NUMWORDS", 173, "eighty", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS26() throws Exception {
		// gunit test on line 174
		Object retval = execLexer("NUMWORDS", 174, "ninety", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS27() throws Exception {
		// gunit test on line 175
		Object retval = execLexer("NUMWORDS", 175, "hundred", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS28() throws Exception {
		// gunit test on line 176
		Object retval = execLexer("NUMWORDS", 176, "thousand", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS29() throws Exception {
		// gunit test on line 177
		Object retval = execLexer("NUMWORDS", 177, "million", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS30() throws Exception {
		// gunit test on line 178
		Object retval = execLexer("NUMWORDS", 178, "billion", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS31() throws Exception {
		// gunit test on line 179
		Object retval = execLexer("NUMWORDS", 179, "oneteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS32() throws Exception {
		// gunit test on line 180
		Object retval = execLexer("NUMWORDS", 180, "fiveteen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS33() throws Exception {
		// gunit test on line 181
		Object retval = execLexer("NUMWORDS", 181, "zero", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS34() throws Exception {
		// gunit test on line 182
		Object retval = execLexer("NUMWORDS", 182, "minus", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testNUMWORDS35() throws Exception {
		// gunit test on line 183
		Object retval = execLexer("NUMWORDS", 183, "seventyeen", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"NUMWORDS", expecting, actual);
	}

	public void testWS1() throws Exception {
		// gunit test on line 185
		Object retval = execLexer("WS", 185, " ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS2() throws Exception {
		// gunit test on line 186
		Object retval = execLexer("WS", 186, "    ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS3() throws Exception {
		// gunit test on line 187
		Object retval = execLexer("WS", 187, "\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS4() throws Exception {
		// gunit test on line 188
		Object retval = execLexer("WS", 188, "\t\t", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS5() throws Exception {
		// gunit test on line 189
		Object retval = execLexer("WS", 189, "\t \t   ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.OK, retval);
		Object expecting = "OK";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS6() throws Exception {
		// gunit test on line 190
		Object retval = execLexer("WS", 190, "blah", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"WS", expecting, actual);
	}

	public void testWS7() throws Exception {
		// gunit test on line 191
		Object retval = execLexer("WS", 191, " a ", false);
		Object actual = examineExecResult(org.antlr.gunit.gUnitParser.FAIL, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"WS", expecting, actual);
	}



}