package rent.model.dto;

public class CarDTO {
	// 자동차 등록번호
	private int carId;
	// 차 모델명 (아반떼, 소나타..)
	private String model;
	// 제조사 브랜드 (현대, 기아..)
	private String brand;
	// 차종 (소형, 중형, ..)
	private String carType;
	// 1박당 대여 가격
	private int price;
	// 대여 여부 (0,1)
	private String isRent;

	public CarDTO() {
	}

	public CarDTO(int carId, String model, String brand, String carType, int price, String isRent) {
		super();
		this.carId = carId;
		this.model = model;
		this.brand = brand;
		this.carType = carType;
		this.price = price;
		this.isRent = isRent;
	}

	public CarDTO(String model, String brand, String carType, int price) {
		super();
		this.model = model;
		this.brand = brand;
		this.carType = carType;
		this.price = price;
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

	public String getIsRent() {
		return isRent;
	}

	public void setIsRent(String isRent) {
		this.isRent = isRent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("  " + carId + "  ");
		builder.append("\t\t" + model);
		if (model.length() >= 5) {
			builder.append("\t\t" + brand);
		} else {
			builder.append("\t\t\t" + brand);
		}
		builder.append("\t\t" + carType);
		builder.append("\t\t" + price);
		if (Integer.parseInt(isRent) == 0) {
			builder.append("\t\t대여가능");
		} else {
			builder.append("\t대여중");
		}
		return builder.toString();
	}

}
