


import java.util.ArrayList;

/**----------------------------------------------------------------------------------------------------
 * Purpose:				Student class store each student's id and response string. Response String
 * 						include A, B, C, D, E, & 2 (missing) A student has the following instance
 * 						variables: String id ArrayList answers include all responses for all items
 * 
 * @author 				axie
 *
 * 
 * 	Revised 11/2/2019	TJT
 * 	Modification:		
 ----------------------------------------------------------------------------------------------------**/

public class Responses {
	
	private String id;
	private ArrayList<String> answers = new ArrayList<String>();

	public Responses(String id, ArrayList<String> answers) {
		this.id = id;
		this.answers = answers;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Observation [ID=" + id + ", Responses=" + answers + "]";
	}

	public ArrayList<String> getAnswer() {
		return answers;
	};
}
