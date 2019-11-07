

public class Runner {

	public static void main(String[] arg) {
		
		//Prompt user for input data file and read in response data
		System.out.println("What is the PATH LOCATION and NAME (with extension) of your input datafile? [e.g.:  C:\\\\filename.csv] ");
		RespReadIn rr = new RespReadIn();
		
		//Prompt user for input key file and read in keys and domain levels
		System.out.println("What is the location and name of the key file for your data?");
		KeyReadIn kr = new KeyReadIn();
//		System.out.printf("Key count %d%n", kr.getAllKeys().size());

		//Create a score matrix to score data
		ScoreMatrix sm = new ScoreMatrix();
		sm.getAllScores();
		
		//Conduct item analysis
		ItemAnalysis ia = new ItemAnalysis();
		ia.itemPPlus();
		ia.rBiserial();
//		System.out.println(ia.itemPPlus());
//		System.out.println(ia.rBiserial());
		
		//Print out item analysis
//		PrintingTables pt = new PrintingTables();
//		pt.writeIA(ia.itemPPlus(),ia.rBiserial(),rr.getHeader());
		
		//Conduct Test analysis
		TestAnalysis ta = new TestAnalysis();
//		pt.writeTA(ta.getMean());
		
		GraphAnalyzer ga = new GraphAnalyzer();
		ga.totalScores();
		ga.discrete();
		ga.smoothingStatistic();
		ga.wts(ga.totalScores(),ga.discrete());
		
		
		
		//Conduct Option Analysis
//		AnalyzeOptions oa = new AnalyzeOptions(1);
//		System.out.println(oa.getOptionStatA());
//		
//		OptionAnalysis aa = new OptionAnalysis();
		
		
		
	}
}
