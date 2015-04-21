package Recursion;

import java.util.Stack;

public class HanoiTower {
	public static void moveTower(int height, Stack<Integer> from, Stack<Integer> temp, Stack<Integer> to){
		if(height <= 1){
			moveDisk(from, to);
			printStatus(from, to, temp);
			return;
		}
		moveTower(height-1, from, to, temp);
		moveDisk(from, to);
		printStatus(from, to, temp);
		moveTower(height-1, temp, from, to);
	}
	private static void printStatus(Stack<Integer> from, Stack<Integer> to, Stack<Integer> temp){
		System.out.println("---------------");
		System.out.println(from);
		System.out.println(temp);
		System.out.println(to);
	}
	public static void moveDisk(Stack<Integer> from, Stack<Integer> to){
		Integer t = from.pop();
		to.push(t);
	}
	public static void main(String[] args){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
//		System.out.println(s1);
		moveTower(s1.size(), s1, s2, s3);
//		System.out.println(s3);
		
	}
}
