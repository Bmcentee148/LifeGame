import java.util.*;
import java.io.*;
import java.util.Scanner;

class Life{

	public static void main(String [] args){
		String fileName = "";

		if(args.length != 0){
			fileName = args[0];
		}
		else{
			System.err.println("No command line arguments");
			System.exit(1);
		}

		try{
			File file = new File(fileName);
			Scanner inputFile = new Scanner(file);
		}
		catch(FileNotFoundException e){
			System.out.println(e.toString());
		}
		
	}
}