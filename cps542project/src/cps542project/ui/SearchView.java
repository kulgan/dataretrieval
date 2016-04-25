package cps542project.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class SearchView extends JPanel {

	/**
	 * Create the panel.
	 */
	public SearchView() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel searchPanel = new JPanel();
		tabbedPane.addTab("Search", null, searchPanel, null);
		
		JPanel analysisPanel = new JPanel();
		tabbedPane.addTab("Analysis", null, analysisPanel, null);

	}

}
