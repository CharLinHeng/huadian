package com.xzsd.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomCode {
    /**
     * 随机编号
     * @return
     */
    public static String radmonkey(){
        //6

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuffer sbf=new StringBuffer();

        sbf.append(sdf.format(new Date()));
        for (int i = 0; i <4; i++) {
            int num=(int)(Math.random()*10);
            sbf.append(num);
        }
        return sbf.toString();
    }

    /**
     * 随机生成  分库分表 的good_code
     * @return
     */
    public static String random_GoodCode(){
        int range [] = new int[]{0,5001,10001,15001};
        /**
         * 抽到索引:
         *   0 表示的good_code在 0~5000       存到  库1表1
         *   1 表示的good_code在 5001~10000   存到  库1表2
         *   2 表示的good_code在 10001~15000  存到  库2表1
         *   3 表示的good_code在  15001~20000 存到  库2表2
         */
        int num=(int)(Math.random()*range.length); //从0,1,2,3中随机抽取。
        int maxRange = 4999;
        if(num == 0) {
            maxRange = 5000;
        }
        num =range[num] + (int)(Math.random()*maxRange);
        // 比如我 num抽到1，这行从0,4999抽一个数，那么就是说 5001+(0,4999)这个范围内的编号

        return String.format("%d",num);
    }

    /**
     * 商品分类随机编号
     * @return
     */
    public static String random_GoodClassifiCationCode() {
        //6位 随机
        int num1=(int)(Math.random()*10e3); //
        int num2=(int)(Math.random()*10e3); //
        return String.format("%d%d",num1,num2);
    }
    public static String getDefaultImageUrl(){
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586715837803&di=2d13a82eb00ce746270c52459f468083&imgtype=0&src=http%3A%2F%2Fb2bfile.91jyh.com%2Ffiles%2Fproductpicture%2Fc89d6633-99c0-4fc4-a733-b3766d4b484a_%25e6%259a%2582%25e6%2597%25a0%25e5%259b%25be%25e7%2589%2587.jpg";
        return url;
    }
}
