package swingf2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;



public class swingf2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField mobileField;
	private JTextField addressField;
	private DefaultListModel<String> outputListModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingf2 frame = new swingf2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public swingf2() {
		setTitle("RegistrationForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(156, 21, 195, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(52, 60, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		nameField = new JTextField();
		nameField.setBounds(118, 59, 254, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(52, 100, 57, 14);
		contentPane.add(lblNewLabel_2);
		
		mobileField = new JTextField();
		mobileField.setBounds(118, 99, 254, 20);
		contentPane.add(mobileField);
		mobileField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(52, 138, 51, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		maleRadioButton.setBounds(118, 135, 109, 23);
		contentPane.add(maleRadioButton);
		
		JRadioButton femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		femaleRadioButton.setBounds(238, 135, 109, 23);
		contentPane.add(femaleRadioButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(maleRadioButton);
		group.add(femaleRadioButton);
		
		setVisible(true);
		
		JLabel lblNewLabel_4 = new JLabel("DOB");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(52, 181, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JSpinner spinnerDay = new JSpinner();
		spinnerDay.setModel(new SpinnerNumberModel(1, null, 31, 1));
		spinnerDay.setBounds(120, 179, 37, 20);
		contentPane.add(spinnerDay);
		
		JSpinner spinnerMonth = new JSpinner();
		spinnerMonth.setModel(new SpinnerListModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		spinnerMonth.setBounds(156, 179, 46, 20);
		contentPane.add(spinnerMonth);
		
		JSpinner spinnerYear = new JSpinner();
		spinnerYear.setModel(new SpinnerNumberModel(1960, 1960, 2024, 1));
		spinnerYear.setBounds(226, 179, 65, 20);
		contentPane.add(spinnerYear);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(52, 225, 57, 14);
		contentPane.add(lblNewLabel_5);
		
		addressField = new JTextField();
		addressField.setBounds(118, 223, 254, 49);
		contentPane.add(addressField);
		addressField.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("Accept the Terms And Conditions.");
		checkBox.setBounds(118, 279, 229, 23);
		contentPane.add(checkBox);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String name = nameField.getText();
		        String mobile = mobileField.getText();
		        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
		        @SuppressWarnings("deprecation")
				Date dob = new Date((int) spinnerYear.getValue() - 1900, ((SpinnerListModel) spinnerMonth.getModel()).getList().indexOf(spinnerMonth.getValue()), (int) spinnerDay.getValue());
		        String address = addressField.getText();
		        boolean termsAccepted = checkBox.isSelected();

		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String dobString = dateFormat.format(dob);

		        String result = "<html><body>" +
		        		        "<p>Name: " + name + "</p>" +
		                        "<p>Mobile: " + mobile + "</p>" +
		                        "<p>Gender: " + gender + "</p>" +
		                        "<p>Date of Birth: " + dobString + "</p>" +
		                        "<p>Address: " + address + "</p>" +
		                        "<p>Terms Accepted: " + termsAccepted + "</p>" +
		                        "</body></html>";

		        outputListModel.addElement(result);
	                  
                    
					JOptionPane.showMessageDialog(submitBtn,"Record Added Successfully!");
		    }  
		      		  
		});
		submitBtn.setBackground(new Color(0, 255, 0));
		submitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		submitBtn.setBounds(113, 324, 89, 31);
		contentPane.add(submitBtn);

		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        nameField.setText("");
		        mobileField.setText("");
		        addressField.setText("");
		        maleRadioButton.setSelected(false);
		        femaleRadioButton.setSelected(false);
		        spinnerDay.setValue(1);
		        spinnerMonth.setValue("Jan");
		        spinnerYear.setValue(1960);
		        checkBox.setSelected(false);
		        outputListModel.clear();
		    }
		});
		resetBtn.setBackground(new Color(220, 20, 60));
		resetBtn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		resetBtn.setBounds(264, 324, 89, 28);
		contentPane.add(resetBtn);
		
		outputListModel = new DefaultListModel<>();
		JList<String> outputListUI = new JList<>(outputListModel);
		JScrollPane scrollPane = new JScrollPane(outputListUI);
		scrollPane.setBounds(449, 75, 195, 215);
		contentPane.add(scrollPane);
		
		JButton resetBtn1 = new JButton("Reset");
		resetBtn1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        nameField.setText("");
		        mobileField.setText("");
		        addressField.setText("");
		        maleRadioButton.setSelected(false);
		        femaleRadioButton.setSelected(false);
		        spinnerDay.setValue(1);
		        spinnerMonth.setValue("Jan");
		        spinnerYear.setValue(1960);
		        checkBox.setSelected(false);
		        outputListModel.clear();
		    }
		});
		resetBtn1.setBackground(new Color(220, 20, 60));
		resetBtn1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		resetBtn1.setBounds(264, 324, 89, 28);
		contentPane.add(resetBtn1);
				JList<Object> outputList1 = new JList<>();
		outputList1.setBounds(449, 75, 195, 215);
		contentPane.add(outputList1);
	}
}

