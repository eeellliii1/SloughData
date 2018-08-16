import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.*;
import javax.swing.JComponent;

import java.util.Random;

public class visualComponent  extends JComponent{
	static int offSet = 50;
	static ArrayList<Filer> files;
	static ArrayList<Integer> gumbo = new ArrayList<>();
	public void paintComponent(Graphics t)
	{
		//System.out.println("Hee Hee");
		t.setColor(Color.blue);
		int ob = (int) Visualizer.window.getBounds().getWidth() - 100;
		//System.out.println(Integer.toString(ob) +  "shingadingaling");
		Rectangle test = new Rectangle(0 + offSet, 0, 640, 350);
	
		Graphics2D rectangle = (Graphics2D) t;
		rectangle.draw(test);	
		
		//int startX = 0;
		
		
		
		
		
		/*
		-------------------------
		|Hard Coded Random Graph|
		-------------------------
		
		int y;
		for(int x = 0; x < 12; x ++)
		{
			y = (int) (Math.random() * (301 - 100) + 100);
			Rectangle graphio = new Rectangle((10 + (10 * x) ), y, 5, 350 - y);
			rectangle.fill(graphio);
			rectangle.draw(graphio);
		}*/
		
		//------------------------------------------------------
		Scanner input = new Scanner(System.in);
		/*
		--------------------------------
		|Hard Coded Random Scaled Graph|
		--------------------------------
		*/
		System.out.println(Integer.toString(files.size()));
		int totalCol = gumbo.size();
		int totalSpace = test.width;
		int space = (int) (totalSpace / totalCol) / 3;
		//System.out.println("Le spassay esta " + Integer.toString(space));
		int width = space * 2;
		int spacing = width / 2;
		int startSpot = spacing + offSet;
		//System.out.println(Integer.toString(startSpot));
		int y;
		
		for(int x = 0; x < totalCol; x ++)
		{
			//System.out.println(Integer.toString(gumbo.get(x)));
			y = gumbo.get(x); 
			Rectangle graphio = new Rectangle(startSpot, y, width, 350 - y);
			startSpot += spacing + width;
			
			//System.out.println(Integer.toString(startSpot));
			rectangle.fill(graphio);
			rectangle.draw(graphio);
			//System.out.println("ooooh lalalalalala" + Integer.toString(x));
		}
		
		
		
		
		
		
		//t.drawLine(1, 50, 23, 90);
		
	}
	
	public static void setFiles(ArrayList<Filer> intry, String typeFilter)
	{
		files = intry;
		typeFilter = typeFilter.toLowerCase();
		
		if (typeFilter.equals("oxygen1"))
		{
			for (Filer i : files)
			{
				System.out.println(i.getOxygen1());
				gumbo.add(i.getOxygen1());
			}
		}
		
		if (typeFilter.equals("oxygen2"))
		{
			for (Filer i : files)
			{
				gumbo.add(i.getOxygen2());
			}
		}
		
		if (typeFilter.equals("ph1"))
		{
			for (Filer i : files)
			{
				gumbo.add(i.getPh1());
			}
		}
		
		if (typeFilter.equals("ph2"))
		{
			for (Filer i : files)
			{
				gumbo.add(i.getPh2());
			}
		}
		
		//need to add stream velocity stuff
		
	}
}
