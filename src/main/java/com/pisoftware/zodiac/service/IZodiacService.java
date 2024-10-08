package com.pisoftware.zodiac.service;

import java.time.LocalDate;

public interface IZodiacService {

	IZodiacSign getSign(LocalDate birthday);

	String getEmoji(IZodiacSign sign);

}
