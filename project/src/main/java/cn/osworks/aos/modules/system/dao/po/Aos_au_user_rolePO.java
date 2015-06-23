package cn.osworks.aos.modules.system.dao.po;

import cn.osworks.aos.base.typewrap.PO;

/**
 * <b>用户-角色关联表[aos_au_user_role]数据持久化对象</b>
 * <p>
 * 注意:此类代码自动生成-禁止手工修改。
 * </p>
 * 
 * @author OSWorks-XC
 * @date 2015-01-13 21:19:52
 */
public class Aos_au_user_rolePO extends PO {

	private static final long serialVersionUID = 1L;

	/**
	 * 流水号
	 */
	private String id_;
	
	/**
	 * 用户流水号
	 */
	private String user_id_;
	
	/**
	 * 角色流水号
	 */
	private String role_id_;
	
	/**
	 * 授权时间
	 */
	private String operate_time_;
	
	/**
	 * 授权人流水号
	 */
	private String operator_id_;
	

	/**
	 * 流水号
	 * 
	 * @return id_
	 */
	public String getId_() {
		return id_;
	}
	
	/**
	 * 用户流水号
	 * 
	 * @return user_id_
	 */
	public String getUser_id_() {
		return user_id_;
	}
	
	/**
	 * 角色流水号
	 * 
	 * @return role_id_
	 */
	public String getRole_id_() {
		return role_id_;
	}
	
	/**
	 * 授权时间
	 * 
	 * @return operate_time_
	 */
	public String getOperate_time_() {
		return operate_time_;
	}
	
	/**
	 * 授权人流水号
	 * 
	 * @return operator_id_
	 */
	public String getOperator_id_() {
		return operator_id_;
	}
	

	/**
	 * 流水号
	 * 
	 * @param id_
	 */
	public void setId_(String id_) {
		this.id_ = id_;
	}
	
	/**
	 * 用户流水号
	 * 
	 * @param user_id_
	 */
	public void setUser_id_(String user_id_) {
		this.user_id_ = user_id_;
	}
	
	/**
	 * 角色流水号
	 * 
	 * @param role_id_
	 */
	public void setRole_id_(String role_id_) {
		this.role_id_ = role_id_;
	}
	
	/**
	 * 授权时间
	 * 
	 * @param operate_time_
	 */
	public void setOperate_time_(String operate_time_) {
		this.operate_time_ = operate_time_;
	}
	
	/**
	 * 授权人流水号
	 * 
	 * @param operator_id_
	 */
	public void setOperator_id_(String operator_id_) {
		this.operator_id_ = operator_id_;
	}
	

}