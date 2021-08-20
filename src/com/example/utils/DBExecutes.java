package com.example.utils;

import com.example.vo.PerInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBExecutes {
    public static List<PerInfo> executeQuery(String sql, Object...args){
        List<PerInfo> list = new ArrayList<>();
        try(PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql);) {
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PerInfo perInfo = new PerInfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                list.add(perInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static int executeUpdate(String sql, Object...args){
        try(PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql);) {
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
