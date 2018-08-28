package Exception;

public class MatrizException extends ScreenException{
	private static final long serialVersionUID = 4324431653173166481L;

	/**
	 * @param screenMessage
	 *            String
	 * @param cause
	 *            Throwable
	 */
	public MatrizException(String screenMessage, Throwable cause) {
		super(screenMessage, cause);
	}
	
	/**
	 * @param screenMessage
	 *            String
	 */
	public MatrizException(String screenMessage) {
		super(screenMessage);
	}
	

}
