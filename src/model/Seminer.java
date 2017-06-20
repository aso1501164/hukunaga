package model;

import java.io.Serializable;

public class Seminer  implements Serializable{

	private String seminer_id = "";
	private String seminer_name = "";
	private String seminer_kind = "";
	private String teacher_id = "";
	private String year = "";
	private String record = "";

	public String getSeminer_id() {
		return seminer_id;
	}
	public void setSeminer_id(String seminer_id) {
		this.seminer_id = seminer_id;
	}
	public String getSeminer_name() {
		return seminer_name;
	}
	public void setSeminer_name(String seminer_name) {
		this.seminer_name = seminer_name;
	}
	public String getSeminer_kind() {
		return seminer_kind;
	}
	public void setSeminer_kind(String seminer_kind) {
		this.seminer_kind = seminer_kind;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}



}
