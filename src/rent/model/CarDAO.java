package rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import rent.model.dto.CarDTO;
import rent.model.util.DBUtil;

public class CarDAO {
	private static Properties sql = DBUtil.getSql();

	// 모든 차량 검색
	public static ArrayList<CarDTO> getAllCar() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> carList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllCar"));
			rset = pstmt.executeQuery();

			carList = new ArrayList<CarDTO>();
			while (rset.next()) {
				carList.add(new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return carList;
	}

	// 모델명으로 검색
	public static ArrayList<CarDTO> getCarModelList(String carModel) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> carList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getCarModelList"));
			pstmt.setString(1, carModel);
			rset = pstmt.executeQuery();

			carList = new ArrayList<CarDTO>();
			while (rset.next()) {
				carList.add(new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return carList;
	}

	// 차종으로 검색
	public static ArrayList<CarDTO> getCarTypeList(String carType) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> carList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getCarTypeList"));
			pstmt.setString(1, carType);
			rset = pstmt.executeQuery();

			carList = new ArrayList<CarDTO>();
			while (rset.next()) {
				carList.add(new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return carList;
	}

	public static ArrayList<CarDTO> getCarBrandList(String carBrand) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> carList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getCarBrandList"));
			pstmt.setString(1, carBrand);
			rset = pstmt.executeQuery();

			carList = new ArrayList<CarDTO>();
			while (rset.next()) {
				carList.add(new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}

		return carList;
	}

	public static ArrayList<CarDTO> getCarisRentList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> carList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getCarisRentList"));
			rset = pstmt.executeQuery();

			carList = new ArrayList<CarDTO>();
			while (rset.next()) {
				carList.add(new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return carList;
	}

	// 차량 추가
	public static boolean addCar(CarDTO car) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addCar"));
			pstmt.setString(1, car.getModel());
			pstmt.setString(2, car.getBrand());
			pstmt.setString(3, car.getCarType());
			pstmt.setInt(4, car.getPrice());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 차량 대여 가능 상태 변경
	public static boolean updateCarIsRent(int carId, String isRent) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("updateCarIsRent"));
			pstmt.setString(1, isRent);
			pstmt.setInt(2, carId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 차량 등록번호로 차량 검색
	public static CarDTO getCar(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CarDTO car = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getCar"));
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				car = new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
			}

		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return car;
	}

	// 차량 삭제
	public static boolean deleteCar(CarDTO car) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteCar"));
			pstmt.setInt(1, car.getCarId());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

}