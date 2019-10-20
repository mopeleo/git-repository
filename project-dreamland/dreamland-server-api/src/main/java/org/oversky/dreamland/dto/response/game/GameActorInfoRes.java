package org.oversky.dreamland.dto.response.game;

import org.oversky.base.service.BaseResDto;

public class GameActorInfoRes extends BaseResDto {

	private static final long serialVersionUID = 1L;

	private String actorid;    //角色ID
	private String actorname;    //角色名称
	private Integer sex;    //性别
	private String race;    //种族1-人类，2-兽人，3-精灵，4-影，5-机械，6-恶魔
	private String profession;    //职业1-战士，2-剑客，3-猎人，4-盗贼，5-刺客，6-牧师，7-魔导士，8-召唤师，9-
	private Integer actorscene;    //角色存在场景(1- 第一场景，2-第二场景)
	private Integer str;    //初始力量
	private Integer intelligence;    //初始智力
	private Integer hp;    //初始生命值
	private Integer mp;    //初始魔法值
	private Integer agl;    //初始敏捷
	private Integer luck;    //初始幸运
	private Integer initrank;    //初始星级
	private Integer maxrank;    //最大星级
	private String ratiotype;    //成长系数类型(0-固定，1-动态)
	private Double ratiostr;    //默认力量成长率
	private Double ratioint;    //默认智力成长率
	private Double ratiohp;    //默认HP成长率
	private Double ratiomp;    //默认MP成长率
	private Double ratioagl;    //默认敏捷成长率
	private Double ratioluck;    //默认幸运成长率
	private String father;    //父角色ID
	private String mother;    //母角色ID

	public String getActorid() {
		return this.actorid;
	}

	public void setActorid(String actorid) {
		this.actorid = actorid;
	}

	public String getActorname() {
		return this.actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Integer getActorscene() {
		return this.actorscene;
	}

	public void setActorscene(Integer actorscene) {
		this.actorscene = actorscene;
	}

	public Integer getStr() {
		return this.str;
	}

	public void setStr(Integer str) {
		this.str = str;
	}

	public Integer getIntelligence() {
		return this.intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getHp() {
		return this.hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getMp() {
		return this.mp;
	}

	public void setMp(Integer mp) {
		this.mp = mp;
	}

	public Integer getAgl() {
		return this.agl;
	}

	public void setAgl(Integer agl) {
		this.agl = agl;
	}

	public Integer getLuck() {
		return this.luck;
	}

	public void setLuck(Integer luck) {
		this.luck = luck;
	}

	public Integer getInitrank() {
		return this.initrank;
	}

	public void setInitrank(Integer initrank) {
		this.initrank = initrank;
	}

	public Integer getMaxrank() {
		return this.maxrank;
	}

	public void setMaxrank(Integer maxrank) {
		this.maxrank = maxrank;
	}

	public String getRatiotype() {
		return this.ratiotype;
	}

	public void setRatiotype(String ratiotype) {
		this.ratiotype = ratiotype;
	}

	public Double getRatiostr() {
		return this.ratiostr;
	}

	public void setRatiostr(Double ratiostr) {
		this.ratiostr = ratiostr;
	}

	public Double getRatioint() {
		return this.ratioint;
	}

	public void setRatioint(Double ratioint) {
		this.ratioint = ratioint;
	}

	public Double getRatiohp() {
		return this.ratiohp;
	}

	public void setRatiohp(Double ratiohp) {
		this.ratiohp = ratiohp;
	}

	public Double getRatiomp() {
		return this.ratiomp;
	}

	public void setRatiomp(Double ratiomp) {
		this.ratiomp = ratiomp;
	}

	public Double getRatioagl() {
		return this.ratioagl;
	}

	public void setRatioagl(Double ratioagl) {
		this.ratioagl = ratioagl;
	}

	public Double getRatioluck() {
		return this.ratioluck;
	}

	public void setRatioluck(Double ratioluck) {
		this.ratioluck = ratioluck;
	}

	public String getFather() {
		return this.father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return this.mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
		sb.append(", actorid=").append(actorid);
		sb.append(", actorname=").append(actorname);
		sb.append(", sex=").append(sex);
		sb.append(", race=").append(race);
		sb.append(", profession=").append(profession);
		sb.append(", actorscene=").append(actorscene);
		sb.append(", str=").append(str);
		sb.append(", intelligence=").append(intelligence);
		sb.append(", hp=").append(hp);
		sb.append(", mp=").append(mp);
		sb.append(", agl=").append(agl);
		sb.append(", luck=").append(luck);
		sb.append(", initrank=").append(initrank);
		sb.append(", maxrank=").append(maxrank);
		sb.append(", ratiotype=").append(ratiotype);
		sb.append(", ratiostr=").append(ratiostr);
		sb.append(", ratioint=").append(ratioint);
		sb.append(", ratiohp=").append(ratiohp);
		sb.append(", ratiomp=").append(ratiomp);
		sb.append(", ratioagl=").append(ratioagl);
		sb.append(", ratioluck=").append(ratioluck);
		sb.append(", father=").append(father);
		sb.append(", mother=").append(mother);
        sb.append("]");
        return sb.toString();
	}
}
