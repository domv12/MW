package gameOfLife;
import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameGui extends JPanel implements MouseListener{ 
	
    public static final int[] COLORS = new int[] {
        0xFFFFFF, 0x000000
    };

    private int width = 10;
    private int height = 10;
    private int rows = 50;
    private int cols = 50;
    private float strokeWidth = 2.0f;
    private Area area;
    

   

    public GameGui() {
        setPreferredSize(new Dimension(width*rows+20, height*cols+40));
        setLayout(null);
        
        area = new Area(rows,cols);
        /*
        area.gameArea[25][26].setState(1);
        area.gameArea[25][25].setState(1);
        area.gameArea[25][27].setState(1);
        area.gameArea[23][28].setState(1);
        area.gameArea[24][28].setState(1);
        */
        /*
        area.gameArea[10][11].setState(1);
        area.gameArea[11][13].setState(1);
        area.gameArea[12][14].setState(1);
        area.gameArea[12][15].setState(1);
        area.gameArea[12][16].setState(1);
        area.gameArea[12][10].setState(1);
        area.gameArea[12][11].setState(1);
        */
        //area.gameArea[16][17].setState(1);

        
        JButton btnCalculate = new JButton("RUN");
        btnCalculate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	
        		 Runnable t1 = new Runnable() {
        	           public void run() {
        	       		while(true){
        	        	   repaint();
                		
                		for(int i=1;i<rows-1;i++){
                			for(int j=1;j<cols-1;j++){
                		Cell tab[]={
                				area.gameArea[i-1][j-1],
                				area.gameArea[i-1][j],
                				area.gameArea[i-1][j+1],
                				area.gameArea[i][j-1],
                				area.gameArea[i][j+1],
                				area.gameArea[i+1][j-1],
                				area.gameArea[i+1][j],
                				area.gameArea[i+1][j+1]
                		};
                		area.Moore(tab, area.gameArea[i][j]);
                			}
                		}
                		
                		for(int i=0;i<rows;i++){
                			for(int j=0;j<cols;j++){
                				area.gameArea[i][j].setState(area.gameArea[i][j].getNewState()); 
                			}
                		}
                		repaint();
        	       		try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        	       		}
        	           }
        	        };
        	        new Thread(t1).start();
        	}
        });
        btnCalculate.setBounds((width*rows)/2-30, height*cols+15, 80, 20);
        add(btnCalculate);
        
        addMouseListener(this);
        }

    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	Stroke stroke = new BasicStroke(strokeWidth,
                BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER);
        ((Graphics2D)g).setStroke(stroke);

        // Fill in background.
        g.setColor(new Color(0xF6F6F6));
        g.fillRect(0, 0,width*rows, height*cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x =  width*col;
                int y = height*row;
                int color = 0;
              
                if(area.gameArea[row][col].getState()==1){
                	color=1;
                }
                g.setColor(new Color(COLORS[color]));
                g.fillRect(10+x, 10+y, width, height); 
               // g.setColor(new Color(0xE7E7E7));
                g.drawRect(10+x, 10+y, width, height);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new GameGui();

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		System.out.println(position.x/10+" "+position.y/10);
		if(position.x/10>=1&&position.y/10>=1&&position.x/10<=50&&position.y/10<=50){
		area.gameArea[(position.y/10)-1][(position.x/10)-1].setState(1);
		}
		
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}