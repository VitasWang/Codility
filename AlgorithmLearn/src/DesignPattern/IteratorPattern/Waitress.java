package DesignPattern.IteratorPattern;

import java.util.Iterator;

public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	Menu cafeMenu;
	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu){
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}
	
	public void printMenu(){
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		Iterator cafeIterator = cafeMenu.createIterator();
		System.out.println("MENU\n-----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
		
		System.out.println("\nDINNER");
		printMenu(cafeIterator);
	}

	private void printMenu(Iterator iterator) {
		// TODO Auto-generated method stub
		while(iterator.hasNext()){
			MenuItem menuItem = (MenuItem)iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getDescription() + ",");
			System.out.print("Is vegetraian: " + menuItem.getVegetarian());
			System.out.println(menuItem.getPrice());
		}
	}
}
