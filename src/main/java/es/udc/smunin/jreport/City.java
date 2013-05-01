package es.udc.smunin.jreport;

/**
 * Cities supported by the wrapper.
 */
public enum City {

	SAN_FRANCISCO(
			"San Francisco",
			"https://open311.sfgov.org/dev/V2/services.xml?jurisdiction_id=sfgov.org",
			"sfgov.org");
	private String cityName;
	private String jurisdictionId;
	private String baseUrl;

	private City(String cityName, String baseUrl, String jurisdictionId) {
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

	public String toString() {
		return this.getCityName();
	}
}