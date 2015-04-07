package asthma.watch.util;

public class ConstantValues {
	public static final String WU_URL = "http://api.wunderground.com/api/7376ff9876400cb0/";
	public static final String CLARITIN_URL = "http://www.claritin.com/weatherpollenservice/weatherpollenservice.svc/getforecast/";
	public static final String EPA_URL="http://www.airnowapi.org//aq/forecast/zipCode/?format=application/json&api_key=D46398E5-2646-4D3B-95A2-A618D3AF3906&zipCode=";

	public static final String CONDITIONS_TEST = "{\r\n  \"response\": {\r\n  \"version\": \"0.1\",\r\n  \"termsofService\": \"http://www.wunderground.com/weather/api/d/terms.html\",\r\n  \"features\": {\r\n  \"conditions\": 1\r\n  }\r\n  },\r\n  \"current_observation\": {\r\n  \"image\": {\r\n  \"url\": \"http://icons-ak.wxug.com/graphics/wu2/logo_130x80.png\",\r\n  \"title\": \"Weather Underground\",\r\n  \"link\": \"http://www.wunderground.com\"\r\n  },\r\n  \"display_location\": {\r\n  \"full\": \"San Francisco, CA\",\r\n  \"city\": \"San Francisco\",\r\n  \"state\": \"CA\",\r\n  \"state_name\": \"California\",\r\n  \"country\": \"US\",\r\n  \"country_iso3166\": \"US\",\r\n  \"zip\": \"94101\",\r\n  \"latitude\": \"37.77500916\",\r\n  \"longitude\": \"-122.41825867\",\r\n  \"elevation\": \"47.00000000\"\r\n  },\r\n  \"observation_location\": {\r\n  \"full\": \"SOMA - Near Van Ness, San Francisco, California\",\r\n  \"city\": \"SOMA - Near Van Ness, San Francisco\",\r\n  \"state\": \"California\",\r\n  \"country\": \"US\",\r\n  \"country_iso3166\": \"US\",\r\n  \"latitude\": \"37.773285\",\r\n  \"longitude\": \"-122.417725\",\r\n  \"elevation\": \"49 ft\"\r\n  },\r\n  \"estimated\": {},\r\n  \"station_id\": \"KCASANFR58\",\r\n  \"observation_time\": \"Last Updated on June 27, 5:27 PM PDT\",\r\n  \"observation_time_rfc822\": \"Wed, 27 Jun 2012 17:27:13 -0700\",\r\n  \"observation_epoch\": \"1340843233\",\r\n  \"local_time_rfc822\": \"Wed, 27 Jun 2012 17:27:14 -0700\",\r\n  \"local_epoch\": \"1340843234\",\r\n  \"local_tz_short\": \"PDT\",\r\n  \"local_tz_long\": \"America/Los_Angeles\",\r\n  \"local_tz_offset\": \"-0700\",\r\n  \"weather\": \"Partly Cloudy\",\r\n  \"temperature_string\": \"66.3 F (19.1 C)\",\r\n  \"temp_f\": 66.3,\r\n  \"temp_c\": 19.1,\r\n  \"relative_humidity\": \"65%\",\r\n  \"wind_string\": \"From the NNW at 22.0 MPH Gusting to 28.0 MPH\",\r\n  \"wind_dir\": \"NNW\",\r\n  \"wind_degrees\": 346,\r\n  \"wind_mph\": 22.0,\r\n  \"wind_gust_mph\": \"28.0\",\r\n  \"wind_kph\": 35.4,\r\n  \"wind_gust_kph\": \"45.1\",\r\n  \"pressure_mb\": \"1013\",\r\n  \"pressure_in\": \"29.93\",\r\n  \"pressure_trend\": \"+\",\r\n  \"dewpoint_string\": \"54 F (12 C)\",\r\n  \"dewpoint_f\": 54,\r\n  \"dewpoint_c\": 12,\r\n  \"heat_index_string\": \"NA\",\r\n  \"heat_index_f\": \"NA\",\r\n  \"heat_index_c\": \"NA\",\r\n  \"windchill_string\": \"NA\",\r\n  \"windchill_f\": \"NA\",\r\n  \"windchill_c\": \"NA\",\r\n  \"feelslike_string\": \"66.3 F (19.1 C)\",\r\n  \"feelslike_f\": \"66.3\",\r\n  \"feelslike_c\": \"19.1\",\r\n  \"visibility_mi\": \"10.0\",\r\n  \"visibility_km\": \"16.1\",\r\n  \"solarradiation\": \"\",\r\n  \"UV\": \"5\",\r\n  \"precip_1hr_string\": \"0.00 in ( 0 mm)\",\r\n  \"precip_1hr_in\": \"0.00\",\r\n  \"precip_1hr_metric\": \" 0\",\r\n  \"precip_today_string\": \"0.00 in (0 mm)\",\r\n  \"precip_today_in\": \"0.00\",\r\n  \"precip_today_metric\": \"0\",\r\n  \"icon\": \"partlycloudy\",\r\n  \"icon_url\": \"http://icons-ak.wxug.com/i/c/k/partlycloudy.gif\",\r\n  \"forecast_url\": \"http://www.wunderground.com/US/CA/San_Francisco.html\",\r\n  \"history_url\": \"http://www.wunderground.com/history/airport/KCASANFR58/2012/6/27/DailyHistory.html\",\r\n  \"ob_url\": \"http://www.wunderground.com/cgi-bin/findweather/getForecast?query=37.773285,-122.417725\"\r\n  }\r\n}";
	public static final String FORECAST_TEST = "\r\n  \"date\": {\r\n  \"epoch\": \"1340863200\",\r\n  \"pretty\": \"11:00 PM PDT on June 27, 2012\",\r\n  \"day\": 27,\r\n  \"month\": 6,\r\n  \"year\": 2012,\r\n  \"yday\": 178,\r\n  \"hour\": 23,\r\n  \"min\": \"00\",\r\n  \"sec\": 0,\r\n  \"isdst\": \"1\",\r\n  \"monthname\": \"June\",\r\n  \"weekday_short\": \"Wed\",\r\n  \"weekday\": \"Wednesday\",\r\n  \"ampm\": \"PM\",\r\n  \"tz_short\": \"PDT\",\r\n  \"tz_long\": \"America/Los_Angeles\"\r\n  },\r\n  \"period\": 2,\r\n  \"high\": {\r\n  \"fahrenheit\": \"72\",\r\n  \"celsius\": \"22\"\r\n  },\r\n  \"low\": {\r\n  \"fahrenheit\": \"54\",\r\n  \"celsius\": \"12\"\r\n  },\r\n  \"conditions\": \"Partly Cloudy\",\r\n  \"icon\": \"partlycloudy\",\r\n  \"icon_url\": \"http://icons-ak.wxug.com/i/c/k/partlycloudy.gif\",\r\n  \"skyicon\": \"mostlysunny\",\r\n  \"pop\": 0,\r\n  \"qpf_allday\": {\r\n  \"in\": 0.00,\r\n  \"mm\": 0.0\r\n  },\r\n  \"qpf_day\": {\r\n  \"in\": 0.00,\r\n  \"mm\": 0.0\r\n  },\r\n  \"qpf_night\": {\r\n  \"in\": 0.00,\r\n  \"mm\": 0.0\r\n  },\r\n  \"snow_allday\": {\r\n  \"in\": 0,\r\n  \"cm\": 0\r\n  },\r\n  \"snow_day\": {\r\n  \"in\": 0,\r\n  \"cm\": 0\r\n  },\r\n  \"snow_night\": {\r\n  \"in\": 0,\r\n  \"cm\": 0\r\n  },\r\n  \"maxwind\": {\r\n  \"mph\": 11,\r\n  \"kph\": 18,\r\n  \"dir\": \"WSW\",\r\n  \"degrees\": 255\r\n  },\r\n  \"avewind\": {\r\n  \"mph\": 9,\r\n  \"kph\": 14,\r\n  \"dir\": \"WSW\",\r\n  \"degrees\": 252\r\n  },\r\n  \"avehumidity\": 70,\r\n  \"maxhumidity\": 84,\r\n  \"minhumidity\": 54\r\n  }, {\r\n  \"date\": {\r\n  \"epoch\": \"1340949600\",\r\n  \"pretty\": \"11:00 PM PDT on June 28, 2012\",\r\n  \"day\": 28,\r\n  \"month\": 6,\r\n  \"year\": 2012,\r\n  \"yday\": 179,\r\n  \"hour\": 23,\r\n  \"min\": \"00\",\r\n  \"sec\": 0,\r\n  \"isdst\": \"1\",\r\n  \"monthname\": \"June\",\r\n  \"weekday_short\": \"Thu\",\r\n  \"weekday\": \"Thursday\",\r\n  \"ampm\": \"PM\",\r\n  \"tz_short\": \"PDT\",\r\n  \"tz_long\": \"America/Los_Angeles\"\r\n  },\r\n  \"period\": 3,\r\n  \"high\": {\r\n  \"fahrenheit\": \"72\",\r\n  \"celsius\": \"22\"\r\n  },\r\n  \"low\": {\r\n  \"fahrenheit\": \"54\",\r\n  \"celsius\": \"12\"\r\n  },\r\n  \"conditions\": \"Partly Cloudy\",\r\n  \"icon\": \"partlycloudy\",\r\n  \"icon_url\": \"http://icons-ak.wxug.com/i/c/k/partlycloudy.gif\",\r\n  \"skyicon\": \"partlycloudy\",\r\n  \"pop\": 0,\r\n  \"qpf_allday\": {\r\n  \"in\": 0.00,\r\n  \"mm\": 0.0\r\n  },\r\n  \"qpf_day\": {\r\n  \"in\": 0.00,\r\n  \"mm\": 0.0\r\n  },\r\n  \"qpf_night\": {\r\n  \"in\": 0.00,\r\n  \"mm\": 0.0\r\n  },\r\n  \"snow_allday\": {\r\n  \"in\": 0,\r\n  \"cm\": 0\r\n  },\r\n  \"snow_day\": {\r\n  \"in\": 0,\r\n  \"cm\": 0\r\n  },\r\n  \"snow_night\": {\r\n  \"in\": 0,\r\n  \"cm\": 0\r\n  },\r\n  \"maxwind\": {\r\n  \"mph\": 14,\r\n  \"kph\": 22,\r\n  \"dir\": \"West\",\r\n  \"degrees\": 265\r\n  },\r\n  \"avewind\": {\r\n  \"mph\": 12,\r\n  \"kph\": 19,\r\n  \"dir\": \"WSW\",\r\n  \"degrees\": 256\r\n  },\r\n  \"avehumidity\": 80,\r\n  \"maxhumidity\": 91,\r\n  \"minhumidity\": 56\r\n  }, {\r\n  \"date\": {\r\n  \"epoch\": \"1341036000\",\r\n  \"pretty\": \"11:00 PM PDT on June 29, 2012\",\r\n  \"day\": 29,\r\n  \"month\": 6,\r\n  \"year\": 2012,\r\n  \"yday\": 180,\r\n  \"hour\": 23,\r\n  \"min\": \"00\",\r\n  \"sec\": 0,\r\n  \"isdst\": \"1\",\r\n  \"monthname\": \"June\",\r\n  \"weekday_short\": \"Fri\",\r\n  \"weekday\": \"Friday\",\r\n  \"ampm\": \"PM\",\r\n  \"tz_short\": \"PDT\",\r\n  \"tz_long\": \"America/Los_Angeles\"\r\n  },\r\n  \"period\": 4,\r\n  \"high\": {\r\n  \"fahrenheit\": \"68\",\r\n  \"celsius\": \"20\"\r\n  },\r\n  \"low\": {\r\n  \"fahrenheit\": \"52\",\r\n  \"celsius\": \"11\"\r\n  },\r\n  \"conditions\": \"Fog\",\r\n  \"icon\": \"partlycloudy\",\r\n  \"icon_url\": \"http://icons-ak.wxug.com/i/c/k/partlycloudy.gif\",\r\n  \"skyicon\": \"mostlysunny\",\r\n  \"pop\": 0,\r\n  \"qpf_allday\": {\r\n  \"in\": 0.00,\r\n  \"mm\": 0.0\r\n  },\r\n  \"qpf_day\": {\r\n  \"in\": 0.00,\r\n  \"mm\": 0.0\r\n  },\r\n  \"qpf_night\": {\r\n  \"in\": 0.00,\r\n  \"mm\": 0.0\r\n  },\r\n  \"snow_allday\": {\r\n  \"in\": 0,\r\n  \"cm\": 0\r\n  },\r\n  \"snow_day\": {\r\n  \"in\": 0,\r\n  \"cm\": 0\r\n  },\r\n  \"snow_night\": {\r\n  \"in\": 0,\r\n  \"cm\": 0\r\n  },\r\n  \"maxwind\": {\r\n  \"mph\": 11,\r\n  \"kph\": 18,\r\n  \"dir\": \"West\",\r\n  \"degrees\": 267\r\n  },\r\n  \"avewind\": {\r\n  \"mph\": 10,\r\n  \"kph\": 16,\r\n  \"dir\": \"West\",\r\n  \"degrees\": 272\r\n  },\r\n  \"avehumidity\": 79,\r\n  \"maxhumidity\": 93,\r\n  \"minhumidity\": 63\r\n  }]\r\n  }\r\n  }\r\n}";
	public static final String ASTRONOMY_TEST = "{\r\n  \"response\": {\r\n  \"version\": \"0.1\",\r\n  \"termsofService\": \"http://www.wunderground.com/weather/api/d/terms.html\",\r\n  \"features\": {\r\n  \"astronomy\": 1\r\n  }\r\n  },\r\n  \"moon_phase\": {\r\n  \"percentIlluminated\": \"81\",\r\n  \"ageOfMoon\": \"10\",\r\n  \"current_time\": {\r\n  \"hour\": \"9\",\r\n  \"minute\": \"56\"\r\n  },\r\n  \"sunrise\": {\r\n  \"hour\": \"7\",\r\n  \"minute\": \"01\"\r\n  },\r\n  \"sunset\": {\r\n  \"hour\": \"16\",\r\n  \"minute\": \"56\"\r\n  }\r\n  }\r\n}";
	public static final String POLLEN_TEST = "{\"pollenForecast\":{\"zip\":\"48145\",\"city\":\"LA SALLE\",\"state\":\"MI\",\"forecast\":[7.3,1.1,6.4,7.1],\"pp\":\" Elm and Alder.\",\"timestamp\":\"Apr 6, 2015 12:30:35 PM\"},\"weatherForecast\":{\"date\":\"Apr 6, 2015 2:16:15 PM\",\"city\":\"La Salle\",\"state\":\"MI\",\"zip\":\"48145\",\"forecast\":[{\"lowF\":43,\"highF\":58,\"iconDay\":\"1100\",\"iconNight\":\"7300\",\"skyDay\":11,\"skyNight\":12,\"phraseDay\":\"Showers\",\"phraseNight\":\"Rain Late\",\"date\":\"Apr 6, 2015 12:00:00 AM\"},{\"lowF\":38,\"highF\":45,\"iconDay\":\"1200\",\"iconNight\":\"1200\",\"skyDay\":12,\"skyNight\":12,\"phraseDay\":\"Rain\",\"phraseNight\":\"Rain\",\"date\":\"Apr 7, 2015 12:00:00 AM\"},{\"lowF\":40,\"highF\":48,\"iconDay\":\"1200\",\"iconNight\":\"1100\",\"skyDay\":12,\"skyNight\":11,\"phraseDay\":\"Rain\",\"phraseNight\":\"Showers\",\"date\":\"Apr 8, 2015 12:00:00 AM\"},{\"lowF\":58,\"highF\":65,\"iconDay\":\"400\",\"iconNight\":\"400\",\"skyDay\":4,\"skyNight\":4,\"phraseDay\":\"Thunderstorms\",\"phraseNight\":\"Thunderstorms\",\"date\":\"Apr 9, 2015 12:00:00 AM\"},{\"lowF\":42,\"highF\":61,\"iconDay\":\"6203\",\"iconNight\":\"9000\",\"skyDay\":38,\"skyNight\":29,\"phraseDay\":\"AM Thunderstorms\",\"phraseNight\":\"Clouds Early/Clearing Late\",\"date\":\"Apr 10, 2015 12:00:00 AM\"},{\"lowF\":38,\"highF\":54,\"iconDay\":\"3000\",\"iconNight\":\"3300\",\"skyDay\":30,\"skyNight\":33,\"phraseDay\":\"Partly Cloudy\",\"phraseNight\":\"Mostly Clear\",\"date\":\"Apr 11, 2015 12:00:00 AM\"}]},\"result\":true}";
	public static final String POLLUTION_TEST = "";
}