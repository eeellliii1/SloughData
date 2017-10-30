/**
 * 
 */

/**
 * @author s-araoe
 *
 */
import java.util.*;
public class InitialProj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "";
		
		Scanner reader = new Scanner(System.in);
		while(!(word.equals("Stop")) && !(word.equals("stop")))
		{
			//Get input to decide next step
			System.out.println("What would you like to do? Write, Read, or enter Stop to exit");
			word = reader.nextLine();
			if(word.equals("write") || word.equals("Write"))
			{
				writer();
			}
			else if(word.equals("read") || word.equals("Read"))
			{
				reader();
			}
			else
			{
				if(!(word.equals("stop")) && !(word.equals("Stop")))
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
	
	//Writing method
	public static void writer()
	{
		System.out.println("Writes---------------");
	}
	
	//Reading method
	public static void reader()
	{
		System.out.println("Reads---------------");
	}

}
