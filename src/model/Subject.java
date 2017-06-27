 /* date:2017/06/16
 * name:
 * comm:subject（科目）テーブルのモデル
 */
package model;
import java.io.Serializable;
public class Subject implements Serializable{
	private String subject_id = "";
	private String classification_id = "";
	private String subject_name = "";
	private String maneger_id = "";
	private String classification_name = "";


	public String getClassification_name() {
		return classification_name;
	}
	public void setClassification_name(String classification_name) {
		this.classification_name = classification_name;
	}
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public String getClassification_id() {
		return classification_id;
	}
	public void setClassification_id(String classification_id) {
		this.classification_id = classification_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getManeger_id() {
		return maneger_id;
	}
	public void setManeger_id(String maneger_id) {
		this.maneger_id = maneger_id;
	}

}
