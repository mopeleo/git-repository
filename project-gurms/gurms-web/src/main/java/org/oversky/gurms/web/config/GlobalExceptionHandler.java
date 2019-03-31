package org.oversky.gurms.web.config;

import org.oversky.base.constant.PubDefine;
import org.oversky.base.service.BaseResDto;
import org.oversky.base.service.BaseServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = WebException.class)
	public Object webExceptionHandler(WebException e) {
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg(e.getMessage());
		restfulResult.setSuccess(false);
		return ResponseEntity.status(e.getHttpStatus()).body(restfulResult);
	}

	@ExceptionHandler(value = BaseServiceException.class)
	public Object busiExceptionHandler(BaseServiceException e) {
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg(e.getMessage());
		restfulResult.setSuccess(false);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restfulResult);
	}

	@ExceptionHandler(value = Exception.class)
	public Object defaultExceptionHandler(Exception e) {
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg(e.getMessage());
		restfulResult.setSuccess(false);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restfulResult);
	}

}
