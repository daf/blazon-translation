package blazon.shared.shield.tinctures;

import java.io.Serializable;


/**
 * An representation of a Tincture on the shield;
 * this could be a Colour, Metal or Fur.
 * @author Luke Torjussen
 * @see AbstractTincture, Colour, Metal, Fur
 */
public interface Tincture extends Serializable {
		
	/**
	 * Gets the fill text from the current Tincture.
	 * The fill text is put in the "fill" property of
	 * an SVG element to set the colour of the element 
	 * to the colour held in the Tincture description.
	 * For example, this may be a name of a Colour.
	 * @return a String containing the fill text of
	 * the Tincture.
	 */
	String getFillText();

	/**
	 * Gets the name from the current Tincture.
	 * The name is the String used to uniquely
	 * identify the Tincture.
	 * @return a String containing the unique identifier
	 * of the Tincture.
	 */
	String getName();
	
	TinctureType getTinctureType();
}
