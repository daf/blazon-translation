package blazon.shared.shield;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ShieldDivisionTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatGetDivisionTypeWithNullThrowsIllegalArgumentException() {
		ShieldDivision division = new ShieldDivision();
		division.getDivisionType(null, new ArrayList<ShieldDiagnostic>());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatGetDivisionTypeWithEmptyStringThrowsIllegalArgumentException() {
		ShieldDivision division = new ShieldDivision();
		division.getDivisionType("", new ArrayList<ShieldDiagnostic>());
	}
	
	@Test
	public void testThatGetDivisionTypeWithBendSinisterLowerCaseWithSpaceReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("bend sinister", diags);
		assertThat(type.getName(), is("BEND_SINISTER"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithBendSinisterLowerCaseWithUnderscoreReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("bend_sinister", diags);
		assertThat(type.getName(), is("BEND_SINISTER"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithFessLowerCaseReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("fess", diags);
		assertThat(type.getName(), is("FESS"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithBendSinisterUpperCaseWithSpaceReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("BEND SINISTER", diags);
		assertThat(type.getName(), is("BEND_SINISTER"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithBendSinisterUpperCaseWithUnderscoreReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("BEND_SINISTER", diags);
		assertThat(type.getName(), is("BEND_SINISTER"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithFessUpperCaseReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("FESS", diags);
		assertThat(type.getName(), is("FESS"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf0ReturnsFieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_0", diags);
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfBlankReturnsFieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_", diags);
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf6ReturnsGyronnyOf6() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_6", diags);
		assertThat(type.getName(), is("GYRONNY_OF_6"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(6));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf8ReturnsGyronnyOf8() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_8", diags);
		assertThat(type.getName(), is("GYRONNY_OF_8"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(8));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf4ReturnsCross() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_4", diags);
		assertThat(type.getName(), is("CROSS"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(4));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf3ReturnsShieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_3", diags);
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf5ReturnsGyronnyOf6() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_5", diags);
		assertThat(type.getName(), is("GYRONNY_OF_6"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(6));
		assertThat(diags.size(), is(1));
	}	
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfEightReturnsGyronnyOf8() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_EIGHT", diags);
		assertThat(type.getName(), is("GYRONNY_OF_8"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(8));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfFiveReturnsGyronnyOf8() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_FIVE", diags);
		assertThat(type.getName(), is("GYRONNY_OF_6"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(6));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfThirtyTwoReturnsGyronnyOf32() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("gyronny of thirty two", diags);
		assertThat(type.getName(), is("GYRONNY_OF_32"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(32));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithBarryReturnsBarry() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("barry", diags);
		assertThat(type.getName(), is("BARRY"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(6));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithBarryOf10ReturnsBarryOf10() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("barry of 10", diags);
		assertThat(type.getName(), is("BARRY_OF_10"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(10));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithBarryOfBlankReturnsFieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("BARRY_OF_", diags);
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithPalyReturnsPaly() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("paly", diags);
		assertThat(type.getName(), is("PALY"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(6));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithPaly10ReturnsFieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("paly 10", diags);
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithChevronnyReturnsChevronny() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("chevronny", diags);
		assertThat(type.getName(), is("CHEVRONNY"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(6));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithBendOf6ReturnsNone() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("bend of 6", diags);
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithyBarryOfTwoReturnsFess() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("barry of two", diags);
		assertThat(type.getName(), is("FESS"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithyBendyOfTwoReturnsBend() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("bendy of two", diags);
		assertThat(type.getName(), is("BEND"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithyPalyOfTwoReturnsPale() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("paly of two", diags);
		assertThat(type.getName(), is("PALE"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithyBendySinisterOfTwoReturnsBendSinister() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("bendy sinister of two", diags);
		assertThat(type.getName(), is("BEND_SINISTER"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithyChevronnyOfTwoReturnsChevron() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("chevronny of two", diags);
		assertThat(type.getName(), is("CHEVRON"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithyChevronnyReversedOfTwoReturnsChevronReversed() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("chevronny reversed of two", diags);
		assertThat(type.getName(), is("CHEVRON_REVERSED"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
		assertThat(diags.size(), is(1));
	}

	@Test
	public void testThatGetDivisionTypeWithyChevronnyReversedOf3ReturnsChevronnyReversedOf4() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("chevronny reversed of 3", diags);
		assertThat(type.getName(), is("CHEVRONNY_REVERSED_OF_4"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(4));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithyBarryOf1ReturnsNone() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("barry of 1", diags);
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithyBarryTwoReturnsBarryyOf32() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("barry of thirty two", diags);
		assertThat(type.getName(), is("BARRY_OF_32"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(32));
		assertTrue(diags.isEmpty());
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfRandomReturnsShieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("gyronny of random", diags);
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithRandomReturnsShieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		ShieldDivisionType type = division.getDivisionType("RANDOM", diags);
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
		assertThat(diags.size(), is(1));
	}
	
	@Test
	public void testThatDivisionTypeToStringContains3Members() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("gyronny of thirty two", new ArrayList<ShieldDiagnostic>());
		String toString = "ShieldDivisionType{name=GYRONNY_OF_32:numberOfSections=32:numberOfTinctures=2}";
		assertThat(type.toString(), is(equalTo(toString)));
	}
	
	@Test
	public void testThatShieldDivisionTypeEqualsNullReturnsFalse() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("saltire", new ArrayList<ShieldDiagnostic>());
		assertThat(type.equals(null), is(false));
	}
	
	@Test
	public void testThatShieldDivisionTypeEqualsSelfReturnsTrue() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("saltire", new ArrayList<ShieldDiagnostic>());
		assertThat(type.equals(type), is(true));
		assertThat(type.hashCode(), is(equalTo(type.hashCode())));
	}
	
	@Test
	public void testThatTwoSaltireShieldDivisionTypesEqualsReturnsTrueSymmetrically() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type1 = division.getDivisionType("saltire", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType type2 = division.getDivisionType("saltire", new ArrayList<ShieldDiagnostic>());
		assertThat(type1.equals(type2), is(true));
		assertThat(type2.equals(type1), is(true));
		assertThat(type1.hashCode(), is(equalTo(type2.hashCode())));
		assertThat(type2.hashCode(), is(equalTo(type1.hashCode())));
	}
	
	@Test
	public void testThatTwoSaltireShieldDivisionTypesEqualsReturnsTrueConsistently() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type1 = division.getDivisionType("saltire", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType type2 = division.getDivisionType("saltire", new ArrayList<ShieldDiagnostic>());
		assertThat(type1.equals(type2), is(true));
		assertThat(type1.equals(type2), is(true));
		assertThat(type1.equals(type2), is(true));
		assertThat(type1.hashCode(), is(equalTo(type2.hashCode())));
		assertThat(type1.hashCode(), is(equalTo(type2.hashCode())));
		assertThat(type1.hashCode(), is(equalTo(type2.hashCode())));
	}
	
	@Test
	public void testThatThreeSaltireShieldDivisionTypesEqualsReturnsTrueTransitively() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type1 = division.getDivisionType("saltire", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType type2 = division.getDivisionType("saltire", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType type3 = division.getDivisionType("saltire", new ArrayList<ShieldDiagnostic>());
		assertThat(type1.equals(type2), is(true));
		assertThat(type2.equals(type3), is(true));
		assertThat(type1.equals(type3), is(true));
		assertThat(type1.hashCode(), is(equalTo(type2.hashCode())));
		assertThat(type2.hashCode(), is(equalTo(type3.hashCode())));
		assertThat(type1.hashCode(), is(equalTo(type3.hashCode())));
	}
	
	@Test
	public void testThatBendSinisterAndFessShieldDivisionTypesEqualsReturnsFalse() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type1 = division.getDivisionType("bend sinister", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType type2 = division.getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		assertThat(type1.equals(type2), is(false));
	}
	
	@Test
	public void testThatBendSinisterAndFessShieldDivisionTypesEqualsReturnsFalseConsistently() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type1 = division.getDivisionType("bend sinister", new ArrayList<ShieldDiagnostic>());
		ShieldDivisionType type2 = division.getDivisionType("fess", new ArrayList<ShieldDiagnostic>());
		assertThat(type1.equals(type2), is(false));
		assertThat(type1.equals(type2), is(false));
	}
}
