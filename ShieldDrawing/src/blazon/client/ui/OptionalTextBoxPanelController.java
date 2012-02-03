package blazon.client.ui;

import java.util.ArrayList;
import java.util.List;

import blazon.client.ui.widget.LabelledTextBox;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;

public class OptionalTextBoxPanelController extends PanelController implements ChangeHandler {
	private ListBox listBox;
	private List<LabelledTextBox> listBoxControlledTextBoxes;
	private List<String> labelTexts;

	OptionalTextBoxPanelController(Panel panel) {
		super(panel);
		this.labelTexts = new ArrayList<String>();
		this.listBoxControlledTextBoxes = new ArrayList<LabelledTextBox>();
	}
	
	void addListBoxForAdditionalTextBoxesAndLabels(final String labelText, final String ... optionalLabelTexts) {
		if (this.listBox != null) {
			return;
		}
		
		this.labelTexts.add(labelText);
		if (optionalLabelTexts != null) {
			for (String optLabelText : optionalLabelTexts) {
				this.labelTexts.add(optLabelText);
			}
		}
		this.listBox = new ListBox();
		this.listBox.addItem("0");
		this.listBox.addItem("1");
		this.listBox.addItem("2");
		this.listBox.addItem("3");
		this.listBox.addItem("4");
		this.listBox.addItem("5");
		this.listBox.setVisibleItemCount(1);
		this.listBox.addChangeHandler(this);
		this.panel.add(listBox);
	}

	@Override
	public void onChange(ChangeEvent event) {
		String value = listBox.getValue(listBox.getSelectedIndex());
		int number = Integer.parseInt(value) * labelTexts.size();
		while (number < listBoxControlledTextBoxes.size()) {
			for (int i = 0; i < labelTexts.size(); i++) {
				removeOptionalLabelledTextBox();
			}
		}
		while (number > listBoxControlledTextBoxes.size()) {
			for (int i = 0; i < labelTexts.size(); i++) {
				addOptionalLabelledTextBox(labelTexts.get(i));
			}
		}
	}

	private void addOptionalLabelledTextBox(String labelText) {
		LabelledTextBox ltb = new LabelledTextBox(labelText + " " + listBoxControlledTextBoxes.size());
		listBoxControlledTextBoxes.add(ltb);
		panel.add(ltb);
	}

	private void removeOptionalLabelledTextBox() {
		LabelledTextBox textBox = listBoxControlledTextBoxes.remove(listBoxControlledTextBoxes.size() - 1);
		panel.remove(textBox);
	}
	
	public List<LabelledTextBox> getOptionalLabelledTextBoxes() {
		return listBoxControlledTextBoxes;
	}
	
	public int getNumberOfLabels() {
		return labelTexts.size();
	}
}