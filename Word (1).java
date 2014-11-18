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
		//TEMP[0] = Y
		//TEMP[1] = X
		int max1 = 2;
		int min1 = 1;
		Random rand1 = new Random();
		int random1 = rand1.nextInt((max1 - min1) + 1) + min1;
		if(random1 == 2){
			reverse();
		}
		int max2 = 4; 
		int min2 = 1; 
		Random rand2 = new Random();
		int random2 = rand2.nextInt((max2 - min2) + 2) + min2;
		random2 = 1; //TEST
		if(random2 == 1){ //horizontal
			int[] temp = new int[2];
			temp = startPoint(a);
			int temp2[] = new int[2];
			temp2 = temp;
			while(1 == 1){
				int size = temp2[1] + word.length;				
				if (word.length > a.getFirstDimension()){
					//THIS WILL TEST IF WORD IS BIGGER THAN THE FIRST DIMENSION OF THE ARRAY
				}					
				else if(size <= a.getFirstDimension()){
					if(checkHorizonal(temp2, a)){
						temp = temp2;
						break;
					}
				}
				
				temp2 = startPoint(a);
			}
			for(int i = 0; i < word.length; i++){ //places word in the array
				a.setCharAt(temp[0], temp[1] + i, word[i]);
			}
		}
		else if(random2 == 2){ //vertical
			int[] temp = new int[2];
			temp = startPoint(a);
			int temp2[] = new int[2];
			temp2 = temp;
			while(1 == 1){
				int size = temp2[1] + word.length;				
				if (word.length > a.getSecondDimension()){
					//THIS WILL TEST IF WORD IS BIGGER THAN THE FIRST DIMENSION OF THE ARRAY
				}					
				else if(size <= a.getSecondDimension()){
					temp = temp2;
					break;
				}
				
				temp2 = startPoint(a);
			}
			for(int i = 0; i < word.length; i++){ //places word in the array
				a.setCharAt(temp[0] + i, temp[1], word[i]);
			}
		}
		else if(random2 == 3){ //diagonal 1
			int[] temp = new int[2];
			temp = startPoint(a);
			int temp2[] = new int[2];
			temp2 = temp;
			int[] grid;
			while(1 == 1){
				grid = temp2;
				grid[0] += word.length;
				grid[1] += word.length;
				if (word.length > a.getSecondDimension() || word.length > a.getSecondDimension()){ //NEEDS TO BE FIXED
					//THIS WILL TEST IF WORD IS BIGGER THAN THE FIRST DIMENSION OF THE ARRAY
				}					
				else if(grid[0] <= a.getSecondDimension() && grid[1] <= a.getFirstDimension()){	//SHITS BROKEN BRUH				
					temp = temp2;
					break;
				}
				
				temp2 = startPoint(a);
			}
			for(int i = 0; i < word.length; i++){ //places word in the array
				System.out.println("Attempting to print");
				a.setCharAt(temp[0] + i, temp[1] + i, word[i]);
			}
		}
		else if(random2 == 4){ //diagonal 2
			
		}
		
	}
	
	public int[] startPoint(Array a){ //starting position for placing a word
		int max1 = a.getFirstDimension();
		int min1 = 0;
		int max2 = a.getSecondDimension();
		int min2 = 0;
		Random rand1 = new Random();
		Random rand2 = new Random();
		int random1 = rand1.nextInt((max1 - min1) + 1) + min1; //X
		int random2 = rand2.nextInt((max2 - min2) + 1) + min2; //Y
		int startPoint[] = new int[2];
		startPoint[0] = random1; //Y
		startPoint[1] = random2; //X
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
	
	public boolean checkHorizonal(int[] startpoint, Array a){
		for(int i = 0; i < word.length; i++){
			if(a.getCharAt(startpoint[1] + i, startpoint[0]) != '\0' || word[i] != a.getCharAt(startpoint[1] + i, startpoint[0])){ //OUT OF BOUNDS ERROR
				return false;
			}
		}
		return true;
	}
	
	public boolean checkVertical(int[] startpoint, Array a){
		for(int i = 0; i < word.length; i++){
			if(a.getCharAt(startpoint[1], startpoint[0] + i) != '\0' || word[i] != a.getCharAt(startpoint[1], startpoint[0] + i)){
				return false;
			}
		}
		return true;
	}

}
