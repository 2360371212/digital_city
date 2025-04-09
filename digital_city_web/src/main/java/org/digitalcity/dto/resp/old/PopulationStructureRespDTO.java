package org.digitalcity.dto.resp.old;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/8
 */
@Data
@AllArgsConstructor
public class PopulationStructureRespDTO {
    private List<String> scope;
    private List<Integer> male;
    private List<Integer> female;
}
