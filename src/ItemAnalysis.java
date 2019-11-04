

import java.util.ArrayList;
import org.apache.commons.math3.distribution.NormalDistribution;



/**----------------------------------------------------------------------------------------------------
 * Purpose:				This class calculates item P values (P+, proportion correct) for 
 * 						each item based on the scored response data (0/1)
 * 
 * 						Proportion correct is the number of people (observations) that answered
 * 						the item correct divided by the total number of observations that tried
 * 						to respond to the item 
 *
 * @author				Axie
 * 
 * Revised 11/2/2019	TJT
 * Modification:		Name changes
 * 						Formatting
 * 					
 ----------------------------------------------------------------------------------------------------**/

public class ItemAnalysis {
	
	ScoreMatrix sm = new ScoreMatrix();
	StatisticsAnalyzer as = new StatisticsAnalyzer();
	
	public ArrayList<Double> itPPlus = new ArrayList<Double>();					// Initiate array (P+, proportion correct)
	public ArrayList<Double> RBiserials = new ArrayList<Double>();				// Initiates array for Rbiserial Correlation
	
	
	/**------------------------------------------------------------------------
	 * Purpose:				This method take each item's response string and calls 
	 * 						the pplus method to calculate each items P+ and
	 * 						then saves it to an array called itPPlus
	 * 
	 * @return				ArrayList<Double> called itPPLus
	 ------------------------------------------------------------------------**/
	public ArrayList<Double> itemPPlus() {

		for(int j = 0; j < sm.getAllScores().get(0).getScores().size(); j++) {
			ArrayList<Integer> itemResp = new ArrayList<Integer>();
			for (int i = 0; i < sm.getAllScores().size(); i ++) {
				int ir = sm.getAllScores().get(i).getScores().get(j);
				itemResp.add(ir);
			}
			
			double itemPplus = pplus(itemResp);
			double value = (double) Math.round(itemPplus * 100d) / 100d;
			itPPlus.add(value);
		}
		return itPPlus;
	}
	
	/**------------------------------------------------------------------------
	 * Purpose:				This method take each item's response string and calls 
	 * 						the ptBiserialCorrelation & bisCorrelation helper
	 * 						methods to calculate each items discrimination index 
	 * 						(or Rbiserial correlation) using the total score as
	 * 						the reference criterion. 
	 * 
	 * @return				ArrayList<Double> of Rbiserial correlations for each
	 * 						item
	 -------------------------------------------------------------------------**/
	public ArrayList<Double> rBiserial() {
		
		for (int j = 0; j < sm.getAllScores().get(0).getScores().size(); j++) {					// j is the number of items
			
			ArrayList<Integer> itemResp = new ArrayList<Integer>();
			ArrayList<Integer> totScore = new ArrayList<Integer>();
			for (int i = 0; i < sm.getAllScores().size(); i++) {								// i is number of observations
				int ir = sm.getAllScores().get(i).getScores().get(j);
				int totsc = sm.getAllScores().get(i).getTotScore();
				
				itemResp.add(ir);
				totScore.add(totsc);
			}
			
			double itemRbis = bisCorrelation(itemResp, totScore);
			double value = (double) Math.round(itemRbis * 100d) / 100d;
		
			RBiserials.add(value);
			
		}
		return RBiserials;
	}


	/**------------------------------------------------------------------------
	 * Purpose:				This helper method calculate the item p+ for each item
	 * 
	 * @param list			ArrayList<Integer> list of item scores  (0,1,2)
	 * @return				Double, pplus statistic (P+)
	 ------------------------------------------------------------------------**/
	public double pplus(ArrayList<Integer> list) {
		
		int correct = -1;
		int count = -1;
		
		for(int i = 0; i < list.size(); i++) {											// Omitted items/Missing are not counted into total N
			if(list.get(i) != 2) {
				count++;
				if(list.get(i) == 1) {
					correct++;	
				}
			} 
		}
		
		double pplus = (double) correct/count;
		return pplus;
	}
	

	/**------------------------------------------------------------------------
	 * Purpose:				This helper method calculates the point biserial 
	 * 						correlation. It is needed to calculate the 
	 * 						RBiserial which is used in Item analysis which
	 * 						follows different assumptions
	 * 
	 * @param itScore		ArrayList<Integer> of item scores (0/1 scored items)
	 * @param critScore		ArrayList<Integer> of the criterion scores (Total score)
	 * @return				ptBiserial, Double
	 ------------------------------------------------------------------------**/
	public double ptBisCorrelation(ArrayList<Integer> itScore, ArrayList<Integer> critScore) {

		double sx = 0.0;
		double sy = 0.0;
		double sxx = 0.0;
		double syy = 0.0;
		double sxy = 0.0;

		int n = itScore.size();
		for (int i = 0; i < n; ++i) {
			double x = itScore.get(i);
			double y = critScore.get(i);
			sx += x;
			sy += y;
			sxx += x * x;
			syy += y * y;
			sxy += x * y;
		}
		
		double cov = sxy / n - sx * sy / n / n;												// Covariance
		double sigmax = Math.sqrt(sxx / n - sx * sx / n / n);								// Standard error of x
		double sigmay = Math.sqrt(syy / n - sy * sy / n / n);								// Standard error of y
		double rpbis = cov / sigmax / sigmay;
		
		return rpbis;
	}
	
	/**------------------------------------------------------------------------
	 * Purpose:				This helper method calculate the item biserial
	 * 						for each item given the total score criterion
	 * 
	 * 						Math Commons is needed for this part of the analysis
	 * 
	 * @param itScore		ArrayList of item scores (0/1)
	 * @param critScore		ArrayList of criterion scores (total Scores)
	 * @return				rbis, double
	 ------------------------------------------------------------------------**/
	public double bisCorrelation(ArrayList<Integer> itScore, ArrayList<Integer> critScore) {
		
		NormalDistribution standardNormal = new NormalDistribution(0, 1);
		
		double rpbis = ptBisCorrelation(itScore, critScore);
		double pplus = pplus(itScore);
		double h = standardNormal.inverseCumulativeProbability((pplus));
		double u = Math.exp(-h * h / 2) / Math.sqrt(2 * Math.acos((-1)));
		double rbis = Math.sqrt(pplus * (1 - pplus)) / u * rpbis;
		return rbis;
	}

	/**------------------------------------------------------------------------
	 * Purpose;		getItPPlus
	 * @return		itPPlus
	 ------------------------------------------------------------------------**/
	public ArrayList<Double> getItPPlus() {
		return itPPlus;
	}
	
	/**------------------------------------------------------------------------
	 * Purpose;		getRBiserial
	 * @return		RBiserials
	 ------------------------------------------------------------------------**/
	public ArrayList<Double> getRBiserials() {
		return RBiserials;
	}
	
	
}


