package org.oversky.gurms.system.service;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseResMapDto;
import org.oversky.gurms.system.dto.response.SysDictValueRes;

public interface SysDictService {

	BaseResListDto<SysDictValueRes> getDict(String unioncode, Integer dictcode);
	
	BaseResMapDto<String, List<SysDictValueRes>> getDict(String unioncode, String dictcodeList);
}