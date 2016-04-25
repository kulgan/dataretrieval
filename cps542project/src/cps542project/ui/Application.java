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
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Application extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 5113941610642069888L;
	private JPanel contentPane;
	private JTextField txtFilename;
	private JLabel lblCpsProjec;
	private JButton btnSelect;
	private JButton btnLoad;
	private JPanel main;
	private JPanel leftBar;

	private String lastDirectoryPath;
	private File selectSource;

	private TableDataStore ds;
	private JButton btnAddDocument;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		loadUI();
		addListeners();
	}

	private void loadUI(){
		main = new JPanel();
		contentPane.add(main, BorderLayout.CENTER);
		GridBagLayout gbl_main = new GridBagLayout();
		gbl_main.columnWidths = new int[]{560, 0, 0, 0};
		gbl_main.rowHeights = new int[]{40, 34, 0};
		gbl_main.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_main.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		main.setLayout(gbl_main);

		lblCpsProjec = new JLabel("CPS 542 Projec");
		GridBagConstraints gbc_lblCpsProjec = new GridBagConstraints();
		gbc_lblCpsProjec.fill = GridBagConstraints.VERTICAL;
		gbc_lblCpsProjec.gridwidth = 3;
		gbc_lblCpsProjec.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpsProjec.gridx = 0;
		gbc_lblCpsProjec.gridy = 0;
		main.add(lblCpsProjec, gbc_lblCpsProjec);

		txtFilename = new JTextField();
		txtFilename.setText("filename");
		GridBagConstraints gbc_txtFilename = new GridBagConstraints();
		gbc_txtFilename.insets = new Insets(0, 0, 0, 5);
		gbc_txtFilename.fill = GridBagConstraints.BOTH;
		gbc_txtFilename.gridx = 0;
		gbc_txtFilename.gridy = 1;
		main.add(txtFilename, gbc_txtFilename);
		txtFilename.setColumns(10);

		btnSelect = new JButton("Select");
		btnSelect.setActionCommand("SelectFile");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.BOTH;
		gbc_btnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelect.gridx = 1;
		gbc_btnSelect.gridy = 1;
		main.add(btnSelect, gbc_btnSelect);

		btnLoad = new JButton("Load");
		btnLoad.setActionCommand("LoadFile");
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.fill = GridBagConstraints.BOTH;
		gbc_btnLoad.gridx = 2;
		gbc_btnLoad.gridy = 1;
		main.add(btnLoad, gbc_btnLoad);

		leftBar = new JPanel();
		contentPane.add(leftBar, BorderLayout.EAST);

		btnAddDocument = new JButton("Add Document");
		leftBar.add(btnAddDocument);
	}

	private void addListeners(){
		ds = TableDataStore.getInstance();
		if(lastDirectoryPath == null){
			lastDirectoryPath = System.getProperty("user.dir");
		}
		Listener listener = new Listener();
		btnSelect.addActionListener(listener);
		btnLoad.addActionListener(listener);
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
