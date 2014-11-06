package project;
import java.util.Scanner;
public class test {

	public static void main(String[] args) {
		Array a = new Array(20, 20);
		Word w = new Word();
		int number;
		String input;
		char[] temp;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter number of words you wold like to enter.");
		number = keyboard.nextInt();
		for(int i = 0; i < number; i++ ){
			System.out.println("Enter word");
			input = keyboard.next();
			temp = input.toCharArray();
			w.setWord(temp);
			
		}
		w.fill(a);
		//w.print();
		
		
		
		//int d1 = a.getFirstDimension();
		//int d2 = a.getSecondDimension();
		//System.out.println("d1 = " + d1 + "   d2 = " + d2);
		
		//a.setCharAt(6, 3, 'A');
		a.randomFill();
		//System.out.println(a.getCharAt(6, 3));
		a.print();
		
		keyboard.close();
	}


}
