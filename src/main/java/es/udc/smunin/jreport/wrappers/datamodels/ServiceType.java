package es.udc.smunin.jreport.wrappers.datamodels;

/**
 * Represents the type of a service.
 * 
 * @author Santiago Munín <santimunin@gmail.com>
 * 
 */
public enum ServiceType {
	REALTIME, BATCH, BLACKBOX;

	public static ServiceType getFromString(String type) {
		if (type.equals("realtime")) {
			return REALTIME;
		}
		if (type.equals("batch")) {
			return BATCH;
		}
		if (type.equals("blackbox")) {
			return BLACKBOX;
		}
		return null;
	}
}
