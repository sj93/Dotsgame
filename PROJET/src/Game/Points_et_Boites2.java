package Game;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class Points_et_Boites2 {
	static String [][]tableau; 
	static int i;
	static int[]score = new int [2];
	
	Points_et_Boites2(){}

// ID de joueur 
	public static void IDplayer(){
		 StdDraw.text(7,15,"score player 1:");		 
		 StdDraw.text(7,14,"score player 2:");
		
	}

//score
	public static int[]mark(){
	 int[]s=new int[2];
	 s[0]=0;
	 s[1]=0;
	 score = s;
	 return s;
	}

	 public static void afficherscore(int[]score){
		 String str1 = Integer.toString(score[0]);
		 String str2 = Integer.toString(score[1]);
		 StdDraw.text(10,15,"str1");		 
		 StdDraw.text(10,14,"str2");
	 }
	 

//	la taille du jeu
	 public static int size(){
		 Scanner scan = new Scanner(System.in);
		 int s;
		 System.out.print("please chose the size");
		 s = scan.nextInt();
		 i=s;
		 while(s<3 || s>6){
			 System.out.print("the number should be between 3 and 6 ");
			 System.out.print("please chose again the size");
			 s = scan.nextInt();
		 }
		 return s;
	 }

	 
// affiche les points
	public static void	point(){
		StdDraw.setXscale(-10,20);
	    StdDraw.setYscale(-10,20);
	    StdDraw.text(2,18,"Dots_and_Boxes");
		for(int l=0;l<i*2;l=l+2){
			for(int c=0;c<i*2;c=c+2){
				StdDraw.setPenColor(StdDraw.BLACK);
				 StdDraw.filledCircle(l, c, 0.5);				 
			}			
		}
	}

	
	// afficher les points	 
				public static String[][] affichepoint(){
					int v =1;
					int v1=1;			 
					String[][]tab = new String [i*2][i*2];	
					for(int l=0;l<i*2-1;l++){
						for(int j=0;j<i*2-1;j++){ 						 
							    if(l%2==0 && j%2==0){
									 tab[l][j]="+"; 
								}if(l%2==0 && j%2==1){
									 tab[l][j]=" ";
								}if(l%2==1 && j%2==0){
									 tab[l][j]=" ";
								 }
						 }
					}	tableau = tab;
						return tab;	
				}

				
//ligne				
	public static void ligne(){
		while(true){ 
			if(StdDraw.mousePressed()) { 
				int	x1 =(int) StdDraw.mouseX();
				int y1 = (int) StdDraw.mouseY();			
				if(x1<i*2-1 && x1>=0 && y1<i*2-1 && y1>=0){
					if(x1%2==0 && y1%2==1){
						StdDraw.setPenColor(StdDraw.RED);
						StdDraw.line(x1,y1-0.5,x1,y1+0.5);
						
					    }if(x1%2==1 && y1%2==0){
							tableau[x1][y1]="*";
							StdDraw.setPenColor(StdDraw.RED);
							StdDraw.line(x1-0.5,y1,x1+0.5,y1);
						  }
				   }
			}
		}
	}
				
// affiche les lignes	
	public static void ligne(boolean res){
		while(true){ 
			if(StdDraw.mousePressed()) { 
				int	x1 =(int) StdDraw.mouseX();
				int y1 = (int) StdDraw.mouseY();
				if(x1<i*2-1 && x1>=0 && y1<i*2-1 && y1>=0){
					if(x1%2==0 && y1%2==1){
						tableau[x1][y1]="*";			
						StdDraw.setPenColor(StdDraw.RED);
						StdDraw.line(x1,y1-0.5,x1,y1+0.5);
						if(tableau[x1-1][y1-1].equals("*") && tableau[x1-2][y1].equals("*") && tableau[x1-1][y1+1].equals("*")){
							if(res==true){
								tableau[x1-1][y1]="1";
								StdDraw.text(x1-1,y1,"1");
								score[0]++;
							}else{
								tableau[x1-1][y1]="2";
								StdDraw.text(x1-1,y1,"2");
								score[1]++;
							 }
							}if(tableau[x1+1][y1-1].equals("*") && tableau[x1+2][y1].equals("*") && tableau[x1+1][y1+1].equals("*")){
								if(res==true){
									tableau[x1+1][y1]="1";
									StdDraw.text(x1-1,y1,"1");
									score[0]++;									
								}else{
									tableau[x1+1][y1]="2";
									StdDraw.text(x1-1,y1,"2");
									score[1]++;
    							}
							 }
					}if(x1%2==1 && y1%2==0){
						tableau[x1][y1]="*";
						StdDraw.setPenColor(StdDraw.RED);
						StdDraw.line(x1-0.5,y1,x1+0.5,y1);
						if(tableau[x1-1][y1-1].equals("*") && tableau[x1][y1-2].equals("*") && tableau[x1+1][y1-1].equals("*")){
							if(res==true){
								tableau[x1][y1-1]="1";
								StdDraw.text(x1,y1-1,"1");
								score[0]++;
							}else{
								tableau[x1][y1-1]="2";
								StdDraw.text(x1,y1-1,"2");
								score[1]++;
							 }
						}if(tableau[x1-1][y1+1].equals("*") && tableau[x1][y1-2].equals("*") && tableau[x1+1][y1+1].equals("*")){
								if(res==true){
									tableau[x1][y1+1]="1";
									StdDraw.text(x1,y1+1,"1");
									score[0]++;									
								}else{
									tableau[x1][y1+1]="2";
									StdDraw.text(x1,y1+1,"2");
									score[1]++;
    							 }
						  }
					}
				 }		
			 }					
		 }						
      }
	 
// tour de joueur
	public static void turn1(){
		int n=0;
		while(n<2*(i-1)*i){			
			if(n%2==0){
				StdDraw.text(-6,n,"player 1 plays");
				ligne();
			}if(n%2==1){
				StdDraw.text(-6,n,"player 2 plays");
				ligne();
			}
		}
	}	
	public static void turn(){
		int n=0;
		boolean res;
		res=true;
		StdDraw.text(-6,n,"player 1 plays");
		ligne(res);
	 do {  if(n%2==0){
				res=true;
				StdDraw.text(-6,n,"player 1 plays");
				ligne(res);
				
			}if(n%2==1){
				res=false;
				StdDraw.text(-6,n,"player 2 plays");
				ligne(res);
				
			 }n++;
	 				
	 }	while(n<2*(i-1)*i);	if(score[0]<score[1]){
			 StdDraw.text(3,10,"the winner is player 2");
		 }if(score[0]==score[1]){
			  StdDraw.text(3,11,"equality");
		  }if(score[0]>score[1]){
			  StdDraw.text(3,12,"the winner is player 1");
			}
	}
	
	
	public static void main(String[] args) {
	    size();
	    point();
	    affichepoint();
	    IDplayer();
	   // ligne();
	//    turn();
	    turn1();
	    
	 }
}
