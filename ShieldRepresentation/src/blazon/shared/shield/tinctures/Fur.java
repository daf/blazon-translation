package blazon.shared.shield.tinctures;

public class Fur extends TinctureImpl {

	private static final long serialVersionUID = -7358652991886352207L;

	public static Fur Build(String name) {
        Fur f = new Fur();
        f.name = name;
        return f;
    }

    @Override
    public String getColour() {
        return "none";
    }

	@Override
	public String getName() {
		return name;
	}

}
