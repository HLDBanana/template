package com.yss.dataMiddle.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 表分类
 * </p>
 *
 * @author Han LiDong
 * @since 2020-07-08
 */
@TableName("p_table_category")
@ApiModel(value="PTableCategory对象", description="表分类")
public class PTableCategory extends Model<PTableCategory> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.INPUT)
    @Excel(name = "id", orderNum = "1", width = 15)
    private Integer id;

    @Excel(name = "分类名称", orderNum = "2", width = 15)
    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @Excel(name = "分类编码", orderNum = "3", width = 15)
    @ApiModelProperty(value = "分类编码")
    private String categoryCode;

    @Excel(name = "排序", orderNum = "4", width = 15)
    @ApiModelProperty(value = "排序")
    private Integer categorySort;

    @Excel(name = "状态", orderNum = "5", width = 15)
    @ApiModelProperty(value = "状态")
    private String status;

    @Excel(name = "优先数据源", orderNum = "6", width = 15)
    @ApiModelProperty(value = "优先数据源")
    private String priorityData;

    @Excel(name = "备注", orderNum = "7", width = 15)
    @ApiModelProperty(value = "备注")
    private String remarks;

    @Excel(name = "创建时间", orderNum = "8", width = 15)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Excel(name = "更新时间", orderNum = "9", width = 15)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @Excel(name = "删除标志", orderNum = "10", width = 15)
    @ApiModelProperty(value = "删除标志")
    private String delFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
    public Integer getCategorySort() {
        return categorySort;
    }

    public void setCategorySort(Integer categorySort) {
        this.categorySort = categorySort;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getPriorityData() {
        return priorityData;
    }

    public void setPriorityData(String priorityData) {
        this.priorityData = priorityData;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PTableCategory{" +
        "id=" + id +
        ", categoryName=" + categoryName +
        ", categoryCode=" + categoryCode +
        ", categorySort=" + categorySort +
        ", status=" + status +
        ", priorityData=" + priorityData +
        ", remarks=" + remarks +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", delFlag=" + delFlag +
        "}";
    }
}
