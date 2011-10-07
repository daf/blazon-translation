package blazon.shared.shield.tinctures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TinctureTypeTest {

	@Test
	public void testThatTinctureTypeParsesColourToCorrectEnumValue() {
		TinctureType tt = TinctureType.valueOf("COLOUR");
		assertThat(tt, is(equalTo(TinctureType.COLOUR)));
	}
	
	@Test
	public void testThatTinctureTypeParsesMetalToCorrectEnumValue() {
		TinctureType tt = TinctureType.valueOf("METAL");
		assertThat(tt, is(equalTo(TinctureType.METAL)));
	}
	
	@Test
	public void testThatTinctureTypeParsesOtherToCorrectEnumValue() {
		TinctureType tt = TinctureType.valueOf("OTHER");
		assertThat(tt, is(equalTo(TinctureType.OTHER)));
	}
}
