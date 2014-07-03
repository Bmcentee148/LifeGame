class CellGrid{

	private Cell [][] cellArray;

	public CellGrid(Cell [][] cellArray){
		this.setGrid(cellArray);
	}

    public CellGrid(CellGrid copyGrid){
        this.setGrid(copyGrid.getCellArray());
    }

	private void setGrid(Cell [][] cellArray){
		this.cellArray = new Cell [cellArray.length][cellArray[0].length];
		for(int i = 0; i< cellArray.length; i++){
			for(int j = 0; j < cellArray[i].length; j++){
				this.cellArray[i][j] = new Cell(cellArray[i][j]);
			}
		} 
	}

    private Cell [][] getCellArray(){
        return cellArray;
    }


    public int getNeighbors(int currRow, int currCol){
        
        
        int tp = -1, bt = -1 , lf = -1, rt = -1;
        
        if(currRow == 0) tp = cellArray.length-1;
        else if(currRow == cellArray.length - 1) bt = 0;
        if(currCol == cellArray[0].length - 1) rt = 0;
        else if(currCol == 0) lf = cellArray[0].length - 1;
        
        if(tp == -1) tp = currRow - 1;
        if(bt == -1) bt = currRow + 1;
        if(rt == -1) rt = currCol + 1;
        if(lf == -1) lf = currCol -1;
        
        int numNeighbors = 0;
        if(cellArray[tp][currCol].getStatus() == true)
        	numNeighbors += 1;
        if(cellArray[bt][currCol].getStatus() == true)
        	numNeighbors += 1;
        if(cellArray[currRow][rt].getStatus() == true)
        	numNeighbors += 1;
        if(cellArray[currRow][lf].getStatus() == true)
        	numNeighbors += 1;
        if(cellArray[tp][lf].getStatus() == true)
        	numNeighbors += 1;
        if(cellArray[bt][lf].getStatus() == true)
        	numNeighbors += 1;
        if(cellArray[tp][rt].getStatus() == true)
        	numNeighbors += 1;
        if(cellArray[bt][rt].getStatus() == true)
        	numNeighbors += 1;
        
        return numNeighbors;

    }

    public void displayGrid(){
		for(int i = 0; i< cellArray.length; i++){
			if(i != 0) System.out.println("");
			for(int j = 0; j< cellArray[i].length; j++){
				cellArray[i][j].display();
			}
		}
	}

    public void displayGrid2(){
        for(int i = 0; i< cellArray.length; i++){
            if(i != 0) System.out.println("");
            for(int j = 0; j< cellArray[i].length; j++){
                System.out.print(this.getNeighbors(i,j));
            }
        }
    }

    public void update(CellGrid prevState){
        Cell [][] prevStateArray = prevState.getCellArray();
        for(int i = 0; i< prevStateArray.length; i++){
            for(int j = 0; j< prevStateArray[i].length; j++){
                cellArray[i][j].changeStatus(prevState.getNeighbors(i,j));
            }
        }
        //return this;
    }
}