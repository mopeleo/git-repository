package org.oversky.dreamland.constant;

import org.oversky.common.spring.SpringBeanUtils;
import org.oversky.dreamland.dao.com.ComParamDao;

public final class ParamConsts {
	
	private static ComParamDao comParamDao = SpringBeanUtils.getBean(ComParamDao.class);

	public final static Integer PARAM1001_SYS_ROOTUSER = 1001;			//超级用户
	public final static Integer PARAM1002_PASSWD_INIT = 1002;			//初始化密码
	public final static Integer PARAM1003_PASSWD_ERROR_TIMES = 1003;	//密码错误次数
	public final static Integer PARAM1004_PASSWD_INVAILD_DAYS = 1004;	//密码失效天数
	

	public static String getParam(String unioncode, Integer paramid) {		
		return comParamDao.getById(unioncode, paramid).getParamvalue();
	}	
	
}
