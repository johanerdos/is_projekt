package Models;

public class Account {
	
	
		private String nbr; 
		private double balance; 
		private Person person; 
		
		public void setNbr (String newNbr) {
			nbr = newNbr;
		}
		public String getNbr() {
			return nbr; 
		}
		public void setBalance (double newBalance) {
			balance = newBalance;
		}
		public double getBalance() {
			return balance;
		}
		public void setPerson (Person newPerson) {
			person = newPerson; 
		}
		public Person getPerson() {
			return person; 
		}
		public void credit (double amount) {
			balance+= amount; 	
		}
		public void withdraw (double amount) {
			balance -= amount; 
		}
	
	
}
