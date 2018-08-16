import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

//Change the dates to be back in the correct order and then create smaller sub folders for years and maybe even months to help make it only have to sort by days. Or also figure out the sorting error in the remove list.

public class writer {
	public static void writer(String fileName) throws IOException
	{
		String left;
		String middle;
		String right;
		//Check original filename
		//System.out.println(fileName);
		//String contents = reader(fileName);
		//contents v
		//reader(fileName);
		StringBuilder appender = new StringBuilder();
		String text = "";
		//Creates file writer scanner
		Scanner fileWrSc = new Scanner(System.in);
		//System.out.println("Writes---------------");
		//boolean desktop = new File("c:\\Users\\" + user + "\\Desktop\\test").mkdirs();
		//////////////////////////
		String dir = System.getProperty("user.dir");
		String[] userSplit = dir.split(Pattern.quote("\\"));
		ArrayList<Filer> filerList = new ArrayList<Filer>();
		String user = userSplit[2];
		
		//System.out.println("bungoowweeewweooowowowowowowo" + fileName);
		String[] year = fileName.split("-");
		String newDir = "C:\\Users\\" + user + "\\Desktop\\test" + "\\" + year[2];
		System.out.println(year[2]);
		boolean dateFolder = new File(newDir).mkdirs();
		//String newDir = dir + "\\" + year[2];
		
		
		
		new File(fileName);
		fileName = newDir + "\\" + fileName + ".txt";
		//System.out.println(fileName);
		
		System.setProperty("user.dir", newDir);
		//////////////////////////
		
		
		
		BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName));
		
		//Group (Seperated by Commas), Site1, oxygen, ph, stream velocity (left, right, center), etc
		
		//Group Names
		System.out.println("Enter in group member names");
		text = fileWrSc.nextLine();
		appender.append("Group Members: " + text + "\n$%^&");
		appender.append("Site1:\n$%^&");
		
		//Oxygen1
		System.out.println("Enter in Oxygen for Site 1");
		text = fileWrSc.nextLine();
		appender.append("Oxygen: " + bigChecker(text, fileWrSc, "1int") + "\n$%^&");
		//PH1
		System.out.println("Enter in PH for Site 1");
		text = fileWrSc.nextLine();
		appender.append("PH: " + bigChecker(text, fileWrSc, "1int") + "\n$%^&");
		//SVel1
		System.out.println("Enter in Left Stream Velocity for Site 1");
		text = fileWrSc.nextLine();
		left = bigChecker(text, fileWrSc, "1int");
		System.out.println("Enter in Middle Stream Velocity for Site 1");
		text = fileWrSc.nextLine();
		middle = bigChecker(text, fileWrSc, "1int");
		System.out.println("Enter in Right Stream Velocity for Site 1");
		text = fileWrSc.nextLine();
		right = bigChecker(text, fileWrSc, "1int");
		text = left + ", " + middle + ", " + right;
		appender.append("Stream Velocity: " + text + "\n$%^&");
		
		appender.append("Site2:\n$%^&");
		//Oxygen2
		System.out.println("Enter in Oxygen for Site 2");
		text = fileWrSc.nextLine();
		appender.append("Oxygen: " + bigChecker(text, fileWrSc, "1int") + "\n$%^&");
		//PH2
		System.out.println("Enter in PH for Site 2");
		text = fileWrSc.nextLine();
		appender.append("PH: " + bigChecker(text, fileWrSc, "1int") + "\n$%^&");
		//SVel2
		System.out.println("Enter in Left Stream Velocity for Site 2");
		text = fileWrSc.nextLine();
		left = bigChecker(text, fileWrSc, "1int");
		System.out.println("Enter in Middle Stream Velocity for Site 2");
		text = fileWrSc.nextLine();
		middle = bigChecker(text, fileWrSc, "1int");
		System.out.println("Enter in Right Stream Velocity for Site 2");
		text = fileWrSc.nextLine();
		right = bigChecker(text, fileWrSc, "1int");
		text = left + ", " + middle + ", " + right;
		appender.append("Stream Velocity: " + text);
		
		fileWrite.write("" + appender);
		fileWrite.close();
		//System.out.println(appender.toString());
		//Check File Location
		//System.out.println(fileName);
		//Filer file = new Filer(fileName, appender.toString());
	}
	
	public static void writerTest(String fileName) throws IOException
	{
		//Checking file name location path
		
		Scanner fileWrSc = new Scanner(System.in);
		
		String left;
		String middle;
		String right;
		//String contents = reader(fileName);
		//contents v
		//reader(fileName);
		int ranDay = 13;
		int ranYear = 0;
		for(int i = 0; i < 20; i++)
			{
			StringBuilder appender = new StringBuilder();
			Random randInt = new Random();
			ranDay += randInt.nextInt(1) - 1;
			ranDay = Math.abs(ranDay);
			ranYear += randInt.nextInt(1) - 1;
			ranYear = Math.abs(ranYear);
			//String tName = fileName + ranDay + "-" + Integer.toString(i) + "-" + ranYear + ".txt";
			//System.out.println(Integer.toString(ranDay));
			//System.out.println(Integer.toString(i));
			//System.out.println(Integer.toString(ranYear));
			
			//System.out.println(tName);
			String text = "";
			//Creates file writer scanner
			//System.out.println("Writes---------------");
			
			String dir = System.getProperty("user.dir");
			String[] userSplit = dir.split(Pattern.quote("\\"));
			ArrayList<Filer> filerList = new ArrayList<Filer>();
			String user = userSplit[2];
			
			//
			//System.out.println("bungoowweeewweooowowowowowowo" + fileName);
			String newDir = fileName + ranYear;
			//System.out.println(newDir);
			boolean dateFolder = new File(newDir).mkdirs();
			newDir = fileName + ranYear + "\\" + ranDay + "-" + Integer.toString(i) + "-" + ranYear + ".txt";
			new File(fileName);
			//System.out.println(newDir);
			//System.out.println(year[2]);
			
			//
			
			BufferedWriter fileWrite = new BufferedWriter(new FileWriter(newDir));
		
			//Group (Seperated by Commas), Site1, oxygen, ph, stream velocity (left, right, center), etc
		
			//Group Names
			//System.out.println("Enter in group member names");
			text = "test file";
			appender.append("Group Members: " + text + "\n$%^&");
			appender.append("Site1:\n$%^&");
		
			//Oxygen1
			//System.out.println("Enter in Oxygen for Site 1");
			text = Integer.toString(randInt.nextInt(50) + 1);
			appender.append("Oxygen: " + bigChecker(text, fileWrSc, "1int") + "\n$%^&");
			//PH1
			//System.out.println("Enter in PH for Site 1");
			text = Integer.toString(randInt.nextInt(50) + 1);
			appender.append("PH: " + bigChecker(text, fileWrSc, "1int") + "\n$%^&");
			//SVel1
			//System.out.println("Enter in Left Stream Velocity for Site 1");
			text = Integer.toString(randInt.nextInt(50) + 1);
			left = bigChecker(text, fileWrSc, "1int");
			//System.out.println("Enter in Middle Stream Velocity for Site 1");
			text = Integer.toString(randInt.nextInt(50) + 1);
			middle = bigChecker(text, fileWrSc, "1int");
			//System.out.println("Enter in Right Stream Velocity for Site 1");
			text = Integer.toString(randInt.nextInt(50) + 1);
			right = bigChecker(text, fileWrSc, "1int");
			text = left + ", " + middle + ", " + right;
			appender.append("Stream Velocity: " + text + "\n$%^&");
		
			appender.append("Site2:\n$%^&");
			//Oxygen2
			//System.out.println("Enter in Oxygen for Site 2");
			text = Integer.toString(randInt.nextInt(50) + 1);
			appender.append("Oxygen: " + bigChecker(text, fileWrSc, "1int") + "\n$%^&");
			//PH2
			//System.out.println("Enter in PH for Site 2");
			text = Integer.toString(randInt.nextInt(50) + 1);
			appender.append("PH: " + bigChecker(text, fileWrSc, "1int") + "\n$%^&");
			//SVel2
			//System.out.println("Enter in Left Stream Velocity for Site 2");
			text = Integer.toString(randInt.nextInt(50) + 1);
			left = bigChecker(text, fileWrSc, "1int");
			//System.out.println("Enter in Middle Stream Velocity for Site 2");
			text = Integer.toString(randInt.nextInt(50) + 1);
			middle = bigChecker(text, fileWrSc, "1int");
			//System.out.println("Enter in Right Stream Velocity for Site 2");
			text = Integer.toString(randInt.nextInt(50) + 1);
			right = bigChecker(text, fileWrSc, "1int");
			text = left + ", " + middle + ", " + right;
			appender.append("Stream Velocity: " + text);
			
			fileWrite.write("" + appender);
			fileWrite.close();
			//System.out.println(appender.toString());
			//File Location Check
			//System.out.println(tName);
			//Filer file = new Filer(tName, appender.toString());
		}
	}
	
	public static String bigChecker(String text, Scanner fileWrSc, String test)
	{
		boolean correct = false;
		boolean fixed = false;
		if(test.equals("1int"))
		{
			while(correct != true)
			{
				try
				{
					Integer.parseInt(text);
					fixed = true;
					//System.out.println("fixed is true");
				}
				catch (NumberFormatException e)
				{
					System.out.println("Please enter a valid number");
					fixed = false;
					//System.out.println("fixed is false");
					text = fileWrSc.nextLine();
				}
				if(fixed == true)
				{
					correct = true;
				}
		
			}
		return text;
		}
		return "0";
	}

}
