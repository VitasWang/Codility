package Recursion;

public class ConvertIntegerToString {
	private static String[] seq= new String[]{"0","1","2","3","4","5","6","7","8","9", 
												"A", "B", "C", "D", "E", "F"};
	
	public String getStringFormat(int number, int base){
		return transfer(number, base);
	}

	private String transfer(int data, int base) {
		
		if(data < base) return seq[data];
		String result = transfer(data/base, base) + seq[data%base];
		return result;
	}
	
	public static void main(String[] args){
		ConvertIntegerToString cits = new ConvertIntegerToString();
		System.out.println(cits.getStringFormat(1,16));
		System.out.println(cits.getStringFormat(22, 16));
		System.out.println(cits.getStringFormat(333, 16));		
		
	}
}
