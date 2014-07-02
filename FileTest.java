import java.util.Scanner;
import java.io.*;

class FileTest{

	public static void main(String [] args) throws IOException{

		readFile("SampleInput.txt");

	}
	public static void readFile(String fileName) throws IOException{
		Cell[][] initArray;
		File file = new File(fileName);
		String tempLine;
		char currChar;
		// BufferedReader reader = new BufferedReader(
		// 	new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
		Scanner inputFile = new Scanner(file);

		int numGens, numRows, numCols;

		numGens = inputFile.nextInt();
		numRows = inputFile.nextInt();
		numCols = inputFile.nextInt();
		inputFile.nextLine();
		System.out.println(numGens + " " + numRows + " " + numCols);
		initArray = new Cell[numRows][numCols];
		while(inputFile.hasNext()){
			
			for(int i = 0; i < numRows; i++){
				tempLine = inputFile.nextLine();
				System.out.println(tempLine);
				// for (int j = 0; j< numCols; j++){
				// 	Cell newCell = new Cell();
				// 	initArray[i][j] = newCell;
				// 	currChar = tempLine.charAt(1);
				// 	String charString = Character.toString(currChar);
				// 	if(charString.equals("#")){
				// 		initArray[i][j].setStatus(true);
				// 	}
				// 	else{
				// 		initArray[i][j].setStatus(false);
				// 	}
				// }
			}
		}
		//return initArray;
	}
}