package rent.controller;

import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import rent.model.CarDAO;
import rent.model.CustomerDAO;
import rent.model.RentDAO;
import rent.model.dto.CarDTO;
import rent.model.dto.CustomerDTO;
import rent.model.dto.RentDTO;
import rent.view.RunningEndView;

public class Controller {
	// 모든 차량 검색
	public static void getAllCar() {
		try {
			RunningEndView.getCarList(CarDAO.getAllCar());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("차량 조회에 실패하였습니다.");
		}
	}

	// 모델명으로 검색
	public static void getCarModelList(String carModel) {
		try {
			RunningEndView.getCarList(CarDAO.getCarModelList(carModel));
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 모델이 없습니다.");
		}
	}

	// 차종으로 검색
	public static void getCarTypeList(String carType) {
		try {
			RunningEndView.getCarList(CarDAO.getCarTypeList(carType));
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 차종이 없습니다.");
		}
	}

	// 브랜드로 검색
	public static void getCarBrandList(String carBrand) {
		try {
			RunningEndView.getCarList(CarDAO.getCarBrandList(carBrand));
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("검색하신 브랜드가 없습니다.");
		}
	}

	// 현재 대여 가능한 차량 검색
	public static void getCarisRentList() {
		try {
			RunningEndView.getCarList(CarDAO.getCarisRentList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("대여 가능한 차량이 없습니다.");
		}
	}

	// 차량 대여
	public static void addRentList(RentDTO rent) {
		try {
			int status = RentDAO.addRentList(rent);
			if (status == 1) {
				RunningEndView.showMessage("예약에 성공했습니다.");
			} else {
				RunningEndView.showMessage("이미 예약중인 차량입니다.");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("차량 예약에 실패하였습니다.");
		} catch (ParseException e) {
			e.printStackTrace();
			RunningEndView.showError("날짜를 yyyy-mm-dd 형태로 다시 입력해주세요.");
		}
	}

	// 차량 반납
	public static void returnRent(int rentID) {
		try {
			int status = RentDAO.returnRent(rentID);

			if (status == 1) {
				RunningEndView.showMessage("반납이 완료되었습니다.");
			} else if (status == -1) {
				RunningEndView.showMessage("이미 반납한 차량입니다.");
			} else {
				RunningEndView.showMessage("존재하지 않는 차량 예약 번호입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("예기치 못한 에러입니다. 관리자에게 문의해주세요.");
		}
	}

	// 예약 조회
	private static void getRentList(String name) {
		try {
			RunningEndView.getRentList(RentDAO.getRentList(name));
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("예기치 못한 에러입니다. 관리자에게 문의해주세요.");
		}
	}

	// 고객 추가
	private static void addCustomer(CustomerDTO customer) throws SQLException {
		try {

			if (CustomerDAO.addCustomer(customer) == true) {
				RunningEndView.showMessage("등록 완료");
			} else {
				RunningEndView.showMessage("등록 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("예기치 못한 에러입니다. 관리자에게 문의해주세요.");
		}
	}

	// 관리자 - 차량 등록 로직
	public static void addCar(CarDTO car) {
		try {
			int carId = CarDAO.addCar(car);
			RunningEndView.showMessage("차량을 등록했습니다. (차량 등록 번호 : " + carId + ")");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("차량 등록에 실패하였습니다.");
		}
	}

	// 관리자 - 차량 삭제 로직
	public static void deleteCar(int id) {
		CarDTO car = null;

		try {
			car = CarDAO.getCar(id);
			CarDAO.deleteCar(car);
			RunningEndView.showMessage("차량을 삭제했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("차량 삭제에 실패하였습니다.");
		} catch (NullPointerException e) {
			e.printStackTrace();
			RunningEndView.showError("해당 차량이 존재하지 않습니다.");
		}
	}

	// 관리자 - 모든 렌트 내역 검색 로직
	public static void getAllRentList() {
		try {
			RunningEndView.getRentList(RentDAO.getAllRentList());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("리스트 조회에 실패했습니다.");
		} catch (NullPointerException e) {
			e.printStackTrace();
			RunningEndView.showError("리스트 조회에 실패했습니다.");
		}
	}

	// 시작 메뉴
	public static void startMenu() {
		System.out.println("***** 안녕하세요! 플레이렌트카입니다. *****");
		int choice = -1;
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		while (true) {
			System.out.println("\n0.메뉴 종료하기 \t1.모든 차량 조회하기  \t2.모델명으로 검색   \t3.차종으로 검색 \t4.브랜드로 검색"
					+ "\n5.대여 가능 차량 조회 \t6.차량 대여하기 \t7.차량 반납하기 \t8.예약 조회하기 \t9.고객 등록"
					+ "\n\n[관리자 메뉴]\n10.차량 추가  \t11.차량 삭제 \t12.모든 대여 내역 조회");
			System.out.println("\n메뉴를 선택해주세요.");

			try {
				choice = Integer.parseInt(sc.next());
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요.");
			}

			if (choice == 0) {
				System.out.println("\n이용해 주셔서 감사합니다.");
				break;

			} else if (choice == 1) {
				getAllCar();

			} else if (choice == 2) {
				System.out.println("검색하실 차량 모델을 입력해주세요. ex) 스파크, 레이, ...");
				String carModel = sc.next();
				getCarModelList(carModel);

			} else if (choice == 3) {
				System.out.println("검색하실 차종을 입력해주세요 [경차/준중형/중형/대형/SUV].");
				String carType = sc.next();
				getCarTypeList(carType);

			} else if (choice == 4) {
				System.out.println("검색하실 차량 브랜드를 입력해주세요. ex) 기아, 현대, ...");
				String carBrand = sc.next();
				getCarBrandList(carBrand);

			} else if (choice == 5) {
				getCarisRentList();

			} else if (choice == 6) {
				String endDay = null;
				int customerId = 0;
				int carId = 0;
				System.out.println("반납할 날짜를 입력하세요. (yyyy-mm-dd 형태로 입력)");
				endDay = sc.next();
				System.out.println("고객번호를 입력하세요.");
				try {
					customerId = Integer.parseInt(sc.next());
					System.out.println("차량번호를 입력하세요.");
					try {
						carId = Integer.parseInt(sc.next());
						addRentList(new RentDTO(endDay, customerId, carId));
					} catch (NumberFormatException e) {
						e.printStackTrace();
						RunningEndView.showError("차량 번호를 다시 확인해주세요.");
					}
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
					RunningEndView.showError("고객 번호를 다시 확인해주세요.");
				}
			} else if (choice == 7) {
				System.out.println("예약번호를 기억하시나요? y/n");
				String answer = sc.next();
				if (answer.equals("n")) {
					System.out.println("예약내역을 조회하실 고객 이름을 입력해주세요.");
					answer = sc.next();
					getRentList(answer);
				}
				System.out.println("예약번호를 입력해주세요.");
				int rentId = 0;
				try {
					rentId = Integer.parseInt(sc.next());
				} catch (NumberFormatException e) {
					System.out.println("숫자로 입력해주세요");
				}
				returnRent(rentId);

			} else if (choice == 8) {
				System.out.println("이름을 입력해주세요");
				String name = sc.next();
				getRentList(name);

			} else if (choice == 9) {
				System.out.println("이름을 입력하세요.");
				String name = sc.next();
				System.out.println("핸드폰 번호를 입력하세요.");
				String phone = sc.next();
				System.out.println("면허증 번호를 입력하세요.");
				String license = sc.next();
				try {
					addCustomer(new CustomerDTO(name, phone, license));
				} catch (SQLException e){
					e.printStackTrace();
					RunningEndView.showError("정확한 번호가 맞는지 확인해주세요.");
				}
				

			} else if (choice == 10) {
				System.out.println("차량 모델을 입력하세요.");
				String model = sc.next();
				System.out.println("차량 브랜드를 입력하세요.");
				String brand = sc.next();
				System.out.println("차종을 입력하세요.");
				String carType = sc.next();
				System.out.println("대여료를 입력하세요.");
				int price = 0;
				try {
					price = Integer.parseInt(sc.next());
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("숫자를 입력하지 않아 기본값 0으로 저장됩니다.");
				} 
				addCar(new CarDTO(model, brand, carType, price));

			} else if (choice == 11) {
				int carId = 0;
				try {
					System.out.println("삭제할 차량 번호를 입력하세요.");
					carId = Integer.parseInt(sc.next());
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("숫자를 입력하지 않아 조회할 수 없습니다.");
				}
				deleteCar(carId);
			} else if (choice == 12) {
				getAllRentList();
			}

		}
		sc.close();
		sc = null;
	}

}
