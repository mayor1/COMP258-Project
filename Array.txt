package project;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Array{
	private char[][] array;
	
	public Array(int column, int row){ //constructor passed an x and y value
		array = new char[column][row];
		for (int i=0; i < getSecondDimension(); i++) {
			for (int j=0; j < getFirstDimension(); j++) {
				array[j][i]=' ';
			}			
		}
	}
	
	public void setArraySize(int column, int row){ //set array size
		array = new char[column][row];
	}
	
	public void setCharAt(int column, int row, char value){ //sets given value at given position
		array[column][row] = value;
	}
	
	public char getCharAt(int column, int row){ //returns value at a given position
		return array[column][row];
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
		for(int i = 0; i < getSecondDimension(); i++){
			for(int j = 0; j < getFirstDimension(); j++){
				if(array[i][j] == ' '){
					while(true){
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
	
	public void printArrayToFile(){ //prints array to text file and formats it.
		File file = new File("C:/Users/Connor Irwin/workspace/project/src/project/output.txt");
		//File file = new File("Documents");
		//C:\Users\irwinc\workspace\Project\src\output
		
		try(FileOutputStream fop = new FileOutputStream(file)) {
			if (!file.exists()) {
				file.createNewFile();
			}
			for(int i = 0; i < getSecondDimension(); i++){
				fop.write('\n');
				for(int j = 0; j < getFirstDimension(); j++){
					fop.write(' ');
					char content = array[j][i];	
					fop.write(content);	
				}	
			}
			fop.flush();
			fop.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
