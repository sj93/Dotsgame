package Game;

import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		System.out.println("start");
		boolean start =true;
		while (true){
		Dots_and_Boxes db = new Dots_and_Boxes ();
		Points_et_Boites2 pt = new Points_et_Boites2();
		 if(db.mode()==0){
			//db.adversairy();
				db.size();
				//db.lignepointille();
				db.ID();
				db.affichepoint();
				db.turn();
				

				System.out.println("restart?  0 for yes; 1 for no");
				 Scanner scan = new Scanner(System.in);
				 int r = scan.nextInt();
				 if(r==1){
					 System.out.println("gameOver");
					 start =false;
				 }
				 if(r==0){
					 System.out.println("restart");	
					 start = true;
					}
				  
		 }if(db.mode()==1){
			pt.size();
			pt.point();
			pt.ligne();
		  }
		
	
		} 

	}

}
