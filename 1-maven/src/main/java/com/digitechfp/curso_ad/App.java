package com.digitechfp.curso_ad;

import java.sql.*;
import java.text.MessageFormat;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String URL = "jdbc:postgresql://localhost:5432/curso_ad";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL2 = "jdbc:postgresql://localhost:5432/curso_ad?user=root&password=root";

    private static final String DRIVER = "org.postgresql.Driver";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        testConnection(conn,"Tres parámetros");
        conn = DbConnection.getConnection(URL, USER, PASSWORD);
        testConnection(conn,"URL Completa");
        conn = DriverManager.getConnection(URL2);
        testConnection(conn,"Usando clase");
        conn = PoolDeConexiones.getConnection();
        testConnection(conn,"PoolDeConexiones");
    }

    public static void testConnection(Connection conn, String msg) throws SQLException {
        final String SELECT = "SELECT * FROM books";
        System.out.println(MessageFormat.format("Db Connected: {0} is {1}",msg,conn.isValid(0)));
        PreparedStatement st = conn.prepareStatement(SELECT);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("title"));
        }
        conn.close();
    }
}
