


import java.util.ArrayList;

/**----------------------------------------------------------------------------------------------------
 * Purpose:				Score class holds scores of 1(correct) or 0(incorrect) based on 
 * 						responses read in from the data and key for each item.
 * 					 	Total and domain level scores are calculated based on the test blueprint
 * 						and incorrect/correct responses.
 * 
 * @author				Axie
 * 
 * Revised 11/2/2019	TJT
 * Modification:		Name changes
 * 						Formatting
 ----------------------------------------------------------------------------------------------------**/

public class Score {
	
	private ArrayList<Integer> scores = new ArrayList<Integer>();
	private ArrayList<Integer> domScores = new ArrayList<Integer>();
	
	private String id;
	private int totScore;
	
	public Score(Responses observation, ArrayList<Key> key) {
		
		this.id = observation.getId();
		this.totScore = 0;
		
		int index = 0;
		for (String answer : observation.getAnswer()) {
			if (answer.equals("2")) {
				scores.add(2);
			} else if (KeyReadIn.getAllKeys().get(index).getKey().equals(answer)) {
				scores.add(1);
				totScore ++;															// Calculate total score
			} else {
				scores.add(0);
			}
			index++;
		}
		
		for (String k : KeyReadIn.getBluePrint().keySet()) { 							// Calculate domain scores

			int domainIndex = 0;
			for (int i = 0; i < scores.size(); i++) {
				if (KeyReadIn.getAllKeys().get(i).getDomain().contentEquals(k)) {
					if (scores.get(i) == 1) {
						domainIndex++;
					}
				}
			}
			domScores.add(domainIndex);
		}
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getID
	 * @return			IDs
	 ------------------------------------------------------------------------**/
	public String getId() {
		return id;
	}
	
	/**------------------------------------------------------------------------
	 * Purpose:			getScores
	 * @return			Scores
	 ------------------------------------------------------------------------**/
	public ArrayList<Integer> getScores() {
		return scores;
	}
	
	/**------------------------------------------------------------------------
	 * Purpose:			getTotScore
	 * @return			Total Score
	 ------------------------------------------------------------------------**/
	public int getTotScore() {
		return totScore;
	}
	
	/**------------------------------------------------------------------------
	 * Purpose:			getDomScores
	 * @return			Domain Scores
	 ------------------------------------------------------------------------**/
	public ArrayList<Integer> getDomScores() {
		return domScores;
	}

	@Override
	public String toString() {
		return "Observation [ID=" + id + ", TotalScore=" + totScore + ", DomainScores=" + domScores + ", ScoreMatrix=" + scores +  "]";
	}
	
}
