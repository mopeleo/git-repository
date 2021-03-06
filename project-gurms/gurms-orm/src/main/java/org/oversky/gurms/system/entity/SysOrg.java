package org.oversky.gurms.system.entity;

import org.oversky.base.entity.BaseEntity;

public class SysOrg extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Long orgid;    //机构ID,内部自动生成[identity]
	private String unioncode;    //
	private String shortname;    //机构简称
	private String fullname;    //机构全称
	private String linkman;    //联系人
	private String linktel;    //联系电话
	private String faxno;    //传真
	private String address;    //联系地址
	private String postcode;    //邮政编码
	private String email;    //电子邮件
	private Long parentorg;    //上级机构
	private String orgtype;    //机构类型(0-虚拟，可选，1-总，2-分，3-支)
	private String remark;    //备注

	public Long getOrgid() {
		return this.orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinktel() {
		return this.linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getFaxno() {
		return this.faxno;
	}

	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getParentorg() {
		return this.parentorg;
	}

	public void setParentorg(Long parentorg) {
		this.parentorg = parentorg;
	}

	public String getOrgtype() {
		return this.orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("SysOrg");
		return build.append("#orgid:").append(this.orgid).toString();
	}

    public static String buildEntityKey(Long orgid){
        StringBuilder build = new StringBuilder("SysOrg");
        return build.append("#orgid:").append(orgid).toString();
    }
    
    public void copyPrimaryKey(SysOrg entity){
		this.orgid = entity.getOrgid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("orgid=").append(orgid).append(", ");
		sb.append("unioncode=").append(unioncode).append(", ");
		sb.append("shortname=").append(shortname).append(", ");
		sb.append("fullname=").append(fullname).append(", ");
		sb.append("linkman=").append(linkman).append(", ");
		sb.append("linktel=").append(linktel).append(", ");
		sb.append("faxno=").append(faxno).append(", ");
		sb.append("address=").append(address).append(", ");
		sb.append("postcode=").append(postcode).append(", ");
		sb.append("email=").append(email).append(", ");
		sb.append("parentorg=").append(parentorg).append(", ");
		sb.append("orgtype=").append(orgtype).append(", ");
		sb.append("remark=").append(remark).append(", ");
        sb.append(super.toString());
        return sb.toString();
	}
}
