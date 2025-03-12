package com.digitechfp.curso_ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

       try {
            Connection conn = DriverManager.getConnection(URL_FULL);
            System.out.println(conn.isValid(0));


            InsertBook(conn,"1984","Orwell");
            SelectBooks(conn);

           conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

/*haciendolo modo transaccion,gracias a quitar el auto commit, los cambios solo se aplican si todas las sentencias pueden completarse
// En este ejemplo, no se inserta ningun libro porque el segundo da error al estar en nulo
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(URL_FULL);
            conn.setAutoCommit(false);
            InsertBook(conn,"El señor de los anillos","J.R.R. Tolkien");
            InsertBook(conn,null,null);
            conn.commit();
            SelectBooks(conn);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

*/
    }

    private static final String URL="jdbc:postgresql://localhost:5432/curso_ad";
    private static final String USER="admin";
    private static final String PASSWORD="admin";
    private static final String URL_FULL="jdbc:postgresql://localhost:5432/curso_ad?user=admin&password=admin";

    public static void SelectBooks(Connection conn) throws SQLException {


        final String SELECT = "Select * from books";
        var st=conn.prepareStatement(SELECT);
        var rs=st.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString("title"));
        }




    }

    public static void InsertBook(Connection conn,String title,String author) throws SQLException {


        final String INSERT = "insert into books (title,author) values (?,?)";
        var st=conn.prepareStatement(INSERT);
        st.setString(1,title);
        st.setString(2,author);
        st.executeUpdate();




    }





}