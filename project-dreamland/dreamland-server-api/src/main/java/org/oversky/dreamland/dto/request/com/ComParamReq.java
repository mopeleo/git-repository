package org.oversky.dreamland.dto.request.com;

import org.oversky.base.service.BaseReqDto;

public class ComParamReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String unioncode;    //
	private Integer paramid;    //
	private String paramvalue;    //

	private String paramlist;
	
	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Integer getParamid() {
		return this.paramid;
	}

	public void setParamid(Integer paramid) {
		this.paramid = paramid;
	}

	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

    public String getParamlist() {
		return paramlist;
	}

	public void setParamlist(String paramlist) {
		this.paramlist = paramlist;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("paramid=").append(paramid).append(", ");
		sb.append("paramvalue=").append(paramvalue).append(", ");
		sb.append("paramlist=").append(paramlist).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
