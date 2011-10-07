package blazon.shared.shield;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.Tinctures;

public class InvalidShieldTest {

	@Test
	public void testThatIfYouBuildAnInvalidShieldWithNoDiagnosticsThenGetDiagnosticsReturnsNull() {
		Shield shield = InvalidShield.build();
		assertThat(shield.getShieldDiagnostics(), is(notNullValue()));
		assertTrue(shield.getShieldDiagnostics().isEmpty());
	}
	
	@Test
	public void testThatIfYouBuildAnInvalidShieldWithNullListOfDiagnosticsThenGetDiagnosticsReturnsNull() {
		Shield shield = InvalidShield.build(null);
		assertThat(shield.getShieldDiagnostics(), is(notNullValue()));
		assertTrue(shield.getShieldDiagnostics().isEmpty());
	}
	
	@Test
	public void testThatIfYouBuildAnInvalidShieldWithEmptyListOfDiagnosticsThenGetDiagnosticsReturnsNull() {
		Shield shield = InvalidShield.build(new ArrayList<ShieldDiagnostic>());
		assertThat(shield.getShieldDiagnostics(), is(notNullValue()));
		assertTrue(shield.getShieldDiagnostics().isEmpty());
	}
	
	@Test
	public void testThatGettingFieldFromInvalidShieldReturnsNull() {
		assertThat(InvalidShield.build().getField(), is(nullValue()));
	}
	
	@Test
	public void testThatAnInvalidShieldIsEqualToItself() {
		Shield shield = InvalidShield.build();
		assertThat(shield.equals(shield), is(true));
		assertThat(shield.hashCode(), is(equalTo(shield.hashCode())));
	}
	
	@Test
	public void testThatTwoInvalidShieldsConstructedWithNoDiagnosticsAreEqualToEachOther() {
		Shield shield1 = InvalidShield.build();
		Shield shield2 = InvalidShield.build();
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
	}
	
	@Test
	public void testThatAnInvalidShieldCanNotBeEqualToNull() {
		Shield shield = InvalidShield.build();
		assertThat(shield.equals(null), is(false));
	}
	
	@Test
	public void testThatAnInvalidShieldCanNotBeEqualToAShieldImpl() {
		Shield invalid = InvalidShield.build();
		Shield valid = ShieldImpl.build(ShieldLayer.buildUndividedShieldLayer(new Tinctures()), null);
		assertThat(invalid.equals(valid), is(false));
	}
	
	@Test
	public void testThat2InvalidShieldsConstructedWithEmptyDiagnosticListsAreEqual() {
		Shield shield1 = InvalidShield.build(new ArrayList<ShieldDiagnostic>());
		Shield shield2 = InvalidShield.build(new ArrayList<ShieldDiagnostic>());
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
	}
	
	@Test
	public void testThat2ShieldsWithTheSameItemsInTheSameOrderAreEqualConsistently() {
		List<ShieldDiagnostic> list1 = new ArrayList<ShieldDiagnostic>();
		List<ShieldDiagnostic> list2 = new ArrayList<ShieldDiagnostic>();
		
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list1.add(diag);
		list2.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.ERROR, "world");
		list1.add(diag);
		list2.add(diag);

		Shield shield1 = InvalidShield.build(list1);
		Shield shield2 = InvalidShield.build(list2);
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
	}
	
	@Test
	public void testThat2ShieldsWithTheSameItemsInTheSameOrderAreEqualSymmetrically() {
		List<ShieldDiagnostic> list1 = new ArrayList<ShieldDiagnostic>();
		List<ShieldDiagnostic> list2 = new ArrayList<ShieldDiagnostic>();
		
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list1.add(diag);
		list2.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.ERROR, "world");
		list1.add(diag);
		list2.add(diag);

		Shield shield1 = InvalidShield.build(list1);
		Shield shield2 = InvalidShield.build(list2);
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
		assertThat(shield2.equals(shield1), is(true));
		assertThat(shield2.hashCode(), is(equalTo(shield1.hashCode())));
	}
	
	@Test
	public void testThat3ShieldsWithTheSameItemsInTheSameOrderAreEqualTransitively() {
		List<ShieldDiagnostic> list1 = new ArrayList<ShieldDiagnostic>();
		List<ShieldDiagnostic> list2 = new ArrayList<ShieldDiagnostic>();
		List<ShieldDiagnostic> list3 = new ArrayList<ShieldDiagnostic>();
		
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list1.add(diag);
		list2.add(diag);
		list3.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.ERROR, "world");
		list1.add(diag);
		list2.add(diag);
		list3.add(diag);
		
		Shield shield1 = InvalidShield.build(list1);
		Shield shield2 = InvalidShield.build(list2);
		Shield shield3 = InvalidShield.build(list3);
		assertThat(shield1.equals(shield2), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield2.hashCode())));
		assertThat(shield2.equals(shield3), is(true));
		assertThat(shield2.hashCode(), is(equalTo(shield3.hashCode())));
		assertThat(shield1.equals(shield3), is(true));
		assertThat(shield1.hashCode(), is(equalTo(shield3.hashCode())));
	}
	
	@Test
	public void testThat2ShieldsWithTheSameItemsInADifferentOrderAreNotEqual() {
		List<ShieldDiagnostic> list1 = new ArrayList<ShieldDiagnostic>();
		List<ShieldDiagnostic> list2 = new ArrayList<ShieldDiagnostic>();
		
		ShieldDiagnostic diag1 = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		ShieldDiagnostic diag2 = ShieldDiagnostic.build(LogLevel.ERROR, "world");
		list1.add(diag1);
		list1.add(diag2);
		list2.add(diag2);
		list2.add(diag1);

		Shield shield1 = InvalidShield.build(list1);
		Shield shield2 = InvalidShield.build(list2);
		assertThat(shield1.equals(shield2), is(false));
		assertThat(shield2.equals(shield1), is(false));
	}
	
	@Test
	public void testThat2ShieldsWithADifferentNumberOfItemsAreNotEqual() {
		List<ShieldDiagnostic> list1 = new ArrayList<ShieldDiagnostic>();
		List<ShieldDiagnostic> list2 = new ArrayList<ShieldDiagnostic>();
		
		ShieldDiagnostic diag1 = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		ShieldDiagnostic diag2 = ShieldDiagnostic.build(LogLevel.ERROR, "world");
		list1.add(diag1);
		list1.add(diag2);
		list2.add(diag1);

		Shield shield1 = InvalidShield.build(list1);
		Shield shield2 = InvalidShield.build(list2);
		assertThat(shield1.equals(shield2), is(false));
		assertThat(shield2.equals(shield1), is(false));
	}
	
	@Test
	public void testThat2ShieldsWithDifferentItemsAreNotEqual() {
		List<ShieldDiagnostic> list1 = new ArrayList<ShieldDiagnostic>();
		List<ShieldDiagnostic> list2 = new ArrayList<ShieldDiagnostic>();
		
		ShieldDiagnostic diag1 = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		ShieldDiagnostic diag2 = ShieldDiagnostic.build(LogLevel.ERROR, "world");
		list1.add(diag1);
		list2.add(diag2);

		Shield shield1 = InvalidShield.build(list1);
		Shield shield2 = InvalidShield.build(list2);
		assertThat(shield1.equals(shield2), is(false));
		assertThat(shield2.equals(shield1), is(false));
	}
	
	@Test
	public void testThat2ShieldsWithOneWithNullListOfItemsAreNotEqual() {
		List<ShieldDiagnostic> list = new ArrayList<ShieldDiagnostic>();
		
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list.add(diag);

		Shield shield1 = InvalidShield.build(list);
		Shield shield2 = InvalidShield.build();
		assertThat(shield1.equals(shield2), is(false));
		assertThat(shield2.equals(shield1), is(false));
	}
	
	@Test
	public void testThatInvalidShieldToStringContainsTheDiagnostics() {
		List<ShieldDiagnostic> list = new ArrayList<ShieldDiagnostic>();
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list.add(diag);
		Shield shield = InvalidShield.build(list);
		String expected = "InvalidShield{diagnostics=[ShieldDiagnostic{level=ERROR:message=hello}]}";
		assertThat(shield.toString(), is(equalTo(expected)));
	}
	
	
	@Test
	public void testThatIfYouAddANullListOfDiagnosticsToAShieldWithNoDiagnosticsGetDiagnosticsReturnsNull() {
		Shield shield = InvalidShield.build();
		shield.addDiagnostics(null);
		assertThat(shield.getShieldDiagnostics(), is(notNullValue()));
		assertTrue(shield.getShieldDiagnostics().isEmpty());
	}
	
	@Test
	public void testThatIfYouAddAnEmptyListOfDiagnosticsToAShieldWithNoDiagnosticsGetDiagnosticsReturnsNull() {
		Shield shield = InvalidShield.build();
		shield.addDiagnostics(new ArrayList<ShieldDiagnostic>());
		assertThat(shield.getShieldDiagnostics(), is(notNullValue()));
		assertTrue(shield.getShieldDiagnostics().isEmpty());
	}
	
	@Test
	public void testThatIfYouAddListOfOneDiagnosticToAShieldWithNoDiagnosticsGetDiagnosticsReturnsAListWithTheSameItems() {
		Shield shield = InvalidShield.build();
		List<ShieldDiagnostic> list = new ArrayList<ShieldDiagnostic>();
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list.add(diag);
		shield.addDiagnostics(list);
		List<ShieldDiagnostic> actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list.size())));
		assertThat(actual.get(0), is(equalTo(list.get(0))));
	}
	
	@Test
	public void testThatIfYouAddListOfTwoDiagnosticsToAShieldWithNoDiagnosticsGetDiagnosticsReturnsAListWithTheSameItems() {
		Shield shield = InvalidShield.build();
		List<ShieldDiagnostic> list = new ArrayList<ShieldDiagnostic>();
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.WARN, "hello world");
		list.add(diag);
		shield.addDiagnostics(list);
		List<ShieldDiagnostic> actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list.size())));
		assertThat(actual.size(), is(equalTo(2)));
		assertThat(actual.get(0), is(equalTo(list.get(0))));
		assertThat(actual.get(1), is(equalTo(list.get(1))));
	}
	
	@Test
	public void testThatIfYouAddANullListOfDiagnosticsToAShieldWithSomeDiagnosticsGetDiagnosticsReturnsAListWithTheSameItems() {
		Shield shield = InvalidShield.build();
		List<ShieldDiagnostic> list = new ArrayList<ShieldDiagnostic>();
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.WARN, "hello world");
		list.add(diag);
		shield.addDiagnostics(list);
		List<ShieldDiagnostic> actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list.size())));
		assertThat(actual.size(), is(equalTo(2)));
		assertThat(actual.get(0), is(equalTo(list.get(0))));
		assertThat(actual.get(1), is(equalTo(list.get(1))));
		
		shield.addDiagnostics(null);
		assertThat(actual.size(), is(equalTo(list.size())));
		assertThat(actual.size(), is(equalTo(2)));
		assertThat(actual.get(0), is(equalTo(list.get(0))));
		assertThat(actual.get(1), is(equalTo(list.get(1))));
	}
	
	@Test
	public void testThatIfYouAddAListOfTwoDiagnosticsToAShieldWithTwoDiagnosticsGetDiagnosticsReturnsAListContainingAllItems() {
		Shield shield = InvalidShield.build();
		
		List<ShieldDiagnostic> list1 = new ArrayList<ShieldDiagnostic>();
		ShieldDiagnostic diag = ShieldDiagnostic.build(LogLevel.ERROR, "hello");
		list1.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.WARN, "hello world");
		list1.add(diag);
		shield.addDiagnostics(list1);

		List<ShieldDiagnostic> actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list1.size())));
		assertThat(actual.size(), is(equalTo(2)));
		assertThat(actual.get(0), is(equalTo(list1.get(0))));
		assertThat(actual.get(1), is(equalTo(list1.get(1))));
		
		List<ShieldDiagnostic> list2 = new ArrayList<ShieldDiagnostic>();
		diag = ShieldDiagnostic.build(LogLevel.INFO, "third item");
		list2.add(diag);
		diag = ShieldDiagnostic.build(LogLevel.WARN, "fourth item");
		list2.add(diag);
		shield.addDiagnostics(list2);
		
		actual = shield.getShieldDiagnostics();
		assertThat(actual.size(), is(equalTo(list1.size() + list2.size())));
		assertThat(actual.size(), is(equalTo(4)));
		assertThat(actual.get(0), is(equalTo(list1.get(0))));
		assertThat(actual.get(1), is(equalTo(list1.get(1))));
		assertThat(actual.get(2), is(equalTo(list2.get(0))));
		assertThat(actual.get(3), is(equalTo(list2.get(1))));
		
	}
}

