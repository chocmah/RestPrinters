package ca.iaah.document.distribution.print;

public class LocalPrintServiceException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public LocalPrintServiceException(Exception e){
		super(e);
	}
	
	public LocalPrintServiceException(Exception e, String msg){
		super(msg, e);
	}
	
	
	public LocalPrintServiceException(String msg){
		super(msg);
	}
}
