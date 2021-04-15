package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Coffee {
	private final SimpleStringProperty cofeeName;
	private final SimpleDoubleProperty priceCofee;
	public Coffee(String cofeeName, double priceCofee) {
		
		this.cofeeName =new SimpleStringProperty (cofeeName);
		this.priceCofee =new SimpleDoubleProperty (priceCofee);
	}
	
	public SimpleStringProperty nameCofeeSimple()
	{
		return cofeeName;
	}
	public SimpleDoubleProperty priceCofeeSimple()
	{
		return priceCofee;
	}

}
