package project;
import java.util.Random;


public class Word {
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
	
	public void fill(Array a){ //takes word and places it in Array
		int max = 2;
		int min = 1;
		Random rand = new Random();
		int random = rand.nextInt((max - min) + 1) + min;
		if(random == 2){
			reverse();
		}
		//NEED TO CREATE AN ALGORITHM TO FIND A SUITABLE STARTING POSITION TO PRINT TO
	}
	
	public void reverse(){ //reverses word
		for(int i = 0; i < word.length/2; i++){
			char temp = word[i];
			word[i] = word[word.length - i - 1];
			word[word.length - i - 1] = temp;
		}
	}
	
	public void print(){ //prints word to screen --used for debugging
		int length = word.length;
		for(int i = 0; i < length; i++){
			System.out.print(word[i]);
		}
	}

}
