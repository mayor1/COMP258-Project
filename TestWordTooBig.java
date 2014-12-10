package project;

public class TestWordTooBig {

	public static void main(String[] args) {
		Array a = new Array(6, 6);
		Word w = new Word();
		String input;
		char[] temp;
		input = "BECAUSE";
		temp = input.toCharArray();
		w.setWord(temp);
		w.fill(a);

		a.printArrayToFile();	
	}

}
