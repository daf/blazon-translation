package blazon.shared.shield.tinctures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blazon.shared.shield.Field;

/**
 * Represents a collection of tinctures to be placed on a
 * layer of the shield.
 * @author Luke Torjussen
 *
 */
public class Tinctures implements Serializable {

	private static final long serialVersionUID = 7967425832023439242L;
	/**
	 * A map of know tinctures which is syncronized and unmodifiable.
	 */
	private static final Map<String, Tincture> tinctureDefinitions;
	static {
		Map<String, Tincture> map = new HashMap<String, Tincture>();
		// add metals
		map.put("or", Metal.build("or", "gold"));
		map.put("argent", Metal.build("argent", "white"));
		// add colours
		map.put("gules", Colour.build("gules", "red"));
		map.put("azure", Colour.build("azure", "blue"));
		map.put("sable", Colour.build("sable", "black"));
		map.put("vert", Colour.build("vert", "green"));
		map.put("purpure", Colour.build("purpure", "purple"));
		// add fur
		map.put("vair", Fur.build("vair", "blue", "white"));
		map.put("counter-vair", Fur.build("counter-vair", "blue", "white"));
		map.put("vair-en-point", Fur.build("vair-en-point", "blue", "white"));
		map.put("vair-en-pale", Fur.build("vair-en-pale", "blue", "white"));
		map.put("potent", Fur.build("potent", "blue", "white"));
		map.put("counter-potent", Fur.build("counter-potent", "blue", "white"));
		map.put("potent-en-point", Fur.build("potent-en-point", "blue", "white"));
		map.put("potent-en-pale", Fur.build("potent-en-pale", "blue", "white"));
		map.put("ermine", Fur.build("ermine", "white", "black"));
		map.put("ermines", Fur.build("ermines", "black", "white"));
		map.put("erminois", Fur.build("erminois", "yellow", "black"));
		map.put("pean", Fur.build("pean", "black", "yellow"));
		map.put("proper", Proper.build());
		// make map unmodifiable.
		tinctureDefinitions = Collections.unmodifiableMap(map);
	}

	/**
	 * A list of tinctures that are on this layer.
	 */
	private List<Tincture> tincturesOnLayer = new ArrayList<Tincture>();

	/**
	 * Get a Tincture object that has a name that matches the given string.
	 * @param name The name of the Tincture object you want to be returned.
	 * @return A Tincture object with the name matching the given string.
	 * @throws UnknownTinctureException thrown if the name given is not a 
	 * recognised tincture.
	 */
	public Tincture getTincture(String name) throws UnknownTinctureException {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Can not get Tincture with null or empty name");
		}
		Tincture tincture = tinctureDefinitions.get(name);
		if (tincture == null) {
			throw new UnknownTinctureException("Could not get tincture with name '" + name + "'");
		}
		return tincture;
	}

	/**
	 * Add a tincture to the current Tinctures object (used on a ShieldLayer)
	 * @param t The tincture that you want to add to this Tinctures object.
	 * @return true if the Tincture was successfully added; false otherwise.
	 * @see Field
	 */
	public boolean addTincture(Tincture t) {
		if (t == null) {
			return false;
		}
		boolean addedToTincturesOnLayerList = tincturesOnLayer.add(t);
		return addedToTincturesOnLayerList;
	}

	/**
	 * Get the collection of tinctures that this Tinctures
	 * object contains (the tinctures on this layer)
	 * @return A collection of tinctures that have been added
	 * to this via the addTincture method.
	 */
	public Collection<Tincture> getTincturesOnLayer() {
		return Collections.unmodifiableCollection(tincturesOnLayer);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Tinctures{tincturesOnLayer=");
		return sb.append(tincturesOnLayer).append("}").toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Tinctures)) {
			return false;
		}
		Tinctures other = (Tinctures)obj;
		return tincturesOnLayer.equals(other.tincturesOnLayer);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + tincturesOnLayer.hashCode();
		return result;
	}
}