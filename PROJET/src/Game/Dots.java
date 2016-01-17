package Game;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Dots extends JPanel {
	 int x;
     int y;
     int t;
  Dots(){}
	Dots(int t){this.t=t;} 
		 public void paint(Graphics g){
		   super.paint(g);
			for(int i=0;i< getT()*8;i=i+8){
			  for(int j=0;j< getT()*8;j=j+8){				 
		          g.setColor(Color.black);
			      g.fillOval(i*8,j*8,8,8);
			    	 
			  }
		    }
	   }
 int getT(){return t;}
 int setT(int t){return t;}
}
