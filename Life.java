import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.nio.charset.Charset;

class Life{
	public static int NUM_ROWS;
	public static int NUM_COLS;
	public static int NUM_GENS;

	public static void main(String [] args){
		
		String fileName = "";
		Cell [][] initArray = null;

		if(args.length != 0){
			fileName = args[0];
		}
		else{
			System.err.println("No command line arguments");
			System.exit(1);
		}

		try{
			initArray = readFile(fileName);
		}
		catch(FileNotFoundException e){
			System.out.println(e.toString());
		}
		catch(IOException e){
			System.out.println(e.toString());
		}

		
		CellGrid gameGrid_1 = new CellGrid(initArray);
		CellGrid gameGrid_2 = new CellGrid(gameGrid_1);
		

		for(int i = 2; i< NUM_GENS + 2; i++){
		
			if( i % 2 == 0 ){
				gameGrid_2.update(gameGrid_1);
				gameGrid_2.displayGrid();
				System.out.println("\n==========");
				gameGrid_2.displayGrid2();
			}
			else{
				gameGrid_1.update(gameGrid_2);
				gameGrid_1.displayGrid();
				System.out.println("\n==========");
				gameGrid_1.displayGrid2();
			}

			System.out.println("\n==========");

		}



	}

	public static Cell[][] readFile(String fileName) throws IOException{
		Cell[][] initArray;
		File file = new File(fileName);
		String tempLine;
		char currChar;

		Scanner inputFile = new Scanner(file);

		

		NUM_GENS = inputFile.nextInt();
		NUM_ROWS = inputFile.nextInt();
		NUM_COLS = inputFile.nextInt();
		inputFile.nextLine();
		initArray = new Cell[NUM_ROWS][NUM_COLS];
		
			
		for(int i = 0; i < NUM_ROWS; i++){
			tempLine = inputFile.nextLine();
			for (int j = 0; j< NUM_COLS; j++){
					Cell newCell = new Cell();
					initArray[i][j] = newCell;
					currChar = tempLine.charAt(j);
					String charString = Character.toString(currChar);
					if(charString.equals("#")){
						initArray[i][j].setStatus(true);
					}
					else{
						initArray[i][j].setStatus(false);
					}
				}
			
		}
		inputFile.close();
		return initArray;
		
	}

}