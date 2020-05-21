package covid;

public class DataProcessor {

	private static final String FILE_PATH = "src\\covid\\covid-19-data.json";
	
	public static void main(String[] args) {
		DataReader reader = new DataReader();
        reader.readData(FILE_PATH);
	}

}
