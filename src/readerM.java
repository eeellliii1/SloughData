import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class readerM {
	public static String readerM(String fileName)
	{
		String dir = System.getProperty("user.dir");
		String[] userSplit = dir.split(Pattern.quote("\\"));
		//System.out.println("First checkpoint");
		//System.out.println(userSplit[1]);
		String user = userSplit[2];
		String[] fileNameSplit = fileName.split("-");
		//System.out.println("Second checkpoint");
		//System.out.println(fileName + "            ayayayayayyay             "         + fileNameSplit.length + "    " + fileNameSplit[2]);
		String[] yearSplit = fileNameSplit[2].split(Pattern.quote("."));
		//System.out.println(yearSplit.length + "           asdfasdfasdfasdfasdfasdfsdf333333asdfasd");
		String year = yearSplit[0];
		String newDir = "C:\\Users\\" + user + "\\Desktop\\test" + "\\" + year;
		System.setProperty("user.dir", newDir);
		///////////////////////////////////////////////////////////
		//System.out.println(fileName);
		
		//System.out.println(dir);
		String text = "";
		//System.out.println("Reads---------------");
		String nextLine = null;
		try
		{
			//System.out.println(fileName + "------");
			//System.out.println("The current reading directory is..... " + System.getProperty("user.dir"));
			FileReader fileRead = new FileReader(newDir + "\\" + fileName);
			//System.out.println(fileRead + "    alexa play despacito");
			BufferedReader buffFileRead = new BufferedReader(fileRead);
			//Keep reading the file while there is file left to be read
			while((nextLine = buffFileRead.readLine()) != null)
			{
				//System.out.println(nextLine + "\n");
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
		//System.out.println(text);
		//System.out.println("Execute order 66  " + text);
		return text;
	}
	
	public static void display(String words)
	{
		String[] data = words.split(Pattern.quote("$%^&"));
		for (String i : data)
		{
			System.out.println(i + "\n");
		}
		
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

