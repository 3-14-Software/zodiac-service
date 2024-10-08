package com.pisoftware.zodiac.service.impl;

import com.pisoftware.zodiac.service.IZodiacService;
import com.pisoftware.zodiac.service.IZodiacSign;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.MonthDay;

@Service
public class WesternZodiacService implements IZodiacService {

	@Override
	public IZodiacSign getSign(LocalDate birthday) {
		MonthDay birthMonthDay = MonthDay.from(birthday);
		for (WesternZodiacSign sign : WesternZodiacSign.values()) {
			if (sign.getStartDate().compareTo(birthMonthDay) <= 0 && sign.getEndDate().compareTo(birthMonthDay) >= 0) {
				return sign;
			}
		}
		return birthMonthDay.isBefore(MonthDay.of(3, 21)) ? WesternZodiacSign.PISCES : WesternZodiacSign.CAPRICORN;
	}

	@Override
	public String getEmoji(IZodiacSign sign) {
		return switch (sign) {
			case WesternZodiacSign.ARIES -> "♈";
			case WesternZodiacSign.TAURUS -> "♉";
			case WesternZodiacSign.GEMINI -> "♊";
			case WesternZodiacSign.CANCER -> "♋";
			case WesternZodiacSign.LEO -> "♌";
			case WesternZodiacSign.VIRGO -> "♍";
			case WesternZodiacSign.LIBRA -> "♎";
			case WesternZodiacSign.SCORPIO -> "♏";
			case WesternZodiacSign.SAGITTARIUS -> "♐";
			case WesternZodiacSign.CAPRICORN -> "♑";
			case WesternZodiacSign.AQUARIUS -> "♒";
			case WesternZodiacSign.PISCES -> "♓";
			default -> "";
		};
	}

}
