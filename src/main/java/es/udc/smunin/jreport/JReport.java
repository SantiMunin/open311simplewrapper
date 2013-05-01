package es.udc.smunin.jreport;

import es.udc.smunin.jreport.wrappers.JWrapper;

/**
 * This class is the facade of the library. It should be used to get a wrapper
 * of a city.
 * 
 * @author Santiago Munín <santiagomunin@gmail.com>
 * 
 */
public class JReport {

	private static JReport instance = new JReport();

	private JReport() {
	}

	public static JReport getInstance() {
		return instance;
	}

	public JWrapper getCityWrapper(CITY city) {
		return new JWrapper(city.getCityName(), city.getBaseUrl(),
				city.getJurisdictionId());
	}

	/**
	 * Cities supported by the wrapper.
	 */
	public static enum CITY {
		SAN_FRANCISCO(
				"San Francisco",
				"https://open311.sfgov.org/dev/V2/services.xml?jurisdiction_id=sfgov.org",
				"sfgov.org");
		private String cityName;
		private String jurisdictionId;
		private String baseUrl;

		private CITY(String cityName, String baseUrl, String jurisdictionId) {
			this.cityName = cityName;
			this.baseUrl = baseUrl;
			this.jurisdictionId = jurisdictionId;
		}

		public String getJurisdictionId() {
			return jurisdictionId;
		}

		public String getBaseUrl() {
			return baseUrl;
		}

		public String getCityName() {
			return cityName;
		}
	}
}
