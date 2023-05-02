package Exemple1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

public class MonBeanVeto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int valeur;

	PropertyChangeSupport changeSupport;

	VetoableChangeSupport vetoableSupport;

	public MonBeanVeto() {
		this.valeur = 0;
		changeSupport = new PropertyChangeSupport(this);
		vetoableSupport = new VetoableChangeSupport(this);
	}

	public synchronized int getValeur() {
		return valeur;
	}

	public synchronized void setValeur(int valeur) {
		int oldValeur = this.valeur;
		this.valeur = valeur;

		try {
			vetoableSupport.fireVetoableChange("valeur", oldValeur, this.valeur);

		} catch (PropertyVetoException e) {
			System.out.println("Mon bean, un veto est émis: " + e.getMessage());
			this.valeur = oldValeur;
		}

		changeSupport.firePropertyChange("valeur", oldValeur, valeur);

	}

	// Property change listener

	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	// vetoable change listener

	public synchronized void addVetoableChangeListener(VetoableChangeListener listener) {
		vetoableSupport.addVetoableChangeListener(listener);
	}

	public synchronized void removeVetoableChangeListener(VetoableChangeListener listener) {
		vetoableSupport.removeVetoableChangeListener(listener);
	}

}
