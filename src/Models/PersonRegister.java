package Models;

import java.util.ArrayList;

public class PersonRegister {
	
	private ArrayList<Person> persons = new ArrayList<Person>(); 
	
	public void setPersons (ArrayList<Person>newPerson) {
		persons = newPerson; 
	}
	public ArrayList<Person> getPersons() {
		return persons; 
	}
	public void addPerson(Person p) {
		persons.add(p); 
	}
	public void removePersons(Person p) {
		persons.remove(p);
	}
	public Person findPerson (String pNbr) {
		if (persons != null) {
			for (Person p : persons) {
				if (p.getPNbr().equals(pNbr)) {
					return p;
				}
			} 
		}
		return null;	
	}
	
	
	
}
