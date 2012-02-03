package blazon.server.charge.adding;

import javax.persistence.EntityManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import blazon.client.charge.adding.ChargeAddingService;
import blazon.client.ui.OptionalTextBoxPanelController;
import blazon.server.PersistedCharge;

public class ChargeAddingServiceImpl extends RemoteServiceServlet implements ChargeAddingService {

	private static final long serialVersionUID = -8716005130771464895L;

	@Override
	public void addChargeToDatastore(OptionalTextBoxPanelController panelController) {
		PersistedCharge charge = new PersistedCharge(
				panelController.getTextFromTextBox("charge"),
				panelController.getTextFromTextBox("attitude"),
				panelController.getTextFromTextBox("attitude modifier"),
				panelController.getTextFromTextBox("tincture"),
				panelController.getOptionalLabelledTextBoxes(),
				panelController.getNumberOfLabels(),
				panelController.getTextFromTextBox("image location"));
		EntityManager entityManager = EMF.getInstance().createEntityManager();
		entityManager.persist(charge);
		entityManager.close();
	}
}
