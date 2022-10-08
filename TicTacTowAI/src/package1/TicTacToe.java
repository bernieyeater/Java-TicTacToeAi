package package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{

		Random random = new Random();
		JFrame frame = new JFrame();
		JPanel title_panel = new JPanel();
		JPanel button_panel = new JPanel();
		JLabel textfield = new JLabel();
		JButton[] buttons = new JButton[9];
		boolean player1_turn;

		TicTacToe(){
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800,800);
			frame.getContentPane().setBackground(new Color(50,50,50));
			frame.setLayout(new BorderLayout());
			frame.setVisible(true);
			
			textfield.setBackground(new Color(25,25,25));
			textfield.setForeground(new Color(25,255,0));
			textfield.setFont(new Font("Ink Free",Font.BOLD,75));
			textfield.setHorizontalAlignment(JLabel.CENTER);
			textfield.setText("Tic-Tac-Toe AI");
			textfield.setOpaque(true);
			
			title_panel.setLayout(new BorderLayout());
			title_panel.setBounds(0,0,800,100);
			
			button_panel.setLayout(new GridLayout(3,3));
			button_panel.setBackground(new Color(150,150,150));
			
			for(int i=0;i<9;i++) {
				buttons[i] = new JButton();
				button_panel.add(buttons[i]);
				buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
				buttons[i].setFocusable(false);
				buttons[i].addActionListener(this);
			}
			
			title_panel.add(textfield);
			frame.add(title_panel,BorderLayout.NORTH);
			frame.add(button_panel);
			
			firstTurn();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			for(int i=0;i<9;i++) {
				if(e.getSource()==buttons[i]) {
					if(player1_turn) {
						if(buttons[i].getText()=="") {
							buttons[i].setForeground(new Color(255,0,0));
							buttons[i].setText("X");
							player1_turn=false;
							//textfield.setText("O turn");
							check();
						}
					}
					else {
						if(buttons[i].getText()=="") {
							buttons[i].setForeground(new Color(0,0,255));
							buttons[i].setText("O");
							player1_turn=true;
							//textfield.setText("X turn");
							xTurn();
							check();

						}
					}
				}			
			}
		}

		

		
		public void xTurn() {
			//X winning moves 
			//Horizontal Top
			xBestMove(0,"X",1,"X",2,"",2);
			xBestMove(0,"X",1,"",2,"X",1);		
			xBestMove(0,"",1,"X",2,"X",0);		
			//Horizontal Middle
			xBestMove(3,"X",4,"X",5,"",5);	
			xBestMove(3,"X",4,"",5,"X",4);	
			xBestMove(3,"",4,"X",5,"X",3);	
			//Horizontal Bottom
			xBestMove(6,"X",7,"X",8,"",8);		
			xBestMove(6,"X",7,"",8,"X",7);				
			xBestMove(6,"",7,"X",8,"X",6);	
			//Vertical Left
			xBestMove(0,"",3,"X",6,"X",0);
			xBestMove(0,"X",3,"",6,"X",3);
			xBestMove(0,"X",3,"X",6,"",6);
			//Vertical Middle
			xBestMove(1,"",4,"X",7,"X",1);
			xBestMove(1,"X",4,"",7,"X",4);
			xBestMove(1,"X",4,"X",7,"",7);
			//Vertical Right
			xBestMove(2,"",5,"X",8,"X",2);
			xBestMove(2,"X",5,"",8,"X",5);
			xBestMove(2,"X",5,"X",8,"",8);
			//Left Diagonal
			xBestMove(0,"X",4,"X",8,"",8);
			xBestMove(0,"",4,"X",8,"X",0);
			xBestMove(0,"X",4,"",8,"X",4);
			//Right Diagonal
			xBestMove(6,"X",4,"X",2,"",2);
			xBestMove(6,"X",4,"",2,"X",4);		
			xBestMove(6,"",4,"X",2,"X",6);
			
			//O defense 
			//Top Row Horizontal
			xBestMove(0,"O",1,"O",2,"",2);
			xBestMove(0,"",1,"O",2,"O",0);			
			xBestMove(0,"O",1,"",2,"O",1);	
			//Middle Row Horizontal
			xBestMove(3,"O",4,"O",5,"",5);
			xBestMove(3,"",4,"O",5,"O",3);
			xBestMove(3,"O",4,"",5,"O",4);			
			//Bottom Row Horizontal
			xBestMove(6,"O",7,"O",8,"",8);
			xBestMove(6,"",7,"O",8,"O",6);	
			xBestMove(6,"O",7,"",8,"O",7);				
			//Left Row Vertical
			xBestMove(0,"O",3,"O",6,"",6);
			xBestMove(0,"",3,"O",6,"O",0);
			xBestMove(0,"O",3,"",6,"O",3);
			//Middle Row Vertical
			xBestMove(1,"O",4,"O",7,"",7);
			xBestMove(1,"",4,"O",7,"O",2);
			xBestMove(1,"O",4,"",7,"O",4);
			//Right Row Vertical
			xBestMove(2,"O",5,"O",8,"",8);
			xBestMove(2,"",5,"O",8,"O",2);
			xBestMove(2,"O",5,"",8,"O",5);
			//Left Diagonal
			xBestMove(0,"O",4,"O",8,"",8);
			xBestMove(0,"",4,"O",8,"O",0);
			xBestMove(0,"O",4,"",8,"O",4);
			//Right Diagonal
			xBestMove(6,"O",4,"O",2,"",2);
			xBestMove(6,"O",4,"",2,"O",4);		
			xBestMove(6,"",4,"O",2,"O",6);			
			
			//X offense clear path to win
			//Top Row Horizontal
			xBestMove(0,"",1,"",2,"",0);
			xBestMove(0,"X",1,"",2,"",1);	
			xBestMove(0,"",1,"",2,"X",1);	
			//Middle Row Horizontal
			xBestMove(3,"",4,"",5,"",3);
			xBestMove(3,"X",4,"",5,"",4);	
			xBestMove(3,"",4,"",5,"X",4);
			//Bottom Row Horizontal
			xBestMove(6,"",7,"",8,"",6);
			xBestMove(6,"X",7,"",8,"",7);	
			xBestMove(6,"",7,"",8,"X",7);
			//Vertical Left
			xBestMove(0,"X",3,"",6,"",3);
			xBestMove(0,"",3,"X",6,"",0);
			xBestMove(0,"",3,"",6,"X",3);
			//Vertical Middle
			xBestMove(1,"",4,"X",7,"",1);
			xBestMove(1,"X",4,"",7,"",4);
			xBestMove(1,"",4,"",7,"X",4);
			//Vertical Right
			xBestMove(2,"",5,"X",8,"",2);
			xBestMove(2,"X",5,"",8,"",5);
			xBestMove(2,"",5,"",8,"X",5);
			//Left Diagonal
			xBestMove(0,"",4,"X",8,"",0);
			xBestMove(0,"X",4,"",8,"",4);
			xBestMove(0,"",4,"",8,"X",4);
			//Right Diagonal
			xBestMove(6,"",4,"X",2,"",6);
			xBestMove(6,"X",4,"",2,"",4);		
			xBestMove(6,"",4,"",2,"X",4);
			
			
			//What's left? No good moves
			for (int x=0; x<9; x++) {
				if (player1_turn & buttons[x].getText()=="") {
				buttons[x].setText("X");player1_turn=false;}}
			
		}
		
		public void xBestMove(int button1, String state1, int button2, String state2, int button3, String state3, int action1) {
			if(
					(player1_turn & 
					buttons[button1].getText()==state1) &&
					(buttons[button2].getText()==state2) &&
					(buttons[button3].getText()==state3)
					) {
				buttons[action1].setText("X");
				buttons[action1].setForeground(new Color(255,0,0));
				player1_turn=false;}
				//textfield.setText("O turn");
		}
		
		public void firstTurn() {
			
			sleep(2000);
			
			player1_turn=false;

		}
		
		public void sleep(int sleepy) {
			try {
				Thread.sleep(sleepy);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void check() {
			//check X win conditions
			if(
					(buttons[0].getText()=="X") &&
					(buttons[1].getText()=="X") &&
					(buttons[2].getText()=="X")
					) {
				xWins(0,1,2);
			}
			if(
					(buttons[3].getText()=="X") &&
					(buttons[4].getText()=="X") &&
					(buttons[5].getText()=="X")
					) {
				xWins(3,4,5);
			}
			if(
					(buttons[6].getText()=="X") &&
					(buttons[7].getText()=="X") &&
					(buttons[8].getText()=="X")
					) {
				xWins(6,7,8);
			}
			if(
					(buttons[0].getText()=="X") &&
					(buttons[3].getText()=="X") &&
					(buttons[6].getText()=="X")
					) {
				xWins(0,3,6);
			}
			if(
					(buttons[1].getText()=="X") &&
					(buttons[4].getText()=="X") &&
					(buttons[7].getText()=="X")
					) {
				xWins(1,4,7);
			}
			if(
					(buttons[2].getText()=="X") &&
					(buttons[5].getText()=="X") &&
					(buttons[8].getText()=="X")
					) {
				xWins(2,5,8);
			}
			if(
					(buttons[0].getText()=="X") &&
					(buttons[4].getText()=="X") &&
					(buttons[8].getText()=="X")
					) {
				xWins(0,4,8);
			}
			if(
					(buttons[2].getText()=="X") &&
					(buttons[4].getText()=="X") &&
					(buttons[6].getText()=="X")
					) {
				xWins(2,4,6);
			}
			//check O win conditions
			if(
					(buttons[0].getText()=="O") &&
					(buttons[1].getText()=="O") &&
					(buttons[2].getText()=="O")
					) {
				oWins(0,1,2);
			}
			if(
					(buttons[3].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[5].getText()=="O")
					) {
				oWins(3,4,5);
			}
			if(
					(buttons[6].getText()=="O") &&
					(buttons[7].getText()=="O") &&
					(buttons[8].getText()=="O")
					) {
				oWins(6,7,8);
			}
			if(
					(buttons[0].getText()=="O") &&
					(buttons[3].getText()=="O") &&
					(buttons[6].getText()=="O")
					) {
				oWins(0,3,6);
			}
			if(
					(buttons[1].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[7].getText()=="O")
					) {
				oWins(1,4,7);
			}
			if(
					(buttons[2].getText()=="O") &&
					(buttons[5].getText()=="O") &&
					(buttons[8].getText()=="O")
					) {
				oWins(2,5,8);
			}
			if(
					(buttons[0].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[8].getText()=="O")
					) {
				oWins(0,4,8);
			}
			if(
					(buttons[2].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[6].getText()=="O")
					) {
				oWins(2,4,6);
			}
		}
		
		public void xWins(int a,int b,int c) {
			buttons[a].setBackground(Color.GREEN);
			buttons[b].setBackground(Color.GREEN);
			buttons[c].setBackground(Color.GREEN);
			
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
			textfield.setText("X wins");
		}
		public void oWins(int a,int b,int c) {
			buttons[a].setBackground(Color.GREEN);
			buttons[b].setBackground(Color.GREEN);
			buttons[c].setBackground(Color.GREEN);
			
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
			textfield.setText("O wins");
		}

	}

