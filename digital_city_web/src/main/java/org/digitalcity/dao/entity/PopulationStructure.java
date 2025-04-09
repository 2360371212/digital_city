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
 * @date 2024/4/8
 */
@TableName("population_structure")
@Data
public class PopulationStructure {
    private int id;
    // 年龄范围
    private String scope;
    // 男性人口
    private int male;
    // 女性人口
    private int female;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
