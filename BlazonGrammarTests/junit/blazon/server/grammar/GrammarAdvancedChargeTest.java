package blazon.server.grammar;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import blazon.shared.shield.charges.AdvancedCharge;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class GrammarAdvancedChargeTest {
	
	private String blazon;
	private String answer;
	private int number;
	private TinctureType underTinctureType;
	
	public GrammarAdvancedChargeTest(String blazon, int number, TinctureType underTinctureType) {
		this.blazon = blazon;
		this.answer = "'" + blazon.replace(" and ", " ") + "'";
		this.number = number;
		this.underTinctureType = underTinctureType;
	}
	
	@Parameters
	public static Collection<Object[]> getBlazonSentences() {
		return Arrays.asList(new Object[][] {
			{ "lion rampant or", 1, TinctureType.COLOUR }, 
			{ "lion rampant or langued gules", 1, TinctureType.COLOUR }, 
			{ "lion rampant or langued gules and armed argent", 1, TinctureType.COLOUR }, 
			{ "lions rampant or", 2, TinctureType.COLOUR }, 
			{ "lion rampant guardant or", 1, TinctureType.COLOUR },
			{ "dragon passant gules", 1, TinctureType.METAL},
			{ "dragon passant reguardant gules", 1, TinctureType.METAL },
			{ "dragon rising gules", 1, TinctureType.METAL },
			{ "dragons rising gules", 3, TinctureType.METAL },
			{ "dragon rising reguardant gules", 1, TinctureType.METAL },
			{ "bee displayed gules", 1, TinctureType.METAL },
			{ "bee displayed guardant gules", 1, TinctureType.COLOUR },
			{ "fish naiant proper", 1, TinctureType.OTHER },
			{ "fish naiant guardant proper", 1, TinctureType.OTHER },
		});
	}

	@Test
	public void testThatAdvancedChargeGetsReturnedCorrectly() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser(blazon);
		Tinctures tinctures = new Tinctures();
		List<AdvancedCharge> advancedCharges = parser.advanced_charge(tinctures, underTinctureType, number);
		assertThat(advancedCharges.size(), is(number));
		for(int i = 0; i < number; i++) {
			AdvancedCharge advCharge = advancedCharges.get(i);
			if (answer.contains(advCharge.getName() + "s")) {
				answer = answer.replace(advCharge.getName() + "s", advCharge.getName());
			}
			assertThat(advCharge.getTextDescription(), is(equalTo(answer)));
		}
	}
}
