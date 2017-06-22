package com.scott.net.datadb;


import java.sql.ResultSet;

/**
 * Created by scott on 17/3/15.
 */
public class MyMain {
    static  String sql = null;
    static   HelpDB dbh= null;
    static ResultSet ret= null;
    public static  void main(String[] args){
    	System.out.println("===="+CommonSelect.login("ma","123qwe"));

//        sql = "select * from user";
//           dbh = new HelpDB(sql);
//        try {
//            ret = dbh.pst.executeQuery();
//            while (ret.next()){
//                String uid = ret.getString(1);
//                String uname = ret.getString(2);
//                String fname = ret.getString(3);
//                System.out.println(uid+ "\t"+uname+ "\t"+fname);
//            }
//            ret.close();
//            dbh.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
