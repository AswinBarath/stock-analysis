package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {

	public static void main(String args[]) throws IOException {
		StockFileReader fr = new StockFileReader("table.csv");

		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}

	/**
	 * Completed the method body so that it returns the given structure needed to
	 * populate the data field in the StockFileData class.
	 * 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		// Insert your code here..
		for (int row = 0; row < lines.size(); row++) {
			HashMap<String, Double> currRow = new HashMap<String, Double>();
			for (int col = 0; col < headers.size(); col++) {
				String curr[] = lines.get(row).split(",");
				currRow.put(headers.get(col), Double.parseDouble(curr[col]));
			}
//			System.out.println(currRow.toString());
			dataResult.add(currRow);
		}
		return dataResult;
	}

}
