package com.group21.www.dao;

import com.group21.www.bean.BookInfo;
import com.group21.www.utils.DBConnection;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookInfoDao {
    public boolean addListFromFile(String pathname) {
        return false;
    }

    public List<BookInfo> getTotalBookInfo(){
        return null;
    }
    public boolean delBookInfoByBookId(int  id){
        boolean flag = false;
        String delStr = "delete from bookinfo where id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(delStr);
            preparedStatement.setInt(1,id);
            int res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<BookInfo> fuzzySearch(String key){
        return null;
    }
}
