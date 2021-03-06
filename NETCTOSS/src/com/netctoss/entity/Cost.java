package com.netctoss.entity;

/**
 * Created by tan on 2016/10/11.
 */

import java.sql.Timestamp;

/**
 * Timestamp 时间格式  yyyy-MM-dd HH:mm:ss
 */

/**
 * 资费实体类
 */
public class Cost {

    private Integer id; //  主键
    private String name;    //  资费名称
    private Integer baseDuration; //    在线时长
    private Double baseCost;    //  基本费用
    private Double unitCost;    //  单位费用
    private String status;  //  状态
    private String descr;   //  资费说明
    private Timestamp createTime;    //  创建日期
    private Timestamp startTime; //  启用日期
    private String costType;    //  资费类型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(Integer baseDuration) {
        this.baseDuration = baseDuration;
    }

    public Double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Double baseCost) {
        this.baseCost = baseCost;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }
}
