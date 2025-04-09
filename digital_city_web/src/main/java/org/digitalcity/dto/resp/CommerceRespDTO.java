package org.digitalcity.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommerceRespDTO {
    private int id;
    private String name;
    private String type;
    private int amount;
}
