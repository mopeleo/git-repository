package org.oversky.gurms.system.dto.request;

import org.oversky.base.service.BaseReqDto;

public class SysDictReq extends BaseReqDto {

	private static final long serialVersionUID = 1L;

	private String unioncode;    //
	private Integer dictcode;    //字典代码
	private String dictname;    //字典名称
	private String dictgroup;    //所属分组
	private String editflag;    //是否可编辑（0-不可见，1-只读，2-读写）

	public String getUnioncode() {
		return this.unioncode;
	}

	public void setUnioncode(String unioncode) {
		this.unioncode = unioncode;
	}

	public Integer getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(Integer dictcode) {
		this.dictcode = dictcode;
	}

	public String getDictname() {
		return this.dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public String getDictgroup() {
		return this.dictgroup;
	}

	public void setDictgroup(String dictgroup) {
		this.dictgroup = dictgroup;
	}

	public String getEditflag() {
		return this.editflag;
	}

	public void setEditflag(String editflag) {
		this.editflag = editflag;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", unioncode=").append(unioncode);
		sb.append(", dictcode=").append(dictcode);
		sb.append(", dictname=").append(dictname);
		sb.append(", dictgroup=").append(dictgroup);
		sb.append(", editflag=").append(editflag);
        sb.append("]");
        return sb.toString();
	}
}
