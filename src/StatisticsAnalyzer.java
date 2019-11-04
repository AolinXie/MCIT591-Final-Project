
import java.util.ArrayList;
import java.util.Collections;


public class StatisticsAnalyzer {

	
	/**------------------------------------------------------------------------
	 *Purpose:				Calculate the N, or number of observations
	 *						from a list of scores
	 * 
	 * @param list 			ArrayList<Integer> of scores
	 * @return				N, or number of observations, Integer
	 *-------------------------------------------------------------------------**/
	public int n(ArrayList<Integer> list) {
		int n = list.size();
		return n;
	}
	
	/**------------------------------------------------------------------------
	 * Purpose:			Calculate the average (Mean) of a list of scores
	 * 
	 * @param list		ArrayList<Integer> of a list of scores	
	 * @return:			Mean (average) Total Score
	 *-------------------------------------------------------------------------**/
	public double mean(ArrayList<Integer> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		double mean = (double) sum / list.size();
		return mean;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			Calculate the median of a list of scores
	 * 
	 * @param list:		ArrayList<Integer> of a list of scores
	 * @return:			Median of Total Scores
	 *-------------------------------------------------------------------------**/
	public int median(ArrayList<Integer> list) {
		Collections.sort(list);
		int median = -1;
		if (list.size() % 2 == 1) {
			median = (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
		} else {
			median = (list.get(list.size() / 2));
		}
		return median;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			Calculate the maximum of a list of scores
	 * 
	 * @param list		ArrayList<Integer> of a list of scores
	 * @return:			Maximum value
	 *-------------------------------------------------------------------------**/
	public int max(ArrayList<Integer> list) {
		int max = Collections.max(list);
		return max;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			Calculate the minimum of a list of scores
	 * 
	 * @param list		ArrayList<Integer>
	 * @return			Minimum value
	 *-------------------------------------------------------------------------**/
	public int min(ArrayList<Integer> list) {
		int min = Collections.min(list);
		return min;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			Calculate the standard deviation of a list of scores
	 * 
	 * @param list		ArrayList<Integer>
	 * @return			Standard deviation (double) of a list of scores
	*-------------------------------------------------------------------------**/
	public double sd(ArrayList<Integer> list) {
		double mean = mean(list);
		double temp = 0;
		for (int i = 0; i < list.size(); i++) {
			int val = list.get(i);
			double sqDifM = Math.pow(val - mean, 2);
			temp += sqDifM;
		}
		double mOfDif = (double) temp / list.size();
		return Math.sqrt(mOfDif);
	}

		  
	/**------------------------------------------------------------------------
	 * Purpose:			Calculate the IQR of a list of scores
	 * 
	 * @param list		ArrayList<Integer>
	 * @return			Interquartile Range of a list of scores
	*-------------------------------------------------------------------------**/	
	public int IQR(ArrayList<Integer> list) { 

		Collections.sort(list);

		int lowerBound;
		int upperBound;

		if (list.size() % 2 == 0) {
			lowerBound = list.size() / 2 - 1;
			upperBound = list.size() / 2;
		} else {
			lowerBound = list.size() / 2 - 1;
			upperBound = list.size() / 2 + 1;
		}

		double q1 = medianForIQR(list, 0, lowerBound);
		double q3 = medianForIQR(list, upperBound, list.size() - 1);

		int iqr = (int) (q3  - q1);
		return iqr;

	} 
	
	/**------------------------------------------------------------------------
	 * Purpose:			Calculate the median of lower and upper bounds
	 * 					for IQR calculation
	 * 
	 * @param list		ArrayList<Integer>
	 * @return			Median value for IQR bounds
	*-------------------------------------------------------------------------**/	
	public int medianForIQR(ArrayList<Integer> list, int beginIndex, int endIndex) {
		int size = endIndex - beginIndex + 1;
		if (size % 2 == 0) {
			return (list.get(beginIndex + size / 2 - 1) + list.get(beginIndex + size / 2)) / 2;
		} else {
			return list.get(beginIndex + size / 2);
		}
	}
	
}
		


