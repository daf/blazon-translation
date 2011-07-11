package blazon.shared.shield.tinctures;

public class Metal extends AbstractTincture {

	private static final long serialVersionUID = 6266304772402209638L;
	private String colour;
    
    static Tincture build(String name, String colour) {
    	if (name == null || name.isEmpty() || colour == null || colour.isEmpty()) {
    		throw new IllegalArgumentException("Metal can not be built with null or empty argument");
    	}
    	
    	Metal m = new Metal();
        m.name = name;
        m.colour = colour;
        return m;
    }
    
    @Override
    public String getFillText() {
        return colour;
    }

	@Override
	public String getName() {
		return name;
	}

}
