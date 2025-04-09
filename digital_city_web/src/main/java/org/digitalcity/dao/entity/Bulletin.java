package org.digitalcity.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description: 医疗公告实体类
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@Data
@TableName("medical_bulletin")
public class Bulletin {
    private int id;
    private String title;
    @TableField(value = "output_date")
    private String date;
    private String link;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
