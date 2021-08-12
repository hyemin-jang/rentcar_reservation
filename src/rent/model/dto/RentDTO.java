package rent.model.dto;

public class RentDTO {
	// 예약번호
	private int rentId;
	// 차량 예약 시작일
	private String startDay;
	// 차량 예약 종료일
	private String endDay;
	// 예약 고객 번호
	private int customerId;
	// 예약 차량 번호
	private int carId;
	// 실 반납일
	private String returnDay;
	
	public RentDTO() {}
	public RentDTO(String endDay, int customerId, int carId) {
		super();
		this.endDay = endDay;
		this.customerId = customerId;
		this.carId = carId;
	}
	
	public RentDTO(int rentId, String startDay, String endDay, int customerId, int carId, String returnDay) {
		super();
		this.rentId = rentId;
		this.startDay = startDay;
		this.endDay = endDay;
		this.customerId = customerId;
		this.carId = carId;
		this.returnDay = returnDay;
	}
	
	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getReturnDay() {
		return returnDay;
	}
	public void setReturnDay(String returnDay) {
		this.returnDay = returnDay;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("  " + rentId + "  ");
		builder.append("\t\t" + startDay);
		builder.append("\t   " + endDay);
		builder.append("\t\t" + customerId);
		builder.append("\t   " + carId);
		if (returnDay == null) {
			builder.append("\t\t-");
		} else {
			builder.append("\t\t" + returnDay);
		}
		
		return builder.toString();
	}	
	
}
