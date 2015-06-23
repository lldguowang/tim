package cn.osworks.aos.modules.system.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.osworks.aos.base.typewrap.Dto;
import cn.osworks.aos.core.annotation.Mapper;
import cn.osworks.aos.modules.system.dao.po.Aos_ge_sequencePO;


/**
 * <b>ID配置表[aos_ge_sequence]数据访问接口</b>
 * 
 * <p>
 * 注意:此类代码自动生成-禁止手工修改
 * </p>
 * 
 * @author OSWorks-XC
 * @date 2015-01-07 20:08:53
 */
@Mapper
public interface Aos_ge_sequenceMapper {

	/**
	 * 插入一个数据持久化对象(插入字段为传入PO实体的非空属性)
	 * <p> 防止DB字段缺省值需要程序中再次赋值
	 *
	 * @param aos_ge_sequencePO
	 *            要插入的数据持久化对象
	 * @return 返回影响行数
	 */
	int insert(Aos_ge_sequencePO aos_ge_sequencePO);
	
	/**
	 * 插入一个数据持久化对象(含所有字段)
	 * 
	 * @param aos_ge_sequencePO
	 *            要插入的数据持久化对象
	 * @return 返回影响行数
	 */
	int insertAll(Aos_ge_sequencePO aos_ge_sequencePO);

	/**
	 * 根据主键修改数据持久化对象
	 * 
	 * @param aos_ge_sequencePO
	 *            要修改的数据持久化对象
	 * @return int 返回影响行数
	 */
	int updateByKey(Aos_ge_sequencePO aos_ge_sequencePO);

	/**
	 * 根据主键查询并返回数据持久化对象
	 * 
	 * @return Aos_ge_sequencePO
	 */
	Aos_ge_sequencePO selectByKey(@Param(value = "id_") String id_);

	/**
	 * 根据唯一组合条件查询并返回数据持久化对象
	 * 
	 * @return Aos_ge_sequencePO
	 */
	Aos_ge_sequencePO selectOne(Dto pDto);

	/**
	 * 根据Dto查询并返回数据持久化对象集合
	 * 
	 * @return List<Aos_ge_sequencePO>
	 */
	List<Aos_ge_sequencePO> list(Dto pDto);

	/**
	 * 根据Dto查询并返回分页数据持久化对象集合
	 * 
	 * @return List<Aos_ge_sequencePO>
	 */
	List<Aos_ge_sequencePO> listPage(Dto pDto);
		
	/**
	 * 根据Dto模糊查询并返回数据持久化对象集合(字符型字段模糊匹配，其余字段精确匹配)
	 * 
	 * @return List<Aos_ge_sequencePO>
	 */
	List<Aos_ge_sequencePO> like(Dto pDto);

	/**
	 * 根据Dto模糊查询并返回分页数据持久化对象集合(字符型字段模糊匹配，其余字段精确匹配)
	 * 
	 * @return List<Aos_ge_sequencePO>
	 */
	List<Aos_ge_sequencePO> likePage(Dto pDto);

	/**
	 * 根据主键删除数据持久化对象
	 *
	 * @return 影响行数
	 */
	int deleteByKey(@Param(value = "id_") String id_);
	
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