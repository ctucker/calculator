import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static final Pattern DELIMITER_PATTERN = Pattern.compile("^//(.)\n");
	public static final String DEFAULT_DELIMITERS = ",\n";

	public int add(String numbers) {
		if (numbers.isEmpty())
			return 0;
		String[] numberList = parseNumbersString(numbers);
		return addStringParts(numberList);
	}

	private String[] parseNumbersString(String numbers) {
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

	private int addStringParts(String[] parts) {
		int accumulator = 0;
		for (String part : parts) {
			accumulator += Integer.parseInt(part);
		}
		return accumulator;
	}

}
