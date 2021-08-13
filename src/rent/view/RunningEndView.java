package rent.view;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import rent.model.dto.CarDTO;
import rent.model.dto.RentDTO;

public class RunningEndView {
	static Logger logger = Logger.getLogger("rent.view.Log4j");

	// 차량 리스트 출력
	public static void getCarList(ArrayList<CarDTO> list) {
		if (list != null) {
			int length = list.size();

			if (length != 0) {
				System.out.println(
						"----------------------------------------------------------------------------------------------------");
				System.out.println(
						"| no. |            모델                           |     브랜드           |     차종            |      대여 금액          |       대여 여부          |");
				System.out.println(
						"----------------------------------------------------------------------------------------------------");
				for (int index = 0; index < length; index++) {
					System.out.println(list.get(index));
				}
				logger.info("차량 조회 성공");
			} else {
				System.out.println("해당 내역이 없습니다.");
				logger.info("조회 내역 없음");
			}
		} else {
			System.out.println("null 값은 허용되지 않습니다.");
			logger.warn("조회 실패");
		}

	}

	// 대여리스트 출력
	public static void getRentList(ArrayList<RentDTO> list) {
		if (list != null) {
			int length = list.size();

			if (length != 0) {
				System.out.println(
						"---------------------------------------------------------------------------------------------");
				System.out.println(
						"| No. |          대여일                   |       반납예정일                 | 고객No. | 차량No. |         실반납일               |");
				System.out.println(
						"---------------------------------------------------------------------------------------------");
				for (int index = 0; index < length; index++) {
					System.out.println(list.get(index));
				}
				logger.info("예약 내역 조회 성공");
			} else {
				System.out.println("예약 내역이 없습니다.");
				logger.info("예약 내역 없음");
			}
		} else {
			System.out.println("null 값은 허용되지 않습니다.");
			logger.warn("예약 조회 실패");
		}

	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
		logger.warn("예외 발생 - " + message);
	}

	// 정상 수행시 메세지 출력
	public static void showMessage(String message) {
		System.out.println(message);
		logger.info("정상 실행 - " + message);
	}

}
