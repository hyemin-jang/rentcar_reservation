package rent.model.dto;

public class CarDTO {
	// �ڵ��� ��Ϲ�ȣ
	private int carId;		
	// �� �𵨸� (�ƹݶ�, �ҳ�Ÿ..)
	private String model;
	// ������ �귣�� (����, ���..)
	private String brand;  
	// ���� (����, ����, ..)
	private String carType;
	// 1�ڴ� �뿩 ����
	private int price;
	// �뿩 ���� (0,1)
	private char isRent;
	
	public CarDTO() {}
	public CarDTO(int carId, String model, String brand, String carType, int price, char isRent) {
		super();
		this.carId = carId;
		this.model = model;
		this.brand = brand;
		this.carType = carType;
		this.price = price;
		this.isRent = isRent;
	}
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public char getIsRent() {
		return isRent;
	}
	public void setIsRent(char isRent) {
		this.isRent = isRent;
	}
	
	@Override
	public String toString() {
		return "CarDTO [carId=" + carId + ", model=" + model + ", brand=" + brand + ", carType=" + carType + ", price="
				+ price + ", isRent=" + isRent + "]";
	}	
	
}
