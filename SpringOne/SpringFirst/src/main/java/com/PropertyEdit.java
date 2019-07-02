package com;


import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
*定义一个属性编辑器必须继承java.beans.PropertyEditorSupport
* Java为PropertyEditor提供了一个方便类：PropertyEditorSupport，该类实现了PropertyEditor接口并提供默认实现，
* 一般情况下，用户可以通过扩展这个方便类设计自己的属性编辑器。
* */

//自定义编辑器实现之后，要将自定义编辑器要注册给Spring容器
public class PropertyEdit extends PropertyEditorSupport {
    private  String format="yyyy-MM-dd";//要转化为什么格式

    //void setAsText(String text)：用一个字符串去更新属性的内部值，这个字符串一般从外部属性编辑器传入
    public  void setAsText(String text){
        try {
            SimpleDateFormat transFormat=new SimpleDateFormat(format);
            Date date=transFormat.parse(text);
            this.setValue(date);//void setValue(Object newValue)：设置属性的值，基本类型以封装类传入；
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
