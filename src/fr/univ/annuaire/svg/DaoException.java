package fr.univ.annuaire.svg;

public class DaoException extends Exception {

	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public DaoException(){
		super();
	}

	public DaoException(String message) { 
		super(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(Throwable cause) { 
		super(cause); 
	}
}
