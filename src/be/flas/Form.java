package be.flas;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Form {
	private String name;
	private String firstname;
	private int nbr;
	private boolean isOk;
	private LocalDate dob;
	
	public Form(String name, String firstname, int nbr, boolean isOk, LocalDate dob) {
		this.name = name;
		this.firstname = firstname;
		this.nbr = nbr;
		this.isOk = isOk;
		this.dob = dob;
	}
	
	public void print() {
		JOptionPane.showMessageDialog(null, "firstname: " + firstname
				+ "\nName: " + name + "\nNbr: " + nbr + "\nIsok: " + isOk
				+ "\nDob: " + dob, "Confirmation",JOptionPane.INFORMATION_MESSAGE);
	}
	
	

}
