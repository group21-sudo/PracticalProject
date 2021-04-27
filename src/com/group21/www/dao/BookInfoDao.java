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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = DBConnection.getConnection().prepareStatement(queryStr);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookInfos.add(new BookInfo(resultSet.getInt("id"), resultSet.getString("bookName"), resultSet.getDouble("price"), resultSet.getString("nick")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
