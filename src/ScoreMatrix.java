
import java.util.ArrayList;

/**----------------------------------------------------------------------------------------------------
 * Purpose:				Creates a score matrix that includes
 * 						Observations, Total and Domain scores, and Scored Matrix data
 * 
 * @author				Axie
 * 
 * Revised 11/2/2019	TJT
 * Modification:		Name changes
 * 						Formatting
 ----------------------------------------------------------------------------------------------------**/

public class ScoreMatrix {
	
	private ArrayList<Score> scores = new ArrayList<Score>();

	public ScoreMatrix() {

		for (Responses observation : RespReadIn.getAllObservations()) {
			Score st = new Score(observation, KeyReadIn.getAllKeys());
			scores.add(st);		
		}
	}

	public ArrayList<Score> getAllScores() {
		return scores;
	}

}

