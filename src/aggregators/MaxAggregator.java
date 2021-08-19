package aggregators;

import java.util.List;

public class MaxAggregator extends Aggregator {

	@Override
	public double calculate() {
		double max = numbers.get(0);
		for (Double number : numbers) {
			if (number > max) {
				max = number;
			}
		}
		return max;
	}

	@Override
	public List<Double> getValues() {
		return numbers;
	}

}
