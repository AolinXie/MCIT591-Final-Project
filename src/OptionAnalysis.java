
import java.util.ArrayList;
import java.util.HashMap;

public class OptionAnalysis {
	HashMap<String, ArrayList<Double>> optionHM = new HashMap<>();
	
	public OptionAnalysis(){
		
		
		//HashMap<String, ArrayList<Double>> optionHM = new HashMap<>();
		OptionAnalyzer oa = new OptionAnalyzer(1);
		optionHM.put("A", oa.getOptionStatA());
		optionHM.put("B", oa.getOptionStatB());
		optionHM.put("C", oa.getOptionStatC());
		optionHM.put("D", oa.getOptionStatD());
		optionHM.put("E", oa.getOptionStatE());
		optionHM.put("Omit", oa.getOptionStatO());
		System.out.println(optionHM);

	}
	
//	public static void main(String[] arg) {
//		OptionAnalysis oaa = new OptionAnalysis();
//
//	}
}
