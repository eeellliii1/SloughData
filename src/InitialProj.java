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

			File data = new File(newDir);
			File[] fileList = data.listFiles();
			String fileListStr = "";
			for(File i : fileList)
			{
				fileListStr += " " + i.getName();
			}
			System.out.println(fileListStr);
		
			System.out.println("What would you like to do? Write, Read, or enter Stop to exit");
			word = reader.nextLine();
			if(word.toLowerCase().equals("write"))
			{
				System.out.println("Enter the name of the file you wish to write:");
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
				//System.setProperty("user.dir", "c:\\Users\\" + user + "\\Desktop")
				System.out.println("Enter the name of the file you wish to write:");
				fileName = newDir += ("\\" + reader.nextLine() + ".txt");
				//Tests file name
				System.out.println(fileName);
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
	
	private class file
	{
		String filename;
		String contents;
		int oxygen;
		int ph;
		int date[] = new int[3];
		String etc;
		int streamVel[] = new int[3] ;
		
		public int getOxygen()
		{
			return oxygen;
		}
		
		public int getPh()
		{
			return ph;
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
		
	}
	
	//Writing method
	public static void writer(String fileName) throws IOException
	{
		String contents = reader(fileName);
		StringBuilder appender = new StringBuilder(contents);
		String text = "";
		//Creates file writer scanner
		Scanner fileWrSc = new Scanner(System.in);
		System.out.println("Writes---------------");
		BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName));
		text = fileWrSc.nextLine();
		appender.append(" " + text);
		fileWrite.write("" + appender);
		fileWrite.close();
	}
	
//Reading method
	public static String reader(String fileName)
	{
		String text = "";
		System.out.println("Reads---------------");
		String nextLine = null;
		try
		{
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
