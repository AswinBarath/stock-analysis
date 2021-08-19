package aggregators;

import java.io.IOException;
import java.util.List;

import fileprocessors.StockFileReader;

public class AggregatorProcessor<AggregatorFunction extends Aggregator> {

	AggregatorFunction aggregator;
	private String filePath;

	public AggregatorProcessor(AggregatorFunction aggregator, String filePath) {
		super();
		this.aggregator = aggregator;
		this.filePath = filePath;
	}

	public double runAggregator(int colIdx) throws IOException {
		StockFileReader fr = new StockFileReader(filePath);
		List<String> lines = fr.readFileData();
		colIdx--; // Converting to zero based indexing
		for(String line : lines) {
			String[] numbers = line.split(",");
			double value = Double.parseDouble(numbers[colIdx]);
			aggregator.add(value);
		}
		double answer = aggregator.calculate();
		return answer;
	}
}
