 /* date:2017/06/16
 * name:
 * comm:maneger（管理者）テーブルのモデル
 */
package model;
import java.io.Serializable;
public class Manager implements Serializable{
	private String manager_id = "";
	private String manager_name = "";
	private String password = "";
	private String permission = "";
	private String class_name = "";

	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}

}
