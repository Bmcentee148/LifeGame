class Cell{

	private static boolean OFF = false;
	private static boolean ON = true;

	private boolean status;
	private int row, col;

	public Cell(boolean initStatus,int row, int col){
		this.status = initStatus;
		this.row = row;
		this.col = col;
	}

	public Cell(Cell copyCell){
		this.status = copyCell.getStatus();
	}

	public boolean getStatus(){
		return this.status;
	}


	public void changeStatus(int numNeighbors){
		if(numNeighbors < 2 || numNeighbors > 3)
			this.status = OFF;
		else if(numNeighbors == 3){
			this.status = true;
		}
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public int getRow(){
		return row;
	}

	public int getCol(){
		return col;
	}

	public void display(){
		if(this.status == OFF)
			System.out.print("-");
		else{
			System.out.print("#");
		}
	}

	@Override
	public String toString(){
		String str = "The cell is " + this.status;
		return str; 
	}
}