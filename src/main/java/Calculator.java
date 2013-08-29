public class Calculator {

	public int add(String numbers) {
		if (numbers.isEmpty())
			return 0;
		return addStringParts(numbers.split("[,\n]"));
	}

	private int addStringParts(String[] parts) {
		int accumulator = 0;
		for (String part : parts) {
			accumulator += Integer.parseInt(part);
		}
		return accumulator;
	}

}
