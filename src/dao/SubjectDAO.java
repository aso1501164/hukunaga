package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Classfication;
import model.Subject;

public class SubjectDAO {
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
	 * その先生が担当の教科をすべて検索（担任用）
*/
	public List<Subject> selectSubject(String teacher_id) {
		// ログインユーザ情報を格納
		ArrayList<Subject> list = new ArrayList<Subject>();
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM subject s LEFT OUTER JOIN classification c ON s.classification_id = c.classification_id WHERE manager_id = ?;";

			stmt = con.prepareStatement(sql);// sql文をプリコンパイルした状態で保持
			// ユーザの入力値を代入
			stmt.setString(1, teacher_id);
			// sql文を実行
			rs = stmt.executeQuery();

			while (rs.next()) {
				Subject su = new Subject();
				// 1件分のデータをBeanに格納し、それをListに入れてjspに渡す
				// DBから取得したデータをScheduleオブジェクトに格納

				su.setSubject_id(rs.getString("subject_id"));
				su.setClassification_id(rs.getString("classification_id"));
				su.setSubject_name(rs.getString("subject_name"));
				su.setManeger_id(rs.getString("manager_id"));
				su.setClassification_name(rs.getString("classification_name"));
				list.add(su);
			}
		} catch (Exception e) {
			Subject su = new Subject();
			su = null;
			System.out.println("muri");
		} finally {
			try {
				close();
			} catch (Exception e) {
		}
	}
		return list;
}

/**
	* ゼミ教科をすべて検索（管理者用）
*/
	public List<Subject> selectAllSubject() {
		// ログインユーザ情報を格納
		ArrayList<Subject> list = new ArrayList<Subject>();
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM subject s LEFT OUTER JOIN classification c ON s.classification_id = c.classification_id;";

			stmt = con.prepareStatement(sql);// sql文をプリコンパイルした状態で保持
			// sql文を実行
			rs = stmt.executeQuery();

			while (rs.next()) {
				Subject su = new Subject();
				// 1件分のデータをBeanに格納し、それをListに入れてjspに渡す
				// DBから取得したデータをScheduleオブジェクトに格納

				su.setSubject_id(rs.getString("subject_id"));
				su.setSubject_name(rs.getString("subject_name"));
				su.setManeger_id(rs.getString("manager_id"));
				su.setClassification_name(rs.getString("classification_name"));
				list.add(su);
			}
		} catch (Exception e) {
			Subject su = new Subject();
			su = null;
			System.out.println("selectAllSubject : 失敗");
		} finally {
			try {
				close();
			} catch (Exception e) {
		}
	}
		return list;
}

	/**
	 * 科目idから科目名を取得
*/
	public String selectSubject_name(String subject_id) {
		String subject_name = "";
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT subject_name FROM subject WHERE subject_id = ?;";

			stmt = con.prepareStatement(sql);// sql文をプリコンパイルした状態で保持
			// ユーザの入力値を代入
			stmt.setString(1, subject_id);
			// sql文を実行
			rs = stmt.executeQuery();

			while (rs.next()) {
				subject_name = (rs.getString("subject_name"));
			}
		} catch (Exception e) {
			Subject su = new Subject();
			su = null;
			System.out.println("muri");
		} finally {
			try {
				close();
			} catch (Exception e) {
		}
	}
		return subject_name;
}

	/**
	 * Subjectテーブルの科目情報を削除
	 */
	public void deleteSubject(String subject_id) {

		try {
			// DB接続
			connection();

			String sql = "DELETE FROM subject WHERE subject_id = ? ;";

			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
			stmt.setString(1, subject_id);

			// sql文を実行
			int cnt = stmt.executeUpdate();

			// コミット
			con.commit();

		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
	}

<<<<<<< HEAD


}
=======
	public ArrayList<Classfication> setClassfication() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
>>>>>>> branch 'master' of https://github.com/aso1501164/hukunaga.git
