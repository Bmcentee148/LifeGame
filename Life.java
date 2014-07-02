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
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
			Scanner inputFile = new Scanner(file);

			int numGens, numRows, numCols;

			while(inputFile.hasNext()){
				numGens = inputFile.nextInt();
				numRows = inputFile.nextInt();
				numCols = inputFile.nextInt();

				initArray = new Cell[numRows][numCols];
				for(int i = 0; i < numRows; i++){
					for (int j = 0; j< numCols; j++){
						byte temp = inputFile.nextByte();
						currChar = (char)temp;
						String charString = Character.toString(currChar);
						if(charString.equals("#")){
							initArray[i][j].setStatus(true);
						}
						else{
							initArray[i][j].setStatus(false);
						}
					}
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println(e.toString());
		}

		CellGrid gameGrid = new CellGrid(initArray);
		gameGrid.displayGrid();

	}
}