package org.oversky.gurms.system.dto.response;

import org.oversky.base.service.BaseResDto;

public class SysDictValueRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private String unioncode;    //
	private Integer dictcode;    //字典代码
	private String itemcode;    //选项代码
	private String itemname;    //选项名称

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

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", unioncode=").append(unioncode);
		sb.append(", dictcode=").append(dictcode);
		sb.append(", itemcode=").append(itemcode);
		sb.append(", itemname=").append(itemname);
        sb.append("]");
        return sb.toString();
	}
}
