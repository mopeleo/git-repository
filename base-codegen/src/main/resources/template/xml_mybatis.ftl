<#macro type datatype><#if datatype=="string">VARCHAR<#elseif datatype=="int">INTEGER<#elseif datatype=="double">DOUBLE<#else>DECIMAL</#if></#macro>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${java_dao_package}.${table.code}Dao">
    <resultMap id="BaseResultMap" type="${java_entity_package}.${table.code}">
<#list table.keys as column>
        <id column="${column.originCode}" jdbcType="<@type datatype=column.datatype />" property="${column.code}" />
</#list>
<#list table.columns as column>
	<#if !table.keys?seq_contains(column)>
        <result column="${column.originCode}" jdbcType="<@type datatype=column.datatype />" property="${column.code}" />
	</#if>
</#list>
    </resultMap>
	
	<sql id="column_list">
        <#list table.columns as column>${r'${'}tab}${column.originCode}<#if column_has_next>, </#if></#list>
	</sql>
  
    <insert id="insert" parameterType="${java_entity_package}.${table.code}">
        insert into ${table.originCode?lower_case} (<include refid="column_list"><property name="tab" value=""/></include>)
        values (<#list table.columns as column>#${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next>, </#if></#list>)
    </insert>
  
    <select id="selectWhere" parameterType="${java_entity_package}.${table.code}" resultMap="BaseResultMap">
        select <include refid="column_list"><property name="tab" value=""/></include>
          from ${table.originCode?lower_case}
		<where>
<#list table.columns as column>
			<if test="${column.code} != null <#if column.datatype == "string"> and ${column.code} !='' </#if>">
				and ${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}
			</if>
</#list>
		</where>
    </select>

	<select id="count" resultType="int" parameterType="${java_entity_package}.${table.code}">
        select count(1) from ${table.originCode?lower_case}
		<where>
<#list table.columns as column>
			<if test="${column.code} != null <#if column.datatype == "string"> and ${column.code} !='' </#if>">
				and ${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}
			</if>
</#list>
		</where>
	</select>

    <select id="selectAll" resultMap="BaseResultMap">
        select <include refid="column_list"><property name="tab" value=""/></include>
          from ${table.originCode?lower_case}
    </select>

	<!-- mysql专属 -->
	<insert id="insertBatch" parameterType="java.util.List" useGeneratedKeys="false">
		insert all
		<foreach item="item" index="index" collection="list">
		into ${table.originCode?lower_case} (<include refid="column_list"><property name="tab" value=""/></include>) 
		values (<#list table.columns as column>#${r'{'}item.${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next>, </#if></#list>)
		</foreach>
		select 1 from dual
	</insert>
	
<#if (table.keys?size > 0)>
    <select id="getById" resultMap="BaseResultMap">
        select <include refid="column_list"><property name="tab" value=""/></include>
          from ${table.originCode?lower_case}
         where 1=1<#list table.keys as column> and ${column.originCode} = #${r'{'}${column_index}}</#list>
    </select>

    <delete id="deleteById">
        delete from ${table.originCode?lower_case}
         where 1=1<#list table.keys as column> and ${column.originCode} = #${r'{'}${column_index}}</#list>
    </delete>
  
	<#if (table.colsExceptKey?size > 0)>
    <update id="updateById" parameterType="${java_entity_package}.${table.code}">
        update ${table.originCode?lower_case} set 
		<#list table.colsExceptKey as column>
               ${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}<#if column_has_next>, </#if>
		</#list>
         where 1=1<#list table.keys as column> and ${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}</#list>
    </update>

	<update id="dynamicUpdateById" parameterType="${java_entity_package}.${table.code}">
		update ${table.originCode?lower_case}
		<set>
		<#list table.colsExceptKey as column>
		    <if test="${column.code} != null">
				${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />},
		    </if>
		</#list>
		</set>
		where 1=1<#list table.keys as column> and ${column.originCode} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype />}</#list>
	</update>
	</#if>
</#if>
</mapper>