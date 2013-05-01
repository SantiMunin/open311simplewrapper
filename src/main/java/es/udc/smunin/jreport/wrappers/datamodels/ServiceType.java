package es.udc.smunin.jreport.wrappers.datamodels;

/**
 * Represents the type of a service.
 * 
 * @author Santiago Munín <santimunin@gmail.com>
 * 
 */
public enum ServiceType {
	REALTIME, BATCH, BLACKBOX;
	/**
	 * Returns an instance of this class from a given string-
	 * 
	 * @param type
	 * @return <code>null</code> if the string is not one of the contained
	 *         types.
	 */
	public static ServiceType getFromString(String type) {
		if (type.toLowerCase().equals("realtime")) {
			return REALTIME;
		}
		if (type.toLowerCase().equals("batch")) {
			return BATCH;
		}
		if (type.toLowerCase().equals("blackbox")) {
			return BLACKBOX;
		}
		return null;
	}
}
