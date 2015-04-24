package DesignPattern.FactoryPattern;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		if(type.equals("cheese")){
			return new ChicagoStyleCheese();
		}
		if(type.equals("veggie")){
			return new ChicagoStyleVeggiePizza();
		}
		if(type.equals("pepperoni")){
			return new ChicagoStylePepperoniPizza();
		}
		return null;
	}
	
}
