package mod2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	//Window Control Objects
	private JFrame frame;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField recordNumTextField;
	
	//Database Control Objects
	private DatabaseManager database = new DatabaseManager();
	private String name;
	private String address;
	private String record;

	/**
	 * Main Statement for editing within Eclipse Compiler
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(28, 65, 45, 13);
		frame.getContentPane().add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(83, 62, 96, 19);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(189, 65, 61, 13);
		frame.getContentPane().add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(262, 62, 96, 19);
		frame.getContentPane().add(addressTextField);
		addressTextField.setColumns(10);
		
		JTextArea outputTextArea = new JTextArea();
		outputTextArea.setBounds(33, 178, 410, 226);
		frame.getContentPane().add(outputTextArea);
		
		JButton addRecordButton = new JButton("Add Record");
		addRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = nameTextField.getText();
				address = addressTextField.getText();
				database.insert(name, address);
				outputTextArea.setText(database.printTable());
				nameTextField.setText("");
				addressTextField.setText("");
			}
		});
		
		addRecordButton.setBounds(373, 61, 103, 21);
		frame.getContentPane().add(addRecordButton);
		
		JButton deleteRecordButton = new JButton("Delete Record");
		deleteRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				record = recordNumTextField.getText();
				database.deleteFromTable(record);
				outputTextArea.setText(database.printTable());
				recordNumTextField.setText("");
			}
		});
		deleteRecordButton.setBounds(189, 147, 135, 21);
		frame.getContentPane().add(deleteRecordButton);
		
		recordNumTextField = new JTextField();
		recordNumTextField.setBounds(83, 148, 96, 19);
		frame.getContentPane().add(recordNumTextField);
		recordNumTextField.setColumns(10);
		
		JLabel recordNumLabel = new JLabel("Name");
		recordNumLabel.setBounds(28, 151, 45, 13);
		frame.getContentPane().add(recordNumLabel);
		
		JLabel addRecordDesc = new JLabel("Add a New Record:");
		addRecordDesc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addRecordDesc.setBounds(28, 10, 330, 45);
		frame.getContentPane().add(addRecordDesc);
		
		JLabel deleteRecordDesc = new JLabel("Delete an Existing Record:");
		deleteRecordDesc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		deleteRecordDesc.setBounds(28, 88, 392, 50);
		frame.getContentPane().add(deleteRecordDesc);
		

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	}

