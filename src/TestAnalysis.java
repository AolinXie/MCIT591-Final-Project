

import java.util.ArrayList;
import java.util.Map;


 /**----------------------------------------------------------------------------------------------------
  * Purpose				This class conducts test analysis by calculating statistics for domain and
 * 						total test score n (count), mean, median, minimum, max, sd frequency, cumulative
 * 						frequency, %frequency, and %cumulative frequency
 * 
 * @author 				axie
 * 
 * 
 * 	Revised 11/2/2019	TJT
 * 	Modification:		Addition of IQR statistics
 * 						Change of access to classes that holds statistics and frequencies
 * 						Addition of different domain score method
 ----------------------------------------------------------------------------------------------------**/

public class TestAnalysis {
	
	
	// ArrayList save the statistics for total score & domain scores
	ArrayList<Integer> n = new ArrayList<Integer>();
	ArrayList<Double> mean = new ArrayList<Double>();
	ArrayList<Integer> median = new ArrayList<Integer>();
	ArrayList<Integer> min = new ArrayList<Integer>();
	ArrayList<Integer> max = new ArrayList<Integer>();
	ArrayList<Double> sd = new ArrayList<Double>();
	ArrayList<Integer> iqr = new ArrayList<Integer>();

	
	public TestAnalysis() {
		
		ScoreMatrix sc = new ScoreMatrix();
		StatisticsAnalyzer as = new StatisticsAnalyzer();
		FrequencyAnalyzer af = new FrequencyAnalyzer();
		PrintingTables pt = new PrintingTables();
		
		// Obtain statistics for Total Score
		ArrayList<Integer> totalScore = new ArrayList<Integer>();
		
		for (int i = 0; i < sc.getAllScores().size(); i++) {
			int totScore = (sc.getAllScores().get(i).getTotScore());
			totalScore.add(totScore);
		}
		
		n.add(as.n(totalScore));
		mean.add(as.mean(totalScore));
		median.add(as.median(totalScore));
		min.add(as.min(totalScore));
		max.add(as.max(totalScore));
		sd.add(as.sd(totalScore));
		iqr.add(as.IQR(totalScore));
		
		
		
		Map<Integer, Integer> totFreq = af.countFreq(totalScore);									// Frequencies total score
		Map<Integer, Integer> totCumFreq = af.countCumFreq(totalScore, as.n(totalScore));			// Cumulative frequencies total score
		Map<Object, Object> totPctFreq = af.pctFreq(totalScore, as.n(totalScore));					// Percent frequencies total score
		Map<Object, Object> totCumPctFreq = af.pctCumFreq(totalScore, as.n(totalScore));			// Percent cumulative frequencies total score

		pt.writeFreq(totFreq,totCumFreq,totPctFreq,totCumPctFreq);									// Output frequency table


		// Obtain statistics for each Domain score using Blueprint of Test
		for (int k = 0; k < KeyReadIn.getBluePrint().size(); k++) {
			ArrayList<Integer> domainScore = new ArrayList<Integer>();

			for (int i = 0; i < sc.getAllScores().size(); i++) {
				int domScore = (sc.getAllScores().get(i).getDomScores().get(k));
				domainScore.add(domScore);
			}
			n.add(as.n(domainScore));
			mean.add(as.mean(domainScore));
			median.add(as.median(domainScore));
			min.add(as.min(domainScore));
			max.add(as.max(domainScore));
			sd.add(as.sd(domainScore));
			iqr.add(as.IQR(domainScore));

			Map<Integer, Integer> domFreq = af.countFreq(domainScore);								// Frequencies domain score
			Map<Integer, Integer> domCumFreq = af.countCumFreq(domainScore, as.n(domainScore));		// Cumulative frequencies domain score
			Map<Object, Object> domPctFreq = af.pctFreq(domainScore, as.n(domainScore));			// Percent frequencies domain score
			Map<Object, Object> domCumPctFreq = af.pctCumFreq(domainScore, as.n(domainScore));		// Percent cumulative frequencies domain score

			pt.writeFreq(domFreq,domCumFreq,domPctFreq,domCumPctFreq);								// Output frequency table domain score
		}
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getN
	 * @return			Number of observations
	 ------------------------------------------------------------------------**/
	public ArrayList<Integer> getN() {
		return n;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getMean
	 * @return			Mean Scores
	 ------------------------------------------------------------------------**/
	public ArrayList<Double> getMean() {
		return mean;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getMedian
	 * @return			Median Score
	 ------------------------------------------------------------------------**/
	public ArrayList<Integer> getMedian() {
		return median;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getMin
	 * @return			Minimum Score
	 ------------------------------------------------------------------------**/
	public ArrayList<Integer> getMin() {
		return min;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getMax
	 * @return			Maximum Score
	 ------------------------------------------------------------------------**/
	public ArrayList<Integer> getMax() {
		return max;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getSD
	 * @return			SD
	 ------------------------------------------------------------------------**/
	public ArrayList<Double> getSd() {
		return sd;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			getIQR
	 * @return			Interquartile Range
	 ------------------------------------------------------------------------**/
	public ArrayList<Integer> getIqr() {
		return iqr;
	}

}
