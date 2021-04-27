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
        ArrayList<BookInfo> bookInfos = new ArrayList<>();
        String queryStr = "select * from bookinfo";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(queryStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookInfos.add(new BookInfo(resultSet.getInt("id"), resultSet.getString("bookName"), resultSet.getDouble("price"), resultSet.getString("nick")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookInfos;
    }
    public boolean delBookInfoByBookId(int  id){
        return false;
    }
    public List<BookInfo> fuzzySearch(String key){
        return null;
    }
}
