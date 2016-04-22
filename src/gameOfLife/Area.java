package gameOfLife;

public class Area {

	private int sizeX;
	private int sizeY;
	public Cell[][] gameArea;
	
	Area(int x,int y){
		sizeX=x;
		sizeY=y;
		
		gameArea = new Cell[x][y];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				gameArea[i][j] = new Cell();
			}
		
		}
	}
	
	public void Moore(Cell tab[],Cell active){
		try{
			int life=0;
			int death=0;
			
			for(int i=0;i<8;i++){
				if(tab[i].getState()==1){
					life++;
				}else{
					death++;
				}
			}
			if(active.getState()==0&&life==3){
				active.setNewState(1);
			}
			if(active.getState()==1&&(life==2||life==3)){
				active.setNewState(1);
			}
			if(active.getState()==1&&life>3){
				active.setNewState(0);
			}
			if(active.getState()==1&&life<2){
				active.setNewState(0);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
}
