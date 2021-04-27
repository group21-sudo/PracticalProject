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
            while(1) {
                line = bufferedReader.readLine();
                infos = line.split("###");
                String addInfoStr = "insert into bookinfo(bookName,price,nick) values(?,?,?)";
                preparedStatement = connection.prepareStatement(addInfoStr);
                preparedStatement.setString(1, infos[0]);
                preparedStatement.setDouble(2, Double.valueOf(infos[1]));
                preparedStatement.setString(3, infos[2]);
                preparedStatement.executeUpdate();
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
        }
        return flag;
    }

    public List<BookInfo> getTotalBookInfo(){
        return null;
    }
    public boolean delBookInfoByBookId(int  id){
        return false;
    }
    public List<BookInfo> fuzzySearch(String key){
        return null;
    }
}
