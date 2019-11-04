

import java.util.ArrayList;


public class OptionAnalyzer {
//	private int n;
	private int nitem = 92;
//	private double pct, mean, mpctCorrect;
	private ArrayList<Double> optionStatA = new ArrayList<Double>();
	private ArrayList<Double> optionStatB = new ArrayList<Double>();
	private ArrayList<Double> optionStatC = new ArrayList<Double>();
	private ArrayList<Double> optionStatD = new ArrayList<Double>();
	private ArrayList<Double> optionStatE = new ArrayList<Double>();
	private ArrayList<Double> optionStatO = new ArrayList<Double>();

	public OptionAnalyzer(int j) {
		
		//j is the item number
		
		ArrayList<String> itemResp = new ArrayList<String>();
		for(int i = 0; i < RespReadIn.getAllObservations().size(); i++) {
			itemResp.add(RespReadIn.getAllObservations().get(i).getAnswer().get(j-1));
		}
		
		optionStatA.add((double) getN("A", itemResp));
		optionStatA.add(getPct("A", itemResp));
		optionStatA.add(getMean("A", itemResp));
		optionStatA.add(getmPctCorrect("A", itemResp));
		
		optionStatB.add((double) getN("B", itemResp));
		optionStatB.add(getPct("B", itemResp));
		optionStatB.add(getMean("B", itemResp));
		optionStatB.add(getmPctCorrect("B", itemResp));
		
		optionStatC.add((double) getN("C", itemResp));
		optionStatC.add(getPct("C", itemResp));
		optionStatC.add(getMean("C", itemResp));
		optionStatC.add(getmPctCorrect("C", itemResp));
		
		optionStatD.add((double) getN("D", itemResp));
		optionStatD.add(getPct("D", itemResp));
		optionStatD.add(getMean("D", itemResp));
		optionStatD.add(getmPctCorrect("D", itemResp));
		
		optionStatE.add((double) getN("E", itemResp));
		optionStatE.add(getPct("E", itemResp));
		optionStatE.add(getMean("E", itemResp));
		optionStatE.add(getmPctCorrect("E", itemResp));
		
		optionStatO.add((double) getN("2", itemResp));
		optionStatO.add(getPct("2", itemResp));
		optionStatO.add(getMean("2", itemResp));
		optionStatO.add(getmPctCorrect("2", itemResp));

		
	}

	public int getN(String option, ArrayList<String> itemResp) {
		int n = 0;
		for (int i = 0; i < itemResp.size(); i++) {
			if (itemResp.get(i).equals(option)) {
				n++;
			}
		}
		return n;
	}

	public double getPct(String option, ArrayList<String> itemResp) {
		int totCount = itemResp.size();
		double pct = (double) getN(option, itemResp) / totCount;
//		System.out.println(totCount);
//		System.out.println(pct);
		return pct;
	}

	public double getMean(String option, ArrayList<String> itemResp) {
		// save total score of student who has response = "option"
		ArrayList<Integer> totScore = new ArrayList<Integer>();
		// index saves the index (student order number) of the element of the response
		// list that
		// is equal to option. Total score of the same index will be added to totScore.
		ArrayList<Integer> index = new ArrayList<Integer>();
		ScoreMatrix sc = new ScoreMatrix();
		for (int i = 0; i < itemResp.size(); i++) {
			if (itemResp.get(i).equals(option)) {
				index.add(i);
			}
		}

		for (int j = 0; j < index.size(); j++) {
			int totsc = sc.getAllScores().get(index.get(j)).getTotScore();
			totScore.add(totsc);
		}

		double sum = 0;
		for (int k = 0; k < totScore.size(); k++) {
			sum = sum + totScore.get(k);
		}

		
//		System.out.println(totScore);
//		System.out.println(index);
		double mean = sum / totScore.size();
		return mean;
		

	}

	public double getmPctCorrect(String option, ArrayList<String> itemResp) {

		double mpctCorrect = (double) getMean(option, itemResp) / nitem;
		return mpctCorrect;
	}
	
	public ArrayList<Double> getOptionStatA() {
		return optionStatA;
	}
	
	public ArrayList<Double> getOptionStatB() {
		return optionStatB;
	}
	public ArrayList<Double> getOptionStatC() {
		return optionStatC;
	}
	public ArrayList<Double> getOptionStatD() {
		return optionStatD;
	}
	public ArrayList<Double> getOptionStatE() {
		return optionStatE;
	}
	public ArrayList<Double> getOptionStatO() {
		return optionStatO;
	}

}

