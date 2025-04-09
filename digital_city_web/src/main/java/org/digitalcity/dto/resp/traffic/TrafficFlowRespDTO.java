package org.digitalcity.dto.resp.traffic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrafficFlowRespDTO {
    private String name;
    private float[] flow;
}
