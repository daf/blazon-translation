package blazon.shared.shield.tinctures;

public abstract class TinctureImpl implements Tincture {

	private static final long serialVersionUID = -3533056694345483720L;

	protected String name;
	protected String colour1;
	protected String colour2;
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tincture : \n---------- ");
        sb.append(name);
        sb.append(":");
        sb.append(getPatternReference());
        return sb.toString();
    }
}
