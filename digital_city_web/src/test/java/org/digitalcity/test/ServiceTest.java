package org.digitalcity.test;

import org.digitalcity.ApplicationStarter;
import org.digitalcity.dao.entity.Attraction;
import org.digitalcity.dto.resp.AttractionRespDTO;
import org.digitalcity.service.IAttractionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/28
 */

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ApplicationStarter.class})
public class ServiceTest {
    @Autowired
    private IAttractionService attractionService;

    @Test
    public void testAttractionService() {
        List<AttractionRespDTO> list = attractionService.selectAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testAttractionGet() {
        AttractionRespDTO attractionRespDTO = attractionService.selectByName("晋祠");
        System.out.println(attractionRespDTO);
        AttractionRespDTO attractionRespDTO1 = attractionService.selectById(4);
        System.err.println(attractionRespDTO1);
    }

    @Test
    public void test() {
//        Attraction dfjasl = Attraction.builder().id(1).content("dfjasl").build();
         
    }
}
