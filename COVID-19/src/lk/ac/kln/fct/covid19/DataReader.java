package lk.ac.kln.fct.covid19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataReader {

	  private static final String JSON_ARRAY = "records";
	  private static final String COUNTRY = "countriesAndTerritories";
	  private static final String Selected_Country = "Sri_Lanka";

	    public void readData(String filePath) {
	        try {
	            String fileContent = Files.readString(Paths.get(filePath));
	            JSONObject obj  = new JSONObject(fileContent);
	            JSONArray arr = obj.getJSONArray(JSON_ARRAY);
	            
	            System.out.println("Date\t|\tReported Cases\t|\tDeaths");
	            for(int i = 0; i < arr.length(); i ++) {
	                if(Selected_Country.equals((arr.getJSONObject(i).getString(COUNTRY)))) {
	                	System.out.println((arr.getJSONObject(i).getString("dateRep"))+"\t\t"+(arr.getJSONObject(i).getString("cases"))+"\t\t"+(arr.getJSONObject(i).getString("deaths")));
	                }
	            }
	            
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
	    }
}
