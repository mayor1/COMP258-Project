package project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Array {
	private char[][] array;
	
	public Array(int x, int y){ //constructor passed an x and y value
		array = new char[x][y];
	}
	
	public void setArraySize(int x, int y){ //set array size
		array = new char[x][y];
	}
	
	public void setCharAt(int x, int y, char value){ //sets given value at given position
		array[x][y] = value;
	}
	
	public char getCharAt(int x, int y){ //returns value at a given position
		return array[x][y];
	}
	
	public void copyArray(char[][] a){ //copies passed array;
		int firstDimension = a.length;
		int secondDimension = a[0].length;
		array = new char[firstDimension][secondDimension]; //sets array to passed array size
		for(int i = 0; i < firstDimension; i++){
			for(int j = 0; j < secondDimension; j++){
				array[i][j] = a[i][j];
			}
		}
	}
	
	public int getFirstDimension(){ //returns first dimension
		return array.length;
	}
	
	public int getSecondDimension(){ //returns second dimension
		return array[0].length;
	}
	
	public void randomFill(){ //fills empty spots in the array with characters A-Z
		char random;
		for(int i = 0; i < getFirstDimension(); i++){
			for(int j = 0; j < getSecondDimension(); j++){
				if(array[i][j] == '\0'){
					while(1 == 1){
						random = (char) (65 + (int) (Math.random()*90));
						if(random >= 'A' && random <= 'Z'){
							array[i][j] = random;
							break;
						}
					}
				}
			}
		}
	}
	
	public void print(){ //prints array to text file and formats it.
		File file = new File("C:/Users/Connor Irwin/workspace/project/src/project/output.txt");
		
		try (FileOutputStream fop = new FileOutputStream(file)) {
			if (!file.exists()) {
				file.createNewFile();
			}
			for(int i = 0; i < getFirstDimension(); i++){
				fop.write('\n');
				for(int j = 0; j < getSecondDimension(); j++){
					fop.write(' ');
					char content = array[i][j];	
					fop.write(content);	
				}	
			}
			fop.flush();
			fop.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
