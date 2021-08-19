package aggregators;

import java.util.List;

public class MinAggregator extends Aggregator {

	@Override
	public double calculate() {
		double min = numbers.get(0);
		for (Double number : numbers) {
			if (number < min) {
				min = number;
			}
		}
		return min;
	}

	@Override
	public List<Double> getValues() {
		return numbers;
	}

}
