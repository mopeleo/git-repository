package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysParam extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String unioncode;    //unioncode
	private Integer paramid;    //paramid
	private String paramvalue;    //paramvalue

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

	public String getEntityKey(){
		StringBuilder build = new StringBuilder("SysParam");
		return build.append("#").append(this.unioncode).append("#").append(this.paramid).toString();
	}

    public static String buildEntityKey(String unioncode, Integer paramid){
        StringBuilder build = new StringBuilder("SysParam");
        return build.append("#").append(unioncode).append("#").append(paramid).toString();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", unioncode=").append(unioncode);
		sb.append(", paramid=").append(paramid);
		sb.append(", paramvalue=").append(paramvalue);
        sb.append("]");
        return sb.toString();
	}
}
