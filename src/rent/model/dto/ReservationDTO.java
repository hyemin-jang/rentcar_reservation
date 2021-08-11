package rent.model.dto;

public class ReservationDTO {
	// �����ȣ
	private int reservationId;
	// ���� ���� ������
	private String startDay;
	// ���� ���� ������
	private String endDay;
	// ���� �� ��ȣ
	private int customerId;
	// ���� ���� ��ȣ
	private int carId;
	// ���� �ѱݾ� ( (������-������)*���� 1�ڴ� �ݾ� )
	private int amount;
	
	public ReservationDTO() {}
	public ReservationDTO(int reservationId, String startDay, String endDay, int customerId, int carId, int amount) {
		super();
		this.reservationId = reservationId;
		this.startDay = startDay;
		this.endDay = endDay;
		this.customerId = customerId;
		this.carId = carId;
		this.amount = amount;
	}
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "ReservationDTO [reservationId=" + reservationId + ", startDay=" + startDay + ", endDay=" + endDay
				+ ", customerId=" + customerId + ", carId=" + carId + ", amount=" + amount + "]";
	}
	
}
