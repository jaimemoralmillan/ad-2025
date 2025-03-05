package com.digitechfp.curso_ad;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolDeConexiones {
    private static final BasicDataSource dataSource = new BasicDataSource();
    static {
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/curso_ad");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
