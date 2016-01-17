package Game;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class Points_et_Boites2 {
	static int i;
    static int p1=0,p2=0;
	Points_et_Boites2(){}

// ID de joueur 
	public static void IDplayer(){
		 StdDraw.text(7,15,"score player 1:");
		 StdDraw.text(7,14,"score player 2:");
	}

	
//	la taille du jeu
	 public static int size(){
		 Scanner scan = new Scanner(System.in);
		 int s;
		 System.out.print("please chose the size");
		 s = scan.nextInt();
		 i=s;
		 return s;
	 }

// affiche les points
	public static void	point(){
		StdDraw.setXscale(-10,20);
	    StdDraw.setYscale(-10,20);
	    StdDraw.text(2,18,"Dots_and_Boxes");

		for(int l=0;l<i*2;l=l+2){
			for(int c=0;c<i*2;c=c+2){
				
				 StdDraw.filledCircle(l, c, 0.5);				 
			}			
		}
	}
	
	 
// affiche les lignes	
	public static void ligne(){ 
		while(true){ 
		if(StdDraw.mousePressed()) { 
		int	x1 =(int) StdDraw.mouseX();
		int y1 = (int) StdDraw.mouseY();
		if(x1%2==0 && y1%2==1){
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(x1,y1-0.5,x1,y1+0.5);
        }if(x1%2==1 && y1%2==0){
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(x1-0.5,y1,x1+0.5,y1);
            }
       
         }  StdDraw.show();
	 }
  }
	 
// tour de joueur
	public static void turn(){
		int n=0;
		while(n<2*(i-1)*i){
			if(n%2==0){
				StdDraw.text(2,13,"player 1 plays");
				//StdDraw.clear();
				ligne();
				
			}if(n%2==1){
				StdDraw.text(2,13,"player 2 plays");
				//StdDraw.clear();
				ligne();
			  }n++;			
		}/*while(n==2*(i-1)*i){
			if(p1+p2==(i-1)*(i-1)){
				if(p1<p2){
					StdDraw.text(3,10,"the winner is player 2");
				}
				if(p1==p2){
					StdDraw.text(3,11,"equality");
				}
				if(p1>p2){
					StdDraw.text(3,12,"the winner is player 1");
				}
			}
		}*/
	}	
	public static void main(String[] args) {
		StdDraw.setXscale(-10,20);
	    StdDraw.setYscale(-10,20);
	    StdDraw.text(2,18,"Dots_and_Boxes");
	    IDplayer();
	    size();
	    point();
	  //  ligne();
	    turn();
	    
	 }
}
