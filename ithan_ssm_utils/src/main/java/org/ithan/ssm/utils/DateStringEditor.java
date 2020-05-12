package org.ithan.ssm.utils;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author HanMengJie
 * @Date 2020/5/12 11:43
 **/
public class DateStringEditor extends PropertiesEditor {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date date = DateUtils.string2Date(text, "yyyy-MM-dd HH:mm");
            super.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
