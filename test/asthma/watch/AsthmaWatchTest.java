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

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AsthmaWatchTest {

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	String zip = "48145";

	@Test
	public void emptyJsonSetsNoAttributes() throws Exception {
		URL url = getMockUrlContents("");
		AsthmaWatch aw = new AsthmaWatch();
		aw.pollenInformation(request, response, url);
		aw.weatherInformation(request, response, url);
		verify(request, never()).setAttribute(anyString(), anyDouble());
		verify(request, never()).setAttribute(anyString(), anyString());
	}

	@Test
	public void emptyJsonReturnsNullString() throws Exception {
		URL url = getMockUrlContents("");
		AsthmaWatch aw = new AsthmaWatch();
		String actual = aw.getJson(url);
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void populatedJsonSetsAttributesForPollen() throws Exception {
		String json = "\"{\\\"pollenForecast\\\":{\\\"forecast\\\":[1.0,2.0,3.0,4.0],\\\"pp\\\":\\\"Treeant.\\\"}}\"";
		URL url = getMockUrlContents(json);
		AsthmaWatch aw = new AsthmaWatch();
		aw.pollenInformation(request, response, url);
		verify(request).setAttribute("day1", 1.0);
		verify(request).setAttribute("day2", 2.0);
		verify(request).setAttribute("day3", 3.0);
		verify(request).setAttribute("day4", 4.0);
		verify(request).setAttribute("pp", "Treeant.");
	}

	@Test
	public void populatedJsonSetsAttributesForWeather() throws Exception {
		String json = "{\"current_observation\":{\"relative_humidity\": \"50%\"}}";
		URL url = getMockUrlContents(json);
		AsthmaWatch aw = new AsthmaWatch();
		aw.weatherInformation(request, response, url);
		verify(request).setAttribute("humidity", "50%");
	}

	@Test
	public void populatedJsonReturnsJsonString() throws Exception {
		String expected = "{\"current_observation\":{\"relative_humidity\": \"50%\"}}";
		URL url = getMockUrlContents(expected);
		AsthmaWatch aw = new AsthmaWatch();
		String actual = aw.getJson(url);
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
