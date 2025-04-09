package org.digitalcity.dto.resp.hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalRespDTO {
    private int id;
    private String name;
    private String tag;
    private float point;
    private String link;
}
