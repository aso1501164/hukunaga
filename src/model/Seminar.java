package model;

public class Seminar {
	private String seminar_id;
	private String seminar_name;
	private String seminar_kind;
	public String getSeminar_id() {
		return seminar_id;
	}
	public void setSeminar_id(String seminar_id) {
		this.seminar_id = seminar_id;
	}
	public String getSeminar_name() {
		return seminar_name;
	}
	public void setSeminar_name(String seminar_name) {
		this.seminar_name = seminar_name;
	}
	public String getSeminar_kind() {
		return seminar_kind;
	}
	public void setSeminar_kind(String seminar_kind) {
		this.seminar_kind = seminar_kind;
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
	private String teacher_id;
	private String year;
	private String record;

}
