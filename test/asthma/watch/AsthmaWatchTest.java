package asthma.watch;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class AsthmaWatchTest {

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	String zip = "48145";

//	@Test
//	public void tooSmallZipTriggersGuardClause() {
//	}

	@Test
	public void emptyJsonReturnsEmptyString() throws Exception {
		URL url = getMockUrlContents("");
		new AsthmaWatch(request, response, url, url);
		verify(request, never()).setAttribute(anyString(), anyDouble());
		verify(request, never()).setAttribute(anyString(), anyString());
	}

//	@Test
//	public void populatedJsonReturnsJson() {
//
//	}
//
//	@Test
//	public void emptyJsonSetsNoAttributes() {
//
//	}
//
//	@Test
//	public void populatedJsonSetsAttributes() {
//	}
//
//	@Test
//	public void malformedJsonSetsNoAttributes() {
//		fail("Not yet implemented");
//	}

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
