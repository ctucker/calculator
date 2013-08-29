import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static final Pattern DELIMITER_PATTERN = Pattern.compile("^//(.)\n");
	public static final String DEFAULT_DELIMITERS = ",\n";

	public int add(String numbers) {
		if (numbers.isEmpty())
			return 0;
		String[] numberList = extractNumberParts(numbers);
		return addStringNumbers(numberList);
	}

	private String[] extractNumberParts(String numbers) {
		String extraDelimiter = "";
		Matcher matcher = DELIMITER_PATTERN.matcher(numbers);
		if (matcher.find()) {
			extraDelimiter = matcher.group(1);
		}
		return matcher.replaceFirst("").split(delimiterSplitRegexp(extraDelimiter));
	}

	private String delimiterSplitRegexp(String extraDelimiter) {
		return "[" + DEFAULT_DELIMITERS + extraDelimiter + "]";
	}

	private int addStringNumbers(String[] parts) {
		OrganizedNumbers partsAsIntegers = new OrganizedNumbers(parts);
		if (partsAsIntegers.hasNegativeValues()) {
			throw new IllegalArgumentException("Cannot add the negative number(s) " +
					                           partsAsIntegers.getNegativeValues());
		}
		return partsAsIntegers.sumOfPositiveValues();
	}

	private class OrganizedNumbers {
		private List<Integer> negativeValues = new LinkedList<Integer>();
		private List<Integer> positiveValues = new LinkedList<Integer>();

		private OrganizedNumbers(String[] parts) {
			for (String part : parts) {
				int value = Integer.parseInt(part);
				if (value < 0)
					negativeValues.add(value);
				else
					positiveValues.add(value);
			}
		}

		private int sumOfPositiveValues() {
			int accumulator = 0;
			for (int value : positiveValues) {
				accumulator += value;
			}
			return accumulator;
		}

		private boolean hasNegativeValues() {
			return !negativeValues.isEmpty();
		}

		private List<Integer> getNegativeValues() {
			return negativeValues;
		}

	}

}
