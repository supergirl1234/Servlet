package com.lei.superform;


import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/*随机数产生器*/
public class TokenProcessor {

    /*因为要保证其对象唯一，所以要使用单例*/
    private  static  final TokenProcessor instance=new TokenProcessor();

    private TokenProcessor() {
    }

    public static TokenProcessor getInstance(){

        return  instance;
    }


    /*产生随机数*/
    public String getRandomToken(){
        String token=System.currentTimeMillis()+new Random().nextInt()+""; //得到的长度可能不一致
        /*将token的长度设置为一样长的*/
        try {

            MessageDigest messageDigest=MessageDigest.getInstance("md5");//摘要算法
            byte[] bytes=messageDigest.digest(token.getBytes());
            /*将bytes转换为字符串，需要查表，但是有的二进制对应的字符不在表中，因此需要使用算法base64编码*/
            /*base64编码：将三个字节转换为4个字节*/
            BASE64Encoder base64Encoder=new BASE64Encoder();
            String str=base64Encoder.encode(bytes);
            return  str;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
