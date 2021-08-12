package rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import rent.model.dto.CarDTO;
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
	public static boolean addRentList(RentDTO rent) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		Date now = new Date();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addRentList"));
			pstmt2 = con.prepareStatement(sql.getProperty("getPrice"));
			pstmt.setString(1, rent.getEndDay());
			pstmt.setInt(2, rent.getCustomerId());
			pstmt.setInt(3, rent.getCarId());
			pstmt2.setInt(1, rent.getCarId());
			
			rset = pstmt2.executeQuery();
			int result = pstmt.executeUpdate();
			
			String date1 = rent.getEndDay();
			
			Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			Date format2 = now;
			
			long diffSec = (format1.getTime() - format2.getTime()) / 1000; //초 차이
			long diffDays = diffSec / (24*60*60); //일자수 차이
			
			if(rset.next()){
				System.out.println("결제 예정 금액은 "+rset.getInt(1)*diffDays+"원 입니다. 선결제 부탁드립니다.");
			}
			
			System.out.println(diffDays);

			CarDAO.updateCarIsRent(rent.getCarId(), "1");
			
			if (result == 1) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 차량 반납
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
