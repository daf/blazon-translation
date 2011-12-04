package blazon.client.ui;

import java.util.HashMap;
import java.util.Map;

import blazon.client.chargeadding.ChargeAddingService;
import blazon.client.chargeadding.ChargeAddingServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;

class AddChargeButtonClickHandler implements ClickHandler {

	private final TextBox chargeTextBox;
	private final TextBox attituteTextBox;
	private final TextBox attitudeModifierTextBox;
	private final TextBox tinctureTextBox;
	private final Map<TextBox, TextBox> bodyParts;
	private final TextBox imageLocationTextBox;

	AddChargeButtonClickHandler(TextBox chargeTextBox, TextBox attituteTextBox, TextBox attitudeModifierTextBox,	TextBox tinctureTextBox, Map<TextBox, TextBox> bodyParts, TextBox imageLocationTextBox) {
		this.chargeTextBox = chargeTextBox;
		this.attituteTextBox = attituteTextBox;
		this.attitudeModifierTextBox = attitudeModifierTextBox;
		this.tinctureTextBox = tinctureTextBox;
		this.bodyParts = bodyParts;
		this.imageLocationTextBox = imageLocationTextBox;
	}

	@Override
	public void onClick(ClickEvent event) {
		String chargeName = chargeTextBox.getValue();
		String attitude = attituteTextBox.getValue();
		String attitudeModifier = attitudeModifierTextBox.getValue();
		String tincture = tinctureTextBox.getValue();
		String imageLocation = imageLocationTextBox.getValue();
		Map<String, String> bodyPartTexts = new HashMap<String, String>();
		for (Map.Entry<TextBox, TextBox> entry : bodyParts.entrySet()) {
			bodyPartTexts.put(entry.getKey().getValue(), entry.getValue().getValue());
		}
        final ChargeAddingServiceAsync service = GWT.create(ChargeAddingService.class);
        service.addChargeToDatastore(chargeName, attitude, attitudeModifier, tincture, bodyPartTexts, imageLocation, new AddChargeToDatastoreCallback<Void>());
	}

}
