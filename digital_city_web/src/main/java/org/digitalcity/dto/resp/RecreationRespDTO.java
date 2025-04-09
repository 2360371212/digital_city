package org.digitalcity.dto.resp;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecreationRespDTO {
    private int id;
    private String name;
    private String tag;
    private float point;
}
