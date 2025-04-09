package org.digitalcity.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description: 交通站点实体类
 *
 * @author xupengxin
 * @date 2024/4/7
 */
@Data
@TableName("traffic_station")
public class TrafficStation {
    private int id;
    private String name;
    private String content;
    // 用户情感的分
    @TableField("emotion_point")
    private float emotionPoint;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
