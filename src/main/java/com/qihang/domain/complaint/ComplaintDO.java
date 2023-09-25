package com.qihang.domain.complaint;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_complaint")
public class ComplaintDO implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 联系方式
     */
    private String phone;

    /**
     * 问题类型
     */
    private String type;
    /**
     * 问题描述
     */
    private String descriptor;
    /**
     * 图片
     */
    private String pic;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 回复
     */
    private String reply;
    /**
     * 店铺ID
     */
    private Integer tid;
}
