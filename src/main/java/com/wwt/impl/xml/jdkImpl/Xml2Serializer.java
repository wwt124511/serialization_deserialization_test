package com.wwt.impl.xml.jdkImpl;

import com.wwt.ISerializer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author wwt
 * @ClassName Xml2Serializer.java
 * @Description TODO
 * @createTime 2019-11-30 13:33
 */
public class Xml2Serializer implements ISerializer {


    @Override
    public <T> byte[] serialize(T obj) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLEncoder xe = new XMLEncoder(out, "utf-8", true, 0);
        xe.writeObject(obj);
        xe.close();
        return out.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {

        XMLDecoder xd = new XMLDecoder(new ByteArrayInputStream(data));
        Object obj = xd.readObject();
        xd.close();
        return (T) obj;
    }
}
