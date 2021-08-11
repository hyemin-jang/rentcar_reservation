package rent.model.dto;

public class CarDTO {
	// �ڵ��� ��Ϲ�ȣ
	private int carId;	
	// ������ �귣�� (����, ���..)
	private String brand;  
	// �� �𵨸� (�ƹݶ�, �ҳ�Ÿ..)
	private String model;
	// ���� (����, ����, ..)
	private String carType;
	// 1�ڴ� �뿩 ����
	private int price;
	
	public CarDTO() {}
	public CarDTO(int carId, String brand, String model, String carType, int price) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.carType = carType;
		this.price = price;
	}
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
	
	@Override
	public String toString() {
		return "CarDTO [carId=" + carId + ", brand=" + brand + ", model=" + model + ", carType=" + carType + ", price="
				+ price + "]";
	}
	
	
}
