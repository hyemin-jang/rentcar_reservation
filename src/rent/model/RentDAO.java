package rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rent.model.dto.RentDTO;
import rent.model.util.DBUtil;

public class RentDAO {

	// 관리자 - 모든 대여 내역 조회
	public static ArrayList<RentDTO> getAllRentList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDTO> rentList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select rent_id, startday, endday, customer_id, car_id, nvl(returnday, '') from rent order by rent_id");
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

	public static boolean addRentList(RentDTO rent) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into rent (rent_id, startday, endday, customer_id, car_id)values(rent_idx.NEXTVAL, SYSDATE, ?, ?, ?)");
			pstmt.setString(1, rent.getEndDay());
			pstmt.setInt(2, rent.getCustomerId());
			pstmt.setInt(3, rent.getCarId());
			
			int result = pstmt.executeUpdate();
			
			CarDAO.updateCarIsRent(rent.getCarId(), "1");
			
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	public static int returnRent(int rentID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select returnday, car_id from rent where rent_id=?");
			pstmt.setInt(1, rentID);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Date returnDay = rset.getDate(1);
				int carId = rset.getInt(2);

				if (returnDay == null) {
					pstmt2 = con.prepareStatement("UPDATE CAR SET IS_RENT = 0 WHERE CAR_ID = ?");
					pstmt2.setInt(1, carId);
					int result = pstmt2.executeUpdate();
					
					// 정상 반납
					if (result == 1) {
						pstmt3 = con.prepareStatement("UPDATE rent SET returnday = SYSDATE WHERE rent_id = ?");
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
