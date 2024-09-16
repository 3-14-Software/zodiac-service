package com.pisoftware.zodiac.service;

import com.pisoftware.zodiac.service.impl.ChineseZodiacService;
import com.pisoftware.zodiac.service.impl.WesternZodiacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/zodiac")
@SpringBootApplication
public class ZodiacServiceApplication {

	private final IZodiacService chineseZodiacService;
	private final IZodiacService westernZodiacService;

	@Autowired
	public ZodiacServiceApplication(ChineseZodiacService chineseZodiacService, WesternZodiacService westernZodiacService) {
		this.chineseZodiacService = chineseZodiacService;
		this.westernZodiacService = westernZodiacService;
	}

	@GetMapping("/chinese")
	public String getChineseZodiac(@RequestParam("birthdate") String birthdate) {
		LocalDate birthDate = LocalDate.parse(birthdate);
		return chineseZodiacService.getSign(birthDate);
	}

	@GetMapping("/western")
	public String getWesternZodiac(@RequestParam("birthdate") String birthdate) {
		LocalDate birthDate = LocalDate.parse(birthdate);
		return westernZodiacService.getSign(birthDate);
	}

	public static void main(String[] args) {
		SpringApplication.run(ZodiacServiceApplication.class, args);
	}

}
