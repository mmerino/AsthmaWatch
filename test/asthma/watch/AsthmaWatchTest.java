package asthma.watch;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AsthmaWatchTest {

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	String zip = "48145";

	// TODO change primaryObject to new name for primary object
	@Test
	public void primaryObjectConstructorTest() throws Exception {
		AsthmaWatch aw = new AsthmaWatch(request, response, zip);
	}

	// TODO figure out how to stub out call to ApiAccess and verify URL set
	// correctly
//	@Test
//	public void primaryObjectSwitchCaseConditions() throws Exception {
//		AsthmaWatch aw = new AsthmaWatch(request, response, zip);
//		aw.fetchWeatherData("conditions");
//		Field field = aw.getClass().get
//        URL actual = (URL) field.get(aw);
//        URL expected = new URL(ConstantValues.WU_URL + "conditions/q/" + zip);
//        assertEquals(expected, actual);
//	}

	@Test
	public void primaryObjectSwitchCaseConditions() throws Exception {
		AsthmaWatch aw = new AsthmaWatch(request, response, zip);
		aw.fetchWeatherData("conditions");
		String weatherType="conditions";
		URL actual = new URL(ConstantValues.WU_URL + weatherType + "/q/" + zip
				+ ".json");
        URL expected = new URL("http://api.wunderground.com/api/7376ff9876400cb0/conditions/q/48145.json");
        assertEquals(expected, actual);
	}
	
	public void primaryObjectSwitchCasePollution() throws Exception {
		AsthmaWatch aw = new AsthmaWatch(request, response, zip);
		aw.fetchWeatherData("pollution");
		URL actual = new URL(ConstantValues.EPA_URL + zip);
		URL expected = new URL("http://www.airnowapi.org//aq/forecast/zipCode/?format=application/json&api_key=D46398E5-2646-4D3B-95A2-A618D3AF3906&zipCode=48145");
		assertEquals(expected, actual);
	}

	@Test
	public void primaryObjectSwitchCasePollen() throws Exception {
		AsthmaWatch aw = new AsthmaWatch(request, response, zip);
//		aw.fetchWeatherData("pollen");
//		URL expectedurl= new URL("www.stuff.com");
//		assertEquals(expectedurl, url);
	}

	@Test
	public void emptyJsonReturnsInputString() throws Exception {
		URL url = getMockUrlContents("{  }");
		String actual = AsthmaWatch.getJson(url);
		String expected = "{  }";
		assertEquals(expected, actual);
	}

	@Test
	public void populatedJsonSetsAttributeForCurrentConditions()
			throws Exception {
		String json = "{\"current_observation\":{\"relative_humidity\": \"50%\"}}";
		URL url = getMockUrlContents(json);
		ApiAccess.fetchWeatherInformation(request, response, "conditions", url);
		verify(request).setAttribute(eq("conditions"), anyObject());
	}

	@Test
	public void populatedJsonSetsAttributeForForecast() throws Exception {
		String json = "\r\n{\r\n  \"response\": {\r\n  \"version\":\"0.1\",\r\n  \"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\",\r\n  \"features\": {\r\n  \"forecast\": 1\r\n  }\r\n\t}\r\n\t\t,\r\n\t\"forecast\":{\r\n\t\t\"txt_forecast\": {\r\n\t\t\"date\":\"7:19 AM PDT\",\r\n\t\t\"forecastday\": [\r\n\t\t{\r\n\t\t\"period\":0,\r\n\t\t\"icon\":\"mostlycloudy\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/mostlycloudy.gif\",\r\n\t\t\"title\":\"Monday\",\r\n\t\t\"fcttext\":\"Partly cloudy this morning, then becoming cloudy during the afternoon. High 62F. Winds SSW at 15 to 25 mph.\",\r\n\t\t\"fcttext_metric\":\"A mix of clouds and sun early followed by cloudy skies this afternoon. High 17C. Winds SSW at 15 to 30 km/h.\",\r\n\t\t\"pop\":\"0\"\r\n\t\t}\r\n\t\t,\r\n\t\t{\r\n\t\t\"period\":1,\r\n\t\t\"icon\":\"nt_rain\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_rain.gif\",\r\n\t\t\"title\":\"Monday Night\",\r\n\t\t\"fcttext\":\"Cloudy skies with periods of rain late. Thunder possible. Low near 50F. Winds S at 15 to 25 mph. Chance of rain 100%.\",\r\n\t\t\"fcttext_metric\":\"Rain. Thunder possible. Low near 10C. Winds S at 15 to 30 km/h. Chance of rain 100%.\",\r\n\t\t\"pop\":\"100\"\r\n\t\t}\r\n\t\t,\r\n\t\t{\r\n\t\t\"period\":2,\r\n\t\t\"icon\":\"chancetstorms\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/chancetstorms.gif\",\r\n\t\t\"title\":\"Tuesday\",\r\n\t\t\"fcttext\":\"Variable clouds with scattered thunderstorms. High 59F. Winds WSW at 15 to 25 mph. Chance of rain 60%.\",\r\n\t\t\"fcttext_metric\":\"Scattered showers and thunderstorms. High around 15C. Winds WSW at 25 to 40 km/h. Chance of rain 60%.\",\r\n\t\t\"pop\":\"60\"\r\n\t\t}\r\n\t\t,\r\n\t\t{\r\n\t\t\"period\":3,\r\n\t\t\"icon\":\"nt_chancerain\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_chancerain.gif\",\r\n\t\t\"title\":\"Tuesday Night\",\r\n\t\t\"fcttext\":\"Rain showers in the evening with clear skies overnight. Thunder is possible early. Low 48F. Winds W at 10 to 20 mph. Chance of rain 40%.\",\r\n\t\t\"fcttext_metric\":\"Rain showers in the evening with clear skies overnight. Thunder is possible early. Low 8C. Winds W at 15 to 30 km/h. Chance of rain 40%.\",\r\n\t\t\"pop\":\"40\"\r\n\t\t}\r\n\t\t,\r\n\t\t{\r\n\t\t\"period\":4,\r\n\t\t\"icon\":\"clear\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\r\n\t\t\"title\":\"Wednesday\",\r\n\t\t\"fcttext\":\"Sunshine. High 61F. Winds NNW at 10 to 15 mph.\",\r\n\t\t\"fcttext_metric\":\"Sunshine. High 16C. Winds NNW at 15 to 25 km/h.\",\r\n\t\t\"pop\":\"10\"\r\n\t\t}\r\n\t\t,\r\n\t\t{\r\n\t\t\"period\":5,\r\n\t\t\"icon\":\"nt_clear\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\r\n\t\t\"title\":\"Wednesday Night\",\r\n\t\t\"fcttext\":\"Mostly clear. Low 48F. NW winds shifting to ENE at 10 to 15 mph.\",\r\n\t\t\"fcttext_metric\":\"A mostly clear sky. Low 8C. Winds NNW at 10 to 15 km/h.\",\r\n\t\t\"pop\":\"10\"\r\n\t\t}\r\n\t\t,\r\n\t\t{\r\n\t\t\"period\":6,\r\n\t\t\"icon\":\"partlycloudy\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\r\n\t\t\"title\":\"Thursday\",\r\n\t\t\"fcttext\":\"Intervals of clouds and sunshine. High 64F. SSE winds shifting to W at 10 to 15 mph.\",\r\n\t\t\"fcttext_metric\":\"Intervals of clouds and sunshine. High 18C. SSE winds shifting to W at 15 to 25 km/h.\",\r\n\t\t\"pop\":\"10\"\r\n\t\t}\r\n\t\t,\r\n\t\t{\r\n\t\t\"period\":7,\r\n\t\t\"icon\":\"nt_partlycloudy\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_partlycloudy.gif\",\r\n\t\t\"title\":\"Thursday Night\",\r\n\t\t\"fcttext\":\"A few clouds. Low 48F. Winds SSW at 5 to 10 mph.\",\r\n\t\t\"fcttext_metric\":\"A few clouds from time to time. Low 9C. Winds SSW at 10 to 15 km/h.\",\r\n\t\t\"pop\":\"10\"\r\n\t\t}\r\n\t\t]\r\n\t\t},\r\n\t\t\"simpleforecast\": {\r\n\t\t\"forecastday\": [\r\n\t\t{\"date\":{\r\n\t\"epoch\":\"1428372000\",\r\n\t\"pretty\":\"7:00 PM PDT on April 06, 2015\",\r\n\t\"day\":6,\r\n\t\"month\":4,\r\n\t\"year\":2015,\r\n\t\"yday\":95,\r\n\t\"hour\":19,\r\n\t\"min\":\"00\",\r\n\t\"sec\":0,\r\n\t\"isdst\":\"1\",\r\n\t\"monthname\":\"April\",\r\n\t\"monthname_short\":\"Apr\",\r\n\t\"weekday_short\":\"Mon\",\r\n\t\"weekday\":\"Monday\",\r\n\t\"ampm\":\"PM\",\r\n\t\"tz_short\":\"PDT\",\r\n\t\"tz_long\":\"America/Los_Angeles\"\r\n},\r\n\t\t\"period\":1,\r\n\t\t\"high\": {\r\n\t\t\"fahrenheit\":\"62\",\r\n\t\t\"celsius\":\"17\"\r\n\t\t},\r\n\t\t\"low\": {\r\n\t\t\"fahrenheit\":\"50\",\r\n\t\t\"celsius\":\"10\"\r\n\t\t},\r\n\t\t\"conditions\":\"Mostly Cloudy\",\r\n\t\t\"icon\":\"mostlycloudy\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/mostlycloudy.gif\",\r\n\t\t\"skyicon\":\"\",\r\n\t\t\"pop\":0,\r\n\t\t\"qpf_allday\": {\r\n\t\t\"in\": 0.52,\r\n\t\t\"mm\": 13\r\n\t\t},\r\n\t\t\"qpf_day\": {\r\n\t\t\"in\": 0.00,\r\n\t\t\"mm\": 0\r\n\t\t},\r\n\t\t\"qpf_night\": {\r\n\t\t\"in\": 0.52,\r\n\t\t\"mm\": 13\r\n\t\t},\r\n\t\t\"snow_allday\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"snow_day\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"snow_night\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"maxwind\": {\r\n\t\t\"mph\": 25,\r\n\t\t\"kph\": 40,\r\n\t\t\"dir\": \"SSW\",\r\n\t\t\"degrees\": 198\r\n\t\t},\r\n\t\t\"avewind\": {\r\n\t\t\"mph\": 17,\r\n\t\t\"kph\": 27,\r\n\t\t\"dir\": \"SSW\",\r\n\t\t\"degrees\": 198\r\n\t\t},\r\n\t\t\"avehumidity\": 57,\r\n\t\t\"maxhumidity\": 0,\r\n\t\t\"minhumidity\": 0\r\n\t\t}\r\n\t\t,\r\n\t\t{\"date\":{\r\n\t\"epoch\":\"1428458400\",\r\n\t\"pretty\":\"7:00 PM PDT on April 07, 2015\",\r\n\t\"day\":7,\r\n\t\"month\":4,\r\n\t\"year\":2015,\r\n\t\"yday\":96,\r\n\t\"hour\":19,\r\n\t\"min\":\"00\",\r\n\t\"sec\":0,\r\n\t\"isdst\":\"1\",\r\n\t\"monthname\":\"April\",\r\n\t\"monthname_short\":\"Apr\",\r\n\t\"weekday_short\":\"Tue\",\r\n\t\"weekday\":\"Tuesday\",\r\n\t\"ampm\":\"PM\",\r\n\t\"tz_short\":\"PDT\",\r\n\t\"tz_long\":\"America/Los_Angeles\"\r\n},\r\n\t\t\"period\":2,\r\n\t\t\"high\": {\r\n\t\t\"fahrenheit\":\"59\",\r\n\t\t\"celsius\":\"15\"\r\n\t\t},\r\n\t\t\"low\": {\r\n\t\t\"fahrenheit\":\"48\",\r\n\t\t\"celsius\":\"9\"\r\n\t\t},\r\n\t\t\"conditions\":\"Chance of a Thunderstorm\",\r\n\t\t\"icon\":\"chancetstorms\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/chancetstorms.gif\",\r\n\t\t\"skyicon\":\"\",\r\n\t\t\"pop\":60,\r\n\t\t\"qpf_allday\": {\r\n\t\t\"in\": 0.16,\r\n\t\t\"mm\": 4\r\n\t\t},\r\n\t\t\"qpf_day\": {\r\n\t\t\"in\": 0.14,\r\n\t\t\"mm\": 4\r\n\t\t},\r\n\t\t\"qpf_night\": {\r\n\t\t\"in\": 0.02,\r\n\t\t\"mm\": 1\r\n\t\t},\r\n\t\t\"snow_allday\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"snow_day\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"snow_night\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"maxwind\": {\r\n\t\t\"mph\": 25,\r\n\t\t\"kph\": 40,\r\n\t\t\"dir\": \"WSW\",\r\n\t\t\"degrees\": 244\r\n\t\t},\r\n\t\t\"avewind\": {\r\n\t\t\"mph\": 17,\r\n\t\t\"kph\": 27,\r\n\t\t\"dir\": \"WSW\",\r\n\t\t\"degrees\": 244\r\n\t\t},\r\n\t\t\"avehumidity\": 66,\r\n\t\t\"maxhumidity\": 0,\r\n\t\t\"minhumidity\": 0\r\n\t\t}\r\n\t\t,\r\n\t\t{\"date\":{\r\n\t\"epoch\":\"1428544800\",\r\n\t\"pretty\":\"7:00 PM PDT on April 08, 2015\",\r\n\t\"day\":8,\r\n\t\"month\":4,\r\n\t\"year\":2015,\r\n\t\"yday\":97,\r\n\t\"hour\":19,\r\n\t\"min\":\"00\",\r\n\t\"sec\":0,\r\n\t\"isdst\":\"1\",\r\n\t\"monthname\":\"April\",\r\n\t\"monthname_short\":\"Apr\",\r\n\t\"weekday_short\":\"Wed\",\r\n\t\"weekday\":\"Wednesday\",\r\n\t\"ampm\":\"PM\",\r\n\t\"tz_short\":\"PDT\",\r\n\t\"tz_long\":\"America/Los_Angeles\"\r\n},\r\n\t\t\"period\":3,\r\n\t\t\"high\": {\r\n\t\t\"fahrenheit\":\"61\",\r\n\t\t\"celsius\":\"16\"\r\n\t\t},\r\n\t\t\"low\": {\r\n\t\t\"fahrenheit\":\"48\",\r\n\t\t\"celsius\":\"9\"\r\n\t\t},\r\n\t\t\"conditions\":\"Clear\",\r\n\t\t\"icon\":\"clear\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\r\n\t\t\"skyicon\":\"\",\r\n\t\t\"pop\":10,\r\n\t\t\"qpf_allday\": {\r\n\t\t\"in\": 0.00,\r\n\t\t\"mm\": 0\r\n\t\t},\r\n\t\t\"qpf_day\": {\r\n\t\t\"in\": 0.00,\r\n\t\t\"mm\": 0\r\n\t\t},\r\n\t\t\"qpf_night\": {\r\n\t\t\"in\": 0.00,\r\n\t\t\"mm\": 0\r\n\t\t},\r\n\t\t\"snow_allday\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"snow_day\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"snow_night\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"maxwind\": {\r\n\t\t\"mph\": 15,\r\n\t\t\"kph\": 24,\r\n\t\t\"dir\": \"NNW\",\r\n\t\t\"degrees\": 335\r\n\t\t},\r\n\t\t\"avewind\": {\r\n\t\t\"mph\": 11,\r\n\t\t\"kph\": 18,\r\n\t\t\"dir\": \"NNW\",\r\n\t\t\"degrees\": 335\r\n\t\t},\r\n\t\t\"avehumidity\": 65,\r\n\t\t\"maxhumidity\": 0,\r\n\t\t\"minhumidity\": 0\r\n\t\t}\r\n\t\t,\r\n\t\t{\"date\":{\r\n\t\"epoch\":\"1428631200\",\r\n\t\"pretty\":\"7:00 PM PDT on April 09, 2015\",\r\n\t\"day\":9,\r\n\t\"month\":4,\r\n\t\"year\":2015,\r\n\t\"yday\":98,\r\n\t\"hour\":19,\r\n\t\"min\":\"00\",\r\n\t\"sec\":0,\r\n\t\"isdst\":\"1\",\r\n\t\"monthname\":\"April\",\r\n\t\"monthname_short\":\"Apr\",\r\n\t\"weekday_short\":\"Thu\",\r\n\t\"weekday\":\"Thursday\",\r\n\t\"ampm\":\"PM\",\r\n\t\"tz_short\":\"PDT\",\r\n\t\"tz_long\":\"America/Los_Angeles\"\r\n},\r\n\t\t\"period\":4,\r\n\t\t\"high\": {\r\n\t\t\"fahrenheit\":\"64\",\r\n\t\t\"celsius\":\"18\"\r\n\t\t},\r\n\t\t\"low\": {\r\n\t\t\"fahrenheit\":\"48\",\r\n\t\t\"celsius\":\"9\"\r\n\t\t},\r\n\t\t\"conditions\":\"Partly Cloudy\",\r\n\t\t\"icon\":\"partlycloudy\",\r\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\r\n\t\t\"skyicon\":\"\",\r\n\t\t\"pop\":10,\r\n\t\t\"qpf_allday\": {\r\n\t\t\"in\": 0.00,\r\n\t\t\"mm\": 0\r\n\t\t},\r\n\t\t\"qpf_day\": {\r\n\t\t\"in\": 0.00,\r\n\t\t\"mm\": 0\r\n\t\t},\r\n\t\t\"qpf_night\": {\r\n\t\t\"in\": 0.00,\r\n\t\t\"mm\": 0\r\n\t\t},\r\n\t\t\"snow_allday\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"snow_day\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"snow_night\": {\r\n\t\t\"in\": 0.0,\r\n\t\t\"cm\": 0.0\r\n\t\t},\r\n\t\t\"maxwind\": {\r\n\t\t\"mph\": 15,\r\n\t\t\"kph\": 24,\r\n\t\t\"dir\": \"WSW\",\r\n\t\t\"degrees\": 251\r\n\t\t},\r\n\t\t\"avewind\": {\r\n\t\t\"mph\": 11,\r\n\t\t\"kph\": 18,\r\n\t\t\"dir\": \"WSW\",\r\n\t\t\"degrees\": 251\r\n\t\t},\r\n\t\t\"avehumidity\": 63,\r\n\t\t\"maxhumidity\": 0,\r\n\t\t\"minhumidity\": 0\r\n\t\t}\r\n\t\t]\r\n\t\t}\r\n\t}\r\n}";
		URL url = getMockUrlContents(json);
		ApiAccess.fetchWeatherInformation(request, response, "forecast", url);
		verify(request).setAttribute(eq("forecast"), anyObject());
	}

	@Test
	public void populatedJsonSetsAttributeForAstronomy() throws Exception {
		String json = "{\"moon_phase\":{\"percentIlluminated\":\"50\"}}";
		URL url = getMockUrlContents(json);
		ApiAccess.fetchWeatherInformation(request, response, "astronomy", url);
		verify(request).setAttribute(eq("astronomy"), anyObject());
	}

	@Test
	public void populatedJsonSetsAttributeForPollution() throws Exception {
		String json = "[{\"Category\":{\"Number\":1.0}}]";
		URL url = getMockUrlContents(json);
		ApiAccess.fetchWeatherInformation(request, response, "pollution", url);
		verify(request).setAttribute(eq("pollution"), anyObject());
	}

	@Test
	public void populatedJsonSetsAttributeForPollen() throws Exception {
		String json = "\"{\\\"pollenForecast\\\":{\\\"forecast\\\":[1.0,2.0,3.0,4.0],\\\"pp\\\":\\\"Treeant.\\\"}}\"";
		URL url = getMockUrlContents(json);
		ApiAccess.fetchWeatherInformation(request, response, "pollen", url);
		verify(request).setAttribute(eq("pollen"), anyObject());
	}

	@Test
	public void populatedJsonReturnsJsonString() throws Exception {
		String expected = "{\"current_observation\":{\"relative_humidity\": \"50%\"}}";
		URL url = getMockUrlContents(expected);
		String actual = AsthmaWatch.getJson(url);
		assertEquals(expected, actual);
	}

	@Test
	public void testConditionsJsonObjectPopulated() {
		String json = ConstantValues.CONDITIONS_TEST;
		Gson gson = new GsonBuilder().create();
		WeatherDAO weatherInfo = new WeatherDAO();
		weatherInfo = gson.fromJson(json, WeatherDAO.class);
		weatherInfo.setAttributes();
		assertEquals(weatherInfo.getHumidity(), 65, 1e-5);
		assertEquals(weatherInfo.getHeatIndex(), "NA");
		assertEquals(weatherInfo.getPressureTrend(), "+");
		assertEquals(weatherInfo.getTemp(), 66.3, 1e-5);
		assertEquals(weatherInfo.getUv(), 5, 1e-5);
		assertEquals(weatherInfo.getWindDescription(),
				"From the NNW at 22.0 MPH Gusting to 28.0 MPH");
		assertEquals(weatherInfo.getWindDirection(), "NNW");
		assertEquals(weatherInfo.getWindSpeed(), 22.0, 1e-5);
	}
	//TODO Finish this test
	@Test
	public void testForecastJsonObjectPopulated() {
		String json = ConstantValues.FORECAST_TEST;
		Gson gson = new GsonBuilder().create();
		ForecastDAO weatherInfo = new ForecastDAO();
		weatherInfo = gson.fromJson(json, ForecastDAO.class);
		weatherInfo.setAttributes();
		String[] actualHigh = {"72","72","58"};
		String[] actualLow = {"54","54","52"};
		long[] actualWindSpeed = {};
		String[] actualConditions = {};
		double[] actualHumdity = {};
		String[] actualIcon = {};
		assertArrayEquals(weatherInfo.getHigh(), actualHigh);
		assertArrayEquals(weatherInfo.getLow(), actualLow);
		assertArrayEquals(weatherInfo.getAveWindSpeed(), actualWindSpeed);
		assertArrayEquals(weatherInfo.getConditions(), actualConditions);
		assertArrayEquals(weatherInfo.getAveHumidity(), actualHumdity, 1e-5);
		assertArrayEquals(weatherInfo.getForecastIcon(), actualIcon);
	}
	//TODO Finish this test
	@Test
	public void testAstronomyJsonObjectPopulated() {
		String json = ConstantValues.ASTRONOMY_TEST;
		Gson gson = new GsonBuilder().create();
		AstronomyInfo weatherInfo = new AstronomyInfo();
		weatherInfo = gson.fromJson(json, AstronomyInfo.class);
		weatherInfo.setAttributes();
		assertEquals(weatherInfo.getPercentIlluminated(),"81");
	}
	//TODO Finish this test
	@Test
	public void testPollenJsonObjectPopulated() {
		String json = ConstantValues.POLLEN_TEST;
		Gson gson = new GsonBuilder().create();
		PollenDAO weatherInfo = new PollenDAO();
		weatherInfo = gson.fromJson(json, PollenDAO.class);
		weatherInfo.setAttributes();
	}
	//TODO Finish this test
	@Test
	public void tesPollutionJsonObjectPopulated() {
		String json = ConstantValues.POLLUTION_TEST;
		Gson gson = new GsonBuilder().create();
		PollutionDAO weatherInfo = new PollutionDAO();
		weatherInfo = gson.fromJson(json, PollutionDAO.class);
		weatherInfo.setAttributes();
	}

	public URL getMockUrlContents(String contents) throws Exception {
		URLConnection mockConnection = mock(URLConnection.class);
		InputStream inputStream = new ByteArrayInputStream(
				contents.getBytes("UTF-8"));
		URLStreamHandler urlStreamHandler = new URLStreamHandler() {
			@Override
			protected URLConnection openConnection(URL url) throws IOException {
				return mockConnection;
			}
		};
		when(mockConnection.getInputStream()).thenReturn(inputStream);
		URL url = new URL("http", "aaa", -1, "", urlStreamHandler);
		return url;
	}
}
