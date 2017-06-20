 /* date:2017/06/16
 * name:
 * comm:application（申請）テーブルのモデル
 */

package model;

import java.io.Serializable;

public class Application   implements Serializable{
	private String student_id = "";
	private String subject_id_1 = "";
	private String subject_id_2 = "";
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
