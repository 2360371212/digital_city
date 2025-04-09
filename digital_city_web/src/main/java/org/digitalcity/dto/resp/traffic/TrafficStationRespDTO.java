package org.digitalcity.dto.resp.traffic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 交通站点相应DTO
 *
 * @author xupengxin
 * @date 2024/4/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrafficStationRespDTO {
    private int id;
    private String name;
    private String content;
    private float emotionPoint;
}
