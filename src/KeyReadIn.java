

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**----------------------------------------------------------------------------------------------------
 * Purpose:			This method reads the test key file that will be used 
 * 					to score the test and to find the test blueprint (e.g., domain scores) 
 * 
 * @author:			Axie
 * 
 * @TT				Modified on 11/2/2019
 * 					Modifications:
 * 						-Prompt user for input file
 * 						-Closed scanner
 * 						
 * 
 ----------------------------------------------------------------------------------------------------**/

public class KeyReadIn {

	private static ArrayList<Key> keys = new ArrayList<>();
	private ArrayList<String> header = new ArrayList<>();
	private static Map<String, Integer> bluePrint = new HashMap<String, Integer>();

	/**------------------------------------------------------------------------
	 * Purpose:			Constructor to Read in key file designated by user
	 * 
	 ------------------------------------------------------------------------**/
	public KeyReadIn() {
		
		Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
        
		try {
			in = new Scanner(new FileReader(filename));
			while (in.hasNextLine()) {
				if (header.size() == 0) {
					String nextLine = in.nextLine();
					for (String str : nextLine.split(",")) {
						header.add(str);
					}
				} else {
					keys.add(parseKey(in.nextLine()));
				}
			}
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}

	/**------------------------------------------------------------------------
	 * Purpose:				Parses csv file, comma delimited
	 * 
	 * @param row			Data Row
	 * @return				Keys
	 ------------------------------------------------------------------------**/
	private Key parseKey(String row) {
		
		String[] keyArray = row.split(",");
		
		Key k = new Key(keyArray[0], keyArray[1], keyArray[2]);
		return k;
	}

	/**------------------------------------------------------------------------
	 * Purpose:				getAllKeys 
	 * @return				All keys
	  ------------------------------------------------------------------------**/
	public static  ArrayList<Key> getAllKeys() {
		return keys;
	}

	
	/**------------------------------------------------------------------------
	 * Purpose:				Create map of key for test blueprint
	 * 						association and scoring of domain level scores
	 * 
	 * @return				Map<String,Integer> reflecting key and position
	 ------------------------------------------------------------------------**/
	public static Map<String, Integer> getBluePrint() {

		ArrayList<String> dm = new ArrayList<String>();

		for (int i = 0; i < keys.size(); i++) {
			dm.add(keys.get(i).getDomain());
		}

		for (String domain : dm) {
			Integer j = bluePrint.get(domain);
			bluePrint.put(domain, (j == null) ? 1 : j + 1);
		}

		return bluePrint;
	}
}
