package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {

	String filePath = null;

	public StockFileReader(String filePath) {
		this.filePath = filePath;
	}

	public List<String> getHeaders() throws IOException {
		String line = readFirstLine(filePath);
		String[] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
//		Check header values:
//		for(String value : values) {
//			System.out.println(value);
//		}
		return values;
	}

	static String readFirstLine(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	/**
	 * Completed the body of this method.
	 * 
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException {
		List<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
			br.readLine(); // skips the first row (i.e.), the headers of the data set
			String line = null;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		}
		return lines;
	}

}
