package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Points_et_Boites extends JFrame  {
	
	public Points_et_Boites(){
		JLabel lab = new JLabel("Dots and Boxes ");
		JPanel setPan1= new JPanel();
		setPan1.add(lab);
		lab.setFont(new Font("Dots and Boxes",Font.BOLD,30));
		setTitle("Points_et_Boites"); 
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
		
		Dots dots = new Dots();
		JPanel setPan= new JPanel();
		TextArea area = new TextArea(1,10);
		
		
		
	    ButtonGroup bg1 = new ButtonGroup(); 
		JLabel lab1 = new JLabel("chose your adversary ");
		setPan.add(lab1);
	    JRadioButton select1= new JRadioButton("Player");
		//select1.addItemListener((ItemListener) PlayerListener);
	    select1.addItemListener(new ItemListener (){ 	
	    	public void itemStateChanged(ItemEvent ie) {
	    		if(select1.isSelected()){	    			
	    			  area.append("you  vs" + "player"); }
	    		}
	    	});
	    setPan.add(select1);
	    bg1.add(select1);
		JRadioButton select2= new JRadioButton("Computer");
		select2.addItemListener(new ItemListener(){    	
				public void itemStateChanged(ItemEvent ie) {
    		if(select2.isSelected()){    			
  			  area.append("you  vs" + "computer"); }
  		}
  	});
		setPan.add(select2);
		bg1.add(select2);
		
		ButtonGroup bg2 = new ButtonGroup(); 	
		JLabel lab2 = new JLabel("chose the size");
		setPan.add(lab2);
		JRadioButton select3= new JRadioButton("3*3");
		select3.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie) {
	    		if(select3.isSelected()){    			
	  			  area.append("you chose" + "3*3");
	  			 
	  			Dots dot = new Dots(3);
				add(dot,BorderLayout.CENTER); 
				setVisible(true);
	  			  }
	  		}
		
		});	
		setPan.add(select3);
		bg2.add(select3);
		
		JRadioButton select4= new JRadioButton("4*4");
		select4.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent ie) {
    		if(select4.isSelected()){    			
  			  area.append("you chose" + "4*4");			 
  			Dots dot = new Dots(4);
			add(dot,BorderLayout.CENTER); 
			setVisible(true);
  			  }
  		}
		});	
		setPan.add(select4);
		bg2.add(select4);
		
		JRadioButton select5= new JRadioButton("5*5");
   	select5.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent ie) {
    		if(select5.isSelected()){    			
  			  area.append("you chose" + "5*5");			 
  			Dots dot = new Dots(5);
			add(dot,BorderLayout.CENTER); 
			setVisible(true);
  			  }
  		}
	});			
		setPan.add(select5);
		bg2.add(select5);
	
		JRadioButton select6= new JRadioButton("6*6");
		select6.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie) {
	    		if(select6.isSelected()){    			
	  			  area.append("you chose" + "6*6");			 
	  			Dots dot = new Dots(6);
				add(dot,BorderLayout.CENTER); 
				setVisible(true);
	  			  }
	  		}
			});			
		setPan.add(select6);
		bg2.add(select6);
	
		ButtonGroup bg3 = new ButtonGroup();
		JLabel lab3 = new JLabel("chose the type");
		setPan.add(lab3); 
        JCheckBox select7= new JCheckBox("console");
        select7.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent ie) {
        		if(select7.isSelected()){
        			  area.append("you chose" + "console");	
        		}
        	}
        	});
	    setPan.add(select7);
	    bg3.add(select7);
	   
	    JCheckBox select8= new JCheckBox("graphic",true);
        select8.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent ie) {
        		if(select8.isSelected()){
        			  area.append("you chose" + "graphic");	
        		}
        	}
        	});
	    setPan.add(select8);
	    bg3.add(select8);
        
		JButton start= new JButton("start");
	    start.addActionListener(new StartListener());               				
		setPan.add(start);
		JButton restart= new JButton("restart");
		restart.addActionListener(new RestartListener()); 
	    setPan. add(restart);     
	      
          
	      setPan.add( area);
		  
	      add(setPan1,BorderLayout.NORTH); 
          add(setPan,BorderLayout.EAST);
      //   add(dots,BorderLayout.CENTER); 
         setPan.setLayout(new BoxLayout(setPan,BoxLayout.Y_AXIS)); 
         setVisible(true);

	
	    }


	public static void main(String[] args) {
	 Points_et_Boites pb = new  Points_et_Boites ();
	  pb.show();
	  
	}
	    

public	class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			System.out.print("start"); 
	}
}
public	class RestartListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			System.out.print("restart"); 
	}
}
	

  
  
   }
