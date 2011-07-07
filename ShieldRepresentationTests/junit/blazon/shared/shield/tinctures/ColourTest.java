package blazon.shared.shield.tinctures;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class ColourTest {
	private String name;
	private String colour;
	
	public ColourTest(String name, String colour) {
		this.name = name;
		this.colour = colour;
	}
	
	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{null, null},
				{"name", null},
				{null, "colour"},
				{"", "colour"},
				{"name", ""},
				{"gules", "red"},
				{"vert,", "green"},
				
		});
	}
	
	@Test
	public void testBuild() {
		if (name == null || name.isEmpty() || colour == null || colour.isEmpty()) {
			try {
				Colour.build(name, colour);
				fail();
			} catch (IllegalArgumentException e) {
				assertThat(e.getMessage(), 
						is(equalTo("Colour can not be built with null or empty argument")));
			}
		} else {
			Tincture c = Colour.build(name, colour);
			assertThat(name, is(equalTo(c.getName())));
			assertThat(colour, is(equalTo(c.getPatternReference())));
		}
	}
}
