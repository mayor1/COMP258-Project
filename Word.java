package project;
import java.util.Random;
public class Word{
	private char[] word;
	
	public Word(){ //default constructor
		
	}
	
	public void setWord(char[] input){ //sets word from input
		word = new char[input.length];
		word = input;
	}
	
	public char[] getWord(){ //returns word
		return word;
	}
	
	public int getWordSize(){ //returns size of entered word
		return word.length;
	}
	
	public void fill(Array a){ //takes word and places it in Array
		int max1 = 2;
		int min1 = 1;
		Random rand1 = new Random();
		int random1 = rand1.nextInt((max1 - min1) + 1) + min1;
		if(random1 == 2){
			reverse();
		}
		int max2 = 3; 
		int min2 = 1; 
		Random rand2 = new Random();
		int random2 = rand2.nextInt((max2 - min2) + 2) + min2;
		//random2 = 1; //TEST
		if(random2 == 1){ //horizontal
			placeHorizontal(a);
		}
		else if(random2 == 2){ //vertical
			placeVertical(a);
		}
		else if(random2 == 3){ //diagonal 1 \
			placeDiagonal1(a);
		}
		else if(random2 == 4){ //diagonal 2 /
			placeDiagonal2(a);
		}
	}
	
	public int startPointRow(Array a){ //starting row for placing a word
		int max = a.getFirstDimension();
		Random rand = new Random();
		int random = Math.abs(rand.nextInt()) % max;
		int startPoint = random;
		return startPoint;
	}
	
	public int startPointColumn(Array a){ //starting column for placing a word
		int max = a.getFirstDimension();
		Random rand = new Random();
		int random = Math.abs(rand.nextInt()) % max;
		int startPoint = random;
		return startPoint;
	}
	
	public void reverse(){ //reverses word
		for(int i = 0; i < word.length/2; i++){
			char temp = word[i];
			word[i] = word[word.length - i - 1];
			word[word.length - i - 1] = temp;
		}
	}
	
	public void printWord(){ //prints word to screen --used for debugging
		int length = word.length;
		for(int i = 0; i < length; i++){
			System.out.print(word[i]);
		}
	}
	
	public boolean checkHorizontal(int column, int row, Array a){ //checks to see is the passed word can be placed horizontally
		for(int i = 0; i < word.length; i++){
			if(a.getCharAt(column + i, row) != ' ' && a.getCharAt(column + i, row) != word[i]){
				return false;
			}
		}
		return true;
	}
	
	
	public boolean checkVertical(int column, int row, Array a){ //checks to see is the passed word can be placed vertically
		for(int i = 0; i < word.length; i++){
			if(a.getCharAt(column, row + i) != ' ' && a.getCharAt(column, row + i) != word[i]){
				return false;
			}	
		}
		return true;
	}

	
	public boolean checkDiagonal1(int column, int row, Array a){ //checks to see is the passed word can be placed diagonally
		for(int i = 0; i < word.length; i++){
			if(a.getCharAt(column + i, row + i) != ' ' && a.getCharAt(column + i, row + i) != word[i]){
				return false;
			}	
		}
		return true;
	}
	
	public boolean checkDiagonal2(int column, int row, Array a){ //checks to see is the passed word can be placed diagonally
		for(int i = 0; i < word.length; i++){
			if(a.getCharAt(column + i, row - i) != ' ' && a.getCharAt(column + i, row - i) != word[i]){
				return false;
			}	
		}
		return true;
	}

	public void placeHorizontal(Array a){ //places passed word horizontally
		int row = startPointRow(a);
		int column = startPointColumn(a);
		while(true){
			int endPos = column + word.length - 1;				
			if (word.length > a.getFirstDimension()){
				System.out.println("Error: passed word is too big");
			}					
			else if(endPos < a.getFirstDimension()){
				if(checkHorizontal(column, row, a)){
					break;
				}
			}
			
			row = startPointRow(a);
			column = startPointColumn(a);
		}
		for(int i = 0; i < word.length; i++){ //places word in the array
			a.setCharAt(column + i, row, word[i]);
		}
	}

	public void placeVertical(Array a){ //places passed word vertically
		int row = startPointRow(a);
		int column = startPointColumn(a);
		int valid = 0;
		while(true){
			int endPos = row + word.length - 1;				
			if (word.length > a.getSecondDimension()){
				System.out.println("Error: passed word is too big");
				valid = -1;
				break;
			}					
			else if(endPos < a.getSecondDimension()){
				if(checkVertical(column, row, a)){
					break;
				}
			}
			
			row = startPointRow(a);
			column = startPointColumn(a);
		}
		if(valid > -1){
			for(int i = 0; i < word.length; i++){ //places word in the array
				a.setCharAt(column, row + i, word[i]);
			}
		}
	}
	
	public void placeDiagonal1(Array a){ //places pased word at a diagonal
		int row = startPointRow(a);
		int column = startPointColumn(a);
		int valid = 0;
		while(true){
			int endPosRow = row + word.length - 1;
			int endPosColumn = column + word.length - 1;
			if (word.length > a.getFirstDimension() || word.length > a.getSecondDimension()){ 
				System.out.println("Error: passed word is too big");
				valid = -1;
				break;
			}					
			else if(endPosColumn < a.getFirstDimension() && endPosRow < a.getSecondDimension()){
				if(checkDiagonal1(column, row, a)){
					break;
				}
			}
			
			row = startPointRow(a);
			column = startPointColumn(a);
		}
		if(valid > -1){
			for(int i = 0; i < word.length; i++){ //places word in the array
				a.setCharAt(column + i, row + i, word[i]);
			}
		}
	}
	public void placeDiagonal2(Array a){ // places passed word at a diagonal
		int row = startPointRow(a);
		int column = startPointColumn(a);
		int valid = 0;
		while(true){
			int endPosRow = row - word.length - 1;
			int endPosColumn = column + word.length - 1;
			if (word.length > a.getFirstDimension() || word.length > a.getSecondDimension()){ 
				System.out.println("Error: passed word is too big");
				valid = -1;
				break;
			}					
			else if(endPosColumn < a.getFirstDimension() && endPosRow < a.getSecondDimension() && endPosRow >= 0){
				if(checkDiagonal2(column, row, a)){
					break;
				}
			}
			row = startPointRow(a);
			column = startPointColumn(a);
		}
		if(valid > -1){
			for(int i = 0; i < word.length; i++){ //places word in the array
				a.setCharAt(column + i, row - i, word[i]);
			}	
		}
	}
}