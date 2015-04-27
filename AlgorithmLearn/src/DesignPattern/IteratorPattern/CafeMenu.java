package DesignPattern.IteratorPattern;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements Menu {
	Hashtable menuItems = new Hashtable();
	
	public CafeMenu(){
		addItem("cafe No 1", "this is the NO 1 cafe", true, 1.99);
		addItem("cafe No 2", "this is the NO 2 cafe", true, 2.99);
		addItem("cafe No 3", "this is the NO 3 cafe", true, 3.99);
		addItem("cafe No 4", "this is the NO 4 cafe", true, 4.99);
	}
	
	@SuppressWarnings("unchecked")
	public void addItem(String name, String description, boolean vegetarian, double price){
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}
	
	public Iterator createIterator(){
		return menuItems.values().iterator();
	}
}
