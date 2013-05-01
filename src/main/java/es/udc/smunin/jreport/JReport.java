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
	/**
	 * Single instance of the class.
	 */
	private static JReport instance = new JReport();

	private JReport() {
	}

	/**
	 * @return the single instance of the class.
	 */
	public static JReport getInstance() {
		return instance;
	}

	/**
	 * Returns the wrapper of the given city. It allows to get data from its
	 * server.
	 * 
	 * @param city
	 *            Desired city to work with.
	 * @return Wrapper of the given city.
	 */
	public JWrapper getCityWrapper(City city) {
		return new JWrapper(city.getCityName(), city.getBaseUrl(),
				city.getJurisdictionId());
	}

	/**
	 * 
	 * @return array with the name of the all supported cities.
	 */
	public String[] getCities() {
		City[] values = City.values();
		String[] cities = new String[values.length];

		for (int i = 0; i < values.length; i++) {
			cities[i] = values[i].toString();
		}
		return cities;
	}
}
