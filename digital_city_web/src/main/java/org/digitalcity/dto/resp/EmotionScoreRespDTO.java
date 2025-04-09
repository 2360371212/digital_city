package org.digitalcity.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmotionScoreRespDTO {
    private int id;
    private String tag;
    private float score;
    private String source;
}
