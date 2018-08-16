/**
 * 
 */

/**
 * @author s-araoe
 *
 */
import java.util.*;
import javax.swing.JFrame;
import java.util.Random;
import java.util.regex.Pattern;
import java.io.*;
import java.io.File;
public class InitialProj {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		String word = "";
		String fileName = "";
		Scanner reader = new Scanner(System.in);
		//Gets the current directory
		String dir = System.getProperty("user.dir");
		//System.out.println(dir);
		//Gets current user
		String[] userSplit = dir.split(Pattern.quote("\\"));
		ArrayList<Filer> filerList = new ArrayList<Filer>();
		//System.out.println(userSplit[2]);
		String user = userSplit[2];
		
		//Sets current directory
		String newDir = "C:\\Users\\" + user + "\\Desktop\\test";
		
		//Checks directory
		//System.out.println(newDir);
		
		//Setting new directory
		System.setProperty("user.dir", newDir);
		
		//Testing new directory
		//System.out.println(System.getProperty("user.dir"));
		
		//Testing new file
		new File(newDir);
		// if the directory does not exist, create it
		
		boolean desktop = new File("c:\\Users\\" + user + "\\Desktop\\testi").mkdirs();
		
		//Loop that runs the program		
		while (!(word.toLowerCase().equals("stop"))) {
			// Gets input to decide next step
			// Lists all files in main folder
			File fold = new File(newDir);
			File[] fileList = fold.listFiles();
			//System.out.println(fileList[0]);
			String fileListStr = "";
			//String[] dateNameSplit = new String[2];
			try {
				if (fileList.length > 0) 
				{
					for (File i : fileList) 
					{
						File[] fileList2 = i.listFiles();
						for (File b : fileList2)
						{
							//System.out.println(i.getName() + " fileList");
							fileListStr += " \n--\n" + b.getName();
							String[] dateNameSplit = b.getName().split(Pattern.quote("."));
							//System.out.println("\n\n\n\n" + i.getName() + "\n\n\n\n");
							//System.out.println(dateNameSplit.length);
							//System.out.println(b.getName() + "             aksldjflaksdjfl;sdjfas");
							if (dateNameSplit.length == 2) 
							{
								System.out.println(b.getName());
								Filer dateName = new Filer(dateNameSplit[0], readerM.readerM(b.getName()));
								//System.out.println("well ur problem is alksjdfljasldkfjaklsdjfklsdjflk     " + b.getName());
								filerList.add(dateName);
							}
							else 
							{
								System.out.println(readerM.readerM(i.getName()) + " is not a valid name.");
							}
						}
					}
				} else 
				{
					System.out.println("No Files Found...");
				}
				//System.out.println(fileListStr);
			} 
			catch (NullPointerException e) 
			{
				System.out.println("No files in folder...");
			}
		
			
			
			
			
			//System.out.println("aaaa");
			
			
			
			System.out.println("What would you like to do? Write, Read, Graph, or enter Stop to exit");
			word = reader.nextLine();
			if(word.toLowerCase().equals("write"))
			{
				System.out.println("Please enter the date in the format month-day-year (EX: 3-8-2000)");
				fileName = (reader.nextLine());
				
				try
				{
					writer.writer(fileName);
				}
				catch(IOException e)
				{
					System.out.println("Oh no. IOException error town woweeeeee");
				}
				
			}
			else if(word.toLowerCase().equals("whumpus"))
			{
				fileName = newDir += ("\\");
				try
				{
				writer.writerTest(fileName);
				}
				catch(IOException e)
				{
					System.out.println("Oh no. IOException error town woweeeeee");
				}
			}
			else if(word.toLowerCase().equals("read"))
			{
				//System.setProperty("user.dir", "c:\\Users\\" + user + "\\Desktop");
				System.out.println("Please enter the date in the format day-month-year (EX: 3-8-2000)");
				String dateName = reader.nextLine() + ".txt";
				//fileName = newDir + ("\\" + dateName + ".txt");
				
				
				//Tests file name
				//System.out.println(fileName);
				//System.out.println(readerM.readerM(dateName));
				readerM.display(readerM.readerM(dateName));
			}
			
			//add a sort that firsts checks <= >= year then month then day and whitles down list to find a range for graphing. Possibly make into new method for external input
			else if (word.toLowerCase().equals("graph"))
			{
				ArrayList<Filer> newList = new ArrayList<Filer>();
				
				System.out.println("Enter a Start Date");
				String startD = reader.nextLine();
				String[] startDCN;
				startDCN = startD.trim().split("-");
				int[] startDC = new int[3];
				startDC[0] = Integer.parseInt(startDCN[0]);
				startDC[1] = Integer.parseInt(startDCN[1]);
				startDC[2] = Integer.parseInt(startDCN[2]);
				
				System.out.println("Enter a End Date");
				String endD = reader.nextLine();
				String[] endDCN;
				endDCN = endD.trim().split("-");
				int[] endDC = new int[3];
				endDC[0] = Integer.parseInt(endDCN[0]);
				endDC[1] = Integer.parseInt(endDCN[1]);
				endDC[2] = Integer.parseInt(endDCN[2]);
				
				//Gets rid of other years
				for(Filer file : filerList)
				{
					if(startDC[2] <= file.getYear() && file.getYear() <= endDC[2])
					{
						newList.add(file);
						System.out.println("AddMark");
						//Remove all other years, go through and remove all start year months and days, go through and remove all end years and days
					}
				}
				System.out.println(Integer.toString(newList.size()));
				ArrayList<Filer> thingsToRemove = new ArrayList<Filer>();
				
				//Trims sides for date and day?
				for(Filer file : newList)
				{
					if ((((file.getYear() == startDC[0]) && (file.getMonth() < startDC[1])) || 
							(((file.getMonth() == startDC[1]) && (file.getYear() == startDC[0])) && (file.getDay() < startDC[2]))) || 
							((file.getYear() == endDC[0]) && (file.getMonth() > endDC[1])) || 
							(((file.getMonth() == endDC[1]) && (file.getYear() == endDC[0])) && (file.getDay() > endDC[2])))
					{
						System.out.println("Mark");
						thingsToRemove.add(file);
						//newList.remove(index);
					}
				}
				//
				System.out.println(Integer.toString(thingsToRemove.size()));
				
				for(Filer file : thingsToRemove)
				{
					int index = newList.indexOf(file);
					System.out.println(index);
					newList.remove(index);
				}
				
				//
				System.out.println(Integer.toString(newList.size()));
				
				for(Filer file : newList)
				{
					System.out.println(file.fileName);
				}
				//
				
				System.out.println("Enter Graphing Criteria");
				word = reader.nextLine();
					
				visualComponent.setFiles(newList, word);
				Visualizer.main(args);
				
			}
			else
			{
				if(!(word.toLowerCase().equals("stop")))
				{
					System.out.println("Invalid input. Please enter a valid input \n\n\n\n");
				}
				else
				{
					System.out.println("Exiting program.... .... ....");
				}
			}
		}

	}
}
	
	