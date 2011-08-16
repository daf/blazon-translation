package blazon.shared.shield;

import org.junit.Test;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShieldDivisionTest {

	@Test(expected=IllegalArgumentException.class)
	public void testThatGetDivisionTypeWithNullThrowsIllegalArgumentException() {
		ShieldDivision division = new ShieldDivision();
		division.getDivisionType(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testThatGetDivisionTypeWithEmptyStringThrowsIllegalArgumentException() {
		ShieldDivision division = new ShieldDivision();
		division.getDivisionType("");
	}
	
	@Test
	public void testThatGetDivisionTypeWithBendSinisterLowerCaseWithSpaceReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("bend sinister");
		assertThat(type.getName(), is("BEND_SINISTER"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
	}
	
	@Test
	public void testThatGetDivisionTypeWithBendSinisterLowerCaseWithUnderscoreReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("bend_sinister");
		assertThat(type.getName(), is("BEND_SINISTER"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
	}
	
	@Test
	public void testThatGetDivisionTypeWithFessLowerCaseReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("fess");
		assertThat(type.getName(), is("FESS"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
	}
	
	@Test
	public void testThatGetDivisionTypeWithBendSinisterUpperCaseWithSpaceReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("BEND SINISTER");
		assertThat(type.getName(), is("BEND_SINISTER"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
	}
	
	@Test
	public void testThatGetDivisionTypeWithBendSinisterUpperCaseWithUnderscoreReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("BEND_SINISTER");
		assertThat(type.getName(), is("BEND_SINISTER"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
	}
	
	@Test
	public void testThatGetDivisionTypeWithFessUpperCaseReturnsFess()  {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("FESS");
		assertThat(type.getName(), is("FESS"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(2));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf0ReturnsFieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_0");
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfBlankReturnsFieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_");
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf6ReturnsGyronnyOf6() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_6");
		assertThat(type.getName(), is("GYRONNY_OF_6"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(6));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf8ReturnsGyronnyOf8() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_8");
		assertThat(type.getName(), is("GYRONNY_OF_8"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(8));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf4ReturnsCross() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_4");
		assertThat(type.getName(), is("CROSS"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(4));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf3ReturnsShieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_3");
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOf5ReturnsGyronnyOf6() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_5");
		assertThat(type.getName(), is("GYRONNY_OF_6"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(6));
	}	
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfEightReturnsGyronnyOf8() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_EIGHT");
		assertThat(type.getName(), is("GYRONNY_OF_8"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(8));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfFiveReturnsGyronnyOf8() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("GYRONNY_OF_FIVE");
		assertThat(type.getName(), is("GYRONNY_OF_6"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(6));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfThirtyTwoReturnsGyronnyOf32() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("gyronny of thirty two");
		assertThat(type.getName(), is("GYRONNY_OF_32"));
		assertThat(type.getNumberOfTinctures(), is(2));
		assertThat(type.getNumberOfSections(), is(32));
	}
	
	@Test
	public void testThatGetDivisionTypeWithGyronnyOfRandomReturnsShieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("gyronny of random");
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
	}
	
	@Test
	public void testThatGetDivisionTypeWithRandomReturnsShieldDivisionOfNone() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("RANDOM");
		assertThat(type.getName(), is("NONE"));
		assertThat(type.getNumberOfTinctures(), is(1));
		assertThat(type.getNumberOfSections(), is(1));
	}
	
	@Test
	public void testThatDivisionTypeToStringContains3Members() {
		ShieldDivision division = new ShieldDivision();
		ShieldDivisionType type = division.getDivisionType("gyronny of thirty two");
		String toString = "ShieldDivisionType{name=GYRONNY_OF_32:numberOfSections=32:numberOfTinctures=2}";
		assertThat(type.toString(), is(equalTo(toString)));
	}
}
