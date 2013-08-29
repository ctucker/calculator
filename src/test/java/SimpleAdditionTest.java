import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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



}
