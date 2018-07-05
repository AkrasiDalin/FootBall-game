package football_game.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fantasy extends JFrame {

	@SuppressWarnings("rawtypes")
	private JComboBox formationBox;
	private GridBagConstraints constraints;
	private FormationPanel formationPanel;

	/**
	 * A constructor for the Fantasy Frame.
	 */
	public Fantasy() {
		super("Fantasy Football");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(560, 700));
		setResizable(false);

		constraints = new GridBagConstraints();

		createWidgets();

		pack();
	}

	/**
	 * A method to add the widgets to the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void createWidgets() {

		formationBox = new JComboBox();

		formationBox.setPreferredSize(new Dimension(300, 25));
		formationBox.setModel(new DefaultComboBoxModel(new String[] { "Select formation","4-4-2", "4-3-3", "3-5-2", "5-3-2", "3-4-3", "4-5-1" }));
		formationBox.setOpaque(false);

		constraints.gridx = 0;
		constraints.gridy = 0;
		add(formationBox, constraints);

	}

	/**
	 * A method to add the formation panel to the view.
	 */
	public void addFormationToTheView() {
		constraints.gridy = 1;

		formationPanel = new FormationPanel();

		formationPanel.setOpaque(false);

		add(formationPanel, constraints);

		revalidate();
	}

	/**
	 * A reference to the controller with an ActionListener for the ComboBox inside the view.
	 * @param listenForComboBox
	 */
	public void changeFormation(ActionListener listenForComboBox) {

		formationBox.addActionListener(listenForComboBox);

	}

	/**
	 * Method to get the formation from the formationBox.
	 * @return a String that passes the formation String.
	 */
	public String getFormation() {
		return formationBox.getSelectedItem().toString();
	}

	/**
	 * Method to get the formation panel from this frame.
	 * @return A JPanel that represents the formation panel.
	 */
	public FormationPanel getFormationPanel() {
		return formationPanel;
	}

}
