package org.digitalcity.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description: 景点简介实体类
 *
 * @author xupengxin
 * @date 2024/1/28
 */
@Data
@TableName("attraction")
public class Attraction {
    private int id;
    private String name;
    private String content;
    private float point;
    private int flow;
    private int cost;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
