package com.pisoftware.zodiac.service.impl;

import com.pisoftware.zodiac.service.IZodiacService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ChineseZodiacService implements IZodiacService {

	private enum ZODIAC_SIGNS {
		RAT, OX, TIGER, RABBIT, DRAGON, SNAKE,
		HORSE, GOAT, MONKEY, ROOSTER, DOG, PIG;
	}

	@Override
	public String getSign(LocalDate birthday) {
		int year = birthday.getYear();
		int zodiacIndex = (year - 4) % 12; // The cycle starts at 4 (Rat year)
		return ZODIAC_SIGNS.values()[zodiacIndex].name();
	}

}
