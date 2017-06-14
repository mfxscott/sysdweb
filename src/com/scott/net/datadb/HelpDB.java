package com.scott.net.datadb;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by scott on 17/3/15.
 */
public class HelpDB {
      public Connection conn=null;
      public PreparedStatement pst =null;
      public HelpDB(String sql){
          try {
              DriverManager.registerDriver(new Driver());
              //外网数据库
              conn = (Connection) DriverManager.getConnection("jdbc:mysql://139.199.205.168:3306/sysddb","mfx","123qwe");
             //本地数据库
//              conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sysddb","root","root");
              pst = (PreparedStatement) conn.prepareStatement(sql);
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      public void close(){
          try {
              pst.close();
              conn.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
}
