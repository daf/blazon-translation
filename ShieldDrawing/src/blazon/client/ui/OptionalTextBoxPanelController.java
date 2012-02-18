package blazon.client.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import blazon.client.ui.widget.LabelledTextBox;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;

public class OptionalTextBoxPanelController extends PanelController implements ChangeHandler {

	private static final long serialVersionUID = 6280297975033184062L;
	private ListBox listBox;
	private List<LabelledTextBox> listBoxControlledTextBoxes;
	private List<String> labelTexts;

	OptionalTextBoxPanelController() {}
	
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
		LabelledTextBox ltb = new LabelledTextBox(labelText + " " + listBoxControlledTextBoxes.size()/labelTexts.size());
		listBoxControlledTextBoxes.add(ltb);
		panel.add(ltb);
	}

	private void removeOptionalLabelledTextBox() {
		LabelledTextBox textBox = listBoxControlledTextBoxes.remove(listBoxControlledTextBoxes.size() - 1);
		panel.remove(textBox);
	}
	
	public int getNumberOfLabels() {
		return labelTexts.size();
	}

	public SortedSet<String> createSetOfBodyPartToTincture() {
		return createSetOfBodyPartToTincture(null);
	}
	
	public SortedSet<String> createSetOfBodyPartToTincture(StringBuilder sb) {
		SortedSet<String> bodyPartsSet = new TreeSet<String>();
		if (listBoxControlledTextBoxes != null) {
			for (int i = 0; i < listBoxControlledTextBoxes.size(); i += 2) {
				LabelledTextBox bodyPart = listBoxControlledTextBoxes.get(i);
				LabelledTextBox bodyPartTincture = listBoxControlledTextBoxes.get(i + 1);
				String bodyPartText = bodyPart.getEnteredText();
				String bodyPartTinctureText = bodyPartTincture.getEnteredText();
				bodyPartsSet.add(bodyPartText + ":" + bodyPartTinctureText);
				if (sb != null) {
					sb.append(bodyPartText).append(" ").append(bodyPartTinctureText);
				}
			}
		}
		return bodyPartsSet;
	}
}