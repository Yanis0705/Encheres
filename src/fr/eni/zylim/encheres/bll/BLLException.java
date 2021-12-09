package fr.eni.zylim.encheres.bll;

import fr.eni.zylim.encheres.dal.DALException;

public class BLLException extends Exception {

	public BLLException() {
	}

	public BLLException(String message) {
		super(message);
	}

	public BLLException(Throwable cause) {
		super(cause);
	}

	public BLLException(String message, Throwable cause) {
		super(message, cause);
	}

	public boolean hasErreur() {
		// TODO Auto-generated method stub
		return false;
	}

	public void ajouterErreur(DALException e) {
		// TODO Auto-generated method stub

	}

}
