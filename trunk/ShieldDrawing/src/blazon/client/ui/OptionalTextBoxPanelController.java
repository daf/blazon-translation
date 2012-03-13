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

public class OptionalTextBoxPanelController extends PanelController implements ChangeHandler {

	private static final long serialVersionUID = 6280297975033184062L;
	private ListBox listBox;
	private boolean optionalBoxAdded = false;
	private final List<LabelledTextBox> listBoxControlledTextBoxes;
	private final List<String> labelTexts;
	private final String labelCss;
	private final String textBoxCss;
	private final String panelCss;
	
	OptionalTextBoxPanelController(Panel panel, String labelCss, String textBoxCss, String panelCss) {
		super(panel);
		this.labelCss = labelCss;
		this.textBoxCss = textBoxCss;
		this.panelCss = panelCss;
		this.labelTexts = new ArrayList<String>();
		this.listBoxControlledTextBoxes = new ArrayList<LabelledTextBox>();
	}
	
	void addListBoxForAdditionalTextBoxesAndLabels(final String listBoxHeader, final String labelCssClass, final String listBoxCssClass, final String mainLabelText, final String ... optionalLabelTexts) {
		if (optionalBoxAdded) {
			return;
		}
		
		optionalBoxAdded = true;
		
		Panel listBoxPanel = new FlowPanel();
		listBoxPanel.setStyleName(panelCss);
		Label label = new Label(listBoxHeader);
		label.setStyleName(labelCssClass);
		listBoxPanel.add(label);
		
		this.labelTexts.add(mainLabelText);
		if (optionalLabelTexts != null) {
			for (String optLabelText : optionalLabelTexts) {
				this.labelTexts.add(optLabelText);
			}
		}
		this.listBox = new ListBox();
		for (Integer i = 0; i < 6; i++) {
			this.listBox.addItem(i.toString());
			for (String labelText : labelTexts) {
				LabelledTextBox ltb = new LabelledTextBox(labelText + " " + ((listBoxControlledTextBoxes.size()/labelTexts.size())+1), this.labelCss, this.textBoxCss, this.panelCss);
				listBoxControlledTextBoxes.add(ltb);
				ltb.setVisible(false);
				textBoxMap.put(labelText + " " + ((listBoxControlledTextBoxes.size()/labelTexts.size())+1), ltb);
				panel.add(ltb);
			}
		}
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
		for (int i = 0; i < number; i++) {
			listBoxControlledTextBoxes.get(i).setVisible(true);
		}
		for (int i = number; i < listBoxControlledTextBoxes.size(); i++) {
			listBoxControlledTextBoxes.get(i).setVisible(false);
		}
	}
	
	@Override
	void addLabelledTextBox(String labelText, String labelCssClass, String textBoxCssClass, String panelCssClass) {
		labelText = labelText.trim();
		LabelledTextBox ltb = new LabelledTextBox(labelText, labelCssClass, textBoxCssClass, panelCssClass);
		panel.add(ltb);
		textBoxMap.put(ltb.getLabelText().toLowerCase(), ltb);
	}

	@Override
	void addButtonToPanel(String buttonText, String buttonCssClass, ClickHandler clickHandler) {
		Button button = new Button(buttonText);
		button.setStyleName(buttonCssClass);
		panel.add(button);
        button.addClickHandler(clickHandler);		
	}
	
	@Override
	void addLabel(String labelText, String labelCss) {
		labelText = labelText.trim();
		Label label = new Label(labelText);
		label.setStyleName(labelCss);
		panel.add(label);
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