package blazon.shared.shield.tinctures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import blazon.shared.numberconversion.NumberConversionException;
import blazon.shared.numberconversion.NumberToOrdinalConverter;

public class Tinctures implements Serializable {
	
	private static final long serialVersionUID = 7967425832023439242L;
	private static final Map<String, Tincture> tinctureDefinitions;
    static {
        Map<String, Tincture> map = new HashMap<String, Tincture>();
        // add metals
        map.put("or", Metal.build("or", "gold"));
        map.put("argent", Metal.build("argent", "silver"));
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
        map.put("ermine", Fur.build("ermine", "silver", "black"));
        map.put("ermines", Fur.build("ermines", "black", "silver"));
        map.put("erminois", Fur.build("erminois", "yellow", "black"));
        map.put("pean", Fur.build("pean", "black", "yellow"));
        // make map unmodifiable.
        tinctureDefinitions = Collections.unmodifiableMap(map);
    }

    private static Map<String, Tincture> tincturesInUse = new HashMap<String, Tincture>();
    private List<Tincture> tincturesOnLayer = new ArrayList<Tincture>();

    public Tincture createTincture(String name) {
        Tincture tincture = tinctureDefinitions.get(name);
        if (tincture == null) {
            // TODO not found tincture - shouldn't have due to token matching.
        }
        return tincture;
    }

    public boolean addTincture(Tincture t) {
        String position;
        try {
            NumberToOrdinalConverter positionFinder = new NumberToOrdinalConverter();
            position = positionFinder.convert(tincturesInUse.size() + 1);
        } catch (NumberConversionException e) {
            // TODO add logging
            return false;
        }
        if (!tincturesInUse.containsKey(position)) {
            tincturesInUse.put(position, t);
            boolean addedToTincturesOnLayerList = tincturesOnLayer.add(t);
            return addedToTincturesOnLayerList;
        }
        return false;
    }

    public Iterator<Tincture> getTincturesOnLayerIterator() {
        return tincturesOnLayer.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tinctures : \n");
        for (Tincture tincture : tincturesOnLayer) {
            sb.append("-------- ").append(tincture);
        }
        return sb.toString();
    }
}