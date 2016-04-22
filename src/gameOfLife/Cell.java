package gameOfLife;

public class Cell {

	private int state;
	private int newState;
	
	Cell(){
		state=0;
		newState=0;
	}

	public int getNewState() {
		return newState;
	}

	public void setNewState(int newState) {
		if(state==0||state==1){
			this.newState = newState;
			}else{
				System.out.println("ERROR WRONG STATE!");
			}
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		if(state==0||state==1){
		this.state = state;
		}else{
			System.out.println("ERROR WRONG STATE!");
		}
	}
	
	
	
}
