package com.group21.www.dao;

import com.group21.www.bean.BookInfo;
import com.group21.www.utils.DBConnection;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookInfoDao {
    public boolean addListFromFile(String pathname) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        BufferedReader bufferedReader = null;
        boolean flag = true;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(pathname)));
            String line;
            String[] infos;
            for (int i = 0; i < 10; i++) {
                line = bufferedReader.readLine();
                infos = line.split("###");
                String addInfoStr = "insert into bookinfo(bookName,price,nick) values(?,?,?)";
                preparedStatement = connection.prepareStatement(addInfoStr);
                preparedStatement.setString(1, infos[0]);
                preparedStatement.setDouble(2, Double.valueOf(infos[1]));
                preparedStatement.setString(3, infos[2]);
                int res = preparedStatement.executeUpdate();
                if (res < 0) {
                    flag = false;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
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
        ArrayList<BookInfo> bookInfos = new ArrayList<>();
        String queryStr = "select * from bookinfo where bookname like '%"+key+"%'";
        Connection connection = DBConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryStr);
            while (resultSet.next()){
                bookInfos.add(new BookInfo(resultSet.getInt("id"), resultSet.getString("bookName"), resultSet.getDouble("price"), resultSet.getString("nick")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return bookInfos;
    }
}
