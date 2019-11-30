package com.wwt.impl.json.Jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.relaxng.datatype.DatatypeException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wwt
 * @ClassName FDateJsonDeserializer.java
 * @Description TODO
 * @createTime 2019-11-30 13:56
 */
public class FDateJsonDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser gen, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = gen.getText();
        if(StringUtils.isEmpty(date)){
            return null;
        }
        if(StringUtils.isNumeric(date)){
            return new Date(Long.valueOf(date));
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
