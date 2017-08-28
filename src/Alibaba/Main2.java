package Alibaba;

/**
 * Created by fangheart on 2017/8/25.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
为了响应公司人才发展的战略要求，计划对团队内的工程师以成立虚拟小组的形式，
让小组内的成员相互学习，进行技能的扩展，同时考虑到日常的工作效率，
所以每个人最多参加2个小组，每个小组最多3个人，小组个数越少越好，方便管理。
团队内有前端工程师，java工程师，数据工程师和算法工程师，虚拟小组的学习目标是：
java工程师必须同时掌握前端，
算法和数据工程师必须掌握java。
请帮助经理合理规划小组成员的分配，成立虚拟小组，来帮助公司人才战略的发展。
输入:
staff_info每一行为一条员工信息（员工工号,员工技能），其中员工技能：java表示java开发，web表示前端开发，data表示数据研发，dm表示算法研究
输出:
一行一个虚拟分组的所有员工工号，多个员工工号之间用英文逗号分隔，分组内部和分组之间按照用例输入的顺序进行排列
输入范例:
4
10001,java
10002,web
10003,data
10004,dm
输出范例:
10001,10002,10003
10001,10004
 */

public class Main2 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String[] fsd_team(String[] staff_info) {
        ArrayList<String> javaArrayList = new ArrayList<>();
        ArrayList<String> webArrayList = new ArrayList<>();
        ArrayList<String> dataArrayList = new ArrayList<>();
        ArrayList<String> dmArrayList = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();

        ArrayList<String> arrayList = new ArrayList<>();

        String id;
        String zw;
        for (int i = 0; i < staff_info.length; i++) {
            id = staff_info[i].split(",")[0];
            zw = staff_info[i].split(",")[1];
            hashMap.put(id,2);
            if (zw.equals("java"))
                javaArrayList.add(id);
            else if (zw.equals("web"))
                webArrayList.add(id);
            else if(zw.equals("data"))
                dataArrayList.add(id);
            else
                dmArrayList.add(id);
        }

        int numOfweb = webArrayList.size();
        int numOfjava = javaArrayList.size();
        String webId="";
        String javaId="";
        String dataId="";
        String dmId="";
        for (int i = 0; i < numOfweb; i++) {
            webId = webArrayList.get(0);
            if (i<javaArrayList.size()){
                if (hashMap.get(javaArrayList.get(i))>0){
                    hashMap.put(javaArrayList.get(i),hashMap.get(javaArrayList.get(i))-1);
                    if (i<dataArrayList.size()){
                        if (hashMap.get(dataArrayList.get(i))>0){
                            hashMap.put(dataArrayList.get(i),hashMap.get(dataArrayList.get(i))-1);
                        }
                    }
                }
            }
        }

        return staff_info;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;

        int _staff_info_size = 0;
        _staff_info_size = Integer.parseInt(in.nextLine().trim());
        String[] _staff_info = new String[_staff_info_size];
        String _staff_info_item;
        for(int _staff_info_i = 0; _staff_info_i < _staff_info_size; _staff_info_i++) {
            try {
                _staff_info_item = in.nextLine();
            } catch (Exception e) {
                _staff_info_item = null;
            }
            _staff_info[_staff_info_i] = _staff_info_item;
        }

        res = fsd_team(_staff_info);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}

