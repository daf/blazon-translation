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
        map.put("or", Metal.Build("or", "gold"));
        map.put("argent", Metal.Build("argent", "silver"));
        // add colours
        map.put("gules", Colour.Build("gules", "red"));
        map.put("azure", Colour.Build("azure", "blue"));
        map.put("sable", Colour.Build("sable", "black"));
        map.put("vert", Colour.Build("vert", "green"));
        map.put("purpure", Colour.Build("purpure", "purple"));
        // add fur
        map.put("vair", Fur.Build("vair"));
        map.put("counter-vair", Fur.Build("counter-vair"));
        map.put("vair-en-point", Fur.Build("vair-en-point"));
        map.put("vair-en-pall", Fur.Build("vair-en-pall"));
        map.put("potent", Fur.Build("potent"));
        map.put("counter-potent", Fur.Build("counter-potent"));
        map.put("potent-en-point", Fur.Build("potent-en-point"));
        map.put("potent-en-pall", Fur.Build("potent-en-pall"));
        map.put("ermine", Fur.Build("ermine"));
        map.put("ermines", Fur.Build("ermines"));
        map.put("erminois", Fur.Build("erminois"));
        map.put("pean", Fur.Build("pean"));
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