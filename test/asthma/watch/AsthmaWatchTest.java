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

import asthma.watch.model.AstronomyDTO;
import asthma.watch.model.ForecastDTO;
import asthma.watch.model.PollenDTO;
import asthma.watch.model.PollutionDTO;
import asthma.watch.model.WeatherDTO;
import asthma.watch.model.WeatherData;
import asthma.watch.service.DTOFactory;
import asthma.watch.service.AsthmaWatch;
import asthma.watch.util.ConstantValues;

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
		AsthmaWatch aw = new AsthmaWatch(zip);
	}

	@Test
	public void primaryObjectSwitchCaseConditions() throws Exception {
		AsthmaWatch aw = new AsthmaWatch(zip);
		aw.fetchWeatherData("conditions");
		String weatherType = "conditions";
		URL actual = new URL(ConstantValues.WU_URL + weatherType + "/q/" + zip
				+ ".json");
		URL expected = new URL(
				"http://api.wunderground.com/api/7376ff9876400cb0/conditions/q/48145.json");
		assertEquals(expected, actual);
	}

	public void primaryObjectSwitchCasePollution() throws Exception {
		AsthmaWatch aw = new AsthmaWatch(zip);
		aw.fetchWeatherData("pollution");
		URL actual = new URL(ConstantValues.EPA_URL + zip);
		URL expected = new URL(
				"http://www.airnowapi.org//aq/forecast/zipCode/?format=application/json&api_key=D46398E5-2646-4D3B-95A2-A618D3AF3906&zipCode=48145");
		assertEquals(expected, actual);
	}

	@Test
	public void primaryObjectSwitchCasePollen() throws Exception {
		AsthmaWatch aw = new AsthmaWatch(zip);
		// aw.fetchWeatherData("pollen");
		// URL expectedurl= new URL("www.stuff.com");
		// assertEquals(expectedurl, url);
	}

	@Test
	public void emptyJsonReturnsInputString() throws Exception {
		URL url = getMockUrlContents("{  }");
		String expected = "{  }";
	}

	// TODO Fix all of the set attribute tests
	@Test
	public void populatedJsonSetsAttributeForCurrentConditions()
			throws Exception {
		String json = ConstantValues.CONDITIONS_TEST;

		Gson gson = new GsonBuilder().create();
		WeatherDTO expected = new WeatherDTO();
		expected = gson.fromJson(json, WeatherDTO.class);
		expected.setAttributes();

		WeatherDTO actual = new WeatherDTO();
		actual = (WeatherDTO) DTOFactory.fetchWeatherInformation(
				"conditions", json);
		actual.setAttributes();

		assertEquals(expected.getTemp(), actual.getTemp(), 1e-5);
		assertEquals(expected.getHeatIndex(), actual.getHeatIndex());
		assertEquals(expected.getPressureTrend(), actual.getPressureTrend());
		assertEquals(expected.getTemp(), actual.getTemp(), 1e-5);
		assertEquals(expected.getUv(), actual.getUv(), 1e-5);
		assertEquals(expected.getWindDescription(), actual.getWindDescription());
		assertEquals(expected.getWindDirection(), actual.getWindDirection());
		assertEquals(expected.getWindSpeed(), actual.getWindSpeed(), 1e-5);
	}

	@Test
	public void populatedJsonSetsAttributeForForecast() throws Exception {
		String json = ConstantValues.FORECAST_TEST;

		Gson gson = new GsonBuilder().create();
		ForecastDTO expected = new ForecastDTO();
		expected = gson.fromJson(json, ForecastDTO.class);
		expected.setAttributes();

		ForecastDTO actual = new ForecastDTO();
		actual = (ForecastDTO) DTOFactory.fetchWeatherInformation(
				"forecast", json);
		actual.setAttributes();

		assertArrayEquals(expected.getAveHumidity(), actual.getAveHumidity(),
				1e-5);
		assertArrayEquals(expected.getAveWindSpeed(), actual.getAveWindSpeed());
		assertArrayEquals(expected.getConditions(), actual.getConditions());
		assertArrayEquals(expected.getForecastIcon(), actual.getForecastIcon());
		assertArrayEquals(expected.getHigh(), actual.getHigh());
		assertArrayEquals(expected.getLow(), actual.getLow());
	}

	@Test
	public void populatedJsonSetsAttributeForAstronomy() throws Exception {
		String json = ConstantValues.ASTRONOMY_TEST;

		Gson gson = new GsonBuilder().create();
		AstronomyDTO expected = new AstronomyDTO();
		expected = gson.fromJson(json, AstronomyDTO.class);
		expected.setAttributes();

		AstronomyDTO actual = new AstronomyDTO();
		actual = (AstronomyDTO) DTOFactory.fetchWeatherInformation(
				"astronomy", json);
		actual.setAttributes();

		assertEquals(expected.getPercentIlluminated(),
				actual.getPercentIlluminated());
		assertEquals(expected.getPhaseofMoon(), actual.getPhaseofMoon());

	}

	@Test
	public void populatedJsonSetsAttributeForPollution() throws Exception {
		String json = ConstantValues.POLLUTION_TEST;

		Gson gson = new GsonBuilder().create();
		PollutionDTO expected = new PollutionDTO();
		expected = gson.fromJson(json, PollutionDTO.class);
		expected.setAttributes();

		PollutionDTO actual = new PollutionDTO();
		actual = (PollutionDTO) DTOFactory.fetchWeatherInformation(
				"pollution", json);
		actual.setAttributes();

		assertEquals(expected.getAirQualityIndex(),
				actual.getAirQualityIndex(), 1e-5);
	}

	@Test
	public void populatedJsonSetsAttributeForPollen() throws Exception {
		String json = "\"{\\\"pollenForecast\\\":{\\\"forecast\\\":[1.0,2.0,3.0,4.0],\\\"pp\\\":\\\"Treeant.\\\"}}\"";
		URL url = getMockUrlContents(json);
		WeatherData weatherInfo = DTOFactory.fetchWeatherInformation(
				"pollen", json);
	}

	@Test
	public void populatedJsonReturnsJsonString() throws Exception {
		String expected = "{\"current_observation\":{\"relative_humidity\": \"50%\"}}";
		URL url = getMockUrlContents(expected);
	}

	@Test
	public void testConditionsJsonObjectPopulated() {
		String json = ConstantValues.CONDITIONS_TEST;
		Gson gson = new GsonBuilder().create();
		WeatherDTO weatherInfo = new WeatherDTO();
		weatherInfo = gson.fromJson(json, WeatherDTO.class);
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

	// TODO Finish this test
	@Test
	public void testForecastJsonObjectPopulated() {
		String json = ConstantValues.FORECAST_TEST;
		Gson gson = new GsonBuilder().create();
		ForecastDTO weatherInfo = new ForecastDTO();
		weatherInfo = gson.fromJson(json, ForecastDTO.class);
		weatherInfo.setAttributes();
		String[] actualHigh = { "72", "72", "58" };
		String[] actualLow = { "54", "54", "52" };
		long[] actualWindSpeed = { 9, 12, 10 };
		String[] actualConditions = { "Partly Cloudy", "Partly Cloudy", "Fog" };
		double[] actualHumdity = { 70.0, 80.0, 79.0 };
		String[] actualIcon = {
				"http://icons-ak.wxug.com/i/c/k/partlycloudy.gif",
				"http://icons-ak.wxug.com/i/c/k/partlycloudy.gif",
				"http://icons-ak.wxug.com/i/c/k/partlycloudy.gif" };
		assertArrayEquals(weatherInfo.getHigh(), actualHigh);
		assertArrayEquals(weatherInfo.getLow(), actualLow);
		assertArrayEquals(weatherInfo.getAveWindSpeed(), actualWindSpeed);
		assertArrayEquals(weatherInfo.getConditions(), actualConditions);
		assertArrayEquals(weatherInfo.getAveHumidity(), actualHumdity, 1e-5);
		assertArrayEquals(weatherInfo.getForecastIcon(), actualIcon);
	}

	// TODO Finish this test
	@Test
	public void testAstronomyJsonObjectPopulated() {
		String json = ConstantValues.ASTRONOMY_TEST;
		Gson gson = new GsonBuilder().create();
		AstronomyDTO weatherInfo = new AstronomyDTO();
		weatherInfo = gson.fromJson(json, AstronomyDTO.class);
		weatherInfo.setAttributes();
		assertEquals(weatherInfo.getPercentIlluminated(), "81");
	}

	// TODO Finish this test
	@Test
	public void testPollenJsonObjectPopulated() {
		String json = ConstantValues.POLLEN_TEST;
		Gson gson = new GsonBuilder().create();
		PollenDTO weatherInfo = new PollenDTO();
		weatherInfo = gson.fromJson(json, PollenDTO.class);
		weatherInfo.setAttributes();
	}

	// TODO Finish this test
	@Test
	public void tesPollutionJsonObjectPopulated() {
		String json = ConstantValues.POLLUTION_TEST;
		Gson gson = new GsonBuilder().create();
		PollutionDTO weatherInfo = new PollutionDTO();
		weatherInfo = gson.fromJson(json, PollutionDTO.class);
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
