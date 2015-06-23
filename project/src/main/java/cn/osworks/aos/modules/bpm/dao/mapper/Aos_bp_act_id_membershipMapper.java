package cn.osworks.aos.modules.bpm.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.osworks.aos.base.typewrap.Dto;
import cn.osworks.aos.core.annotation.Mapper;
import cn.osworks.aos.modules.bpm.dao.po.Aos_bp_act_id_membershipPO;


/**
 * <b>[aos_bp_act_id_membership]数据访问接口</b>
 * 
 * <p>
 * 注意:此类代码自动生成-禁止手工修改
 * </p>
 * 
 * @author OSWorks-XC
 * @date 2015-01-07 23:01:59
 */
@Mapper
public interface Aos_bp_act_id_membershipMapper {

	/**
	 * 插入一个数据持久化对象(插入字段为传入PO实体的非空属性)
	 * <p> 防止DB字段缺省值需要程序中再次赋值
	 *
	 * @param aos_bp_act_id_membershipPO
	 *            要插入的数据持久化对象
	 * @return 返回影响行数
	 */
	int insert(Aos_bp_act_id_membershipPO aos_bp_act_id_membershipPO);
	
	/**
	 * 插入一个数据持久化对象(含所有字段)
	 * 
	 * @param aos_bp_act_id_membershipPO
	 *            要插入的数据持久化对象
	 * @return 返回影响行数
	 */
	int insertAll(Aos_bp_act_id_membershipPO aos_bp_act_id_membershipPO);

	/**
	 * 根据主键修改数据持久化对象
	 * 
	 * @param aos_bp_act_id_membershipPO
	 *            要修改的数据持久化对象
	 * @return int 返回影响行数
	 */
	int updateByKey(Aos_bp_act_id_membershipPO aos_bp_act_id_membershipPO);

	/**
	 * 根据主键查询并返回数据持久化对象
	 * 
	 * @return Aos_bp_act_id_membershipPO
	 */
	Aos_bp_act_id_membershipPO selectByKey(@Param(value = "user_id_") String user_id_,@Param(value = "group_id_") String group_id_);

	/**
	 * 根据唯一组合条件查询并返回数据持久化对象
	 * 
	 * @return Aos_bp_act_id_membershipPO
	 */
	Aos_bp_act_id_membershipPO selectOne(Dto pDto);

	/**
	 * 根据Dto查询并返回数据持久化对象集合
	 * 
	 * @return List<Aos_bp_act_id_membershipPO>
	 */
	List<Aos_bp_act_id_membershipPO> list(Dto pDto);

	/**
	 * 根据Dto查询并返回分页数据持久化对象集合
	 * 
	 * @return List<Aos_bp_act_id_membershipPO>
	 */
	List<Aos_bp_act_id_membershipPO> listPage(Dto pDto);
		
	/**
	 * 根据Dto模糊查询并返回数据持久化对象集合(字符型字段模糊匹配，其余字段精确匹配)
	 * 
	 * @return List<Aos_bp_act_id_membershipPO>
	 */
	List<Aos_bp_act_id_membershipPO> like(Dto pDto);

	/**
	 * 根据Dto模糊查询并返回分页数据持久化对象集合(字符型字段模糊匹配，其余字段精确匹配)
	 * 
	 * @return List<Aos_bp_act_id_membershipPO>
	 */
	List<Aos_bp_act_id_membershipPO> likePage(Dto pDto);

	/**
	 * 根据主键删除数据持久化对象
	 *
	 * @return 影响行数
	 */
	int deleteByKey(@Param(value = "user_id_") String user_id_,@Param(value = "group_id_") String group_id_);
	
	/**
	 * 根据Dto统计行数
	 * 
	 * @param pDto
	 * @return
	 */
	int rows(Dto pDto);
	
	/**
	 * 根据数学表达式进行数学运算
	 * 
	 * @param pDto
	 * @return String
	 */
	String calc(Dto pDto);
	
}
