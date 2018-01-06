package Controller;
import java.util.ArrayList;

import Models.Account;
import Models.Person;
import Models.PersonRegister;

public class Controller {

		private Person person;
		private Account account;
		private PersonRegister personRegister;

		public Controller() {
			personRegister = new PersonRegister();
		}

		public Person findPerson(String pNbr) {
			return personRegister.findPerson(pNbr);
		}


		
		public void addPerson(String pNbr, String name) {
			if (findPerson(pNbr) == null) {
				Person p = new Person();
				p.setPNbr(pNbr);
				p.setName(name);
				
				personRegister.addPerson(p);
			}
		}
		public void removePersons(String pNbr) {
			person = findPerson(pNbr);
			personRegister.removePersons(person);
		}

		public void addAccount(String pNbr, String accNbr) {
			person = findPerson(pNbr);
			account = new Account();
			if (person != null) {
				person.addAccount(account);
				//generateAccNbr();
				//account.setNbr(getAccNbr());
				account.setNbr(accNbr);
			}
			
		}
		public ArrayList<Person> getPersons() {
			return personRegister.getPersons();
		}
	
		
		/*private void generateAccNbr(){
			accNbr++; 
		}
		
		public String getAccNbr(){
			return Integer.toString(accNbr); 
		}*/
	
	
		

}
