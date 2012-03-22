package blazon.server.grammar;

import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.shared.shield.charges.AdvancedCharge;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GrammarAdvancedChargeTest {

	@Test
	public void testThatLionRampantOrCreatedCorrectObject() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("lion rampant or");
		Tinctures tinctures = new Tinctures();
		List<AdvancedCharge> advancedCharges = parser.advanced_charge(tinctures, TinctureType.COLOUR, 1);
		assertThat(advancedCharges.size(), is(1));
		AdvancedCharge advCharge = advancedCharges.get(0);
		assertThat(advCharge.getTextDescription(), is(equalTo("'lion rampant or'")));
	}
	
	
	//beast with attitude
	//with and without att Modifier
	//winged beast w/ attitude
	//with and without att Modifier
	//winged beast with flying attitude
	//with and without att Modifier
	//bird flying insect with flying attitude
	//with and without att Modifier
	//swimming beast with swimming attitude
	//with and without att Modifier
	//beast on own
	//attitude on own
	// try one or 2 with plurals
	// try one or 2 with body parts
	// try one or 2 with rule of tincture
	
}
