package Game;

import java.util.Scanner;

public class PlayGame {
	  static int mode;

	 // choisir le mode de jeux;
	 public static int mode(){
		 System.out.print("choose the type: console ou graphic, 0 for console, 1 for graphic ");
		 Scanner scan = new Scanner(System.in);
		 int m = scan.nextInt();
		 if(m==0){ 
			 System.out.println(" you choose the console mode ");
	     }if(m==1){
	    	 System.out.println(" you choose the graphic mode ");
	     }mode =m;
		return m;
	 }		 
		 
	public static void main(String[] args) {
		System.out.println("start");
		boolean start =true;
		while (true){
			Dots_and_Boxes db = new Dots_and_Boxes ();
			Points_et_Boites2 pt = new Points_et_Boites2();
			db.adversairy();
			mode();
			if(mode==0){
				db.size();
				db.affichepoint();
				db.lignepointille();
				db.ID();
				db.turn();
				System.out.println("restart?  0 for yes; 1 for no");
				 Scanner scan = new Scanner(System.in);
				 int r = scan.nextInt();
				 if(r==1){
					 System.out.println("gameOver");
					 start =false;
					 break;
				 }
				 if(r==0){
					 System.out.println("restart");	
					 db.mark();
					 start = true;
					}
				  
		 }if(mode==1){
			pt.size();			
			pt.point();
			pt.affichepoint();
			pt.IDplayer();			
			//pt.ligne();
			pt.turn1();
			//pt.turn();
		  }
		
	
		} 

	}

}
