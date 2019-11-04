

import java.util.ArrayList;

public class GraphAnalyzer {

	static ScoreMatrix sm = new ScoreMatrix();
	static TestAnalysis ta = new TestAnalysis();
	static StatisticsAnalyzer sa = new StatisticsAnalyzer();
	
	
	
	
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

		// Need to pull in Total test SD, and IQR from test analysis
		Double sd = ta.getSd().get(0);
		Integer iqr = ta.getIqr().get(0);
		
		//Getting total N from statistic analyzer method
		int n = sa.n(totalScores());
		
		double h = Math.pow( ( .90 * Math.min(sd, (iqr/1.34) ) * n ) , -.20 );

//		System.out.println(n + "  " + mean + " " + sd + " " + iqr);
//		System.out.println(h);
		
		return h;
	}

	
	
	
//weight at discrete point = ( (1/SQRT(PI*h) )* sd )               
		// *EXP( (-1 * (1/(2*h) ) ) * ( (total-discrete_pt)/sd )^2  )
	public static  ArrayList<Double>  test() {

		ArrayList<Integer> scores = totalScores();
		ArrayList<Integer> discrete = discrete();
		
		
		// Need to pull in total score SD, and IQR from test analysis
		Double sd = ta.getSd().get(0);
		Integer iqr = ta.getIqr().get(0);
		double h = smoothingStatistic();
		
		ArrayList<Double> weights = new ArrayList<Double>();
		
		for (int i = 0; i < scores.size(); i++) {
			
			for (int j = 0; j < discrete.size(); j++) {
				
				ArrayList<Integer> a1 = new ArrayList<Integer>();
				ArrayList<Integer> a2  = new ArrayList<Integer>();
				
				a1.add(scores.get(i));
				a2.add(discrete.get(j));
				weights.add(  ( ( 1/Math.sqrt(Math.PI*h) ) * sd )
					* Math.exp( (-1 * (1/(2*h) ) ) *  Math.pow( ( scores.get(i) - discrete.get(j) ) /sd, 2 ) )  )  ;
				System.out.println(a1);
				System.out.println(a2);
				System.out.println(weights);
			}
		
		}
//		System.out.println(weights);
		return weights;
	}

	
	



}
