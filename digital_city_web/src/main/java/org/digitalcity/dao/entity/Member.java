package org.digitalcity.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Description: 用户成员实体类
 *
 * @author xupengxin
 * @date 2024/1/22
 */
@Data
@TableName("member")
public class Member {
    @TableId(type = IdType.AUTO)
    private int id;
    private String mail;
    private String password;
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
