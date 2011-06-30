package blazon.shared.shield.tinctures;

public class Metal extends TinctureImpl {

	private static final long serialVersionUID = 6266304772402209638L;
	private String colour;
    
    public static TinctureImpl Build(String name, String colour) {
        Metal m = new Metal();
        m.name = name;
        m.colour = colour;
        return m;
    }
    
    @Override
    public String getColour() {
        return colour;
    }

	@Override
	public String getName() {
		return name;
	}

}
