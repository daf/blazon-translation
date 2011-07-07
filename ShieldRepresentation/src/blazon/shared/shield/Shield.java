package blazon.shared.shield;

import java.io.Serializable;

public class Shield implements Serializable {

	private static final long serialVersionUID = 4665249893045885094L;
	private ShieldLayer base;

    public static Shield build(ShieldLayer base) {
    	Shield shield = new Shield();
    	shield.base = base;
    	return shield;
    }
    
    public ShieldLayer getField() {
        return base;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shield :\n-- ");
        sb.append(base);
        return sb.toString();
    }
    
}

