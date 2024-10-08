package com.pisoftware.zodiac.service;

public interface IZodiacSign {

	default String getName() {
		return toString();
	}

}
