package es.udc.smunin.jreport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import es.udc.smunin.jreport.wrappers.JWrapper;
import es.udc.smunin.jreport.wrappers.datamodels.Service;

public class JReportTest {

	@Test
	public void supportedCitiesTest() {
		String[] cities = JReport.getInstance().getCities();
		assertEquals(cities.length, 2);
		assertEquals(cities[0], "San Francisco, CA");
		assertEquals(cities[1], "Chicago, IL");
	}

	@Test
	public void JWrapperTest() throws IOException {
		System.out.println("Test: getting all services from San Francisco");
		System.out
				.println("Please, note that this test could fail if the server change its data or goes down.");
		JWrapper sanFranciscoWrapper = JReport.getInstance().getCityWrapper(
				City.SAN_FRANCISCO);
		List<Service> sfServices = sanFranciscoWrapper.getServices();
		assertTrue(sfServices != null);
		assertEquals(sfServices.size(), 38);
	}
}
