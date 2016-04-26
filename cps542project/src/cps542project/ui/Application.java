package cps542project.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cps542project.reader.TextReader;
import cps542project.store.TableDataStore;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.CardLayout;

public class Application extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 5113941610642069888L;
	private JPanel contentPane;
	private JTextField txtFilename;
	private JButton btnSelect;
	private JButton btnLoad;
	private JPanel main;

	private String lastDirectoryPath;
	private File selectSource;

	private TableDataStore ds;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmDocuments;
	private JMenuItem mntmSearch;
	private JMenu mnHelp;
	private JMenuItem mntmExit;
	private JPanel titlePanel;
	private JLabel demoTitle;
	private JButton btnDocuments;
	private JButton btnQuery;

	private CardLayout layout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setTitle("CPS 542 Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 501);

		layout = new CardLayout(0, 0);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmDocuments = new JMenuItem("Documents");
		mnFile.add(mntmDocuments);

		mntmSearch = new JMenuItem("Search");
		mnFile.add(mntmSearch);

		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		loadUI();
		addListeners();
	}

	private void loadUI(){

		titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		contentPane.add(titlePanel, BorderLayout.NORTH);
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[]{0, 100, 100, 0};
		gbl_titlePanel.rowHeights = new int[]{50, 0};
		gbl_titlePanel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_titlePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		titlePanel.setLayout(gbl_titlePanel);

		demoTitle = new JLabel("CPS 542 Project: Term Weighing Demo");
		demoTitle.setBackground(Color.WHITE);
		GridBagConstraints gbc_demoTitle = new GridBagConstraints();
		gbc_demoTitle.insets = new Insets(0, 0, 0, 5);
		gbc_demoTitle.fill = GridBagConstraints.BOTH;
		gbc_demoTitle.gridx = 0;
		gbc_demoTitle.gridy = 0;
		titlePanel.add(demoTitle, gbc_demoTitle);

		btnDocuments = new JButton("Documents");
		btnDocuments.setActionCommand("DataLoadView");
		GridBagConstraints gbc_btnDocuments = new GridBagConstraints();
		gbc_btnDocuments.fill = GridBagConstraints.BOTH;
		gbc_btnDocuments.insets = new Insets(0, 0, 0, 5);
		gbc_btnDocuments.gridx = 1;
		gbc_btnDocuments.gridy = 0;
		titlePanel.add(btnDocuments, gbc_btnDocuments);

		btnQuery = new JButton("Query");
		btnQuery.setActionCommand("SearchView");
		GridBagConstraints gbc_btnQuery = new GridBagConstraints();
		gbc_btnQuery.fill = GridBagConstraints.BOTH;
		gbc_btnQuery.gridx = 2;
		gbc_btnQuery.gridy = 0;
		titlePanel.add(btnQuery, gbc_btnQuery);
		main = new JPanel();
		contentPane.add(main, BorderLayout.CENTER);
		main.setLayout(layout);
		addViews();

		txtFilename = new JTextField();
		txtFilename.setText("filename");
		txtFilename.setColumns(10);

		btnSelect = new JButton("Select");
		btnSelect.setActionCommand("SelectFile");

		btnLoad = new JButton("Load");
		btnLoad.setActionCommand("LoadFile");
		layout.show(main, "data-view");
	}

	private void addViews(){
		DataLoadiView dv = new DataLoadiView();
		main.add(dv, "data-view");
		SearchView sv = new SearchView();
		main.add(sv, "search-view");
	}

	private void addListeners(){
		ds = TableDataStore.getInstance();
		if(lastDirectoryPath == null){
			lastDirectoryPath = System.getProperty("user.dir");
		}
		Listener listener = new Listener();
		btnSelect.addActionListener(listener);
		btnLoad.addActionListener(listener);

		btnQuery.addActionListener(listener);
		btnDocuments.addActionListener(listener);
	}

	class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			switch (cmd) {
			case "SelectFile":
				chooseFile();
				break;

			case "LoadFile":
				loadFile();
				break;
			case "DataLoadView":
				layout.show(main, "data-view");
				break;
			case "SearchView":
				layout.show(main, "search-view");
				break;
			default:
				break;
			}

		}

		protected void chooseFile(){
			JFileChooser chooser = new JFileChooser(lastDirectoryPath);
			int selected = chooser.showOpenDialog(Application.this);
			if(selected == JFileChooser.APPROVE_OPTION){
				selectSource = chooser.getSelectedFile();
				lastDirectoryPath = selectSource.getParentFile().getAbsolutePath();
			}
		}

		protected void loadFile(){
			System.out.println("Loadinf");
			TextReader reader = new TextReader();
			try {
				reader.read(selectSource);
				String word = reader.next();
				long tm = Runtime.getRuntime().totalMemory();
				System.out.println(tm);
				while(word != null){
					ds.store(selectSource.getName(), word);
					word = reader.next();
				}
				long free = Runtime.getRuntime().freeMemory();
				System.out.println(tm - free);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
