package com.wwt.impl.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.wwt.ISerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author wwt
 * @ClassName HessianSerializer.java
 * @Description hessian实现序列化、反序列化
 *              hessian是一个支持跨语言传输的二进制序列化协议
 * @createTime 2019-11-30 14:21
 */
public class HessianSerializer implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        if(obj == null){
            throw new NullPointerException();
        }

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            HessianOutput ho = new HessianOutput(os);
            ho.writeObject(obj);
            return os.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {

        if(data == null){
            throw new NullPointerException();
        }

        try {
            ByteArrayInputStream is = new ByteArrayInputStream(data);
            HessianInput hi = new HessianInput(is);
            return (T) hi.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
