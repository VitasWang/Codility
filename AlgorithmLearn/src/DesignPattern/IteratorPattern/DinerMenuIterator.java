package DesignPattern.IteratorPattern;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator {
	MenuItem[] items;
	int position; 
	
	public DinerMenuIterator(MenuItem[] menus){
		items = menus;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(position < items.length && items[position] != null){
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		return items[position++];
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		if(position <= 0){
			throw new IllegalStateException("you cannot remvoe an item until you've done at least one next()");
		}
		
		if(items[position-1] != null){
			for(int i = position-1; i < (items.length-1); i++){
				items[i] = items[i+1];
			}
			items[items.length - 1] = null;
		}
	}
	
}
