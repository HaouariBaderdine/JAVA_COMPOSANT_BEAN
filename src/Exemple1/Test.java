package Exemple1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MonBeanVeto monBeanVeto = new MonBeanVeto();
		
		monBeanVeto.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				System.out.println("propretyChange : valeur = "+ event.getNewValue());
			}
		});
		
		monBeanVeto.addVetoableChangeListener(new VetoableChangeListener() {
			public void vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
				if(((Integer) event.getNewValue()).intValue() >100){
					throw new PropertyVetoException("Valeur supérieur à 100", event);
				}
			}
			
		});
		
		monBeanVeto.addVetoableChangeListener(new VetoableChangeListener() {
			public void vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
			
				if(((Integer) event.getNewValue()).intValue() <50){
					throw new PropertyVetoException("Valeur inférieur à 50", event);
				}
			}	
		});
		
		System.out.println("valeur = "+ monBeanVeto.getValeur());
		
		monBeanVeto.setValeur(10);
		
		System.out.println("valeur = "+ monBeanVeto.getValeur());
		
		monBeanVeto.setValeur(200);
		
		System.out.println("valeur = "+ monBeanVeto.getValeur());

	}
	
}
