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

import asthma.watch.exception.APIDownException;
import asthma.watch.exception.InvalidWeatherTypeException;
import asthma.watch.model.AstronomyDTO;
import asthma.watch.model.ForecastDTO;
import asthma.watch.model.PollenDTO;
import asthma.watch.model.PollutionDTO;
import asthma.watch.model.WeatherDTO;
import asthma.watch.service.DTOFactory;
import asthma.watch.service.BusinessDelegate;
import asthma.watch.service.JsonDAO;
import asthma.watch.util.ConstantValues;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BusinessDelegateTest {

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	String zip = "48145";

	@Test
	public void primaryObjectConstructorTest() {
		BusinessDelegate apiDelegate = new BusinessDelegate(zip);
	}

	@Test
	public void primaryObjectSwitchCaseConditions() throws Exception {
		BusinessDelegate apiDelegate = new BusinessDelegate(zip);
		apiDelegate.fetchWeatherData("conditions");
		String weatherType = "conditions";
		URL actual = new URL(ConstantValues.WU_URL + weatherType + "/q/" + zip
				+ ".json");
		URL expected = new URL(
				"http://api.wunderground.com/api/7376ff9876400cb0/conditions/q/48145.json");
		assertEquals(expected, actual);
	}
	
	@Test
	public void primaryObjectSwitchCaseForecast() throws Exception {
		BusinessDelegate apiDelegate = new BusinessDelegate(zip);
		apiDelegate.fetchWeatherData("forecast");
		String weatherType = "forecast";
		URL actual = new URL(ConstantValues.WU_URL + weatherType + "/q/" + zip
				+ ".json");
		URL expected = new URL(
				"http://api.wunderground.com/api/7376ff9876400cb0/forecast/q/48145.json");
		assertEquals(expected, actual);
	}
	
	@Test
	public void primaryObjectSwitchCaseAstronomy() throws Exception {
		BusinessDelegate apiDelegate = new BusinessDelegate(zip);
		apiDelegate.fetchWeatherData("astronomy");
		String weatherType = "astronomy";
		URL actual = new URL(ConstantValues.WU_URL + weatherType + "/q/" + zip
				+ ".json");
		URL expected = new URL(
				"http://api.wunderground.com/api/7376ff9876400cb0/astronomy/q/48145.json");
		assertEquals(expected, actual);
	}

	public void primaryObjectSwitchCasePollution() throws Exception {
		BusinessDelegate apiDelegate = new BusinessDelegate(zip);
		apiDelegate.fetchWeatherData("pollution");
		URL actual = new URL(ConstantValues.EPA_URL + zip);
		URL expected = new URL(
				"http://www.airnowapi.org//aq/forecast/zipCode/?format=application/json&api_key=D46398E5-2646-4D3B-95A2-A618D3AF3906&zipCode=48145");
		assertEquals(expected, actual);
	}

	@Test
	public void primaryObjectSwitchCasePollen() throws Exception {
		BusinessDelegate apiDelegate = new BusinessDelegate(zip);
		apiDelegate.fetchWeatherData("pollen");
		URL actual = new URL(ConstantValues.CLARITIN_URL + zip);
		URL expected = new URL(
				"http://www.claritin.com/weatherpollenservice/weatherpollenservice.svc/getforecast/48145");
		assertEquals(expected, actual);
	}

	@Test(expected = APIDownException.class)
	public void emptyJsonReturnsThrowsAPIDownException() throws Exception {
		URL url = new URL("http://www.ffffffffffffpoipoipoipoiadfqwerty.com/");
		JsonDAO jsonDAO = new JsonDAO("conditions", url);
		jsonDAO.getJson(url);
	}

	@Test(expected = InvalidWeatherTypeException.class)
	public void invalidWeatherTypeThrowsInvalidWeatherTypeException() throws Exception {
		BusinessDelegate apiDelegate = new BusinessDelegate(zip);
		apiDelegate.fetchWeatherData("bananas");
	}
	
	@Test(expected = InvalidWeatherTypeException.class)
	public void invalidWeatherTypeThrowsInvalidWeatherTypeExceptionInFactory() throws Exception {
		DTOFactory.fetchWeatherInformation("bananas", "json");
	}

	@Test
	public void populatedJsonSetsAttributeForCurrentConditions()
			throws Exception {
		String json = ConstantValues.CONDITIONS_TEST;

		Gson gson = new GsonBuilder().create();
		WeatherDTO expected = new WeatherDTO();
		expected = gson.fromJson(json, WeatherDTO.class);
		expected.setAttributes();

		WeatherDTO actual = new WeatherDTO();
		actual = (WeatherDTO) DTOFactory.fetchWeatherInformation("conditions",
				json);
		actual.setAttributes();

		assertEquals(expected.getTemp(), actual.getTemp(), 1e-5);
		assertEquals(expected.getHumidity(), actual.getHumidity(), 1e-5);
		assertEquals(expected.getHeatIndex(), actual.getHeatIndex());
		assertEquals(expected.getPressureTrend(), actual.getPressureTrend());
		assertEquals(expected.getTemp(), actual.getTemp(), 1e-5);
		assertEquals(expected.getUvIndex(), actual.getUvIndex(), 1e-5);
		assertEquals(expected.getWindDescription(), actual.getWindDescription());
		assertEquals(expected.getWindDirection(), actual.getWindDirection());
		assertEquals(expected.getWindSpeed(), actual.getWindSpeed(), 1e-5);
		assertEquals(expected.getUvIndex(), actual.getUvIndex(), 1e-5);
		assertEquals(expected.getOneHourPrecip(), actual.getOneHourPrecip());
		assertEquals(expected.getTempBar(), actual.getTempBar(), 1e-5);
		assertEquals(expected.getHumidityBar(), actual.getHumidityBar(), 1e-5);
		assertEquals(expected.getWindBar(), actual.getWindBar(), 1e-5);
		assertEquals(expected.getUvBar(), actual.getUvBar(), 1e-5);
		assertEquals(expected.getOneHourPrecipBar(), actual.getOneHourPrecipBar(), 1e-5);
	}

	@Test
	public void populatedJsonSetsAttributeForForecast() throws Exception {
		String json = ConstantValues.FORECAST_TEST;

		Gson gson = new GsonBuilder().create();
		ForecastDTO expected = new ForecastDTO();
		expected = gson.fromJson(json, ForecastDTO.class);
		expected.setAttributes();

		ForecastDTO actual = new ForecastDTO();
		actual = (ForecastDTO) DTOFactory.fetchWeatherInformation("forecast",
				json);
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
		actual = (AstronomyDTO) DTOFactory.fetchWeatherInformation("astronomy",
				json);
		actual.setAttributes();

		assertEquals(expected.getPercentIlluminated(),
				actual.getPercentIlluminated());
		assertEquals(expected.getMoonPhase(), actual.getMoonPhase());
		assertEquals(expected.getSunrise(), actual.getSunrise());
		assertEquals(expected.getSunset(), actual.getSunset());
		assertEquals(expected.getMoonPic(), actual.getMoonPic());
	}

	@Test
	public void populatedJsonSetsAttributeForPollution() throws Exception {
		String json = ConstantValues.POLLUTION_TEST;

		Gson gson = new GsonBuilder().create();
		PollutionDTO expected = new PollutionDTO();
		JsonParser parser = new JsonParser();
		String parsedJson = parser.parse(json).getAsJsonArray().get(0)
				.toString();
		expected = gson.fromJson(parsedJson, PollutionDTO.class);
		expected.setAttributes();

		PollutionDTO actual = new PollutionDTO();
		actual = (PollutionDTO) DTOFactory.fetchWeatherInformation("pollution",
				json);
		actual.setAttributes();

		assertEquals(expected.getAirQualityIndex(),
				actual.getAirQualityIndex(), 1e-5);
		assertEquals(expected.getAirQualityBar(), actual.getAirQualityBar());
	}

	@Test
	public void populatedJsonSetsAttributeForPollen() throws Exception {
		String json = ConstantValues.POLLEN_TEST;

		Gson gson = new GsonBuilder().create();
		PollenDTO expected = new PollenDTO();
		String testjson = json.replaceAll("\\\\", "");
		testjson = testjson.substring(1, testjson.length() - 1);
		expected = gson.fromJson(testjson, PollenDTO.class);
		expected.setAttributes();

		PollenDTO actual = new PollenDTO();
		actual = (PollenDTO) DTOFactory.fetchWeatherInformation("pollen", json);
		actual.setAttributes();

		assertArrayEquals(expected.getPollenCount(), actual.getPollenCount(),
				1e-5);
		assertEquals(expected.getPredominantPollen(),
				actual.getPredominantPollen());
		assertArrayEquals(expected.getPollenBar(), actual.getPollenBar(), 1e-5);
	}

	@Test
	public void populatedJsonReturnsJsonString() throws Exception {
		String expected = "{\"current_observation\":{\"relative_humidity\": \"50%\"}}";
		URL url = getMockUrlContents(expected);
		JsonDAO jsonDao = new JsonDAO("conditions", url);
		String actual = jsonDao.getJson(url);
		assertEquals(expected, actual);
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
