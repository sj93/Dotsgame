package Game;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class Dots_and_Boxes {
	 static String [][]tableau; 
	 static int i;//pour la taille
	 static int p;//pour nombre de ligne pointillée
	 static String[] player= new String[2];
     static int mode;
     static int[]score = new int [2];
     static int sp1=0;
     
   Dots_and_Boxes(){}

 // choisir le mode de jeux;
	 public static int mode(){
		 System.out.print("chose the type: console ou graphic, 0 for console, 1 for graphic ");
		 Scanner scan = new Scanner(System.in);
		 int m = scan.nextInt();
		 if(m==0){ 
			 System.out.println(" you chose the console mode ");
	     }if(m==1){
	    	 System.out.println(" you chose the graphic mode ");
	     }mode =m;
		return m;
			 
		 
	 }
	 
// choisir contre joueur ou ordinateur
	 public static void adversairy(){
		 System.out.println("VS player(enter the number 0) or VS computer(enter 1)");
		 Scanner scan = new Scanner(System.in);
		 int a = scan.nextInt();
		 if(a==0){
			 System.out.println("VS player");
			 }
		 if(a==1){
			 System.out.println("VS computer");
			 }
	 }
	 
 // ID des joueurs
	 public static String[]ID(){
		 String []joueur = new String[2];
		 joueur[0]="player1";
		 joueur[1]="player2";
		 player=joueur;
		 return joueur;
	 }
	 
// score
	 public static int[]mark(){
		 int[]s=new int[2];
		 s[0]=0;
		 s[1]=0;
		 score = s;
		 return s;
	 }
	 
	 public static void afficherscore(int[]score){
		 System.out.println("score for player 1 is "+score[0]);
		 System.out.println("score for player 2 is "+score[1]);
	 }
	 
// choix de la taille
	 public static int size(){
		 Scanner scan = new Scanner(System.in);
		 int s;
		 System.out.print("please chose the size");
		 s = scan.nextInt();
		 while(s<3 || s>6){
			 System.out.print("the number should be between 3 and 6 ");
			 System.out.print("please chose again the size");
			 s = scan.nextInt();
		 }
		 i=s;
		 return s;
	 }

// afficher les points	 
		public static String[][] affichepoint(){
			int v =1;
			int v1=1;			 
			String[][]tab = new String [i*2][i*2];	
			for(int l=0;l<i*2;l=l+1){
				for(int j=0;j<i*2;j=j+1){ 					
					if(l==0 && j==0){ tab[0][0]="c ";						
						 System.out.print(tab[0][0]);
					}if(l==0 && j%2==1 ){
						String str1 = Integer.toString(v);		
					    tab[l][j]=str1;
						v++;
						System.out.print(tab[l][j]);
					  }if(j==0 && l%2==1){
						  String str2 = Integer.toString(v1);		
						  tab[l][0]=str2;
						  v1++;
						  System.out.print(tab[l][0]+" ");							 
					    }if(l%2==1 && j%2==1){
							 tab[l][j]="+"; 
							 System.out.print(tab[l][j]);
						}if(i!=0&& l%2==0 && j%2==1){
							 tab[l][j]="   ";
							 System.out.print(tab[l][j]);
						}if(j!=0 && l%2==1 && j%2==0){
							 tab[l][j]="   ";
							 System.out.print(tab[l][j]);
						 }
				 } System.out.println();
			}		tableau = tab;
					 return tab;	
		}
		
	public static void affichertab(String[][]tab){
		for(int l=0;l<tab.length;l++){
			for(int c=0; c<tab.length;c++){
				if(tab[l][c]==null){tab[l][c]=" ";}
				System.out.print(tab[l][c]);
			}System.out.println();
		}		
	}
			
// afficher les lignepleines	
		
	public static void lignes(boolean res){
		Scanner scan = new Scanner(System.in);
		int x1,y1,x2,y2;		
		System.out.println("draw the line between two points");
		System.out.println("first point's coordinate (x1,y1)");		
		System.out.println("\n"+"x1");
		x1 = scan.nextInt();
		while(x1>i || x1<=0){
		    System.out.println("this number doesnt't exist,please chose another one"+"\n"+"x1");
			x1 = scan.nextInt();
		}
		System.out.println("y1");
		y1 = scan.nextInt();
		while(y1>i || y1<=0){
		   System.out.println("this number doesnt't exist,please chose another one"+"\n"+"y1");
		    y1 = scan.nextInt();
		}
		System.out.println("second point's coordinate (x2,y2)");		
		System.out.println("x2");
		 x2 = scan.nextInt();
		while( x2>i || x2<=0){
			System.out.println("this number doesnt't exist,please chose another one"+"\n"+"x2");
			 x2 = scan.nextInt();
		}
		System.out.println("y2");
		y2 = scan.nextInt();
		while( y2>i || y2<=0){
			System.out.println("this number doesnt't exist,please chose another one"+"\n"+"y2");
			y2 = scan.nextInt();
		 }
		while(x1+y1+1!=x2+y2){
			if(x2+y2+1==x1+y1){
				int temp1 =x1;
				x1=x2;
				x2=temp1;
				int temp2=y1;
				y1=y2;
				y2=temp2;
			}else{
				System.out.println("please enter two points consecutives");
				System.out.println("x2");
				x2 = scan.nextInt();
				System.out.println("y2");
				y2 = scan.nextInt();
				while(x2>i || x2<=0){
					System.out.println("x2");
					x2 = scan.nextInt();
				}while(y2>i || y2<=0){
					System.out.println("y2");
					y2 = scan.nextInt();
				}
			}			
		}if(x1==x2){
				tableau[2*x1-1][y1*2]="__";
				if(x1<i && tableau[2*x1][y1*2-1].equals("|") && tableau[2*x1+1][y1*2].equals("__") && tableau[2*x1][y1*2+1].equals("|")){
					if(res==true){
						tableau[2*x1][y1*2]="1 ";score[0]++;
					}else{
						tableau[2*x1][y1*2]="2 ";score[1]++;
					}
				}if(x1<=i && tableau[2*x1-2][y1*2-1].equals("|") && tableau[2*x1-3][y1*2].equals("__") && tableau[2*x1-2][y1*2+1].equals("|")){
					if(res==true){
						tableau[2*x1-2][y1*2]="1 "; score[0]++;
					}else{
						tableau[2*x1-2][y1*2]="2 "; score[1]++;
					}
				}
				
		}if(y1==y2){
			tableau[x1*2][y1*2-1]="|"; 
			if(tableau[2*x1-2][y1*2+1].equals("__") && tableau[2*x1][y1*2+1].equals("__") && tableau[2*x1-1][y1*2+2].equals("|")){
				if(res==true){
					tableau[2*x1-1][y1*2+1]="1";score[0]++;
				}else{
					tableau[2*x1-1][y1*2+1]="2"; score[1]++;
				}
			}if(tableau[2*x1-2][y1*2-1].equals("__") && tableau[2*x1][y1*2-1].equals("__") && tableau[2*x1-1][y1*2-2].equals("|")){
				if(res==true){
					tableau[2*x1-1][y1*2+1]="1";score[0]++;
				}else{
					tableau[2*x1-1][y1*2+1]="2"; score[1]++;
				}
			}
		} affichertab(tableau);
	      afficherscore(score);
	}
		
					 
		
// afficher les lignes en pointillées
		
	/*	public static void lignepointille(){
			 int l;
			 System.out.print("please chose a  number for dottedline");
			 Scanner scan = new Scanner(System.in);
			 l = scan.nextInt();
			// p=l;
			 while(l>2*(i-1)*i){
				 System.out.print(" the  number should be under"+2*(i-1)*i);
				 System.out.print("please chose the  number for dottedline");
				 l = scan.nextInt();				
			 } int n=0; 
			
			  while(n<l){
				   int ligne = (int)(Math.random() * (i*2-1))+1 ; 
				   int colonne= (int)Math.floor(Math.random() * (i))+1 ; 
				   while( tableau[ligne][colonne]!=""){
				        ligne = (int)Math.floor(Math.random() * (i))+1 ; 				  
				        colonne= (int)Math.floor(Math.random() * (i))+1 ;
				   } 
					    if(ligne%2==1 && colonne%2==0){
					    	tableau[ligne][colonne]="--";
					    }if(ligne%2==0 && colonne%2==1){
						   tableau[ligne][colonne]=":";
					      }  
				 
			}affichertab(tableau);
			
		}
*/
	

	
	
//le tour de joueur	
	public static void turn(){
		int n=0;
		boolean res;
		while(n<2*(i-1)*i){
			if(n==0 || n%2==0){
				res=true;
				System.out.println( player[0]+" plays");
				System.out.println();
				lignes(res);
			}if(n!=0 && n%2==1){
				res=false;
				System.out.println();
				System.out.println(player[1]+ " plays");
				lignes(res);
			  }n++;			
		}while(n==2*(i-1)*i){
			if(score[0]+score[1]==(i-1)*(i-1)){
				if(score[0]<score[1]){
					System.out.println("the winner is"+player[1]);
				}
				if(score[0]==score[1]){
					System.out.println("equality, no winner");
				}
				if(score[0]>score[1]){
					System.out.println("the winner is"+player[0]);
				}
			}
		}
	}	
	

	
	
	public static void main(String[] args) {
	    mode();
		//adversairy();
		size();
		//lignepointille();
		ID();
		affichepoint();
		turn();
		

		System.out.println("restart?  0 for yes; 1 for no");
		 Scanner scan = new Scanner(System.in);
		 int r = scan.nextInt();
		 if(r==1){
			 System.out.println("gameOver");
			 }
		 if(r==0){
			 System.out.println("restart");	
			mode();
			//adversairy();
			size();
			//lignepointille();
				ID();
				affichepoint();
				turn();
		 } 
		
	   
	}

}
