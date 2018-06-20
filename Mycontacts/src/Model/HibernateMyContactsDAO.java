package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.microsoft.sqlserver.jdbc.*;


import javax.persistence.PersistenceContext;


import Exception.MyContactsException;
/**
 * 
 * @author linoy
 *
 */
public class HibernateMyContactsDAO implements MyContactsDAO{

		private Connection  connection = null;
		
		public HibernateMyContactsDAO() {}


		/**
		 * I run only one time - to create the SQL DB in AZURE therfore there is not call for it
		 */
		private void createTable() {
			openConnection();
			Statement statement =null;
			try {
			// Define the SQL string.
		    String sqlString = 
				"CREATE TABLE My (" + 
					"ID [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,"+
		        	"[PhoneNumber] [nvarchar] (15) NOT NULL," +
		            "[userName] [nvarchar](50) NOT NULL)";
		     statement = connection.createStatement();
		
		    // Execute the statement.
		    statement.executeUpdate(sqlString);
		
		    // Provide a message when processing is complete.
		    System.out.println("Processing complete.");
			}
			catch (Exception e)
	        {
	            System.out.println("Exception " + e.getMessage());
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                // Close resources.
	                if (null != connection) connection.close();
	                if (null != statement) statement.close();
	            }
	            catch (SQLException sqlException)
	            {
	            	System.out.println("failed to close resources"+ sqlException.getMessage());
	            }
	        }
		
		}
		/**
		 * open connection to the database
		 */
		public void openConnection() {
			try {
			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				    String connectionUrl = "jdbc:sqlserver://server.database.windows.net:1433;"+"database=contacts;"
				    		+"user=root123;" + "password=Linoyst1;";

				    connection = DriverManager.getConnection(connectionUrl); 
			} catch (Exception  e) {
				System.out.println("Failed to create sessionFactory object." + e + "\n" + e.getCause().getCause());
				e.printStackTrace();
			}
		}


		/**
		 * 
		 * @param contact
		 * @throws MyContactsException
		 */
		@Override
		public void addContact(Contact contact) throws MyContactsException {
			openConnection();
			 Statement stmt = null;
			 ResultSet rs = null;
			if (isContactExist(contact) == false) {
				try {
					String SQL = "INSERT INTO My(PhoneNumber,userName)"+
							" VALUES('"+ contact.getPhoneNumber()+"',"+"'"+ contact.getUserName()+"'"+");";
				    stmt = connection.createStatement(); 
				    stmt.executeUpdate(SQL);
				}

				catch ( SQLException e) {
					throw new MyContactsException("Failed to add contact", e.getCause());
				}
				finally {
					try {
					if(connection!=null) connection.close();
				     if (null != stmt) stmt.close();
		                if (null != rs) rs.close();
					}
					  catch (SQLException sqlException)
		            {
						 System.out.println(sqlException.getCause());
		            }
				}
			}

		}
		
		/**
		 * check if contact exist in the DB
		 * @return true if succeded, false otherwise. 
		 */
		@Override
		public boolean isContactExist(Contact contact) throws MyContactsException{
			boolean exist = false;
			Statement stmt = null;
			try {

				String SQL = "select PhoneNumber from My where PhoneNumber =" + "'"+contact.getPhoneNumber() + "';";
			     stmt = connection.createStatement(); 
			    ResultSet rs = stmt.executeQuery(SQL);
			
					if (rs.next())
						exist = true;
					else
						exist = false;
			
			} catch ( SQLException e) {
				if(connection != null){
					try {
						connection.close();
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				throw new MyContactsException("Failed to get contact", e);
			}

			return exist;
		}


		/**
		 * Get all contacts
		 * @return list of the items. 
		 */
		@Override
		public List<Contact> getAllContacts() throws MyContactsException{
			openConnection();
			Statement  stmt = null;
			ResultSet rs = null;
			List<Contact> results= new ArrayList<Contact>();
			try {
				String SQL = "Select PhoneNumber,userName From My";
			    stmt = connection.createStatement(); 
			    rs = stmt.executeQuery(SQL);
			    
			    while(rs.next()) {
			    	String phone = rs.getString("PhoneNumber");
			    	  String name = rs.getString("userName");

			    	  Contact contact = new Contact(phone, name);
			    	  results.add(contact);

			    }
				
			} catch (SQLException e) {
				throw new MyContactsException("Unable to get contact list from the database");
			} finally {
				try {
					if(connection!=null) connection.close();
				     if (null != stmt) stmt.close();
		                if (null != rs) rs.close();
					}
					  catch (SQLException sqlException)
		            {
						 System.out.println(sqlException.getCause());
		            }
			}
			return results;
		}

		
	

}
