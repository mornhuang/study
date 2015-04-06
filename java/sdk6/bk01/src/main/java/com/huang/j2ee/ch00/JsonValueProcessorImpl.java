package com.huang.j2ee.ch00;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import net.sf.json.util.JSONUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created By User : Morn
 * Created DateTime: 2015/2/2 10:51
 * Descriptions    : 学习JsonValueProcessor
 */
public class JsonValueProcessorImpl implements JsonValueProcessor {

    private String format = "yyyy-MM-dd";

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public JsonValueProcessorImpl() {
        super();
    }

    public JsonValueProcessorImpl(String format) {
        super();
        this.format = format;
    }

    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        String obj = null;
        if (value instanceof Date) {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            obj = sf.format((Date)value);
        }
        return obj;
    }

    @Override
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        if (value instanceof java.util.Date) {
            return new SimpleDateFormat(format).format((Date) value);
        }
        return value.toString();
    }

    public static void main(String[] args) {
/*
        String[] dateFmts = new String[] { "yyyy/MM/dd", "yyyy-MM-dd" };
        JSONUtils.getMorpherRegistry().registerMorpher( new DateMorpher(dateFmts));
        User jsonToBean = (User) JSONObject.toBean(jsonstr, User.class);
*/
        // 日期对象列表转为JSon数组
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessorImpl());
        List<Date> dateList = new ArrayList<Date>();
        dateList.add(new Date());
        JSONArray jsonArray = JSONArray.fromObject(dateList.toArray(), jsonConfig);
        System.out.println(jsonArray.toString());
    }

}
