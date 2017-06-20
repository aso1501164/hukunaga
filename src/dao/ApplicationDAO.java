	/*
	 * date:2017/06/16
	 * name:
	 * comm:applicationテーブルのDAO
	 *
	 *
	 */
	package dao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Student;

	public class ApplicationDAO {
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

		/**
		 *	その教科を受講する生徒をすべて検索
	*/
		public List<Student> selectStudentList(String subject_id) {
			// ログインユーザ情報を格納
			ArrayList<Student> list = new ArrayList<Student>();
			try {
				// DB接続
				connection();
				// SQL文設定の準備・SQL文の実行
				String sql = "SELECT * FROM `student` WHERE `student_id` = (select `student_id` from `application` where (`subject_id_1` = ? OR `subject_id_2` = ? ) AND `year` = (select max(`year`) from `application`));";

				stmt = con.prepareStatement(sql);// sql文をプリコンパイルした状態で保持
				// ユーザの入力値を代入
				stmt.setString(1, subject_id);
				stmt.setString(2, subject_id);

				// sql文を実行
				rs = stmt.executeQuery();

				while (rs.next()) {
					Student st = new Student();
					// 1件分のデータをBeanに格納し、それをListに入れてjspに渡す
					// DBから取得したデータをScheduleオブジェクトに格納
					st.setStudent_name(rs.getString("student_name"));
					st.setClass_name(rs.getString("class_name"));
					list.add(st);
				}
			} catch (Exception e) {
				Student st = new Student();
				st = null;
				System.out.println("受講者なし");
				list.add(null);
			} finally {
				try {
					close();
				} catch (Exception e) {
			}
		}
			return list;
	}
}
