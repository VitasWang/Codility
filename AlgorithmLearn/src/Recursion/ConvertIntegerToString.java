package Recursion;

public class ConvertIntegerToString {
	private static String[] seq= new String[]{"0","1","2","3","4","5","6","7","8","9"};
	
	public String getStringFormat(int number){
		return transfer(number);
	}

	private String transfer(int data) {
		if(data < 10) return seq[data];
		String result = transfer(data/10) + seq[data%10];
		return result;
	}
	
	public static void main(String[] args){
		ConvertIntegerToString cits = new ConvertIntegerToString();
		System.out.println(cits.getStringFormat(1));
		System.out.println(cits.getStringFormat(22));
		System.out.println(cits.getStringFormat(333));
		
	}
}
