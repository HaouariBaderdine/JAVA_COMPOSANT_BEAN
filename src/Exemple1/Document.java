package Exemple1;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

public class Document {
	
	BeanInfo bi;

	
	public BeanInfo getBi() {
		return bi;
	}

	public void setBi(BeanInfo bi) {
		this.bi = bi;
	}

	public Document(){
		try {
			Class<?> monBeanClasse = Class.forName("Exemple1.MonBeanVeto");
			this.bi = Introspector.getBeanInfo(monBeanClasse, monBeanClasse.getSuperclass());
			BeanDescriptor unBeanDescriptor = bi.getBeanDescriptor();
			
			System.out.println("Nom de bean : "+ unBeanDescriptor.getName());
			System.out.println("Classe de bean : "+ unBeanDescriptor.getBeanClass());
			System.out.println("");
		}catch(Exception e) {
			System.out.println("Classe non trouvée");
		}

	}
	
	
	public void getPropretDescriptor() {
		PropertyDescriptor[] propretyDescriptor = this.bi.getPropertyDescriptors();
		
		for(int i = 0; i< propretyDescriptor.length; i++) {
			System.out.println(" Nom proprieté : " + propretyDescriptor[i].getName() );
			System.out.println(" Type proprieté : " + propretyDescriptor[i].getPropertyType() );
			System.out.println(" Getter proprieté : " + propretyDescriptor[i].getReadMethod() );
			System.out.println(" Setter proprieté : " + propretyDescriptor[i].getWriteMethod() );

		}
	}
	
	public void getMhetohdDescriptor() {
		MethodDescriptor[] methodDescriptor = this.bi.getMethodDescriptors();
		
		for(int i = 0; i< methodDescriptor.length; i++) {
			System.out.println(" Methode " + i +" : " + methodDescriptor[i].getName() );

		}
	}
	
	public void getEventDescriptor() {
		EventSetDescriptor[] unEventDescriptor = this.bi.getEventSetDescriptors();
		
		for(int i = 0; i< unEventDescriptor.length; i++) {
			System.out.println(" Nom Event : " + unEventDescriptor[i].getName() );
			System.out.println(" Methode add event : " + unEventDescriptor[i].getAddListenerMethod() );
			System.out.println(" Methode remove event : " + unEventDescriptor[i].getRemoveListenerMethod() );
			
			MethodDescriptor[] methodDescriptor = unEventDescriptor[i].getListenerMethodDescriptors();
			
			for(int j = 0; j< methodDescriptor.length; j++) {
				System.out.println(" Event type " + i +" : " + methodDescriptor[j].getName() );

			}

		}
	}


}
