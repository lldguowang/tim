package cn.osworks.aos.modules.bpm.service.admin;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.osworks.aos.base.asset.AOSUtils;
import cn.osworks.aos.base.typewrap.Dto;
import cn.osworks.aos.core.dao.SqlDao;
import cn.osworks.aos.web.misc.DicCons;

/**
 * 任务服务
 * 
 * @author OSWorks-XC
 * @date 2014-12-16
 */
@Service
public class ProcTaskService {
	
	@Autowired
	private RuntimeService runtimeServic;
	@Autowired
	private SqlDao sqlDao;
	
	/**
	 * 查询流程任务列表
	 * 
	 * @param inDto
	 * @return
	 */
	public List<Dto>listProcTasks(Dto inDto){
		List<Dto> list = sqlDao.list("Bpm.listProcTasksPage", inDto);
		for (Dto dto : list) {
			if (AOSUtils.isEmpty(dto.getString("assignee_"))) {
				dto.put("proctask_status_", DicCons.PROCTASK_STATUS_DQS);
			}else {
				dto.put("proctask_status_", DicCons.PROCTASK_STATUS_DB);
			}
		}
		return list;
	}

}