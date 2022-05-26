

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class MovingPlatform   {

	private Image img, img2;	
	private AffineTransform tx;
	public int x, y;
	private String fn;
	

	public MovingPlatform(int x, int y) {
 		img = getImage("/imgs/regPlat (1).png"); //load the image for Tree
 		this.x = x;
 		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}

	public void paint(Graphics g) {
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
	
		// call update to update the actually picture location
		update();
		g2.drawImage(img, tx, null);

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
