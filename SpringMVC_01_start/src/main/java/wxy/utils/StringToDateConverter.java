package wxy.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符窗转日期
 */
public class StringToDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        if(s == null){
            throw new RuntimeException("请您传数据。");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换失败！");
        }
    }
}
