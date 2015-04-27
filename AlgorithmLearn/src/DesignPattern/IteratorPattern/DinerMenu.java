package DesignPattern.IteratorPattern;

import java.util.Iterator;

public class DinerMenu implements Menu{
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	public DinerMenu(){
		menuItems = new MenuItem[MAX_ITEMS];
		addItem("Diner No 1", "This is the NO 1 diner", true, 5.00);
		addItem("Diner No 2", "This is the NO 2 diner", true, 8.00);
		addItem("Diner No 3", "This is the NO 3 diner", false, 15.00);
		addItem("Diner No 4", "This is the NO 5 diner", false, 25.00);
	}

	private void addItem(String name, String description, boolean vegetarian, double price) {
		// TODO Auto-generated method stub
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if(numberOfItems < MAX_ITEMS){
			menuItems[numberOfItems++] = menuItem;
		}
		else{
			System.err.println("Sorry menu is full! Can't add item to menu");
		}
	}
	
	public Iterator createIterator(){
		return new DinerMenuIterator(menuItems);
	}
}
