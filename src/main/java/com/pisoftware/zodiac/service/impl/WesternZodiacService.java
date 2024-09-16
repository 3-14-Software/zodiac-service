package com.pisoftware.zodiac.service.impl;

import com.pisoftware.zodiac.service.IZodiacService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.MonthDay;

@Service
public class WesternZodiacService implements IZodiacService {

	private enum ZodiacSign {
		ARIES(MonthDay.of(3, 21), MonthDay.of(4, 19)),
		TAURUS(MonthDay.of(4, 20), MonthDay.of(5, 20)),
		GEMINI(MonthDay.of(5, 21), MonthDay.of(6, 20)),
		CANCER(MonthDay.of(6, 21), MonthDay.of(7, 22)),
		LEO(MonthDay.of(7, 23), MonthDay.of(8, 22)),
		VIRGO(MonthDay.of(8, 23), MonthDay.of(9, 22)),
		LIBRA(MonthDay.of(9, 23), MonthDay.of(10, 22)),
		SCORPIO(MonthDay.of(10, 23), MonthDay.of(11, 21)),
		SAGITTARIUS(MonthDay.of(11, 22), MonthDay.of(12, 21)),
		CAPRICORN(MonthDay.of(12, 22), MonthDay.of(1, 19)),
		AQUARIUS(MonthDay.of(1, 20), MonthDay.of(2, 18)),
		PISCES(MonthDay.of(2, 19), MonthDay.of(3, 20));

		private final MonthDay startDate;
		private final MonthDay endDate;

		ZodiacSign(MonthDay startDate, MonthDay endDate) {
			this.startDate = startDate;
			this.endDate = endDate;
		}
	}

	@Override
	public String getSign(LocalDate birthday) {
		MonthDay birthMonthDay = MonthDay.from(birthday);
		for (ZodiacSign sign : ZodiacSign.values()) {
			if (sign.startDate.compareTo(birthMonthDay) <= 0 && sign.endDate.compareTo(birthMonthDay) >= 0) {
				return sign.name();
			}
		}
		return birthMonthDay.isBefore(MonthDay.of(3, 21)) ? ZodiacSign.PISCES.name() : ZodiacSign.CAPRICORN.name();
	}

}
