MyBatisGenerator
================

使用方法
-----
1. 修改 config.properties 配置文件为正确数据库连接
2. 执行 com.chn.mybatis.gen.Main，会在项目目录下的 gen 目录下生成结果文件，基本目录结构如下
   
	   project
	   |---src
	   |---gen
	       |---vo
	       |   |--User.java
	       |---UserMapper.java
	       |---UserMapper.xml

目标文件格式
-------
### User.java ###
	
	public class User {
	    private Integer id;
	    private String portrait;
	    private Date registTime;
	    private Long score;
	    private String mobile;
	    
	    private Org org;
	    private List<UserInfo> userInfoList;

        //省略getter setter
    }

### UserMapper.java ###

	public interface UserMapper {
	    public User get(Integer id);
	    public void set(User obj);
	    public void add(User obj);
	    public void remove(Integer id);
	    public List<User> list(Map<String, Object> params);
	    public Integer count(Map<String, Object> params);
	}

### UserMapper.xml ###

	<mapper namespace="com.chn.xietong.web.mapper.UserMapper">
    
	    <sql id="pkCondition">
	        <trim prefix="" prefixOverrides="AND">
	                AND T2.ID = #{id}
	        </trim>
	    </sql>
	    
	    <sql id="colList">
	        <trim prefix="" prefixOverrides=",">
	            , T2.PORTRAIT AS C36
	            , T2.REGIST_TIME AS C37
	            , T2.SCORE AS C38
	            , T2.MOBILE AS C39
	            , T2.ID AS C47
	            <if test="linkOrg != null">
	                , T13.NAME AS C126
	                , T13.ID AS C133
	            </if>
	            <if test="withUserInfoList != null">
	                , T1.STRATUM AS C2
	                , T1.birthday AS C3
	                , T1.HOUSEHOLD_ZIPCODE AS C4
	                , T1.USER_ID AS C1
	            </if>
	        </trim>
	    </sql>
	    
	    <resultMap id="result" type="User">
	        <id column="C47" javaType="Integer" jdbcType="INTEGER" property="id"/>
	        <result column="C36" javaType="String" jdbcType="VARCHAR" property="portrait"/>
	        <result column="C37" javaType="Date" jdbcType="TIMESTAMP" property="registTime"/>
	        <result column="C38" javaType="Long" jdbcType="BIGINT" property="score"/>
	        <result column="C39" javaType="String" jdbcType="VARCHAR" property="mobile"/>
	        <association property="org" javaType="Org">
	            <id column="C133" javaType="Integer" jdbcType="INTEGER" property="id"/>
	            <result column="C126" javaType="String" jdbcType="VARCHAR" property="name"/>
	        </association>
	        <collection property="userInfoList" ofType="UserInfo">
	            <id column="C1" javaType="Integer" jdbcType="INTEGER" property="userId"/>
	            <result column="C2" javaType="Integer" jdbcType="TINYINT" property="stratum"/>
	            <result column="C3" javaType="Date" jdbcType="DATE" property="birthday"/>
	            <result column="C4" javaType="String" jdbcType="VARCHAR" property="householdZipcode"/>
	        </collection>
	    </resultMap>
	    
	    <select id="get" parameterType="int" resultMap="result">
	        SELECT <include refid="colList" />
	          FROM user T2 
	         WHERE <include refid="pkCondition"/>
	    </select>
	    
	    <update id="set" parameterType="User">
	        UPDATE user T2 SET 
	            <trim prefix="" prefixOverrides=",">
	                    , PORTRAIT = #{portrait}
	                    , REGIST_TIME = #{registTime}
	                    , SCORE = #{score}
	                    , MOBILE = #{mobile}
	            </trim>
	        WHERE <include refid="pkCondition"/>
	    </update>
	    
	    <insert id="add" parameterType="User" useGeneratedKeys="true" keyProperty="ID" >
	        INSERT INTO user (
	            <trim prefix="" prefixOverrides=",">
	                    , PORTRAIT
	                    , REGIST_TIME
	                    , SCORE
	                    , MOBILE
	            </trim>
	        ) VALUES (
	            <trim prefix="" prefixOverrides=",">
	                    , #{portrait}
	                    , #{registTime}
	                    , #{score}
	                    , #{mobile}
	            </trim>
	        )
	    </insert>
	    
	    <delete id="remove" parameterType="int">
	        DELETE T2 FROM user T2 WHERE <include refid="pkCondition"/>
	    </delete>
	    
	    <select id="list" parameterType="map" resultMap="result">
	        SELECT <include refid="colList" />
	          FROM user T2
	        <if test="linkOrg != null">LEFT JOIN org T13 ON T2.ORG_ID=T13.ID</if>
	        <if test="withUserInfoList != null" >LEFT JOIN user_info T1 ON T2.ID=T1.USER_ID</if>
	        <where>
	            <if test="id != null">AND T2.ID = #{id}</if>
	            <if test="idGT != null">AND T2.ID > #{idGT}</if><if test="idLT != null">AND #{idLT} > T2.ID</if>
	            <if test="portrait != null">AND T2.PORTRAIT = #{portrait}</if>
	            <if test="portraitLK != null">AND T2.PORTRAIT LIKE #{portraitLK}</if>
	            <if test="registTime != null">AND T2.REGIST_TIME = #{registTime}</if>
	            <if test="score != null">AND T2.SCORE = #{score}</if>
	            <if test="scoreGT != null">AND T2.SCORE > #{scoreGT}</if>
	            <if test="scoreLT != null">AND #{scoreLT} > T2.SCORE</if>
	            <if test="mobile != null">AND T2.MOBILE = #{mobile}</if>
	            <if test="mobileLK != null">AND T2.MOBILE LIKE #{mobileLK}</if>
	            
	            <if test="orgId != null">AND T13.ID = #{orgId}</if>
	            <if test="orgIdGT != null">AND T13.ID > #{orgIdGT}</if>
	            <if test="orgIdLT != null">AND #{orgIdLT} > T13.ID</if>
	            <if test="orgName != null">AND T13.NAME = #{orgName}</if>
	            <if test="orgNameLK != null">AND T13.NAME LIKE #{orgNameLK}</if>
	        </where>
	        <if test="orderBy != null">ORDER BY ${orderBy}</if>
	        <if test="pageStartPos != null and pageSize != null">LIMIT #{pageStartPos}, #{pageSize}</if>
	    </select>
	    
	    <select id="count" parameterType="map" resultType="int">
	        SELECT COUNT(1) 
	          FROM user T2
	        <if test="linkOrg != null">
	     LEFT JOIN org T13 ON T2.ORG_ID=T13.ID
	        </if>
	        <where>
	            <if test="id != null">AND T2.ID = #{id}</if>
	            <if test="idGT != null">AND T2.ID > #{idGT}</if><if test="idLT != null">AND #{idLT} > T2.ID</if>
	            <if test="portrait != null">AND T2.PORTRAIT = #{portrait}</if>
	            <if test="portraitLK != null">AND T2.PORTRAIT LIKE #{portraitLK}</if>
	            <if test="registTime != null">AND T2.REGIST_TIME = #{registTime}</if>
	            <if test="score != null">AND T2.SCORE = #{score}</if>
	            <if test="scoreGT != null">AND T2.SCORE > #{scoreGT}</if>
	            <if test="scoreLT != null">AND #{scoreLT} > T2.SCORE</if>
	            <if test="mobile != null">AND T2.MOBILE = #{mobile}</if>
	            <if test="mobileLK != null">AND T2.MOBILE LIKE #{mobileLK}</if>
	            
	            <if test="orgId != null">AND T13.ID = #{orgId}</if>
	            <if test="orgIdGT != null">AND T13.ID > #{orgIdGT}</if>
	            <if test="orgIdLT != null">AND #{orgIdLT} > T13.ID</if>
	            <if test="orgName != null">AND T13.NAME = #{orgName}</if>
	            <if test="orgNameLK != null">AND T13.NAME LIKE #{orgNameLK}</if>
	        </where>
	    </select>
	    
	</mapper>