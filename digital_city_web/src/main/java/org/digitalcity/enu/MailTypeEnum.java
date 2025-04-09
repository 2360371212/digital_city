package org.digitalcity.enu;

public enum MailTypeEnum {
    FIND_PASSWORD("find"), REGISTER("register");

    private final String content;

    MailTypeEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
