package org.digitalcity.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description: 情感得分实体类
 *
 * @author xupengxin
 * @date 2024/3/25
 */
@Data
@TableName("emotion_score")
public class EmotionScore {
    private int id;
    // 数据标签类型
    private String tag;
    // 数据来源
    private String source;
    private float grades;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
