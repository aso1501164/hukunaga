package model;

public class Attendance {
	private String student_id;
	private String seminar_id;
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getSeminar_id() {
		return seminar_id;
	}
	public void setSeminar_id(String seminar_id) {
		this.seminar_id = seminar_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	private String teacher_id;
}
