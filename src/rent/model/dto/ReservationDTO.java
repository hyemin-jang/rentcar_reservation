package rent.model.dto;

public class ReservationDTO {
	// 예약번호
	private int reservationId;
	// 차량 예약 시작일
	private String startDay;
	// 차량 예약 종료일
	private String endDay;
	// 예약 고객 번호
	private int customerId;
	// 예약 차량 번호
	private int carId;
	// 예약 총금액 ( (종료일-시작일)*차량 1박당 금액 )
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
