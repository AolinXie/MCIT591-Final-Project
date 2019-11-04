

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class PrintingTables {

	public void writeTA(ArrayList<Double> list) {
		
		try {

			File out = new File("TestAnalysis.txt");
			
			FileWriter fw = new FileWriter(out);
			Writer output = new BufferedWriter(fw);

			for (int i = 0; i < list.size() ; i++) {
				output.write(list.get(i).toString() + "\n");
				}
			
			output.close();
		} catch (Exception e) {
			System.err.println("Could not create that file.");
		}
	}
	

	public void writeIA(ArrayList<Double> list1, ArrayList<Double> list2, 
			ArrayList<String> listLabel) {
		
		try {

			File out = new File("ItemAnalysis.txt");
			
			FileWriter fw = new FileWriter(out);
			Writer output = new BufferedWriter(fw);

			for (int i = 0; i < list1.size() && i < listLabel.size(); i++) {
				output.write(listLabel.get(i).toString() + "\t" + list1.get(i).toString() + 
						"\t" + list2.get(i).toString() + "\n");
				}
			
			output.close();
		} catch (Exception e) {
			System.err.println("Could not create that file.");
		}
	}
	
	public void writeFreq(Map<Integer, Integer> map1, Map<Integer, Integer> map2,
			Map<Object, Object> map3, Map<Object, Object> map4){
		
		File out = new File("freq.txt");
		
		try( PrintWriter pw = new PrintWriter(out) ) {
			
			Iterator<Entry<Integer, Integer>> a = map1.entrySet().iterator(); 
			Iterator<Entry<Integer, Integer>> b= map2.entrySet().iterator(); 
			Iterator<Entry<Object, Object>> c= map3.entrySet().iterator(); 
			Iterator<Entry<Object, Object>> d= map4.entrySet().iterator(); 
			
			while(a.hasNext()){
				while(b.hasNext()) {
					while(c.hasNext()) {
						while(d.hasNext()) {
							
						    Integer key1 = a.next().getKey();
						    Integer key2 = b.next().getKey();
						    Object key3 = c.next().getKey();
						    Object key4 = d.next().getKey();
			    
			    pw.println(key1 +"\t"+ map1.get(key1) + "\t"+ map2.get(key2) 
			    + "\t"+ map3.get(key3) + "\t"+ map4.get(key4));
						}
					}
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not write the File out.  Check permissions, or contact course staff for help");
		}
	}
	
}
