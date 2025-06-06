package dev.plastikrab.weatherapp

object Screens{
    const val MAIN_SCREEN = "main"
    const val FORECAST_SCREEN = "forecast"
}

const val TAG = "MyLog"


const val MOCK_JSON = """
    {
  "city": {
    "id": 524901,
    "name": "Moscow",
    "coord": {
      "lon": 37.6156,
      "lat": 55.7522
    },
    "country": "RU",
    "population": 13097587,
    "timezone": 10800
  },
  "cod": "200",
  "message": 0.001,
  "cnt": 7,
  "list": [
    {
      "dt": 1717612800,
      "sunrise": 1717551000,
      "sunset": 1717619400,
      "temp": {
        "day": 288.15,
        "min": 286.15,
        "max": 289.15,
        "night": 286.5,
        "eve": 287.8,
        "morn": 286.15
      },
      "feels_like": {
        "day": 287.9,
        "night": 286.2,
        "eve": 287.5,
        "morn": 285.9
      },
      "pressure": 1012,
      "humidity": 70,
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01d"
        }
      ],
      "speed": 3.0,
      "deg": 270,
      "gust": 4.5,
      "clouds": 0,
      "pop": 0.1
    },
    {
      "dt": 1717699200,
      "sunrise": 1717637400,
      "sunset": 1717705800,
      "temp": {
        "day": 290.0,
        "min": 287.0,
        "max": 291.0,
        "night": 288.0,
        "eve": 289.5,
        "morn": 287.0
      },
      "feels_like": {
        "day": 289.8,
        "night": 287.8,
        "eve": 289.2,
        "morn": 286.8
      },
      "pressure": 1010,
      "humidity": 65,
      "weather": [
        {
          "id": 801,
          "main": "Clouds",
          "description": "few clouds",
          "icon": "02d"
        }
      ],
      "speed": 3.5,
      "deg": 280,
      "gust": 5.0,
      "clouds": 20,
      "pop": 0.2
    },
    {
      "dt": 1717785600,
      "sunrise": 1717723800,
      "sunset": 1717792200,
      "temp": {
        "day": 289.5,
        "min": 286.5,
        "max": 290.5,
        "night": 287.5,
        "eve": 288.8,
        "morn": 286.5
      },
      "feels_like": {
        "day": 289.3,
        "night": 287.3,
        "eve": 288.6,
        "morn": 286.3
      },
      "pressure": 1011,
      "humidity": 75,
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10d"
        }
      ],
      "speed": 4.0,
      "deg": 290,
      "gust": 6.0,
      "clouds": 75,
      "pop": 0.6,
      "rain": 1.5
    },
    {
      "dt": 1717872000,
      "sunrise": 1717810200,
      "sunset": 1717878600,
      "temp": {
        "day": 291.0,
        "min": 287.5,
        "max": 292.0,
        "night": 289.0,
        "eve": 290.0,
        "morn": 287.5
      },
      "feels_like": {
        "day": 290.8,
        "night": 288.8,
        "eve": 289.8,
        "morn": 287.3
      },
      "pressure": 1009,
      "humidity": 60,
      "weather": [
        {
          "id": 802,
          "main": "Clouds",
          "description": "scattered clouds",
          "icon": "03d"
        }
      ],
      "speed": 3.2,
      "deg": 275,
      "gust": 4.8,
      "clouds": 40,
      "pop": 0.3
    },
    {
      "dt": 1717958400,
      "sunrise": 1717896600,
      "sunset": 1717965000,
      "temp": {
        "day": 293.0,
        "min": 288.0,
        "max": 294.0,
        "night": 290.0,
        "eve": 292.0,
        "morn": 288.0
      },
      "feels_like": {
        "day": 292.8,
        "night": 289.8,
        "eve": 291.8,
        "morn": 287.8
      },
      "pressure": 1013,
      "humidity": 55,
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01d"
        }
      ],
      "speed": 2.5,
      "deg": 260,
      "gust": 4.0,
      "clouds": 0,
      "pop": 0.1
    },
    {
      "dt": 1718044800,
      "sunrise": 1717983000,
      "sunset": 1718051400,
      "temp": {
        "day": 295.0,
        "min": 289.0,
        "max": 296.0,
        "night": 291.0,
        "eve": 293.0,
        "morn": 289.0
      },
      "feels_like": {
        "day": 294.8,
        "night": 290.8,
        "eve": 292.8,
        "morn": 288.8
      },
      "pressure": 1015,
      "humidity": 50,
      "weather": [
        {
          "id": 801,
          "main": "Clouds",
          "description": "few clouds",
          "icon": "02d"
        }
      ],
      "speed": 2.8,
      "deg": 265,
      "gust": 4.2,
      "clouds": 15,
      "pop": 0.1
    },
    {
      "dt": 1718131200,
      "sunrise": 1718069400,
      "sunset": 1718137800,
      "temp": {
        "day": 294.5,
        "min": 288.5,
        "max": 295.5,
        "night": 290.5,
        "eve": 292.5,
        "morn": 288.5
      },
      "feels_like": {
        "day": 294.3,
        "night": 290.3,
        "eve": 292.3,
        "morn": 288.3
      },
      "pressure": 1014,
      "humidity": 60,
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10d"
        }
      ],
      "speed": 3.8,
      "deg": 285,
      "gust": 5.5,
      "clouds": 60,
      "pop": 0.5,
      "rain": 1.0
    }
  ]
}
"""