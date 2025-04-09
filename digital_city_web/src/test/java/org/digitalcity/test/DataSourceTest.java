package org.digitalcity.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.digitalcity.ApplicationStarter;
import org.digitalcity.dao.entity.Member;
import org.digitalcity.dao.IMemberDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.ObjectUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/22
 */
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(classes = {ApplicationStarter.class})
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnect() throws SQLException {
        System.err.println(dataSource.getConnection());
    }

    @Autowired
    private IMemberDAO memberDAO;

    @Autowired
    private MetaObjectHandler metaObjectHandler;

    @Test
    public void testInsert() {
        Member member = new Member();
        member.setMail("hel");
        member.setPassword("123456");
        System.out.println(member);
        memberDAO.insert(member);
    }

    @Test
    public void testSelect() {
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("mail", "hel");
        Member member = memberDAO.selectOne(wrapper);
        System.err.println(member);
    }

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("not", "bad");
    }

    @Test
    public void testObjectUtils() {
        UpdateWrapper<Member> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("password", "djlfdkasj");
        updateWrapper.eq("mail", "hel");
        memberDAO.update(null, updateWrapper);
    }
}

