package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dao.ICommerceDAO;
import org.digitalcity.dao.entity.Commerce;
import org.digitalcity.dto.resp.CommerceRespDTO;
import org.digitalcity.service.ICommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/2
 */
@Service
public class CommerceServiceImpl implements ICommerceService {
    @Autowired
    private ICommerceDAO commerceDAO;

    @Override
    public RestResp<List<CommerceRespDTO>> selectByName(String name) {
        QueryWrapper<Commerce> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "type", "amount").eq("name", name);
        List<Commerce> commerce = commerceDAO.selectList(queryWrapper);
        List<CommerceRespDTO> list = new ArrayList<>();
        for (Commerce value : commerce) {
            list.add(new CommerceRespDTO(value.getId(), value.getName(), value.getType(), value.getAmount()));
        }
        return RestResp.ok(list);
    }
}
