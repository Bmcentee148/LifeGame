class CellTest{

	public static void main(String [] args){

		//init 2 cells with diff status. checking the constr.
		Cell testCell1 = new Cell();
		Cell testCell2 = new Cell(false,0,0);

		testCell1.display();
		testCell2.display();
		System.out.println("");
		System.out.println(testCell1.getStatus());
		System.out.println(testCell2.getStatus());

		testCell1.changeStatus(6);
		testCell2.changeStatus(2);

		System.out.println(testCell1.getStatus());
		System.out.println(testCell2.getStatus());

		Cell[][] input = new Cell[3][3];
		input[0][0] = new Cell(false,0,0);
		input[0][1] = new Cell(true,0,1);
		input[0][2] = new Cell(false,0,2);
		input[1][0] = new Cell(true,1,0);
		input[1][1] = new Cell(true,1,1);
		input[1][2] = new Cell(true,1,2);
		input[2][0] = new Cell(true,2,0);
		input[2][1] = new Cell(true,2,1);
		input[2][2] = new Cell(true,2,2);
		CellGrid testGrid = new CellGrid(input);

		System.out.println(testGrid.getNeighbors(0,1));

		testGrid.displayGrid();


	}
	
}