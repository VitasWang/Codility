package DesignPattern.SinglePattern;

public class SinglePattern {
	private static SinglePattern singlePattern = null;
	private SinglePattern(){
		
	}
	
	public static SinglePattern getInstance(){
		if(singlePattern == null){
			singlePattern = new SinglePattern();
		}
		return singlePattern;
	}
}
