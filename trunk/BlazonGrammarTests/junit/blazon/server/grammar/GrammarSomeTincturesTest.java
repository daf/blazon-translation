package blazon.server.grammar;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import org.antlr.runtime.NoViableAltException;
import blazon.shared.shield.ShieldDivision;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.tinctures.Tinctures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GrammarSomeTincturesTest {
	
	@Test(expected=MismatchedTokenException.class)
	public void testThatBendWithOrIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("bend");
		parser.some_tinctures(tinctures, sdt);
	}
	
	@Test
	public void testThatBendWithPurpureAndSableGivesALayerWithTheCorrectTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("purpure and sable");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("bend");
		ShieldLayer layer = parser.some_tinctures(tinctures, sdt);
		assertThat(layer.getTinctures(), is(equalTo(tinctures)));
	}
	
	@Test(expected=MismatchedTokenException.class)
	public void testThatBendWithOrSableIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or sable");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("bend");
		parser.some_tinctures(tinctures, sdt);
	}
	
	@Test(expected=MyRecognitionException.class)
	public void testThatBendWithOrSableAndGulesIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or sable and gules");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("bend");
		parser.some_tinctures(tinctures, sdt);
	}
	
	@Test(expected=MismatchedTokenException.class)
	public void testThatPaleWithOrIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("pale");
		parser.some_tinctures(tinctures, sdt);
	}
	
	@Test
	public void testThatPaleWithErmineAndErminoisGivesALayerWithTheCorrectTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("ermine and erminois");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("pale");
		ShieldLayer layer = parser.some_tinctures(tinctures, sdt);
		assertThat(layer.getTinctures(), is(equalTo(tinctures)));
	}
	
	@Test(expected=MismatchedTokenException.class)
	public void testThatPaleWithOrSableIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or sable");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("pale");
		parser.some_tinctures(tinctures, sdt);
	}
	
	@Test(expected=MyRecognitionException.class)
	public void testThatPaleWithOrSableAndGulesIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or sable and gules");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("pale");
		parser.some_tinctures(tinctures, sdt);
	}
	
	
	@Test(expected=MismatchedTokenException.class)
	public void testThatPallWithOrIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("pall");
		parser.some_tinctures(tinctures, sdt);
	}
	
	@Test(expected=MyRecognitionException.class)
	public void testThatPallWithOrAndSableIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or and sable");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("pall");
		parser.some_tinctures(tinctures, sdt);
	}
	
	@Test
	public void testThatPallWithErminesPeanAndPotentGivesALayerWithTheCorrectTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("ermines pean and potent");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("pall");
		parser.some_tinctures(tinctures, sdt);
	}
	
	@Test(expected=MyRecognitionException.class)
	public void testThatPallWithOrSableGulesAndArgentIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or sable gules and argent");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("pall");
		parser.some_tinctures(tinctures, sdt);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatGulesAndIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gules and");
		Tinctures tinctures = new Tinctures();
		ShieldDivisionType sdt = new ShieldDivision().getDivisionType("bend");
		parser.some_tinctures(tinctures, sdt);
	}
}
