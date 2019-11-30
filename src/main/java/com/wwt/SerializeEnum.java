package com.wwt;

import java.io.Serializable;

/***
 * @Description 序列化方式枚举
*/
public enum SerializeEnum {

    JAVA_SERIALIZER("java", "java jdk默认序列化方式"),
    HESSIAN_SERIALIZER("hessian", "hessian框架序列化方式"),
    JSON_SERIALIZER("json", "json框架序列化方式"),
    XML_SERIALIZER("hessian", "hessian框架序列化方式"),
    UNKNOW("UNKNOW", "未知");

    private String type;
    private String desc;

    SerializeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SerializeEnum getSerializableEnumByType(String type){
        for (SerializeEnum claimEnum : SerializeEnum.values()) {
            if(type.equalsIgnoreCase(claimEnum.type)){
                return claimEnum;
            }
        }
        return SerializeEnum.UNKNOW;
    }
}
