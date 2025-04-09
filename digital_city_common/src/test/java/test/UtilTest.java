package test;

import org.digitalcity.common.util.MD5Util;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/30
 */
public class UtilTest {
    @Test
    public void test() {
        String hello = MD5Util.md5Encode("hello");
        System.err.println(hello);
    }
}
