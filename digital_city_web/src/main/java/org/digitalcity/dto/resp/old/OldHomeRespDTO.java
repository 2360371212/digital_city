package org.digitalcity.dto.resp.old;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OldHomeRespDTO {
    private int id;
    private String name;
    private float point;
    private String content;
}
