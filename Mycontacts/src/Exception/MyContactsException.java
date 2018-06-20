package Exception;

public class MyContactsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param msg
	 */
	public MyContactsException (String msg) {
		super (msg);
	}
	/**
	 * 
	 * @param desc
	 * @param throwable
	 */
	public MyContactsException (String desc , Throwable throwable)
	{
		super (desc , throwable);
	}

}

