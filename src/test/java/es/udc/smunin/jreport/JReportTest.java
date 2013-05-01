package es.udc.smunin.jreport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import es.udc.smunin.jreport.net.DataParserTest;
import es.udc.smunin.jreport.wrappers.JWrapper;
import es.udc.smunin.jreport.wrappers.datamodels.Service;

/**
 * Tests the network related functionality getting data from different endpoints
 * (HTTP and HTTPS). The data parsing test is done in the {@link DataParserTest}
 * class.
 * 
 * @author Santiago Munín <santimunin@gmail.com>
 * 
 */
public class JReportTest {

	@Test
	public void supportedCitiesTest() {
		String[] cities = JReport.getInstance().getCities();
		assertEquals(cities.length, 2);
		assertEquals(cities[0], "San Francisco, CA");
		assertEquals(cities[1], "Chicago, IL");
	}

	@Test
	public void JWrapperTestHttps() throws IOException {
		printConnectionDisclaimer("Test: getting all services from San Francisco (HTTPS)");
		JWrapper sanFranciscoWrapper = JReport.getInstance().getCityWrapper(
				City.SAN_FRANCISCO);
		List<Service> sfServices = sanFranciscoWrapper.getServices();
		assertTrue(sfServices != null);
		assertEquals(sfServices.size(), 38);
	}

	@Test
	public void JWrapperTestHttp() throws IOException {
		printConnectionDisclaimer("Test: getting all services from Chicago (HTTP)");
		JWrapper chicagoWrapper = JReport.getInstance().getCityWrapper(
				City.CHICAGO);
		List<Service> chicagoServices = chicagoWrapper.getServices();
		assertTrue(chicagoServices != null);
		assertEquals(chicagoServices.size(), 14);
	}

	private void printConnectionDisclaimer(String header) {
		System.out.println(header);
		System.out
				.println("Please, note that this test could fail if the server change its data or goes down.");
	}

}
