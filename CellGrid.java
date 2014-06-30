class CellGrid{

	private Cell [][] gameGrid;

	public CellGrid(){
		gameGrid = new Cell[10][10];
	}

	public CellGrid(Cell [][] gameGrid){
		this.copyGrid(gameGrid);
	}

	public void setDimensions(int rows, int cols){
		this.gameGrid = new Cell[rows][cols];
	}

	private void copyGrid(Cell [][] gameGrid){
		this.gameGrid = new Cell [gameGrid.length][gameGrid[0].length];
		for(int i = 0; i< gameGrid.length; i++){
			for(int j = 0; j < gameGrid[i].length; j++){
				this.gameGrid[i][j] = new Cell(gameGrid[i][j]);
			}
		}
	}


    public int getNeighbors(int row, int col){
        int currRow = row;
        int currCol = col;
        
        int tp = -1, bt = -1 , lf = -1, rt = -1;
        
        if(currRow == 0) tp = gameGrid.length-1;
        else if(currRow == gameGrid.length - 1) bt = 0;
        if(currCol == gameGrid[0].length - 1) rt = 0;
        else if(currCol == 0) lf = gameGrid[0].length - 1;
        
        if(tp == -1) tp = currRow - 1;
        if(bt == -1) bt = currRow + 1;
        if(rt == -1) rt = currCol + 1;
        if(lf == -1) lf = currCol -1;
        
        int numNeighbors = 0;
        if(gameGrid[tp][currCol].getStatus() == true)
        	numNeighbors += 1;
        if(gameGrid[bt][currCol].getStatus() == true)
        	numNeighbors += 1;
        if(gameGrid[currRow][rt].getStatus() == true)
        	numNeighbors += 1;
        if(gameGrid[currRow][lf].getStatus() == true)
        	numNeighbors += 1;
        if(gameGrid[tp][lf].getStatus() == true)
        	numNeighbors += 1;
        if(gameGrid[bt][lf].getStatus() == true)
        	numNeighbors += 1;
        if(gameGrid[tp][rt].getStatus() == true)
        	numNeighbors += 1;
        if(gameGrid[bt][rt].getStatus() == true)
        	numNeighbors += 1;
        
        return numNeighbors;

    }

    public void displayGrid(){
		for(int i = 0; i< gameGrid.length; i++){
			if(i != 0) System.out.println("");
			for(int j = 0; j< gameGrid[i].length; j++){
				gameGrid[i][j].display();
			}
		}
	}
}