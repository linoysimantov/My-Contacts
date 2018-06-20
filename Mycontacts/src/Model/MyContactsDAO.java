package Model;

import java.util.List;

import Exception.MyContactsException;

/**
 * This interface defines the options of the ToDoList application,
 *  for the user and it's items.
 *  
 * @author Linoy
 *
 */
public interface MyContactsDAO {

	/**
	 * Adding a contact and saves it
	 * @param contact
	 * @throws MyContactsException
	 */
	public void addContact(Contact contact) throws MyContactsException;


	/**
	 *	returns list of contacts
	 * @param contact
	 * @return list of contacts
	 * @throws MyContactsException
	 */
	public List<Contact> getAllContacts() throws MyContactsException;



	/**
	 * checking if contact is already exist
	 * @param contact
	 * @return true if contact is exist, false otherwise.
	 * @throws MyContactsException
	 */
	public boolean isContactExist(Contact contact) throws MyContactsException;


}
