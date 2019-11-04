

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**----------------------------------------------------------------------------------------------------
 * Purpose:				Data file read in; Read file and parses the csv file into a list of object
 *  
 * @author 				Axie
 * 
 * Revised 11/2/2019	TJT
 * Modification:		Name changes
 * 						Formatting
 * 						User prompts
 ----------------------------------------------------------------------------------------------------**/

public class RespReadIn {
	
	private static ArrayList<Responses> responseData = new ArrayList<>();
	private ArrayList<String> header = new ArrayList<>();
	
	public RespReadIn() {

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
					responseData.add(parseObservations(in.nextLine()));
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		//Removing ID from header for later use in labeling
		header.remove(0);
		in.close();
	}


	/**------------------------------------------------------------------------
	 * Purpose:			Read in response data into ArrayList of answers
	 * 
	 * @param row		Row
	 * @return			Object of response data 
	 ------------------------------------------------------------------------**/
	private Responses parseObservations(String row) {
		
		String[] rowArray = row.split(",");
		ArrayList<String> answer = new ArrayList<String>();
		for (int i = 1; i < rowArray.length; i++) {
			answer.add(rowArray[i]);
		}

		Responses s = new Responses(rowArray[0], answer);
		return s;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			Return all response data into an array list
	 * 
	 * @return			ArrayList<Responses> for all test takers
	 ------------------------------------------------------------------------**/ 
	public static ArrayList<Responses> getAllObservations() {
		return responseData;
	}


	/**------------------------------------------------------------------------
	 * Purpose:			Return all headers in an array list for labeling
	 * 
	 * @return			ArrayList<String> Headers
	 ------------------------------------------------------------------------**/ 
	public ArrayList<String> getHeader() {
		return header;
	}

}
