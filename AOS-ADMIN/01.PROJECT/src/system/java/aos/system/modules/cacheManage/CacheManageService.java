package aos.system.modules.cacheManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import aos.framework.core.exception.AOSException;
import aos.framework.core.redis.JedisUtil;
import aos.framework.core.typewrap.Dto;
import aos.framework.core.typewrap.Dtos;
import aos.framework.core.utils.AOSCfgHandler;
import aos.framework.core.utils.AOSCons;
import aos.framework.core.utils.AOSCxt;
import aos.framework.core.utils.AOSJson;
import aos.framework.core.utils.AOSUtils;
import aos.framework.web.router.HttpModel;
import aos.system.common.service.AOSBaseService;
import redis.clients.jedis.Jedis;

/**
 * <b>Redis缓存管理</b>
 * 
 * @author xiongchun
 */
@Service
public class CacheManageService extends AOSBaseService{

	/**
	 * 页面初始化
	 * 
	 * @param httpModel
	 * @return
	 */
	public void init(HttpModel httpModel) {
		Dto inDto = httpModel.getInDto();
		httpModel.setAttribute("app_key", AOSCfgHandler.getValue("app_key"));
		httpModel.setAttribute("juid", inDto.getString("juid"));
		httpModel.setViewPath("system/redis.jsp");
	}
	
	/**
	 * 代码编辑器页面初始化
	 * 
	 * @param httpModel
	 * @return
	 */
	public void initCodeEditor(HttpModel httpModel) {
		
		httpModel.setViewPath("system/redis.codeEditor.jsp");
	}
	
	/**
	 * 查询缓存DB中的Key
	 * 
	 * @param httpModel
	 * @return
	 */
	public void listKeys(HttpModel httpModel) {
		Dto inDto = httpModel.getInDto();
		Jedis jedis = JedisUtil.getJedisClient();
		Set<String> keySet = jedis.keys("*" + inDto.getString("key_") + "*");
		List<String>  keyList = new ArrayList<String>(keySet);
		List<Dto> list = Lists.newArrayList();
		for (String key_ : keyList) {
			Dto dto = Dtos.newDto();
			dto.put("key_", key_);
			dto.put("type_", jedis.type(key_));
			long ttl_ = jedis.ttl(key_);
			dto.put("ttl_", ttl_ == -1 ? "永久有效" : ttl_ + "秒");
			list.add(dto);
		}
		JedisUtil.close(jedis);
		int start = Integer.valueOf(inDto.getString("start"));
		int end = start + Integer.valueOf(inDto.getString("limit"));
		end = end > list.size() ? list.size() : end;
		List<Dto> outList = list.subList(start, end);
		
		httpModel.setOutMsg(AOSJson.toGridJson(outList, list.size()));
	}
	
	/**
	 * 显示详情
	 * 
	 * @param httpModel
	 * @return
	 */
	public void listValues(HttpModel httpModel) {
		List<Dto> outList = Lists.newArrayList();
		Dto inDto = httpModel.getInDto();
		Jedis jedis = JedisUtil.getJedisClient();
		String key = inDto.getString("key_");
		String type = inDto.getString("type_");
		int total = 0;
		if (StringUtils.equalsIgnoreCase(type, "string")) {
			Dto dto = Dtos.newDto();
			dto.put("field_", "-");
			dto.put("value_", jedis.get(key));
			outList.add(dto);
			total = outList.size();
		}else if (StringUtils.equalsIgnoreCase(type, "hash")) {
		    Set<String> fieldSet = jedis.hkeys(key);
		    List<String> fiedList = new ArrayList<>(fieldSet);
			int start = Integer.valueOf(inDto.getString("start"));
			int end = start + Integer.valueOf(inDto.getString("limit"));
			total = fiedList.size();
			end = end > fiedList.size() ? fiedList.size() : end;
			fiedList = fiedList.subList(start, end);
		    for (String field : fiedList) {
		    	Dto dto = Dtos.newDto();
				dto.put("field_", field);
				dto.put("value_", jedis.hget(key, field));
				outList.add(dto);
			}
		}else if (StringUtils.equalsIgnoreCase(type, "list")) {
			int start = inDto.getPageStart();
			int limit = inDto.getPageLimit();
			List<String> valueList = jedis.lrange(key, start, start + limit);
			for (String value : valueList) {
				Dto dto = Dtos.newDto();
				dto.put("field_", "-");
				dto.put("value_", value);
				outList.add(dto);
			}
			total = jedis.llen(key).intValue();
		}
		
		JedisUtil.close(jedis);
		httpModel.setOutMsg(AOSJson.toGridJson(outList, total));
	}
	
	/**
	 * 清空缓存
	 * 
	 * @param httpModel
	 * @return
	 */
	public void flushAll(HttpModel httpModel) {
		if (StringUtils.equals(AOSCons.RUN_MODE.DEMO, AOSCxt.getParam("run_mode_"))) {
			throw new AOSException(13);
		}
		Jedis jedis = JedisUtil.getJedisClient();
		jedis.flushAll();
		JedisUtil.close(jedis);
		httpModel.setOutMsg("缓存数据库被清空，你必须重启应用服务器完成基础数据缓存重建。");
	}
	
	/**
	 * 获取缓存服务器信息
	 * 
	 * @param httpModel
	 * @return
	 */
	public void info(HttpModel httpModel) {
		Jedis jedis = JedisUtil.getJedisClient();
		String info = jedis.info();
		JedisUtil.close(jedis);
		httpModel.setOutMsg(info);
	}
	
	/**
	 * 删除单个缓存键
	 * 
	 * @param httpModel
	 * @return
	 */
	public void delByKey(HttpModel httpModel) {
		if (StringUtils.equals(AOSCons.RUN_MODE.DEMO, AOSCxt.getParam("run_mode_"))) {
			throw new AOSException(13);
		}
		Dto inDto = httpModel.getInDto();
		String key = inDto.getString("key_");
		JedisUtil.delString(key);
		httpModel.setOutMsg(AOSUtils.merge("键[{0}]已成功删除。", key));
	}
	
}