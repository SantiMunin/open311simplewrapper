package es.udc.smunin.jreport.wrappers.datamodels;

/**
 * Represents a service fetched from an endpoint.
 * 
 * @author Santiago Munín <santimunin@gmail.com>
 * 
 */
public class Service {

	private String code;
	private boolean metadata;
	private ServiceType type;
	private String[] keywords;
	private String group;
	private String name;
	private String description;

	public Service(String code, boolean metadata, String type, String group,
			String name, String description, String[] keywords) {
		super();
		this.code = code;
		this.metadata = metadata;
		this.type = ServiceType.getFromString(type);
		this.group = group;
		this.name = name;
		this.description = description;
		this.keywords = keywords;
	}

	public String getCode() {
		return code;
	}

	public boolean hasMetadata() {
		return metadata;
	}

	public ServiceType getType() {
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
