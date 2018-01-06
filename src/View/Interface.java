package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Models.Person;
import Controller.Controller;
import Models.PersonRegister;
import Models.Account;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Interface {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtRemovePersonField;
	private JTextField textField_pnr_konto;
	private JTextField txtSkrivInPersonnummer;
	private JTextField textField_konto_pnr;
	private JTextField txtOutPutField;
	private JTextField textField_6;
	private JTextField txtPnbr;
	private JTextField txtName;
	private Controller controller;
	private JTextField txtPersonnummer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
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
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//controller = new Controller();
		frame = new JFrame("Bank Applikation");
		frame.setBounds(100, 100, 840, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSkrivInPersonnummer = new JLabel("Skriv in personnummer: ");
		lblSkrivInPersonnummer.setBounds(45, 105, 186, 20);
		frame.getContentPane().add(lblSkrivInPersonnummer);

		txtPnbr = new JTextField();
		txtPnbr.setBounds(40, 141, 179, 26);
		frame.getContentPane().add(txtPnbr);
		txtPnbr.setColumns(10);

		JLabel lblSkrivInNamn = new JLabel("Skriv in namn :");
		lblSkrivInNamn.setBounds(45, 174, 174, 20);
		frame.getContentPane().add(lblSkrivInNamn);

		txtName = new JTextField();
		txtName.setBounds(40, 215, 179, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		JButton btnLggTillPerson = new JButton("L\u00E4gg till person");
		btnLggTillPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtOutPutField.setText("");

				String personnummer = txtPnbr.getText();
				String namn = txtName.getText();

				boolean b = false;

				for (Person p : controller.getPersons()) {
					if (p.getPNbr().equals(personnummer)) { //Om det redan finns en person där kommer b = true. 
						b = true;
					}
				}

				if (b == false && !namn.equals("")) {
					controller.addPerson(personnummer, namn); //Om b = true kommer inte detta att ske. 
					txtOutPutField.setText("Person tillagd!");
				} else {
					txtOutPutField.setText("ERROR");
				}

				txtPnbr.setText("");
				txtName.setText("");

			}
		});

		JButton btnCalculate_1 = new JButton("Ta bort person");
		btnCalculate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String personnummer = txtRemovePersonField.getText();

				controller.removePersons(personnummer);
				txtRemovePersonField.setText("");
				txtOutPutField.setText("Personen med personnummer: " + personnummer + " är borttagen.");

			}
		});
		btnLggTillPerson.setBounds(45, 257, 141, 29);
		frame.getContentPane().add(btnLggTillPerson);

		JButton btnLggTillKonto = new JButton("L\u00E4gg till konto");
		btnLggTillKonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtOutPutField.setText("");

				String personnummer = textField_pnr_konto.getText();
				String kontonummer = textField_konto_pnr.getText();

				Person tmp = controller.findPerson(personnummer);
				if(tmp != null) {
					if(!kontonummer.equals("")) {
						controller.addAccount(personnummer, kontonummer);
						String txt = "";
						for (Account a : tmp.getAccounts()) {
							txt += ("\n Kontonummer : " + a.getNbr() + " är tillagt");
						}
		
						txtOutPutField.setText(txt);
					}else txtOutPutField.setText("Kontot kräver ett giltligt kontonummer.");
				}else txtOutPutField.setText("ERROR Du måste lägga till en person innan du kan lägga till kontonummer."); //Det finns ingen person med detta personnummer
				textField_pnr_konto.setText("");
				textField_konto_pnr.setText("");
			}
		});
		btnLggTillKonto.setBounds(591, 298, 159, 29);
		frame.getContentPane().add(btnLggTillKonto);

		txtRemovePersonField = new JTextField();
		txtRemovePersonField.setBounds(313, 141, 146, 26);
		frame.getContentPane().add(txtRemovePersonField);
		txtRemovePersonField.setColumns(10);

		textField_pnr_konto = new JTextField();
		textField_pnr_konto.setBounds(597, 141, 157, 26);
		frame.getContentPane().add(textField_pnr_konto);
		textField_pnr_konto.setColumns(10);

		JLabel lblSkrivInPersonnummer_1 = new JLabel("Skriv in personnummer: ");
		lblSkrivInPersonnummer_1.setBounds(313, 105, 186, 20);
		frame.getContentPane().add(lblSkrivInPersonnummer_1);

		JLabel lblSkrivPersonnummer = new JLabel("Skriv in personnummer: ");
		lblSkrivPersonnummer.setBounds(595, 105, 186, 20);
		frame.getContentPane().add(lblSkrivPersonnummer);

		JButton btnHittaPerson = new JButton("Hitta person");
		btnHittaPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String personnummer = txtPersonnummer.getText();
				Person p = controller.findPerson(personnummer);
				if(p != null) {
					//personnummer = p.getPNbr();
					String personnamn = p.getName();
	
					txtOutPutField.setText("Personen: " + personnummer + " " + personnamn);
				}else txtOutPutField.setText("Det finns ingen person med detta personnummer.");
				txtPersonnummer.setText("");
			}
		});
		btnHittaPerson.setBounds(45, 401, 146, 29);
		frame.getContentPane().add(btnHittaPerson);

		JLabel lblSkrivInPersonnummer_2 = new JLabel("Skriv in personnummer: ");
		lblSkrivInPersonnummer_2.setBounds(45, 302, 202, 20);
		frame.getContentPane().add(lblSkrivInPersonnummer_2);

		JButton btnSkrivUtKonton = new JButton("Skriv ut konton");
		btnSkrivUtKonton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String personnummer = txtSkrivInPersonnummer.getText();
				Person person = controller.findPerson(personnummer);
				if(person != null) {
					ArrayList<Account> accountList = person.getAccounts();//sparar undan personens kontolista
					if(accountList.size() != 0) {//Kollar om listan är tom.
					String accString = person.getName() + ", dina kontonummer är: ";//Om den inte är tom - initierar en sträng som ska fyllas på. 
					for(Account acc : accountList) {//for each account i vår accountList 
						
						accString = accString + acc.getNbr() + ", "; // lägger till varje account i strängen.
					}
					txtOutPutField.setText(accString);//Skriver ut strängen. 
					
					}else {
						txtOutPutField.setText("Det finns inga konton anslutna till denna person.");//Har olika för att hålla koll på vilken rad det kan bli fel.
					}
				}else txtOutPutField.setText("Det finns ingen person med detta personnummer.");
				txtSkrivInPersonnummer.setText("");
			}
		});
		btnSkrivUtKonton.setBounds(325, 401, 154, 29);
		frame.getContentPane().add(btnSkrivUtKonton);

		txtSkrivInPersonnummer = new JTextField();
		txtSkrivInPersonnummer.setBounds(325, 356, 174, 29);
		frame.getContentPane().add(txtSkrivInPersonnummer);
		txtSkrivInPersonnummer.setColumns(10);

		JLabel lblSkrivInPersonnummer_3 = new JLabel("Skriv in personnummer: ");
		lblSkrivInPersonnummer_3.setBounds(325, 302, 186, 20);
		frame.getContentPane().add(lblSkrivInPersonnummer_3);

		JLabel lblKontonummer = new JLabel("Skriv in nytt kontonummer");
		lblKontonummer.setBounds(595, 194, 159, 20);
		frame.getContentPane().add(lblKontonummer);

		textField_konto_pnr = new JTextField();
		textField_konto_pnr.setBounds(591, 238, 159, 26);
		frame.getContentPane().add(textField_konto_pnr);
		textField_konto_pnr.setColumns(10);
		btnCalculate_1.setBounds(313, 190, 146, 29);
		frame.getContentPane().add(btnCalculate_1);

		txtOutPutField = new JTextField();
		txtOutPutField.setBounds(42, 457, 708, 84);
		frame.getContentPane().add(txtOutPutField);
		txtOutPutField.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(331, 53, 69, 20);
		frame.getContentPane().add(label);

		txtPersonnummer = new JTextField();
		txtPersonnummer.setBounds(40, 359, 179, 26);
		frame.getContentPane().add(txtPersonnummer);
		txtPersonnummer.setColumns(10);

		controller = new Controller();

	}
}
