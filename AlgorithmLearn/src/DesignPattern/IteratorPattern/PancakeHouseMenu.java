package DesignPattern.IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu{
	ArrayList<MenuItem> menuItems;
	
	public PancakeHouseMenu(){
		menuItems = new ArrayList<MenuItem>();
		addItem("Pancake1", "This is the NO 1 pancake", true, 2.99);
		addItem("Pancake2", "This is the NO 2 pancake", true, 3.14);
		addItem("Pancake3", "This is the NO 3 pancake", false, 3.99);
		addItem("Pancake4", "This is the NO 4 pancake", false, 4.99);
	}

	private void addItem(String name,
						 String description,
						 boolean vegetarian,
						 double price) {
		// TODO Auto-generated method stub
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
	
	public Iterator createIterator(){
		return menuItems.iterator();
	}
}
