package com.group21.www.view;

import com.group21.www.bean.BookInfo;
import com.group21.www.dao.BookInfoDao;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private BookInfoDao bookInfoDao = new BookInfoDao();
    public void start(){
        while (true){
            System.out.println("-----欢迎使用-----");
            System.out.println("1.获取实时数据");
            System.out.println("2.将数据存入数据库");
            System.out.println("3.数据展示");
            System.out.println("4.模糊查询");
            System.out.println("5.指定删除");
            System.out.println("------------------");
            System.out.print("请选择：");
            String choose = scanner.next();
            switch (choose) {
                case "1":
                    System.out.println("请执行tb.py文件获取实时数据");
                    break;
                case "2":
                    boolean res = bookInfoDao.addListFromFile("D:\\src\\list.txt");
                    if (res) {
                        System.out.println("存入成功！");
                    }else {
                        System.out.println("存入失败！");
                    }
                    break;
                case "3":
                    List<BookInfo> totalBookInfo = bookInfoDao.getTotalBookInfo();
                    for (BookInfo bookInfo : totalBookInfo) {
                        System.out.println(bookInfo);
                    }
                    break;
                case "4":
                    System.out.print("请输入书名：");
                    String bookName = scanner.next();
                    List<BookInfo> bookInfos = bookInfoDao.fuzzySearch(bookName);
                    if (bookInfos == null || bookInfos.size() == 0) {
                        System.out.println("无数据");
                    }else {
                        for (BookInfo bookInfo : bookInfos) {
                            System.out.println(bookInfo);
                        }
                    }
                    break;
                case "5":
                    System.out.print("请输入id：");
                    int delBookId = scanner.nextInt();
                    boolean delRes = bookInfoDao.delBookInfoByBookId(delBookId);
                    if (delRes) {
                        System.out.println("删除成功！");
                    }else {
                        System.out.println("删除失败！");
                    }
                    break;
                default:
                    System.out.println("输入有误！");
                    break;
            }
        }
    }
}
