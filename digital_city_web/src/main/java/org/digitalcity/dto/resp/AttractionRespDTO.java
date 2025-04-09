package org.digitalcity.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttractionRespDTO {
    private int id;
    private String name;
    private String content;
    private float point;
    private int flow;
    private int cost;
}
