package com.wwt;

import com.google.common.collect.Maps;
import com.wwt.impl.hessian.HessianSerializer;
import com.wwt.impl.jdk.JavaImpl;
import com.wwt.impl.json.Jackson.JsonSerializer;
import com.wwt.impl.xml.xmlImpl.XmlSerializer;

import java.util.Map;

/**
 * @author wwt
 * @ClassName SerializerEngine.java
 * @Description TODO
 * @createTime 2019-11-30 14:41
 */
public class SerializerEngine {

    public static final Map<String, ISerializer> serializerMap = Maps.newConcurrentHashMap();

    static {
        serializerMap.put(SerializeEnum.JAVA_SERIALIZER.getType(), new JavaImpl());
        serializerMap.put(SerializeEnum.HESSIAN_SERIALIZER.getType(), new HessianSerializer());
        serializerMap.put(SerializeEnum.JSON_SERIALIZER.getType(), new JsonSerializer());
        serializerMap.put(SerializeEnum.XML_SERIALIZER.getType(), new XmlSerializer());

    }

    /**
     * @Description 根据枚举类型，动态调用序列化框架进行序列化操作
     * @param obj
     * @param serializeType
     * @return : byte[]
    */
    public <T> byte[] serialize(T obj, String serializeType){
        SerializeEnum serialize = SerializeEnum.getSerializableEnumByType(serializeType);
        if(null == serialize){
            throw new RuntimeException("serialize is null");
        }

        ISerializer serializer = serializerMap.get(serialize.getType());
        if(null == serializer){
            throw new RuntimeException("serialize error");
        }

        return serializer.serialize(obj);
    }



    public <T> T deserialize(byte[] data, Class<T> clazz, String serializeType){
        SerializeEnum serialize = SerializeEnum.getSerializableEnumByType(serializeType);
        if(null == serialize){
            throw new RuntimeException("serialize is null");
        }
        ISerializer serializer = serializerMap.get(serialize.getType());
        if(null == serializer){
            throw new RuntimeException("serialize error");
        }

        return serializer.deserialize(data, clazz);
    }


}
