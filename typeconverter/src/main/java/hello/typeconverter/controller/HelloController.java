package hello.typeconverter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	@GetMapping("/hello-v1")
	public String helloV1(HttpServletRequest request) {
		String data = request.getParameter("data");
		Integer intValue = Integer.valueOf(data);
		log.info("data====", intValue);

		return "ok";
	}

	@GetMapping("/hello-v2")
	public String helloV2(@RequestParam Integer data) {
		log.info("v2 data====", data);
		return "ok";
	}

	@GetMapping("/ip-port")
	public String ipPort(@RequestParam IpPort ipPort) {
		System.out.println("ipPort ip = " + ipPort.getIp());
		System.out.println("ipPort port = " + ipPort.getPort());
		return "ip ok";
	}

}
