package hello.typeconverter.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.Locale;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyNumberFormatterTest {

	MyNumberFormatter formatter = new MyNumberFormatter();

	@Test
	void parse() throws ParseException {
		Number result = formatter.parse("1,000", Locale.KOREA);
		Assertions.assertThat(result).isEqualTo(1000L);
	}

	@Test
	void print() {
		String print = formatter.print(1000, Locale.KOREA);
		assertThat(print).isEqualTo("1,000");
	}
}
