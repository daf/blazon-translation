package blazon.shared.shield.tinctures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProperTest {

	private static final String PROPER = "proper";
	
	@Test
	public void testThatBuildProperReturnsAProperObject() {
		Tincture tincture = Proper.build();
		assertThat(tincture instanceof Proper, is(true));
	}
	
	@Test
	public void testThatBuildSetsNameToProper() {
		Tincture t = Proper.build();
		assertThat(t.getName(), is(equalTo(PROPER)));
	}
	
	@Test
	public void testThatBuildSetsFillTextToProper() {
		Tincture t = Proper.build();
		assertThat(t.getFillText(), is(equalTo(PROPER)));
	}
	
	@Test
	public void testThatProperGetTinctureTypeReturnsOther() {
		Tincture t = Proper.build();
		assertThat(t.getTinctureType(), is(TinctureType.OTHER));
	}
	
	@Test
	public void testThatToStringForSableIsAsExpected() {
		Tincture t = Proper.build();
		String toString = "Tincture{name=proper:fillText=proper}";
		assertThat(t.toString(), is(equalTo(toString)));
	}
	
	@Test
	public void testThatEqualsReturnsFalseForNull() {
		Tincture t = Proper.build();
		assertThat(t.equals(null), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsFalseWhenComparingWithObjectVariable() {
		Tincture t = Proper.build();
		assertThat(t.equals(new Object()), is(false));
	}
	
	@Test
	public void testThatEqualsReturnsTrueWhenPassingReferenceToSameObject() {
		Tincture t = Proper.build();
		assertThat(t.equals(t), is(true));
	}
	
	@Test
	public void testThatEqualsReturnsTrueConstistentlyWhenPassingReferenceToSameObject() {
		Tincture t = Proper.build();
		assertThat(t.equals(t), is(true));
		assertThat(t.equals(t), is(true));
		assertThat(t.equals(t), is(true));
	}
	
	@Test
	public void testThatEqualsReturnsTrueWhenPassingObjectThatWasConstructedUsingTheSameParameters() {
		Tincture t1 = Proper.build();
		Tincture t2 = Proper.build();
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
	}
	
	@Test
	public void testThatEqualsReturnsTrueSymmetricallyForObjectsConstructedTheSameWay() {
		Tincture t1 = Proper.build();
		Tincture t2 = Proper.build();
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
		assertThat(t2.equals(t1), is(true));
		assertThat(t2.hashCode(), is(equalTo(t1.hashCode())));
	}
	
	@Test
	public void testThatEqualsReturnsTrueTransitivelyForObjectsConstructedTheSameWay() {
		Tincture t1 = Proper.build();
		Tincture t2 = Proper.build();
		Tincture t3 = Proper.build();
		assertThat(t1.equals(t2), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
		assertThat(t2.equals(t3), is(true));
		assertThat(t2.hashCode(), is(equalTo(t3.hashCode())));
		assertThat(t1.equals(t3), is(true));
		assertThat(t1.hashCode(), is(equalTo(t2.hashCode())));
	}
}
