import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SimpleAdditionTest {

	private final Calculator calculator = new Calculator();

	@Test
	public void addOfEmptyStringIs0() {
		assertThat(calculator.add(""), is(equalTo(0)));
	}

	@Test
	public void addOfSingleNumberIsThatNumber() {
		assertThat(calculator.add("7"), is(equalTo(7)));
	}

	@Test
	public void addOfTwoNumbersIsSumOfThoseNumbers() {
		assertThat(calculator.add("3,5"), is(equalTo(3 + 5)));
	}

	@Test
	public void addOfManyNumbersIsSumOfThoseNumbers() {
		assertThat(calculator.add("3,5,1,3,4"), is(equalTo(3 + 5 + 1 + 3 + 4)));
	}

	@Test
	public void addOfTwoNumbersSeparatedByNewlineIsSumOfThoseNumbers() {
		assertThat(calculator.add("3\n4"), is(equalTo(3 + 4)));
	}

	@Test
	public void addOfThreeNumbersSeparatedByNewlineAndCommaIsSumOfThoseNumbers() {
		assertThat(calculator.add("3,4\n5"), is(equalTo(3 + 4 + 5)));
	}

	@Test
	public void changingDelimiterToSemiColonAllowsForSemicolonSeparators() {
		assertThat(calculator.add("//;\n3;4"), is(equalTo(3 + 4)));
	}

	@Test
	public void changedDelimiterStillAllowsDefaultDelimitersInSameString() {
		assertThat(calculator.add("//:\n3:4,5\n6"), is(equalTo(3 + 4 + 5 + 6)));
	}

	@Test
	public void singleNegativeNumberCausesIAEReportingThatNumber() {
		verifyIAEOnStringWithExceptions("-1");
	}

	@Test
	public void multipleNegativeNumbersCauseIAEReportingAllNumbers() {
		verifyIAEOnStringWithExceptions("-1,-2,-3", "-1", "-2", "-3");
	}

	@Test
	public void negativeNumbersMixedWithPositiveNumbersCauseAnIAE() {
		verifyIAEOnStringWithExceptions("-1,2,-3", "-1", "-3");
	}

	private void verifyIAEOnStringWithExceptions(String numbers, String ... expectedErrors) {
		try {
			calculator.add(numbers);
			fail("Successfully added a negative value!");
		}
		catch (IllegalArgumentException e) {
			for (String expectedError : expectedErrors) {
				assertThat(e.getMessage(), containsString(expectedError));
			}
		}
	}
}
