package es.udc.smunin.jreport.wrappers.datamodels;

/**
 * Represents a service fetched from an endpoint.
 * 
 * @author Santiago Munín <santimunin@gmail.com>
 * 
 */
public class Service {

	/**
	 * Represents the type of a service.
	 * 
	 * @author Santiago Munín <santimunin@gmail.com>
	 * 
	 */
	public static enum SERVICE_TYPE {
		REALTIME, BATCH, BLACKBOX;

		public static SERVICE_TYPE getFromString(String type) {
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

	private long code;
	private boolean metadata;
	private SERVICE_TYPE type;
	private String[] keywords;
	private String group;
	private String name;
	private String description;

	// TODO document constructor
	public Service(long code, boolean metadata, String type, String group,
			String name, String description, String[] keywords) {
		super();
		this.code = code;
		this.metadata = metadata;
		this.type = SERVICE_TYPE.getFromString(type);
		this.group = group;
		this.name = name;
		this.description = description;
		this.keywords = keywords;
	}

	public long getCode() {
		return code;
	}

	public boolean hasMetadata() {
		return metadata;
	}

	public SERVICE_TYPE getType() {
		return type;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public String getGroup() {
		return group;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
