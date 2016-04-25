package cps542project.ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class DataLoadiView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6591699920203752107L;

	/**
	 * Create the panel.
	 */
	public DataLoadiView() {
		setLayout(new BorderLayout(0, 0));
		loadUI();
	}
	
	private void loadUI(){
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel loadPanel = new DataPanel();
		tabbedPane.addTab("Load", null, loadPanel, null);
		
		JPanel resultPanel = new JPanel();
		tabbedPane.addTab("Result", null, resultPanel, null);
	}

}
