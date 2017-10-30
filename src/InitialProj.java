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
		while(word != "Stop" || word != "stop")
		{
			//Get input to decide next step
			System.out.println("What would you like to do? Write, Read, or enter Stop to exit");
			word = reader.nextLine();
			if(word == "write" || word == "Write")
			{
				writer();
			}
			else if(word == "read" || word == "Read")
			{
				reader();
			}
			else
			{
				System.out.println("Invalid input. Please enter a valid input \n\n\n\n");
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
