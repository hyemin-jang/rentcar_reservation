package rent.model.dto;

public class CustomerDTO {
	// ∞Ì∞¥ π¯»£
	private int customerId;
	// ∞Ì∞¥ ¿Ã∏ß
	private String name;
	// ∞Ì∞¥ ø¨∂Ù√≥
	private String phone;
	// ∞Ì∞¥ ∏È«„ ¡§∫∏
	private String license;
	
	public CustomerDTO() {}
	public CustomerDTO(int customerId, String name, String phone, String license) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phone = phone;
		this.license = license;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", phone=" + phone + ", license=" + license
				+ "]";
	}
	
}	
