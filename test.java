package project;
import java.util.Scanner;
public class test {

	public static void main(String[] args) {
		Array a = new Array(15, 15);
		Word w = new Word();
		int number;
		String input;
		char[] temp;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter number of words you would like to enter.");
		number = keyboard.nextInt();
		for(int i = 0; i < number; i++ ){
			System.out.println("Enter word");
			input = keyboard.next();
			temp = input.toCharArray();
			if(temp.length > a.getFirstDimension()){
				//fail
			}
			w.setWord(temp);
			w.fill(a);
		}
//		w.fill(a);
		//w.print();
		
		
		
		//int d1 = a.getFirstDimension();
		//int d2 = a.getSecondDimension();
		//System.out.println("d1 = " + d1 + "   d2 = " + d2);
		
		//a.setCharAt(6, 3, 'A');
		//a.randomFill();
		//System.out.println(a.getCharAt(6, 3));
		
		//System.out.println(w.startPoint(a)[0][0]);
		//System.out.println(w.startPoint(a)[1][1]);
//		w.fill(a);
		a.printArrayToFile();
//		int x[][] = new int[1][1];
//		x[0][0] = w.startPoint(a)[0][0];
//		System.out.println(x[0][0]);
		
		keyboard.close();
	}


}

