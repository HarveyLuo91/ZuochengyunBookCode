package Alibaba;

/**
 * Created by fangheart on 2017/8/25.
 */
import java.util.Scanner;
/*
(1)OFO小黄车:按距离计费(1元/1.5千米),不到1.5千米按1.5千米算
(2)永安行:按时间计费(0.2元/1分钟),不到1分钟则按一分钟算
(3)hellobike：分段收费(小于等于2千米收费1元,大于2千米小于等于4千米收费3元,大于4米小于等于8千米收费5元,大于8千米收费8元)
 */
public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String bike_plan(double distance, double speed) {
        String result="";
        result+= "骑行距离" + distance+"(千米)，匀速骑行速度"+speed+"(千米/分钟)最省钱方案:";

        double moneyOfo = ((int)Math.ceil(distance/1.5))*1;
        double moneyYongan = ((int)Math.ceil(distance/speed))*0.2;
        double moneyHellobike = 0;
        if (distance<=2){
            moneyHellobike = 1.0;
        }else if (distance>2&&distance<=4){
            moneyHellobike = 3.0;
        }else if (distance>4&&distance<=8){
            moneyHellobike = 5.0;
        }else if (distance>8){
            moneyHellobike = 8.0;
        }
        double moneyTemp = 0;
        double moneyFinal = 0;
        if (moneyOfo==moneyYongan){
            moneyTemp = moneyOfo;
            if (moneyTemp==moneyHellobike){
                result+="\n"+"OFO小黄车"+moneyTemp+"（元）和"+"永安行"+moneyTemp+"（元）和"+"hellobike"+moneyTemp+"（元）";
            }else {
                moneyFinal = Math.min(moneyTemp,moneyHellobike);
                if (moneyFinal==moneyTemp){
                    result+="\n"+"OFO小黄车"+moneyTemp+"（元）和"+"永安行"+moneyTemp+"（元）";
                }else {
                    result+="\n"+"hellobike"+moneyTemp+"（元）";
                }
            }
        }else {
            moneyTemp = Math.min(moneyOfo,moneyYongan);
            if (moneyTemp==moneyOfo){
                if (moneyTemp==moneyHellobike){
                    result+="\n"+"OFO小黄车"+moneyTemp+"（元）和"+"hellobike"+moneyTemp+"（元）";
                }else {
                    moneyFinal = Math.min(moneyTemp, moneyHellobike);
                    if (moneyFinal==moneyTemp){
                        result+="\n"+"OFO小黄车"+moneyTemp+"（元）";
                    }else {
                        result+="\n"+"hellobike"+moneyTemp+"（元）";
                    }
                }
            }else {
                if (moneyTemp==moneyHellobike){
                    result+="\n"+"永安行"+moneyTemp+"（元）和"+"hellobike"+moneyTemp+"（元）";
                }else {
                    moneyFinal = Math.min(moneyTemp, moneyHellobike);
                    if (moneyFinal==moneyTemp){
                        result+="\n"+"永安行"+moneyTemp+"（元）";
                    }else {
                        result+="\n"+"hellobike"+moneyTemp+"（元）";
                    }
                }
            }
        }

        //System.out.println(moneyOfo+" "+moneyYongan+" "+moneyHellobike);
        return result;
        //永安行8.0（元）和hellobike8.0（元）
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        double _distance;
        _distance = Double.parseDouble(in.nextLine().trim());

        double _speed;
        _speed = Double.parseDouble(in.nextLine().trim());

        res = bike_plan(_distance, _speed);
        System.out.println(res);
    }
}