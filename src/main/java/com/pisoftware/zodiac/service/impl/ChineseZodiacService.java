package com.pisoftware.zodiac.service.impl;

import com.pisoftware.zodiac.service.IZodiacService;
import com.pisoftware.zodiac.service.IZodiacSign;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ChineseZodiacService implements IZodiacService {

	@Override
	public IZodiacSign getSign(LocalDate birthday) {
		int year = birthday.getYear();
		int zodiacIndex = (year - 4) % 12; // The cycle starts at 4 (Rat year)
		return ChineseZodiacSign.values()[zodiacIndex];
	}

	@Override
	public String getEmoji(IZodiacSign sign) {
		return switch (sign) {
			case ChineseZodiacSign.RAT -> "🐀";
			case ChineseZodiacSign.OX -> "🐂";
			case ChineseZodiacSign.TIGER -> "🐅";
			case ChineseZodiacSign.RABBIT -> "🐇";
			case ChineseZodiacSign.DRAGON -> "🐉";
			case ChineseZodiacSign.SNAKE -> "🐍";
			case ChineseZodiacSign.HORSE -> "🐎";
			case ChineseZodiacSign.GOAT -> "🐐";
			case ChineseZodiacSign.MONKEY -> "🦧";
			case ChineseZodiacSign.ROOSTER -> "🐓";
			case ChineseZodiacSign.DOG -> "🐩";
			case ChineseZodiacSign.PIG -> "🐖";
			default -> "";
		};
	}

}
