package aos.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import aos.framework.core.annotation.Dao;
import aos.framework.core.typewrap.Dto;
import aos.system.dao.Aos_iconPO;

/**
 * <b>aos_icon[aos_icon]数据访问接口</b>
 * 
 * <p>
 * 注意:此文件由AOS平台自动生成-禁止手工修改
 * </p>
 * 
 * @author xiongchun
 * @date 2016-10-10 23:40:43
 */
@Dao
public interface Aos_iconDao {

	/**
	 * 插入一个数据持久化对象(插入字段为传入PO实体的非空属性)
	 * <p> 防止DB字段缺省值需要程序中再次赋值
	 *
	 * @param aos_iconPO
	 *            要插入的数据持久化对象
	 * @return 返回影响行数
	 */
	int insert(Aos_iconPO aos_iconPO);
	
	/**
	 * 插入一个数据持久化对象(含所有字段)
	 * 
	 * @param aos_iconPO
	 *            要插入的数据持久化对象
	 * @return 返回影响行数
	 */
	int insertAll(Aos_iconPO aos_iconPO);

	/**
	 * 根据主键修改数据持久化对象
	 * 
	 * @param aos_iconPO
	 *            要修改的数据持久化对象
	 * @return int 返回影响行数
	 */
	int updateByKey(Aos_iconPO aos_iconPO);

	/**
	 * 根据主键查询并返回数据持久化对象
	 * 
	 * @return Aos_iconPO
	 */
	Aos_iconPO selectByKey(@Param(value = "id_") String id_);

	/**
	 * 根据唯一组合条件查询并返回数据持久化对象
	 * 
	 * @return Aos_iconPO
	 */
	Aos_iconPO selectOne(Dto pDto);

	/**
	 * 根据Dto查询并返回数据持久化对象集合
	 * 
	 * @return List<Aos_iconPO>
	 */
	List<Aos_iconPO> list(Dto pDto);

	/**
	 * 根据Dto查询并返回分页数据持久化对象集合
	 * 
	 * @return List<Aos_iconPO>
	 */
	List<Aos_iconPO> listPage(Dto pDto);
		
	/**
	 * 根据Dto模糊查询并返回数据持久化对象集合(字符型字段模糊匹配，其余字段精确匹配)
	 * 
	 * @return List<Aos_iconPO>
	 */
	List<Aos_iconPO> like(Dto pDto);

	/**
	 * 根据Dto模糊查询并返回分页数据持久化对象集合(字符型字段模糊匹配，其余字段精确匹配)
	 * 
	 * @return List<Aos_iconPO>
	 */
	List<Aos_iconPO> likePage(Dto pDto);

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