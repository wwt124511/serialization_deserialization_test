package com.wwt;

/***
 * @Description 序列化、反序列化接口
*/
public interface ISerializer {

    /**
     * @Description 序列化
     * @param obj
     * @return : byte[]
    */
    public <T> byte[] serialize(T obj);


    /**
     * @Description 反序列化
     * @param data
     * @param clazz
     * @return : T
    */
    public <T> T deserialize(byte[] data, Class<T> clazz);
}
