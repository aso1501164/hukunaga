/*
 * date:2017/06/06
 * name:福永利恵
 * comm:seminar(ゼミ教科)テーブルのDAO
 *
 * 適宜変更追加よろしく
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

import model.Seminar;

public class SeminarDAO {
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
		 * その先生が担当の教科をすべて検索
	*/
		public List<Seminar> selectSubject(String teacher_id) {
			// ログインユーザ情報を格納
			ArrayList<Seminar> list = new ArrayList<Seminar>();
			try {
				// DB接続
				connection();
				// SQL文設定の準備・SQL文の実行
				String sql = "SELECT * FROM seminar WHERE teacher_id = ?;";

				stmt = con.prepareStatement(sql);// sql文をプリコンパイルした状態で保持
				// ユーザの入力値を代入
				stmt.setString(1, teacher_id);
				// sql文を実行
				rs = stmt.executeQuery();

				while (rs.next()) {
					Seminar se = new Seminar();
					// 1件分のデータをBeanに格納し、それをListに入れてjspに渡す
					// DBから取得したデータをScheduleオブジェクトに格納

					se.setSeminar_id(rs.getString("seminar_id"));
					se.setSeminar_name(rs.getString("seminar_name"));
					se.setSeminar_kind(rs.getString("seminar_kind"));
					se.setTeacher_id(rs.getString("teacher_id"));
					list.add(se);
				}
			} catch (Exception e) {
				Seminar se = new Seminar();
				se = null;
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
		 * Seminarテーブルの科目情報を削除
		 */
		public void deleteSeminar(String seminar_id) {

			try {
				// DB接続
				connection();

				String sql = "DELETE FROM seminar WHERE seminar_id = ? ;";

				stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
				stmt.setString(1, seminar_id);

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

}
