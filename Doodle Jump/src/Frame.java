import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {

	//objects and background being set
	Background 	bg 	= new Background();
	Character doodle = new Character(150,600);	 

	Font f1 = new Font(Font.SERIF, Font.PLAIN, 30);
	int score = 0;
	long time = System.currentTimeMillis();//accessing time
	
	//an arraylist to add all the moving platforms in the game
	ArrayList<MovingPlatform> randomPlats = new ArrayList<MovingPlatform>();
	
	//specific x-y positions of each platform
	int[] xnumDis = {0, 200, 50, 270, 320, 50};
	int[] ynumDis = {450, 370, 290, 210, 130, 50}; 
	
	// ArrayList<Integer> heightsReached = new ArrayList<Integer>();
	//was going to add a score feature where if the doodle went down a platform
	//score would go down by 10 
	//didn't have time :((
	
	//starting platform position
	int pos1 = 200;
	int pos2 = 530;
	int i=0; // index of arrayList
	

	
	public void paint(Graphics g) {
		super.paintComponent(g);
		//painting the objects
		bg.paint(g);
		doodle.paint(g);
		
		
		g.setFont(f1);
		g.drawString("Doodle Jump!", 160, 40);
		g.drawString("Score: "+score, 370,70);	

		//painting our platforms every specific amount of seconds
		if(time%20==0 && i<6){	
			MovingPlatform platform = new MovingPlatform(pos1,pos2); 
			randomPlats.add(platform);
			System.out.println("here");
			pos1 = xnumDis[i];
			pos2 = ynumDis[i];
			i++;
			
		}
		
		if(score>=70) {
			g.drawString("You win!!", 10, 70);
		}
		
		if(randomPlats.size()>0)System.out.println(randomPlats.get(0).x);
	//	painting each platform within arrayList of random platforms
		for(MovingPlatform p : randomPlats) {
			p.paint(g);
		
		
			//checking whether bottom of doodle collides with top of platform to make it jump
			if(doodle.vy > 0 && doodle.x >= p.x && doodle.x + 50 <= p.x + 100 && doodle.y + 76 >= p.y) {
				doodle.vy = -30;
				doodle.ay = 2.0;
				score += 10;
				break;
			}		
		}
		
		
		//will only paint message of who wins when score is 10
//		
//		
//		//updating time
		time+=1;
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Doodle Jump");
		f.setSize(new Dimension(500, 700));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
Random rnd = new Random();
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println(arg0);
		System.exit(-1);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub



//

//this switch statement allows us to move left and right, depending on which key is pressed

		int x = arg0.getKeyCode();
		switch(x) {
		case 37:
			doodle.x -= 50;
			break; 
		case 39:             
			doodle.x += 50;
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//if up or down arrow is pressed card is flipped and score is updated 
	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	


}