package Exemple1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class MonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Propriety simple
	protected int valeur;

	//Propriety bound
	PropertyChangeSupport changeSupport;

	public MonBean() {
		changeSupport = new PropertyChangeSupport(this);
	}
	
	public synchronized int getValeur() {
		return valeur;
	}

	public synchronized void setValeur(int valeur) {
		int oldValeur = this.valeur;
		this.valeur = valeur;
		changeSupport.firePropertyChange("valeur", oldValeur, valeur);
	}

	/*
	 * Add an observer
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	/*
	 * Remove an observer
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

}
