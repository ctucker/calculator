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

}
