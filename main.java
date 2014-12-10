package project;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Main m = new Main();
		m.run();
	}
	public void run() {
		Scanner keyboard = new Scanner(System.in);
		int option1;
		int option2;
		Word word = new Word();
		String wordbank = ("\n");
		System.out.println("Welcome to the CR2 Word Search Generator. \n");
		
		do{
			System.out.println("Would you like to:");
			System.out.println("1) generate a word search with default values (15x15 grid)");
			System.out.println("2) generate a word search with custom values");
			System.out.print("enter your option (1 or 2): ");
			option1 = keyboard.nextInt();
			if(option1 != 1 && option1 != 2){
				System.out.println("The number you entered does not correspond with the prompt.");
				System.out.println("Please enter either a 1 or a 2. \n");
			}
		}while(option1 != 1 && option1 != 2);
		
		Array array = new Array(15, 15);
		if(option1 == 1){
			System.out.println("Grid size has been set to 15x15."); //sets grid size to 15x15
		}
		else if(option1 == 2){
			array = option1(array, keyboard); //sets grid size to user input
		}
				
		do{
			System.out.println("\nWould you like to:");
			System.out.println("1) enter words to fill the word search manually");
			System.out.println("2) enter words from a text file");
			System.out.print("enter your option (1 or 2): ");
			option2 = keyboard.nextInt();
			if(option2 != 1 && option2 != 2){
				System.out.println("The number you entered does not correspond with the prompt.");
				System.out.println("Please enter either a 1 or a 2. \n");
			}
		}while(option2 != 1 && option2 != 2);
		
		if(option2 == 1){
			option2Choice1(array, word, wordbank, keyboard); //inserts words into the grid from user input
		}
		else if(option2 == 2){
			option2Choice2(array, word, wordbank); //inserts words into the grid from a predefined text file
		}
		
		keyboard.close();
	}
	private Array option1(Array array, Scanner keyboard){ //sets grid size to user input
		int size;
		do{

			System.out.print("Enter the desired size of your grid (n x n): ");
			
			size = keyboard.nextInt();
			if(size < 5){
				System.out.println("The minumum size you can have is 5. \n");
			}
			if(size > 100){
				System.out.println("The maximum size you can have is 100. \n");
			}
			
		}while(size < 5 || size > 100);

		array = new Array(size, size);
		return array;
	}
	private void option2Choice1(Array array, Word word, String wordbank, Scanner keyboard){ //inserts words into the grid from user input
		int number = -1;
		String input;
		char[] temp;
		do{
			System.out.print("Enter number of words you would like to enter: ");
				number = keyboard .nextInt();
			if(number > array.getFirstDimension()){
				System.out.println("Too many words for this size grid.");
				System.out.println("The maximum amount of words for this size is " + array.getFirstDimension());
			}
			else if(number <= 0){
				System.out.println("You need at least one word.");
			}
		}while(number > array.getFirstDimension() || number <= 0);
		System.out.println("*IT IS PREFFERABLE THAT THE WORDS ENTERED ARE IN ALL CAPITAL LETTERS*");
		for(int i = 0; i < number; i++ ){
			System.out.print("Enter word: ");
			input = keyboard.next();
			temp = input.toCharArray();
			if(temp.length > array.getFirstDimension()){
				System.out.println("Word entered exceeds grid length and cannot fit.");
				System.out.println("This word will not be placed into the search.");
			}
			else
			{
				word.setWord(temp);
				word.fill(array);
				wordbank = wordbank + "\n" + input;
			}
		}
		array.randomFill();
		array.printArrayToFile();
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Connor Irwin/workspace/project/src/project/output.txt", true)))) {
		    out.print("\n\nWordbank: ");
			out.print(wordbank);
		}catch (IOException e) {
		}
		System.out.println("\nYour word search has been printed to output.txt.");
	}
	private void option2Choice2(Array array, Word word, String wordbank){ //inserts words into the grid from a predefined text file
		try{
			File file = new File("C:/Users/Connor Irwin/workspace/project/src/project/input.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int i = 0;
			while((line = bufferedReader.readLine()) != null){
				if(line.length() > array.getFirstDimension()){
					System.out.println("The word " + line + " is to big and will not fit in this size wordsearch.");
					System.out.println(line + " will be not be used.");
				}
				else{
					char[] input = line.toCharArray();
					word.setWord(input);
					word.fill(array);
					wordbank = wordbank + "\n" + line;
					i++;
					if(i == array.getFirstDimension()){
						System.out.println("There are more words in the text file than words that can be used.");
						System.out.println(i + " words were used.");
						break;
					}
				}
			}
			fileReader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		array.randomFill();
		array.printArrayToFile();
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Connor Irwin/workspace/project/src/project/output.txt", true)))) {
		    out.print("\n\nWordbank: ");
			out.print(wordbank);
		}catch (IOException e) {
		}
		System.out.println("\nYour word search has been printed to output.txt.");
	}

}
