package DesignPattern.FactoryPattern;

public class NYPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		if(type.equals("cheese")){
			return new NYStyleCheese();
		}
		if(type.equals("veggie")){
			return new NYStyleVeggiePizza();
		}
		if(type.equals("pepperoni")){
			return new NYStylePepperoniPizza();
		}
		return null;
	}

}
