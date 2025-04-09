package org.digitalcity.dto.resp.traffic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrafficCommentRespDTO {
    private int id;
    private String name;
    private String comment;
    private float score;
}
