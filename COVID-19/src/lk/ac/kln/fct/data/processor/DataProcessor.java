package lk.ac.kln.fct.data.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import lk.ac.kln.fct.data.pojo.Record;
import lk.ac.kln.fct.data.utils.Constants;

public class DataProcessor implements Constants{
	private static DateFormat dateformat = new SimpleDateFormat(DATE_FORMAT);
	 /**
	  * @param filePath  file path to the JSON data file
	  * @param searchDate date input by the user
	  * @return This is a array list of records of data until the given date
	  * @exception JSONException Relevant record is not found for a given date
	  */
	public ArrayList<Record> getDataByDate(String filePath, String searchDate) {
		ArrayList <Record> casesbydate = new ArrayList<Record>();
		try {
			String fileContent = Files.readString(Paths.get(filePath));
			JSONObject obj  = new JSONObject(fileContent);
			JSONArray arr = obj.getJSONArray(JSON_ARRAY);

			for(int i = 0; i < arr.length(); i ++) {
				JSONObject element = arr.getJSONObject(i);
				if(element.getString(DATE).equals(searchDate)) {
					try {
						Date date = dateformat.parse(element.getString(DATE));
						int deaths = element.getInt(DEATHS);
						int cases = element.getInt(CASES);
						String country = element.getString(COUNTRY);
						String continent = element.getString(CONTINENT);
						Record temp = new Record(date, deaths, cases, country,continent);
						casesbydate.add(temp);
					} catch (JSONException | ParseException e) {
						e.printStackTrace();
					}					
				}				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return casesbydate;
	}
}
