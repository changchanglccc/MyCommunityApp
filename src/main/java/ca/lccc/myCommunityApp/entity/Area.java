package ca.lccc.myCommunityApp.entity;

import java.util.Date;

public class Area {
    private Integer areaId; // 为什么使用包装类型（对象类型，默认为null）儿不是基本类型？ 因为基本数据类型会有默认值，可能会影响结果
    private String areaName;
    private Integer priority;   // 权重，越大越排前
    private Date createTime;
    private Date lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
