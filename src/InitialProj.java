/**
 * 
 */

/**
 * @author s-araoe
 *
 */
import java.util.*;
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
			String fileListStr = "";
			if(fileList.length > 0)
			{
				for(File i : fileList)
				{
					fileListStr += " \n--\n" + i.getName();
				}
			}
			System.out.println(fileListStr);
		
			System.out.println("What would you like to do? Write, Read, or enter Stop to exit");
			word = reader.nextLine();
			if(word.toLowerCase().equals("write"))
			{
				System.out.println("Please enter the date in the format month-day-year (EX: 3-8-2000)");
				fileName = newDir += ("\\" + reader.nextLine() + ".txt");
				try 
				{
					writer(fileName);
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(word.toLowerCase().equals("read"))
			{
				System.setProperty("user.dir", "c:\\Users\\" + user + "\\Desktop");
				System.out.println("Please enter the date in the format day/month/year (EX: 3-8-2000)");
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
	
	private static class Filer
	{
		//Group (Seperated by Commas), Site1, oxygen, ph, stream velocity (left, right, center), etc
		String fileName;
		String contents;
		int oxygen1;
		int ph1;
		int date[] = new int[3];
		String etc1;
		int streamVel1[] = new int[3];
		
		int oxygen2;
		int ph2;
		int date2[] = new int[3];
		String etc2;
		int streamVel2[] = new int[3] ;
		String group;
		
		public Filer(String fileName, String contents)
		{
			String[] aSplit;
			String[] name = fileName.split("-");
			for(int x = 0; x > 3; x++)
			{
				date[x] = Integer.parseInt(name[x]);
			}
			this.fileName = fileName;
			this.contents = contents;
			//System.out.println("--------------------------------\ncontents is \n" + contents + "\n--------------------------------");
			String[] content = contents.split("\n");
			
			//Gets group names
			aSplit = content[0].trim().split(":");
			group = aSplit[1].trim();
			
			//Gets oxygen 1
			aSplit = content[2].split(":");
			oxygen1 = Integer.parseInt(aSplit[1].trim());
			
			//Gets ph1
			aSplit = content[3].trim().split(":");
			ph1 = Integer.parseInt(aSplit[1].trim());
			
			//Gets stream velocities 1
			aSplit = content[4].trim().split(":");
			String[] streamVelComp1 = aSplit[1].split(", ");
			for(int y = 0; y > 3; y++)
			{
				streamVel1[y] = Integer.parseInt(streamVelComp1[y].trim());
			}
			
			//Gets oxygen 2
			aSplit = content[6].trim().split(":");
			oxygen2 = Integer.parseInt(aSplit[1].trim());
			
			//Gets ph 2
			aSplit = content[7].trim().split(":");
			ph2 = Integer.parseInt(aSplit[1].trim());
			
			//Gets stream velocities 2
			aSplit = content[8].trim().split(":");
			String[] streamVelComp2 = aSplit[1].split(", ");
			for(int y = 0; y > 3; y++)
			{
				streamVel2[y] = Integer.parseInt(streamVelComp2[y].trim());
			}
			
		}
		
		public int getOxygen1()
		{
			return oxygen1;
		}
		
		public int getPh1()
		{
			return ph1;
		}
		
		public int getOxygen2()
		{
			return oxygen2;
		}
		
		public int getPh2()
		{
			return ph2;
		}
		
		public int getMonth()
		{
			return date[0];
		}
		
		public int getDay()
		{
			return date[1];
		}
		
		public int getYear()
		{
			return date[2];
		}
		
		public String getGroup()
		{
			return group;
		}
	}
	
	//Writing method ------ SHOULD COMBINE WITH FILER METHOD TO MAKE THINGS MORE SIMPLE. MAKE IT SO FILER METHOD TAKES IN ALL VARIABLES SEPERATELY
	public static void writer(String fileName) throws IOException
	{
		//String contents = reader(fileName);
		//contents v
		//reader(fileName);
		StringBuilder appender = new StringBuilder();
		String text = "";
		//Creates file writer scanner
		Scanner fileWrSc = new Scanner(System.in);
		//System.out.println("Writes---------------");
		BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName));
		
		//Group (Seperated by Commas), Site1, oxygen, ph, stream velocity (left, right, center), etc
		
		//Group Names
		System.out.println("Enter in group member names");
		text = fileWrSc.nextLine();
		appender.append("Group Members: " + text + "\n");
		appender.append("Site1:\n");
		
		//Oxygen1
		System.out.println("Enter in Oxygen for Site 1");
		text = fileWrSc.nextLine();
		appender.append("Oxygen: " + text + "\n");
		//PH1
		System.out.println("Enter in PH for Site 1");
		text = fileWrSc.nextLine();
		appender.append("PH: " + text + "\n");
		//SVel1
		System.out.println("Enter in Stream Velocity for Site 1");
		text = fileWrSc.nextLine();
		appender.append("Stream Velocity: " + text + "\n");
		
		appender.append("Site2:\n");
		//Oxygen2
		System.out.println("Enter in Oxygen for Site 2");
		text = fileWrSc.nextLine();
		appender.append("Oxygen: " + text + "\n");
		//PH1
		System.out.println("Enter in PH for Site 2");
		text = fileWrSc.nextLine();
		appender.append("PH: " + text + "\n");
		//SVel1
		System.out.println("Enter in Stream Velocity for Site 2");
		text = fileWrSc.nextLine();
		appender.append("Stream Velocity: " + text);
		
		fileWrite.write("" + appender);
		fileWrite.close();
		System.out.println(appender.toString());
		
		Filer file = new Filer(fileName, appender.toString());
	}
	
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

}
