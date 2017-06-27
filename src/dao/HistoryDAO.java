	/*
	 * date:2017/06/16
	 * name:
	 * comm:historyテーブルのDAO
	 */
	package dao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.History;

	public class HistoryDAO {
		// データソース
		DataSource ds = null;
		// データベース接続情報
		Connection con = null;
		// プリコンパイル用のステートメント
		PreparedStatement stmt = null;
		// SELECTの結果を格納するResultSet
		ResultSet rs = null;

		/**
		 * データベースへの接続処理を行うメソッド
		 *
		 * @return コネクション情報
		 */
		public Connection connection() throws Exception {
			// データソースがなければ、context.xmlから読み込んで設定する
			if (ds == null) {
				ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
			}
			con = ds.getConnection();
			return con;
		}

		/**
		 * データベースからの切断処理を行うメソッド
		 */
		public void close() throws Exception {
			// データベース接続されていれば、切断する
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		public ArrayList<History> getHistory(String student_id) {
			ArrayList<History> historyList = new ArrayList<History>();

			try {
				connection();

				String sql = "SELECT * FROM history WHERE student_id = ? ORDER BY year";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, student_id);
				rs = stmt.executeQuery();

				while (rs.next()) {
					History history = new History();
					history.setStudent_id(rs.getString("student_id"));
					history.setSubject_id_1(rs.getString("subject_id_1"));
					history.setSubject_id_2(rs.getString("subject_id_2"));
					history.setYear(rs.getString("year"));
					historyList.add(history);
				}
			} catch (Exception e) {
			} finally {
				try {
					close();
				} catch (Exception e) {
				}
			}


			return historyList;
		}
}
