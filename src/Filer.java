import java.util.regex.Pattern;

public class Filer {
	
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
			//System.out.println("fileName");
			String[] aSplit;
			String[] name = fileName.split("-");
			for(int x = 0; x > 3; x++)
			{
				date[x] = Integer.parseInt(name[x]);
			}
			this.fileName = fileName;
			this.contents = contents;
			//System.out.println("--------------------------------\ncontents is \n" + contents + "\n--------------------------------");
			//System.out.println(contents);
			String[] content = contents.split(Pattern.quote("$%^&"));
			//System.out.println(Integer.toString(content.length));
			//Gets group names
			aSplit = content[0].trim().split(":");
			//System.out.println(aSplit.length);
			//System.out.println("Prepare the whumpooosti      " + contents);
			//System.out.println(content[0] + "   the whimsical woopeedangus");
			group = aSplit[1].trim();
			
			//System.out.println("Have you ever heard the tale of darth Pelagius the wise? It is not a story the Jedi would tell you. Pelagius was a sith lord who had such control over midoclorians that he could control the creation of life itself. He could save those he loved from dying yet he was killed himself. Ironic, he could save others but not himself." + "\n" + content[1] + "\n");
			
			//System.out.println(content[0]);
			//System.out.println(content[1]);
			//System.out.println(content[2]);
			//System.out.println(content[3]);
			//System.out.println(content[4]);
			//System.out.println(content[5]);
			//System.out.println(content[6]);
			//System.out.println(content[7]);
			
			
			//Gets oxygen 1
			aSplit = content[2].split(Pattern.quote(":"));
			
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
			
			//System.out.println(content[5]);
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
			return date[1];
		}
		
		public int getDay()
		{
			return date[0];
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
