package org.oversky.dreamland.entity.server;

import org.oversky.base.entity.BaseEntity;

public class ServerPlayerActorFavor extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String serverid;    //
	private Long custno;    //
	private String maleid;    //男性角色ID
	private String femaleid;    //女性角色ID
	private Integer degree;    //好感度

	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public Long getCustno() {
		return this.custno;
	}

	public void setCustno(Long custno) {
		this.custno = custno;
	}

	public String getMaleid() {
		return this.maleid;
	}

	public void setMaleid(String maleid) {
		this.maleid = maleid;
	}

	public String getFemaleid() {
		return this.femaleid;
	}

	public void setFemaleid(String femaleid) {
		this.femaleid = femaleid;
	}

	public Integer getDegree() {
		return this.degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public String buildEntityKey(){
		StringBuilder build = new StringBuilder("ServerPlayerActorFavor");
		return build.append("#serverid:").append(this.serverid).append("#maleid:").append(this.maleid).append("#femaleid:").append(this.femaleid).toString();
	}

    public static String buildEntityKey(String serverid, String maleid, String femaleid){
        StringBuilder build = new StringBuilder("ServerPlayerActorFavor");
        return build.append("#serverid:").append(serverid).append("#maleid:").append(maleid).append("#femaleid:").append(femaleid).toString();
    }
    
    public void copyPrimaryKey(ServerPlayerActorFavor entity){
		this.serverid = entity.getServerid();
		this.maleid = entity.getMaleid();
		this.femaleid = entity.getFemaleid();
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", serverid=").append(serverid);
		sb.append(", custno=").append(custno);
		sb.append(", maleid=").append(maleid);
		sb.append(", femaleid=").append(femaleid);
		sb.append(", degree=").append(degree);
        sb.append("]");
        return sb.toString();
	}
}
