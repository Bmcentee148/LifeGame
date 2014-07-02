import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.nio.charset.Charset;
class Life{

	public static void main(String [] args){
		
		String fileName = "";
		char currChar;
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

		CellGrid gameGrid = new CellGrid(initArray);
		gameGrid.displayGrid();

	}

	public static Cell[][] readFile(String fileName) throws IOException{
		Cell[][] initArray;
		File file = new File(fileName);
		String tempLine;
		char currChar;

		Scanner inputFile = new Scanner(file);

		int numGens, numRows, numCols;

		numGens = inputFile.nextInt();
		numRows = inputFile.nextInt();
		numCols = inputFile.nextInt();
		inputFile.nextLine();
		initArray = new Cell[numRows][numCols];
		
			
		for(int i = 0; i < numRows; i++){
			tempLine = inputFile.nextLine();
			for (int j = 0; j< numCols; j++){
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