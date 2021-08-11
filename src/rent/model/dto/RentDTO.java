package rent.model.dto;

public class RentDTO {
	// �����ȣ
	private int rentId;
	// ���� ���� ������
	private String startDay;
	// ���� ���� ������
	private String endDay;
	// ���� �� ��ȣ
	private int customerId;
	// ���� ���� ��ȣ
	private int carId;
	// �� �ݳ���
	private String returnDay;
	
	public RentDTO() {}
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
		return "RentDTO [rentId=" + rentId + ", startDay=" + startDay + ", endDay=" + endDay + ", customerId="
				+ customerId + ", carId=" + carId + ", returnDay=" + returnDay + "]";
	}	
	
}
