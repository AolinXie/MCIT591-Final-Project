

import java.util.ArrayList;

public class GraphAnalyzer {

	public GraphAnalyzer
	
	ScoreMatrix sm = new ScoreMatrix();
	TestAnalysis ta = new TestAnalysis();
	StatisticsAnalyzer sa = new StatisticsAnalyzer();
	
	
	ArrayList<Integer> totalScores = new ArrayList<>();
	ArrayList<Double> discretePts = new ArrayList<>();
	
	ArrayList<Double> weights = new ArrayList<>();
	

	public static ArrayList<Double> getWeights() {
		return weights;
	}

	//Getting total scores
	public static ArrayList<Integer> totalScores() {
		
		ArrayList<Integer> totalScores = new ArrayList<Integer>();
		for (int i = 0; i < sm.getAllScores().size(); i++) {
			int score = sm.getAllScores().get(i).getTotScore();
			totalScores.add(score);
		}
		
		System.out.println(totalScores);
		return totalScores;
	}

	//Set up the discrete points for calculations
	public static ArrayList<Integer> discrete() {
		
		ArrayList<Integer> discretePoints = new ArrayList<>();
		for (int i = 0; i <= 100; i+=5) {
			discretePoints.add(i);
		}
		System.out.println(discretePoints);
		return discretePoints;
	}
	
	
	//h=(.90*min(SD,(IQR/1.34))*N)**(-1/5);
	public static double smoothingStatistic() {

		// Need to pull in Total test SD, and IQR & N from test analysis
		Double sd = ta.getSd().get(0);
		Integer iqr = ta.getIqr().get(0);
		Integer n = ta.getN().get(0);
		
		double h = Math.pow( ( .90 * Math.min(sd, (iqr/1.34) ) * n ) , -.20 );
		System.out.println(h);
		return h;
	}

	
	
	public static ArrayList<Double> wts(ArrayList<Integer> a, ArrayList<Integer> b) {
		
		
		Double sd = ta.getSd().get(0);										// Need to pull in total score SD from test analysis & h from smoothing statistic
		double h = smoothingStatistic();
		
		ArrayList<Double> weights = new ArrayList<Double>();
		
			for (int i = 0; i < a.size(); i++) {								//testing with 1
				for (int j = 0; j < b.size(); j++) {
				
				weights.add(  ( ( 1/Math.sqrt(Math.PI*h) ) * sd ) 
					* Math.exp( (-1 * (1/(2*h) )  ) * 
							Math.pow(   ( a.get(i) - b.get(j) ) /sd, 2 )  )   )     ;
				
			
		}		
				
	}
			
//			System.out.println(weights);	
	return weights;
	}
	
	public static ArrayList<Double> sumWts() {
		
		ArrayList<Double> sumWt = new ArrayList<Double>();
		double sum = 0.0;
		
			for (int i = 0; i < weights.size(); i++) {	
				if(i % 21 ==0) {
				sum = + weights.get(i);
				
				sumWt.add(sum);
				System.out.println(sum);
				}
	}
			System.out.println(sumWt);	
	return sumWt;
	}
	
	
	public static ArrayList<Integer> getTotalScores() {
		return totalScores;
	}


	public static void setWeights(ArrayList<Double> weights) {
		GraphAnalyzer.weights = weights;
	}

	public ArrayList<Double> getDiscretePts() {
		return discretePts;
	}



}
