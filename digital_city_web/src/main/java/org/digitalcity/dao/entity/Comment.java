package org.digitalcity.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description: 用户评论实体类
 *
 * @author xupengxin
 * @date 2024/3/27
 */
@Data
@TableName("comment")
public class Comment {
    private int id;
    private String tag;
    // 数据来源(微博，知乎)
    private String source;
    private String content;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
