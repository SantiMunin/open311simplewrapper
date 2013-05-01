package es.udc.smunin.jreport.net;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import es.udc.smunin.jreport.wrappers.datamodels.Service;

public class DataParserTest {

	private String serviceXmlString = "<services xmlns:m=\"http://org/sfgov/sf311v2/services\" "
			+ "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
			+ "<service><service_code>001</service_code><metadata>false</metadata>"
			+ "<type>realtime</type><keywords>lorem, ipsum, dolor</keywords><group>Litter Receptacles</group><service_name>"
			+ "Cans_Left_Out_24x7</service_name><description>Garbage or recycling cans that have been "
			+ "left out for more than 24 hours after collection. Violators will be cited.</description>"
			+ "</service></services>";

	@Test
	public void parseServicesList() {
		List<Service> services = DataParser.getInstance().parseServicesList(
				serviceXmlString);
		assertEquals(services.size(), 1);
		Service service = services.get(0);
		assertEquals(service.getCode(), 1);
		assertEquals(service.hasMetadata(), false);
		assertEquals(service.getKeywords().length, 3);
		assertEquals(service.getKeywords()[0], "lorem");
		assertEquals(service.getKeywords()[1], "ipsum");
		assertEquals(service.getKeywords()[2], "dolor");
		assertEquals(service.getType(), Service.SERVICE_TYPE.REALTIME);
		assertEquals(service.getGroup(), "Litter Receptacles");
		assertEquals(service.getName(), "Cans_Left_Out_24x7");
		assertEquals(
				service.getDescription(),
				"Garbage or recycling cans that have been left out for more than 24 hours after collection. Violators will be cited.");
	}
}
