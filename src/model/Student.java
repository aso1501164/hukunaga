 /* date:2017/06/16
 * name:
 * comm:student（学生）テーブルのモデル
 */
package model;
import java.io.Serializable;
public class Student implements Serializable{
	private String student_id = "";
	private String student_name = "";
	private String password = "";
	private String class_name = "";

	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

}
