package com.zifeiyu.client.common.enums;

public enum CodeEnum {
    SUCCESS(0, "OK"),
    YES(1, "true")
    
    
    ;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsgDesc(Integer code) {
        for (CodeEnum baseEnum : CodeEnum.values()) {
            if (baseEnum.getCode().equals(code)) {
                return baseEnum.getMsg();
            }
        }
        return null;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
