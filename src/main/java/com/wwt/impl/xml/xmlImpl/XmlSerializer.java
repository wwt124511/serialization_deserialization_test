package com.wwt.impl.xml.xmlImpl;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.wwt.ISerializer;

/**
 * @author wwt
 * @ClassName XmlSerializer.java
 * @Description xStream实现序列化、反序列化
 *              优点：
 *                  1. 可读性好
 *                  2. 语言无关行，可用于异构系统间的数据交换
 *              缺点：
 *                  1. 码流过大，效率不高，适用于对性能要求不高，切QPS较低的企业级内部系统之间的数据交换场景
 *                  2.
 *
 * @createTime 2019-11-30 10:58
 */
public class XmlSerializer implements ISerializer {

    private static final XStream xStream = new XStream(new DomDriver());

    /**
     * @param obj
     * @return : byte[]
     * @Description xStream实现序列化
     */
    @Override
    public <T> byte[] serialize(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    /**
     * @Description xStream实现反序列化
     * @param data
     * @param clazz
     * @return : T
    */
    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {

        String xml = new String(data);
        return (T) xStream.fromXML(xml);
    }
}
