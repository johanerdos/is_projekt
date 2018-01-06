package Models;

import java.util.ArrayList;

public class Person {

	private String pNbr; 
	private String name; 
	private ArrayList<Account>accounts = new ArrayList<Account>(); 
	
	public void setPNbr(String newPNbr) { 
		pNbr = newPNbr; 
	}
	public String getPNbr() {
		return pNbr; 
	}
	public void setName(String newName) {
		name = newName; 
	}
	public String getName() {
		return name; 
	}
	public void setAccounts(ArrayList<Account>newAccounts) {
		accounts = newAccounts; 
	}
	public ArrayList<Account> getAccounts() {
		return accounts; 
	}
	public void addAccount(Account a) {
			accounts.add(a); 

	}
}
