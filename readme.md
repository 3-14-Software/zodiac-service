# ♒ Zodiac Service

## Introduction

A simple REST API that calculate and returns a Western 🇪🇺 or Chinese 🇨🇳 astrological sign, based on a user's birthdate. 

It supports both standard text and emoji format for zodiac signs.

## API Structure

**Base URLs:**
- `http://localhost:8080/api/zodiac`
- `http://localhost:8080/api/v1/zodiac`

The API offers four main endpoints to calculate the Chinese and Western zodiac signs, either with or without emoji.

### Endpoints

#### 1. **Get Chinese Zodiac Sign**
- **URL:** `/api/zodiac/chinese/{birthdate}`
- **Method:** `GET`
- **Description:** Returns the Chinese zodiac sign's name, based on the birthdate.
- **Parameters:**
    - `birthdate`: The birthdate in `yyyy-MM-dd` format. Example: `1990-12-25`
- **Response:**
    - Type: `text/plain`
    - Body: `Horse`

#### 2. **Get Chinese Zodiac Emoji**
- **URL:** `/api/zodiac/chinese/{birthdate}/emoji`
- **Method:** `GET`
- **Description:** Returns the Chinese zodiac sign as an emoji, based on the birthdate.
- **Parameters:**
    - `birthdate`: The birthdate in `yyyy-MM-dd` format. Example: `1990-12-25`
- **Response:**
    - Type: `text/plain`
    - Body: `🐎`

#### 3. **Get Western Zodiac Sign**
- **URL:** `/api/zodiac/western/{birthdate}`
- **Method:** `GET`
- **Description:** Returns the Western zodiac sign's name, based on the birthdate.
- **Parameters:**
    - `birthdate`: The birthdate in `yyyy-MM-dd` format. Example: `1990-12-25`
- **Response:**
    - Type: `text/plain`
    - Body: `Capricorn`

#### 4. **Get Western Zodiac Emoji**
- **URL:** `/api/zodiac/western/{birthdate}/emoji`
- **Method:** `GET`
- **Description:** Returns the Western zodiac sign as an emoji, based on the birthdate.
- **Parameters:**
    - `birthdate`: The birthdate in `yyyy-MM-dd` format. Example: `1990-12-25`
- **Response:**
    - Type: `text/plain`
    - Body: `♑`

## Error Handling

- **400 Bad Request:** If the date format is incorrect or an invalid date is provided.
- **404 Not Found:** If no zodiac sign is found for the given date (rarely applicable unless there is an error).

## Usage Examples

1. **Get the Chinese zodiac sign for someone born on December 25, 1990:**
    - **Request:** `GET /api/zodiac/chinese/1990-12-25`
    - **Response:** `Horse`

2. **Get the Chinese zodiac emoji for someone born on January 1, 2000:**
    - **Request:** `GET /api/zodiac/chinese/2000-01-01/emoji`
    - **Response:** `🐉`

3. **Get the Western zodiac sign for someone born on December 25, 1990:**
    - **Request:** `GET /api/zodiac/western/1990-12-25`
    - **Response:** `Capricorn`

4. **Get the Western zodiac emoji for someone born on January 1, 2000:**
    - **Request:** `GET /api/zodiac/western/2000-01-01/emoji`
    - **Response:** `♓`

## Running the Application

To start the application, use the following command:

```bash
mvn spring-boot:run
```

The service will be accessible at:
- `http://localhost:8080/api/zodiac`
- `http://localhost:8080/api/v1/zodiac`