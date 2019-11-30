package com.wwt.impl.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wwt.ISerializer;

/**
 * @author wwt
 * @ClassName Json2Serializer.java
 * @Description fastjson实现序列化、反序列化
 * @createTime 2019-11-30 14:16
 */
public class Json2Serializer implements ISerializer {


    @Override
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return (T) JSON.parseObject(new String(data), clazz);
    }
}
