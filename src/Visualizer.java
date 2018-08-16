import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Visualizer{

static JFrame window = new JFrame();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		window.setSize(740, 480);
		window.setTitle("Hueeeeeee");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		//System.out.println("Tst");
		visualComponent v = new visualComponent();
		window.add(v);
		//System.out.println("Tst");
	}
	
	/*public static 
	{
	visualComponent v = new visualComponent();
	window.add(v);
	}
	*/
}
