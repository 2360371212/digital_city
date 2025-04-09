package org.digitalcity.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/7
 */
@TableName("traffic_comment")
@Data
public class TrafficComment {
    private int id;
    private String name;
    // 用户评论
    private String comment;
    // 评论情感分数
    private float score;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
