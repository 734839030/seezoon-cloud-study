package com.seezoon.data.sharding.entity;

import java.util.Date;

public class DemoUser {
    /**
     * 编号
     */
    private Long id;

    private Integer userId;

    private String name;

    private Integer age;

    private Date birthday;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    
    public Integer getAge() {
        return age;
    }

    
    public void setAge(Integer age) {
        this.age = age;
    }

    
    public Date getBirthday() {
        return birthday;
    }

    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    
    public String getCreateBy() {
        return createBy;
    }

    
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    
    public Date getCreateDate() {
        return createDate;
    }

    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    public String getUpdateBy() {
        return updateBy;
    }

    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    
    public Date getUpdateDate() {
        return updateDate;
    }

    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}