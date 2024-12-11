package be.flas;

import java.awt.EventQueue;

import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfFirstname;
	private JComboBox cboxNbr;
	private JCheckBox cbIsok;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameForm frame = new JFrameForm();
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
	public JFrameForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfName = new JTextField();
		tfName.setBounds(213, 31, 96, 19);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfFirstname = new JTextField();
		tfFirstname.setBounds(213, 70, 96, 19);
		contentPane.add(tfFirstname);
		tfFirstname.setColumns(10);
		
		cbIsok = new JCheckBox("Isok");
		cbIsok.setBounds(213, 154, 93, 21);
		contentPane.add(cbIsok);
		
		cboxNbr = new JComboBox();
		cboxNbr.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cboxNbr.setBounds(213, 111, 93, 21);
		contentPane.add(cboxNbr);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(213, 199, 96, 19);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddInscription();
			}
		});
		btnNewButton.setBounds(43, 232, 85, 21);
		contentPane.add(btnNewButton);
	}
	private void AddInscription() {
		try {
			if(tfName.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this,"Name is required","ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tfFirstname.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this,"FirstName is required","ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(dateChooser.getDate()==null) {
				JOptionPane.showMessageDialog(this,"date is required","ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!tfName.getText().matches("[a-zA-Z]+")) {
				JOptionPane.showMessageDialog(this,"Name must contain only letters","ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!tfFirstname.getText().matches("[a-zA-Z]+")) {
				JOptionPane.showMessageDialog(this,"FirstName must contain only letters","ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String selectedValue=(String) cboxNbr.getSelectedItem();
			int value = Integer.parseInt(selectedValue);
			
			LocalDate dob=dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			Form f=new Form(
					tfName.getText(),
					tfFirstname.getText(),
					value,
					cbIsok.isSelected(),
					dob);
			
			f.print();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "ERROR ADD" + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			
		}
	}
}
