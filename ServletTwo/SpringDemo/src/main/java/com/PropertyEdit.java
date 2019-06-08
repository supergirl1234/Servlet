package com;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:Fanleilei
 * Created:2019/6/8 0008
 */

/*
* 自定义属性编辑器
*
* */
public class PropertyEdit  extends PropertyEditorSupport {


    public String format="yyyy--MM--dd";

    public void setAsText(String text) {

        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
            Date date=simpleDateFormat.parse(text);
           this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
