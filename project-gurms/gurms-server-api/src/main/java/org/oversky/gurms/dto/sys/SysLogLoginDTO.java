package org.oversky.gurms.dto.sys;

import org.oversky.base.service.BaseDto;

public class SysLogLoginDto extends BaseDto {

	private String logid;    //logid
	private Long userid;    //userid
	private String logindate;    //登录日期
	private String logintime;    //登录时间
	private String loginpasswd;    //登录密码
	private String loginip;    //登录IP
	private Integer logintype;    //登录方式（1-pc，2-手机）
	private Integer loginresult;    //登录是否成功 0-失败，1-成功

	public String getLogid() {
		return this.logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getLogindate() {
		return this.logindate;
	}

	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}

	public String getLogintime() {
		return this.logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getLoginpasswd() {
		return this.loginpasswd;
	}

	public void setLoginpasswd(String loginpasswd) {
		this.loginpasswd = loginpasswd;
	}

	public String getLoginip() {
		return this.loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public Integer getLogintype() {
		return this.logintype;
	}

	public void setLogintype(Integer logintype) {
		this.logintype = logintype;
	}

	public Integer getLoginresult() {
		return this.loginresult;
	}

	public void setLoginresult(Integer loginresult) {
		this.loginresult = loginresult;
	}


	public void clear(){
		this.logid = null;
		this.userid = null;
		this.logindate = null;
		this.logintime = null;
		this.loginpasswd = null;
		this.loginip = null;
		this.logintype = null;
		this.loginresult = null;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", logid=").append(logid);
		sb.append(", userid=").append(userid);
		sb.append(", logindate=").append(logindate);
		sb.append(", logintime=").append(logintime);
		sb.append(", loginpasswd=").append(loginpasswd);
		sb.append(", loginip=").append(loginip);
		sb.append(", logintype=").append(logintype);
		sb.append(", loginresult=").append(loginresult);
        sb.append("]");
        return sb.toString();
	}
}