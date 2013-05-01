package es.udc.smunin.jreport.net;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Performs all kinds of HTTP requests in order to get data from the endpoints.
 * Implements the Singleton pattern.
 * 
 * @author Santiago Munín <santimunin@gmail.com>
 * 
 */
public class APIHttpClient {
	/**
	 * Single instance of the class.
	 */
	private static APIHttpClient instance = new APIHttpClient();

	private HttpClient httpClient;

	/**
	 * Private constructor in order to forbid the instantiation.
	 */
	private APIHttpClient() {
		httpClient = new DefaultHttpClient();
	}

	/**
	 * Returns the single instance of the class.
	 */
	public static APIHttpClient getInstance() {
		return instance;
	}

	/**
	 * Performs a HTTP GET request.
	 * 
	 * @param url
	 *            Target URL.
	 * @param parameters
	 *            Request parameters.
	 * @return Server's response.
	 * @throws IOException If there was any problem with the server.
	 * @throws URISyntaxException If the given url is not correct.
	 */
	public String doGet(String url, Map<String, String> parameters)
			throws IOException, URISyntaxException {
		URIBuilder uriBuilder = new URIBuilder(url);
		for (Entry<String, String> entry : parameters.entrySet()) {
			uriBuilder.setParameter(entry.getKey(), entry.getValue());
		}
		HttpGet httpGet = new HttpGet(url);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		return httpClient.execute(httpGet, responseHandler);
	}

}
