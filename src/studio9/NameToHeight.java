package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	
	
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */

	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name="";
		while(!(name.equals("quit")))
		{
			System.out.println("what is your name?");
			name =in.nextLine();
			Map<String,Double> map = new HashMap<String,Double>();
			map.put("Cole", 7.1);
			map.put("Isaac", 5.4);
			map.put("Jess", 5.2);
			map.put("JP", 6.0);
			map.put("Izzy", 5.1);
			System.out.println(map.get(name));
		}
		
	
	}
}
