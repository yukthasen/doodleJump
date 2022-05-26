
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Character   {

	// add location attributes
	public int x, y; // position of the doodle
	private Image img;
	public int p1w = 50, p1h = 50;
	private int dvx = 3; // ball velocity in x direction
	private int dvy = 3; // ball velocity in y direction
	private AffineTransform tx;
	public double ay  = 3.0;
	public int vy = 0;
	

	public Character(int x, int y) {
		this.x = x;
		this.y = 100;
		img = getImage("/imgs/doodleCatRe (1).png"); // load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); // initialize the location of the image
					// use your variables
	}

	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}

	public void paint(Graphics g) {
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		jumping();
		
		// call update to update the actually picture location
		update();
		g2.drawImage(img, tx, null);

	}
	/* update the picture variable location */

	public void jumping() {
		//updates velocity and makes doodle jump down if it is above 600
				if(y<600) {
				vy += ay;
				y += vy;
				}
				
				//updates velocity and makes doodle jump up if it is below 600
				if(y>=600) {
					vy = -40;
					y+=vy;
				}
	}



	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(1.0, 1.0);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.0, 1.0);
	}

	protected Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Character.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
