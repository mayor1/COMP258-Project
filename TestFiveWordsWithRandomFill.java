package project;

import java.util.Scanner;

public class TestFiveWordsWithRandomFill {

	public static void main(String[] args) {
		Array a = new Array(15, 15);
		Word w = new Word();
		String input;
		char[] temp;
		input = "ONE";
		temp = input.toCharArray();
		w.setWord(temp);
		w.fill(a);
		input = "TWO";
		temp = input.toCharArray();
		w.setWord(temp);
		w.fill(a);
		input = "THREE";
		temp = input.toCharArray();
		w.setWord(temp);
		w.fill(a);
		input = "FOUR";
		temp = input.toCharArray();
		w.setWord(temp);
		w.fill(a);
		input = "FIVE";
		temp = input.toCharArray();
		w.setWord(temp);
		w.fill(a);
		a.randomFill();
		a.printArrayToFile();	
	}

}
