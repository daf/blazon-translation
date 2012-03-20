package blazon.shared.shield.tinctures;

public class Proper extends AbstractTincture {

	private static final long serialVersionUID = -6662404459781501132L;

	private static final Proper instance = new Proper();
	
	private static final String PROPER = "proper";
	
	private Proper() { 
		this.name = PROPER; 
	}
	
	@Override
	public String getFillText() {
		return PROPER;
	}

	@Override
	public String getName() {
		return PROPER;
	}

	@Override
	public TinctureType getTinctureType() {
		return TinctureType.OTHER;
	}

	public static Tincture build() {
		return instance;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Proper;
	}
}
