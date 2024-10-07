package com.pisoftware.zodiac.service;

import com.pisoftware.zodiac.service.impl.ChineseZodiacService;
import com.pisoftware.zodiac.service.impl.WesternZodiacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping({"/api/zodiac", "/api/v1/zodiac"})
@SpringBootApplication
public class ZodiacServiceApplication {

	private final IZodiacService chineseZodiacService;
	private final IZodiacService westernZodiacService;

	@Autowired
	public ZodiacServiceApplication(ChineseZodiacService chineseZodiacService, WesternZodiacService westernZodiacService) {
		this.chineseZodiacService = chineseZodiacService;
		this.westernZodiacService = westernZodiacService;
	}

	@GetMapping("/chinese/{birthdate}")
	public String getChineseZodiac(@PathVariable("birthdate") String birthdate) {
		return getZodiacSign(chineseZodiacService, birthdate, false);
	}

	@GetMapping("/chinese/{birthdate}/emoji")
	public String getChineseZodiacWithEmoji(@PathVariable("birthdate") String birthdate) {
		return getZodiacSign(chineseZodiacService, birthdate, true);
	}

	@GetMapping("/western/{birthdate}")
	public String getWesternZodiac(@PathVariable("birthdate") String birthdate) {
		return getZodiacSign(westernZodiacService, birthdate, false);
	}

	@GetMapping("/western/{birthdate}/emoji")
	public String getWesternZodiacWithEmoji(@PathVariable("birthdate") String birthdate) {
		return getZodiacSign(westernZodiacService, birthdate, true);
	}

	private String getZodiacSign(IZodiacService zodiacService, String birthdate, boolean emoji) {
		LocalDate birthDate = LocalDate.parse(birthdate);
		String sign = zodiacService.getSign(birthDate);

		if (emoji) {
			sign = zodiacService.getEmoji(sign);
		}
		return sign;
	}

	public static void main(String[] args) {
		SpringApplication.run(ZodiacServiceApplication.class, args);
	}

}
