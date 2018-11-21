package com.javarush.task.task33.task3310;

public class SolutionJDBC {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

    }
}
