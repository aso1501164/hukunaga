 /* date:2017/06/16
 * name:
 * comm:history（受講履歴）テーブルのモデル
 */
package model;

import java.io.Serializable;
public class History  implements Serializable{
	private String student_id = "";
	private String subject_id_1 = "";
	private String subject_id_2 = "";
	private String subject_name_1;
	private String subject_name_2;
	public String getSubject_name_1() {
		return subject_name_1;
	}
	public void setSubject_name_1(String subject_name_1) {
		this.subject_name_1 = subject_name_1;
	}
	public String getSubject_name_2() {
		return subject_name_2;
	}
	public void setSubject_name_2(String subject_name_2) {
		this.subject_name_2 = subject_name_2;
	}
	private String year = "";
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getSubject_id_1() {
		return subject_id_1;
	}
	public void setSubject_id_1(String subject_id_1) {
		this.subject_id_1 = subject_id_1;
	}
	public String getSubject_id_2() {
		return subject_id_2;
	}
	public void setSubject_id_2(String subject_id_2) {
		this.subject_id_2 = subject_id_2;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}
