/*
 * date:2017/06/06
 * name:福永利恵
 * comm:studentテーブルのDAO
 *
 *
 * とりあえず基本的なsqlをコメントアウトして入れてます適宜変更追加よろしく
 *
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Student;

public class StudentDAO {
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
	 * userテーブルからログインするユーザを探す
	 */

	public Student selectLoginStudent(String userID, String password) {
		// ログインユーザ情報を格納
		Student st = new Student();
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM student WHERE student_id = ? AND password = ?;";

			stmt = con.prepareStatement(sql);// sql文をプリコンパイルした状態で保持
			// ユーザの入力値を代入
			stmt.setString(1, userID);
			stmt.setString(2, password);

			// sql文を実行
			rs = stmt.executeQuery();

			// 1件目のデータにカーソルをあわせる
			// データない場合はcatchに飛ぶ
			rs.next();

			// DBから取得したデータをstudentオブジェクトに格納
			st.setStudent_id(rs.getString("student_id"));
			st.setPassword(rs.getString("password"));
		} catch (Exception e) {
			st = null;
			System.out.println("muri");
		} finally {
			try {
				close();
			} catch (Exception e) {
		}
	}
		return st;
}
}

