package rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import rent.model.dto.RentDTO;
import rent.model.util.DBUtil;

public class RentDAO {
	private static Properties sql = DBUtil.getSql();

	// 관리자 - 모든 대여 내역 조회
	public static ArrayList<RentDTO> getAllRentList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDTO> rentList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllRentList"));
			rset = pstmt.executeQuery();
			rentList = new ArrayList<RentDTO>();
			
			while (rset.next()) {
				rentList.add(new RentDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getString(6)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return rentList;
	}

	// 차량 대여
	public static boolean addRentList(RentDTO rent) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rset1 = null;
		ResultSet rset2 = null;
		ResultSet rset3 = null;

		try {
			con = DBUtil.getConnection();
			pstmt4 = con.prepareStatement(sql.getProperty("getCarIsRent"));
			pstmt4.setInt(1, rent.getCarId());
			rset3 = pstmt4.executeQuery();
			if(rset3.next()) {
				if(rset3.getInt(1) == 0) {
					pstmt = con.prepareStatement(sql.getProperty("addRentList"));
					pstmt2 = con.prepareStatement(sql.getProperty("getPrice"));
					pstmt3 = con.prepareStatement(sql.getProperty("getRentId"));
					pstmt.setString(1, rent.getEndDay());
					pstmt.setInt(2, rent.getCustomerId());
					pstmt.setInt(3, rent.getCarId());
					pstmt2.setInt(1, rent.getCarId());
					
					rset1 = pstmt2.executeQuery();
					int result = pstmt.executeUpdate();
					rset2 = pstmt3.executeQuery();

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date format1 = dateFormat.parse(rent.getEndDay());
					Date format2 = dateFormat.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
					
					long diffSec = ((format1.getTime()) - format2.getTime()) / 1000 + (24*60*60); //초 차이
					long diffDays = (diffSec / (24*60*60)); //일자수 차이
					
					if(rset1.next()){
						if(rset2.next()) {
							System.out.println("고객님의 예약 번호는 "+rset2.getInt(1)+"번 입니다.");
						}
						System.out.println("결제 예정 금액은 " + rset1.getInt(1)*diffDays + "원 입니다. 선결제 부탁드립니다.");
					}
					
					CarDAO.updateCarIsRent(rent.getCarId(), "1");
					
					if (result == 1) {
						return true;
					}
				} else {
					System.out.println("해당 차량은 이미 예약되어 있습니다.");
					throw new SQLException();
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt, rset1);
			DBUtil.close(con, pstmt2, rset2);
			DBUtil.close(con, pstmt3);
			DBUtil.close(con, pstmt4, rset3);
		}
		return false;
	}

	// 렌트 내역 검색
	public static ArrayList<RentDTO> getRentList(String name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDTO> rentList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getRentList"));
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();

			rentList = new ArrayList<RentDTO>();
			
			while (rset.next()) {
				rentList.add(new RentDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getString(6)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return rentList;
	}
	
	// 차랑 반납
	public static int returnRent(int rentID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("returnRentGetId"));
			pstmt.setInt(1, rentID);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Date returnDay = rset.getDate(1);
				int carId = rset.getInt(2);

				if (returnDay == null) {
					pstmt2 = con.prepareStatement(sql.getProperty("updateIsRentZero"));
					pstmt2.setInt(1, carId);
					int result = pstmt2.executeUpdate();
					
					// 정상 반납
					if (result == 1) {
						pstmt3 = con.prepareStatement(sql.getProperty("updateReturnday"));
						pstmt3.setInt(1, rentID);
						pstmt3.executeUpdate();
						
						return 1;
					}
				}else {
					// 이미 반납된 차량
					return -1;
				}
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
			DBUtil.close(pstmt2);
			DBUtil.close(pstmt3);
		}
		// 에러
		return 0;
	}
}
