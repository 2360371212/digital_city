package org.digitalcity.jwt.provider.impl;
import org.digitalcity.jwt.config.EncryptConfigProperties;
import org.digitalcity.jwt.provider.IEncryptProvider;
import org.digitalcity.jwt.util.EncryptSalt;
import org.digitalcity.jwt.util.MD5Code;
import org.springframework.beans.factory.annotation.Autowired;

public class EncryptProvider implements IEncryptProvider {

    @Autowired
    private EncryptConfigProperties encryptConfigProperties;


    @Override
    public String getEncryptPassword(String password) {
        String newPass = EncryptSalt.encrypt(password, this.encryptConfigProperties.getSalt(),
                this.encryptConfigProperties.getRepeat()); // Base64加密
        MD5Code md5 = new MD5Code(); // 获取MD5加密对象实例
        for (int x = 0; x < this.encryptConfigProperties.getRepeat(); x++) {
            newPass = md5.getMD5ofStr(newPass);
        }
        return newPass;
    }
}
