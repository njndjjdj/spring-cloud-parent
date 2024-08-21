package com.zyc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName classes
 */
@TableName(value ="classes")
@Data
public class Classes implements Serializable {
    /**
     * 
     */
    @TableId
    private String classno;

    /**
     * 
     */
    private String classname;

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
        Classes other = (Classes) that;
        return (this.getClassno() == null ? other.getClassno() == null : this.getClassno().equals(other.getClassno()))
            && (this.getClassname() == null ? other.getClassname() == null : this.getClassname().equals(other.getClassname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClassno() == null) ? 0 : getClassno().hashCode());
        result = prime * result + ((getClassname() == null) ? 0 : getClassname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classno=").append(classno);
        sb.append(", classname=").append(classname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}