 /* date:2017/06/16
 * name:
 * comm:classfication（分類）テーブルのモデル
 */


package model;

import java.io.Serializable;

public class Classfication  implements Serializable {
	private String classfication_id = "";
	private String classfication_name = "";

	public String getClassfication_id() {
		return classfication_id;
	}
	public void setClassfication_id(String classfication_id) {
		this.classfication_id = classfication_id;
	}
	public String getClassfication_name() {
		return classfication_name;
	}
	public void setClassfication_name(String classfication_name) {
		this.classfication_name = classfication_name;
	}

}
