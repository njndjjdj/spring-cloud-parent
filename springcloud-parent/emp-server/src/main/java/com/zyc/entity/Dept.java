package com.zyc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName dept
 */
@TableName(value ="dept")
@Data
public class Dept implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String did;

    /**
     * 
     */
    private String dname;

    /**
     * 
     */
    private String dcity;

    /**
     * 逻辑删除 N未删除 Y已删除
     */
    @TableField("isdel")
    private String isdel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Dept other = (Dept) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDid() == null ? other.getDid() == null : this.getDid().equals(other.getDid()))
            && (this.getDname() == null ? other.getDname() == null : this.getDname().equals(other.getDname()))
            && (this.getDcity() == null ? other.getDcity() == null : this.getDcity().equals(other.getDcity()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDid() == null) ? 0 : getDid().hashCode());
        result = prime * result + ((getDname() == null) ? 0 : getDname().hashCode());
        result = prime * result + ((getDcity() == null) ? 0 : getDcity().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", did=").append(did);
        sb.append(", dname=").append(dname);
        sb.append(", dcity=").append(dcity);
        sb.append(", isdel=").append(isdel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}