package com.sh.monitor.mapper;
import java.util.List;

import com.sh.monitor.common.util.Assist;
import com.sh.monitor.entity.SysMonitorConfig;

import org.apache.ibatis.annotations.Param;
/**
 * SysMonitorConfig的Dao接口
 * 
 * @author 
 *
 */
public interface SysMonitorConfigDao {

	/**
	 * 获得SysMonitorConfig数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getSysMonitorConfigRowCount(Assist assist);
	
	/**
	 * 获得SysMonitorConfig数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<SysMonitorConfig> selectSysMonitorConfig(Assist assist);
	/**
	 * 通过SysMonitorConfig的id获得SysMonitorConfig对象
	 * 
	 * @param id
	 * @return
	 */
	SysMonitorConfig selectSysMonitorConfigById(String id);
	
	/**
	 * 获得一个SysMonitorConfig对象,以参数SysMonitorConfig对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	SysMonitorConfig selectSysMonitorConfigObjSingle(SysMonitorConfig obj);
	
	/**
	 * 获得一个SysMonitorConfig对象,以参数SysMonitorConfig对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<SysMonitorConfig> selectSysMonitorConfigByObj(SysMonitorConfig obj);

	/**
	 * 插入SysMonitorConfig到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertSysMonitorConfig(SysMonitorConfig value);
	
	/**
	 * 插入SysMonitorConfig中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullSysMonitorConfig(SysMonitorConfig value);
	
	/**
	 * 批量插入SysMonitorConfig到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertSysMonitorConfigByBatch(List<SysMonitorConfig> value);
	/**
	 * 通过SysMonitorConfig的id删除SysMonitorConfig
	 * 
	 * @param id
	 * @return
	 */
	int deleteSysMonitorConfigById(String id);
	
	/**
	 * 通过辅助工具Assist的条件删除SysMonitorConfig
	 * 
	 * @param assist
	 * @return
	 */
	int deleteSysMonitorConfigByAssist(Assist assist);
	
	/**
	 * 通过SysMonitorConfig的id更新SysMonitorConfig中的数据,包括null值
	 * 
	 * @param enti
	 * @return
	 */
	int updateSysMonitorConfigById(SysMonitorConfig enti);
	
	/**
	 * 通过SysMonitorConfig的id更新SysMonitorConfig中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	int updateNotNullSysMonitorConfigById(SysMonitorConfig enti);
	
	/**
	 * 通过辅助工具Assist的条件更新SysMonitorConfig中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateSysMonitorConfig(@Param("enti") SysMonitorConfig value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新SysMonitorConfig中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullSysMonitorConfig(@Param("enti") SysMonitorConfig value, @Param("assist") Assist assist);
}