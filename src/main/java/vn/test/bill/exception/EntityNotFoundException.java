package vn.test.bill.exception;

public class EntityNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3887723812623699454L;

	private String entityName;
	
	public EntityNotFoundException(String entityName) {
		super();
	}
	
	@Override
	public String getMessage() {
		return entityName + " not found";
	}
}
