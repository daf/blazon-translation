package blazon.shared.shield.tinctures;

public abstract class TinctureImpl implements Tincture {

	private static final long serialVersionUID = -3533056694345483720L;

	protected String name;
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tincture : \n---------- ");
        sb.append(name);
        sb.append(":");
        sb.append(getColour());
        return sb.toString();
    }
	
	public abstract String getColour();
}
