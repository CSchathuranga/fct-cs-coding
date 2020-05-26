package lk.ac.kln.fct.covid19;

public class DataProcessor {

	private static final String FILE_PATH = "\\Git\\fct-cs-coding\\COVID-19\\src\\covid-19-data.json";
	
	public static void main(String[] args) {
		DataReader reader = new DataReader();
        reader.readData(FILE_PATH);
	}

}
