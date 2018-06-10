/**
 * 
 */

/**
 * @author s-araoe
 *
 */
import java.util.*;
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
		System.out.println(dir);
		//Gets current user
		String[] userSplit = dir.split(Pattern.quote("\\"));
		System.out.println(userSplit[2]);
		String user = userSplit[2];
		
		//Sets current directory
		String newDir = "C:\\Users\\" + user + "\\Desktop\\test";
		
		//Checks directory
		System.out.println(newDir);
		
		//Setting new directory
		System.setProperty("user.dir", newDir);
		
		//Testing new directory
		System.out.println(System.getProperty("user.dir"));
		
		//Testing new file
		new File(newDir);
		// if the directory does not exist, create it
		
		boolean desktop = new File("c:\\Users\\" + user + "\\Desktop\\test").mkdirs();
		
		//Loop that runs the program		
		while(!(word.toLowerCase().equals("stop")))
		{
		//Gets input to decide next step
			//Lists all files in main folder
			File fold = new File(newDir);
			File[] fileList = fold.listFiles();
			//System.out.println(fileList[0]);
			String fileListStr = "";
			String[] dateNameSplit = new String[2];
			try 
			{
				if(fileList.length > 0)
				{
					for(File i : fileList)
					{
						System.out.println(i.getName() + "fileList");
						fileListStr += " \n--\n" + i.getName();
						dateNameSplit = i.getName().split(".");
						System.out.println(dateNameSplit.length);
						if(dateNameSplit.length == 3) 
						{
							Filer file = new Filer(dateNameSplit[0], reader(i.getName()));
						}
						else
						{
							System.out.println(reader(i.getName()) + " is not a valid name.");
						}
					}
				}
				else
				{
					System.out.println("No Files Found...");
				}
			System.out.println(fileListStr);
			}
			catch(NullPointerException e)
			{
				System.out.println("No files in folder...");
			}
			
			System.out.println("What would you like to do? Write, Read, or enter Stop to exit");
			word = reader.nextLine();
			if(word.toLowerCase().equals("write"))
			{
				System.out.println("Please enter the date in the format month-day-year (EX: 3-8-2000)");
				fileName = newDir += ("\\" + reader.nextLine() + ".txt");
				try 
				{
					writer.writer(fileName);
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
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
					System.out.println("Oh no");
				}
			}
			else if(word.toLowerCase().equals("read"))
			{
				System.setProperty("user.dir", "c:\\Users\\" + user + "\\Desktop");
				System.out.println("Please enter the date in the format day-month-year (EX: 3-8-2000)");
				String dateName = reader.nextLine();
				fileName = newDir + ("\\" + dateName + ".txt");
				
				
				//Tests file name
				//System.out.println(fileName);
				reader(fileName);
				
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
	
	
	
	//Writing method ------ SHOULD COMBINE WITH FILER METHOD TO MAKE THINGS MORE SIMPLE. MAKE IT SO FILER METHOD TAKES IN ALL VARIABLES SEPERATELY
	
	
	
	
	//Reading method
	public static String reader(String fileName)
	{
		String text = "";
		//System.out.println("Reads---------------");
		String nextLine = null;
		try
		{
			System.out.println(fileName + "------");
			FileReader fileRead = new FileReader(fileName);
			BufferedReader buffFileRead = new BufferedReader(fileRead);
			//Keep reading the file while there is file left to be read
			while((nextLine = buffFileRead.readLine()) != null)
			{
				System.out.println(nextLine + "\n");
				text += nextLine;
			}
		}
		catch(FileNotFoundException exc)
		{
			System.out.println("File not found!\nCreating File...");
		}
		catch(IOException exc)
		{
			System.out.println("IO Exception");
		}
		return text;
	}
	
	//Method for getting future graphing information
	public static int grapho(String catagory, boolean average, String dateS, String dateE)
	{
		boolean day = false;
		boolean month = false;
		boolean year = false;
		String sD = dateS.split("-")[0];
		String sM = dateS.split("-")[1];
		String sY = dateS.split("-")[2];
		
		String eD = dateE.split("-")[0];
		String eM = dateE.split("-")[1];
		String eY = dateE.split("-")[2];
		
		if(sM.equals(eM))
		{
			
		}
		
		
		if(catagory == "sVelR")
		{
			
		}
		else if(catagory == "sVelM")
		{
			
		}
		else if(catagory == "sVelL")
		{
			
		}
		else if(catagory == "DO")
		{
			
		}
		else if(catagory == "PH")
		{
			
		}
		return 0;
	}
	
	//Non average version
	public static int grapho(String category)
	{
		return 0;
	}
}
