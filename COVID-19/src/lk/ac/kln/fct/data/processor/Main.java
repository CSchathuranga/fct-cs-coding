package lk.ac.kln.fct.data.processor;

import java.util.ArrayList;

import lk.ac.kln.fct.data.pojo.Record;

public class Main {
	private static final String FILE_PATH = "\\Git\\fct-cs-coding\\COVID-19\\src\\covid-19-data.json";
	private static final String DATE = "18/05/2020";

	public static void main(String[] args) {
		DataProcessor processor = new DataProcessor();
		sortAndPrint(processor.getDataByDate(FILE_PATH,DATE));
	}
	/**
	 * 
	 * @param records this contain total cases reported until given date
	 */
	public static void sortAndPrint(ArrayList<Record> records) {
		records.sort((record1, record2)-> Integer.compare(record2.getCases(), record1.getCases()));
		for(Record currentrecord:records) {
			int totalcases=currentrecord.getCases();
			if(totalcases>=1000) {
				String country=currentrecord.getCountriesAndTerritories();
				int deaths=currentrecord.getDeaths();
				System.out.println(country+":"+totalcases+":"+deaths);
			}
		}
	}
}
