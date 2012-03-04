package blazon.client.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import blazon.client.ui.widget.LabelledTextBox;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class OptionalTextBoxPanelController extends PanelController implements ChangeHandler {

	private static final long serialVersionUID = 6280297975033184062L;
	private ListBox listBox;
	private List<LabelledTextBox> listBoxControlledTextBoxes;
	private List<String> labelTexts;
	private String labelCss;
	private String textBoxCss;
	private String panelCss;
	private boolean optionalBoxAdded = false;
	private List<Widget> itemsAfterListBox = new ArrayList<Widget>();
	
	OptionalTextBoxPanelController(Panel panel, String labelCss, String textBoxCss, String panelCss) {
		super(panel);
		this.labelCss = labelCss;
		this.textBoxCss = textBoxCss;
		this.panelCss = panelCss;
		this.labelTexts = new ArrayList<String>();
		this.listBoxControlledTextBoxes = new ArrayList<LabelledTextBox>();
	}
	
	void addListBoxForAdditionalTextBoxesAndLabels(final String listBoxHeader, final String labelCssClass, final String listBoxCssClass, final String labelText, final String ... optionalLabelTexts) {
		if (optionalBoxAdded) {
			return;
		}
		
		optionalBoxAdded = true;
		
		Panel listBoxPanel = new FlowPanel();
		listBoxPanel.setStyleName(panelCss);
		Label label = new Label(listBoxHeader);
		label.setStyleName(labelCssClass);
		listBoxPanel.add(label);
		
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
		this.listBox.setStyleName(listBoxCssClass);
		listBoxPanel.add(listBox);
		this.panel.add(listBoxPanel);
	}

	@Override
	public void onChange(ChangeEvent event) {
		String value = listBox.getValue(listBox.getSelectedIndex());
		int number = Integer.parseInt(value) * labelTexts.size();
		for (Widget w : itemsAfterListBox) {
			panel.remove(w);
		}
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
		for (Widget w : itemsAfterListBox) {
			panel.add(w);
		}
	}

	private void addOptionalLabelledTextBox(String labelText) {
		LabelledTextBox ltb = new LabelledTextBox(labelText + " " + ((listBoxControlledTextBoxes.size()/labelTexts.size())+1), this.labelCss, this.textBoxCss, this.panelCss);
		listBoxControlledTextBoxes.add(ltb);
		panel.add(ltb);
	}

	private void removeOptionalLabelledTextBox() {
		LabelledTextBox textBox = listBoxControlledTextBoxes.remove(listBoxControlledTextBoxes.size() - 1);
		panel.remove(textBox);
	}
	
	@Override
	void addLabelledTextBox(String labelText, String labelCssClass, String textBoxCssClass, String panelCssClass) {
		labelText = labelText.trim();
		LabelledTextBox ltb = new LabelledTextBox(labelText, labelCssClass, textBoxCssClass, panelCssClass);
		panel.add(ltb);
		textBoxMap.put(ltb.getLabelText().toLowerCase(), ltb);
		if (optionalBoxAdded) {
			itemsAfterListBox.add(ltb);
		}
	}

	@Override
	void addButtonToPanel(String buttonText, String buttonCssClass, ClickHandler clickHandler) {
		Button button = new Button(buttonText);
		button.setStyleName(buttonCssClass);
		panel.add(button);
        button.addClickHandler(clickHandler);		
		if (optionalBoxAdded) {
			itemsAfterListBox.add(button);
		}
	}
	
	@Override
	void addLabel(String labelText, String labelCss) {
		labelText = labelText.trim();
		Label label = new Label(labelText);
		label.setStyleName(labelCss);
		panel.add(label);
		if (optionalBoxAdded) {
			itemsAfterListBox.add(label);
		}
	}
	
	int getNumberOfLabels() {
		return labelTexts.size();
	}

	SortedSet<String> createSetOfBodyPartToTincture() {
		return createSetOfBodyPartToTincture(null);
	}
	
	SortedSet<String> createSetOfBodyPartToTincture(StringBuilder sb) {
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