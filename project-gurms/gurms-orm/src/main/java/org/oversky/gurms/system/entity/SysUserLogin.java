package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysUserLogin extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long logid;    //[identity]
	private String unioncode;    //
	private Long userid;    //
	private String logindate;    //登录日期
	private String logintime;    //登录时间
	private String loginpasswd;    //登录密码
	private String loginip;    //登录IP
	private String logintype;    //登录方式（0-pc，1-手机）
	private String loginresult;    //登录是否成功 0-失败，1-成功
	private String summary;    //说明

	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
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

	public String getLogintype() {
		return this.logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	public String getLoginresult() {
		return this.loginresult;
	}

	public void setLoginresult(String loginresult) {
		this.loginresult = loginresult;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysUserLogin");
		return build.append("#logid:").append(this.logid).toString();
	}

    public static String buildEntityKey(Long logid){
        StringBuilder build = new StringBuilder("SysUserLogin");
        return build.append("#logid:").append(logid).toString();
    }
    
    public void copyPrimaryKey(SysUserLogin entity){
		this.logid = entity.getLogid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("logid=").append(logid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("userid=").append(userid).append(", ");
		sb.append("logindate=").append(logindate).append(", ");
		sb.append("logintime=").append(logintime).append(", ");
		sb.append("loginpasswd=").append(loginpasswd).append(", ");
		sb.append("loginip=").append(loginip).append(", ");
		sb.append("logintype=").append(logintype).append(", ");
		sb.append("loginresult=").append(loginresult).append(", ");
		sb.append("summary=").append(summary).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
