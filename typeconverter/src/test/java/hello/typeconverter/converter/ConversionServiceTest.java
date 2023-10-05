package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import hello.typeconverter.type.IpPort;

public class ConversionServiceTest {

	@Test
	void conversionService() {
		DefaultConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new StringToIntegerConverter());
		conversionService.addConverter(new IntegerToStringConverter());
		conversionService.addConverter(new StringToIpPortConverter());
		conversionService.addConverter(new IpPortToStringConverter());

		// Integer result = conversionService.convert("10", Integer.class);
		// System.out.println(result);

		// assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
		// assertThat(conversionService.convert(10, String.class)).isEqualTo("10");

		// IpPort result = conversionService.convert("127.0.0.1:8080", IpPort.class);
		// assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));

		String result = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
		assertThat(result).isEqualTo("127.0.0.1:8080");
	}
}
