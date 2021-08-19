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
		System.out.println(dataResult.size()); // 251 - No. of rows from table.csv data set
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
		
		for (int row = 0; row < lines.size(); row++) {
			
			HashMap<String, Double> currRow = new HashMap<>();
			
//			Generating current row as HashMap by iterating through each column of current row			
			for (int col = 0; col < headers.size(); col++) {
				String currRowInString[] = lines.get(row).split(",");
				currRow.put(headers.get(col), Double.parseDouble(currRowInString[col]));
			}
			
//			Check how the current row is stored
//			System.out.println(currRow.toString());
			
//			Each "row" HashMap is added into the "dataResult" ArrayList
			dataResult.add(currRow);
		}
		return dataResult;
	}

}
