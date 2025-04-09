package org.digitalcity.jwt.util;

import java.util.Base64;

public class EncryptSalt {
    private EncryptSalt() {
    }

    public static String encrypt(String origin, String salt, int repeat) {
        Base64.Encoder encoder = Base64.getEncoder(); // 获得加密器
        byte data[] = ("{" + salt + "}" + origin).getBytes(); // 将字符串转为字节数组
        for (int x = 0; x < repeat; x++) {
            data = encoder.encode(data);
        }
        return new String(data); // 返回加密后的数据信息
    }

    public static String decrypt(String mist, String salt, int repeat) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte data[] = mist.getBytes(); // 将字符串转为字节数组
        for (int x = 0; x < repeat; x++) {
            data = decoder.decode(data);
        }
        String str = new String(data);
        return str.substring((("{" + salt + "}")).length());
    }
}
