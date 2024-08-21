package com.zyc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student implements Serializable {
    /**
     * 
     */
    @TableId
    private String stuno;

    /**
     * 
     */
    private String stuname;

    /**
     * 
     */
    private String classno;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private Integer age;

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
        Student other = (Student) that;
        return (this.getStuno() == null ? other.getStuno() == null : this.getStuno().equals(other.getStuno()))
            && (this.getStuname() == null ? other.getStuname() == null : this.getStuname().equals(other.getStuname()))
            && (this.getClassno() == null ? other.getClassno() == null : this.getClassno().equals(other.getClassno()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuno() == null) ? 0 : getStuno().hashCode());
        result = prime * result + ((getStuname() == null) ? 0 : getStuname().hashCode());
        result = prime * result + ((getClassno() == null) ? 0 : getClassno().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuno=").append(stuno);
        sb.append(", stuname=").append(stuname);
        sb.append(", classno=").append(classno);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}