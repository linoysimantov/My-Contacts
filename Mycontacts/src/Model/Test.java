package Model;
import java.util.List;

import Exception.MyContactsException;

public class Test {


	/**
	 * Testing Model
	 */
	/**
	 * User methods test
	 */
	
		public static void main(String[] args){

			HibernateMyContactsDAO model = new HibernateMyContactsDAO();
			Contact contact1 = new Contact("0502309988", "Linoy");
			Contact contact2 = new Contact("0503893283", "Shir");
			Contact contact3 = new Contact("0523059787", "Tomer");

			/**
			 * Test adding contacts and get contacts from database
			 */
			try {
				model.addContact(contact1);
				model.addContact(contact2);				
				model.addContact(contact3);

				List<Contact> contacts = model.getAllContacts();
				for(Contact contact: contacts)
				{
					System.out.println(contact);
				}
				
			} catch (MyContactsException e) {
				System.err.println(
						"test add contacts : Failed to create contacts. There will be nothing to get - failing this test...");
			}
	}
		

}