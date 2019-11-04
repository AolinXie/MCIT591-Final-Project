

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FrequencyAnalyzer {

	/**
	 * The below methods calculate the frequency, cumulative frequency, %frequency,
	 * and % cumulative frequency for each raw score
	 * 
	 * @param list is the ArrayList of scores (e.g. total or domain)
	 * @return HashMaps to store the values
	 */
	public Map<Integer, Integer> countFreq(ArrayList<Integer> list) {
		SortedMap<Integer, Integer> scoreFreq = new TreeMap<>();
		for (int sc : list) {
			Integer j = scoreFreq.get(sc);
			scoreFreq.put(sc, (j == null) ? 1 : j + 1);
		}
		return scoreFreq;
	}

	/**------------------------------------------------------------------------
	 * Purpose:			This method calculates the count of frequencies for
	 * 					calculation of the cumulative frequencies of a list of scores
	 * 
	 * @param list		ArrayList<Integer> of list of scores
	 * @param n			The count of list of scores
	 * @return			Map<Integer,Integer> of counts and cumulative frequencies
	 ------------------------------------------------------------------------**/
	public Map<Integer, Integer> countCumFreq(ArrayList<Integer> list, int n) {

		Map<Integer, Integer> scoreFreq = new HashMap<>();							// Frequencies of list of scores
		scoreFreq = countFreq(list);

		SortedMap<Integer, Integer> st = new TreeMap<>();

		for (HashMap.Entry<Integer, Integer> x : scoreFreq.entrySet()) {			// Insert the element and and insert its frequency in a set
			st.put(x.getKey(), x.getValue());
		}

		int cumul = 0;

		HashMap<Integer, Integer> cumFreq = new HashMap<>();						// Iterate the set and get the cumulative frequency
		for (SortedMap.Entry<Integer, Integer> x : st.entrySet()) {
			cumul += x.getValue();
			cumFreq.put(x.getKey(), cumul);
		}
		return cumFreq;
	}

	
	/**------------------------------------------------------------------------
	 * Purpose:			Calculates the frequency percent
	 * 
	 * @param list		ArrayList<Integer> of scores, 
	 * @param n			total number of observations (n) in score list
	 * @return			Map<Object,Object> of percents (formatted)
	 ------------------------------------------------------------------------**/
	public Map<Object, Object> pctFreq(ArrayList<Integer> list, int n) {
		
		SortedMap<Integer, Integer> totN = new TreeMap<>();							// create a HashMap with total N
		for (int sc : list) {
			totN.put(sc, n);
		}
		
		Map<Integer, Integer> cFreq = countFreq(list);								// get cumulative frequency

		final Map<Object, Object> pctFreq = cFreq.entrySet().stream().collect(		// divide the frequency by total N 
				Collectors.toMap(Map.Entry::getKey, entry -> 
				asPercent(entry.getValue(), totN.get(entry.getKey()))));
		return pctFreq;
	}

	
	/**------------------------------------------------------------------------
	 * Purpose:			Calculates the cumulative frequency percent
	 * 
	 * @param list		ArrayList<Integer> list of scores
	 * @param n			total number of observations (n) in score list
	 * @return			Map<Object,Object> of cumulative percents (formatted)
	 ------------------------------------------------------------------------**/
	public Map<Object, Object> pctCumFreq(ArrayList<Integer> list, int n) {
		
		SortedMap<Integer, Integer> totN = new TreeMap<>();								// create a HashMap with total N
		for (int sc : list) {
			totN.put(sc, n);
		}
		
		Map<Integer, Integer> cumFreq = countCumFreq(list, n);							// get cumulative frequency
		
		final Map<Object, Object> pctCumFreq = cumFreq.entrySet().stream().collect(		// divide the cumulative frequency by total N 
				Collectors.toMap(Map.Entry::getKey, entry -> 
				asPercent(entry.getValue(), totN.get(entry.getKey()))));
		return pctCumFreq;
	}

	
	/**------------------------------------------------------------------------
	 * Purpose:			Formatting of the percents related to frequencies
	 * 
	 * @param l1		FreqPercent
	 * @param l2		Total number of observations at the that entry
	 * @return			Format, String
	------------------------------------------------------------------------**/
	private static String asPercent(int l1, int l2) {
		return String.format("%2.2f%%", ((float) l1 / l2 * 100));
	}

	
}
