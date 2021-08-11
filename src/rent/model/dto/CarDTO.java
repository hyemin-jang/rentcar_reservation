package rent.model.dto;

public class CarDTO {
	// 자동차 등록번호
	private int carId;	
	// 제조사 브랜드 (현대, 기아..)
	private String brand;  
	// 차 모델명 (아반떼, 소나타..)
	private String model;
	// 차종 (소형, 중형, ..)
	private String carType;
	// 1박당 대여 가격
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
