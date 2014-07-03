class Cell{

	private static boolean OFF = false;
	private static boolean ON = true;

	private boolean status;
	
	public Cell(){
		status = OFF;
	}

	public Cell(boolean initStatus){
		this.status = initStatus;
		
	}

	public Cell(Cell copyCell){
		this.status = copyCell.getStatus();
	}

	public boolean getStatus(){
		return this.status;
	}


	public void changeStatus(int numNeighbors){
		if(this.status == OFF && numNeighbors == 3){
			this.status = ON;
		}
		else if(this.status == ON && numNeighbors < 2){
			this.status = OFF;
		}
		else if(this.status == ON && numNeighbors > 3){
			this.status = OFF;
		}
	}

	public void setStatus(boolean status){
		this.status = status;
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