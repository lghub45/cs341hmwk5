package tester;
import cs341hwmk5.NumberList;

//To run the GUI run this class


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JButton;
import tester.fileChooser;
import javax.swing.JTextArea;

public class NumWindow {

	private JFrame frame;
	private JFileChooser fileCHooser;
	private JButton chooseButton;
	private File file;
	private JButton readBtn;
	private JTextArea listArea;
	private JScrollPane scroll;
	static JLabel l; //helps when selecting the .txt file 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumWindow window = new NumWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NumWindow() {
		initialize();
		chooseBtnClick();
		readClick();
	}
	
	//listens for clicking of Choose File button
			private void chooseBtnClick(){
				chooseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chooseFile();
				}
				});
			}
	//listens for clicking of Read File Button
			//listens for clicking of make a list button
			private void readClick(){
				readBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				readFile();
				}
				});
				}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Insert a .txt file ");
		lblNewLabel.setBounds(10, 10, 203, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("and we'll give you the mean and standard deviation of the numbers inside");
		lblNewLabel_1.setBounds(10, 22, 572, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		//choose file button
		chooseButton = new JButton("Choose File");
		chooseButton.setBounds(10, 40, 148, 21);
		frame.getContentPane().add(chooseButton);
		
		listArea = new JTextArea();
		listArea.setBounds(34, 71, 286, 89);
		frame.getContentPane().add(listArea);
		
		
		
		readBtn = new JButton("Read File");
		readBtn.setBounds(172, 40, 148, 21);
		frame.getContentPane().add(readBtn);
		
		//lets us scroll if the list gets too long
		scroll = new JScrollPane(listArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(34, 71, 286, 89);
		frame.getContentPane().add(scroll);
	    frame.setVisible(true);
		
	}
	
	private void chooseFile() {
		   JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		    fc.addChoosableFileFilter(filter);
		    fc.setAcceptAllFileFilterUsed(false);
		    fc.setDialogTitle("Select a .txt file");

		    int result = fc.showOpenDialog(frame);
		    if (result == JFileChooser.APPROVE_OPTION) {
		        file = fc.getSelectedFile();
		        listArea.setText("Selected File: " + file.getName());
		    } else {
		        listArea.setText("No file selected.");
		    }
	}
	
	private void readFile() {
		Scanner scan;
		NumberList nums=new NumberList(); //this is going to go in the text area
		try {//use scanner to read the file
			scan = new Scanner(file);
			while (scan.hasNextLine()) {
				nums.addToList(scan.nextLine()); //add our list to the output string
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			listArea.setText(" File not found");
		}
		listArea.setText(nums.printList()+"\n Mean: "+nums.meanMaker()+
				"\n Standard Deviation: "+nums.stnDev(nums.meanMaker())); // set the text in the listarea to our output string
		
	}
}
