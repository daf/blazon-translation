package blazon.server.charge.adding;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
    private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");

    private EMF() {}

    public static synchronized EntityManagerFactory getInstance() {
        return emfInstance;
    }
}
