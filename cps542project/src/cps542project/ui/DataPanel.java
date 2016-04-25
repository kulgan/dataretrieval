package cps542project.ui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Insets;
import javax.swing.JLabel;

public class DataPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7642509036505526815L;
	private JLabel lblFileName;
	private JCheckBox chckbxHashtable;
	private JCheckBox chckbxTrie;
	private JCheckBox chckbxSuffixTree;
	private JCheckBox chckbxSuffixArray;

	/**
	 * Create the panel.
	 */
	public DataPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblFileName = new JLabel("File Name");
		GridBagConstraints gbc_lblFileName = new GridBagConstraints();
		gbc_lblFileName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileName.gridx = 0;
		gbc_lblFileName.gridy = 0;
		add(lblFileName, gbc_lblFileName);
		
		JButton btnLoadDocument = new JButton("Load Document");
		GridBagConstraints gbc_btnLoadDocument = new GridBagConstraints();
		gbc_btnLoadDocument.anchor = GridBagConstraints.EAST;
		gbc_btnLoadDocument.gridwidth = 3;
		gbc_btnLoadDocument.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoadDocument.gridx = 2;
		gbc_btnLoadDocument.gridy = 0;
		add(btnLoadDocument, gbc_btnLoadDocument);
		
		chckbxHashtable = new JCheckBox("Hashtable");
		GridBagConstraints gbc_chckbxHashtable = new GridBagConstraints();
		gbc_chckbxHashtable.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxHashtable.gridx = 1;
		gbc_chckbxHashtable.gridy = 1;
		add(chckbxHashtable, gbc_chckbxHashtable);
		
		chckbxTrie = new JCheckBox("Trie");
		GridBagConstraints gbc_chckbxTrie = new GridBagConstraints();
		gbc_chckbxTrie.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxTrie.gridx = 2;
		gbc_chckbxTrie.gridy = 1;
		add(chckbxTrie, gbc_chckbxTrie);
		
		chckbxSuffixTree = new JCheckBox("Suffix Tree");
		GridBagConstraints gbc_chckbxSuffixTree = new GridBagConstraints();
		gbc_chckbxSuffixTree.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSuffixTree.gridx = 3;
		gbc_chckbxSuffixTree.gridy = 1;
		add(chckbxSuffixTree, gbc_chckbxSuffixTree);
		
		chckbxSuffixArray = new JCheckBox("Suffix Array");
		GridBagConstraints gbc_chckbxSuffixArray = new GridBagConstraints();
		gbc_chckbxSuffixArray.gridx = 4;
		gbc_chckbxSuffixArray.gridy = 1;
		add(chckbxSuffixArray, gbc_chckbxSuffixArray);

	}

}
