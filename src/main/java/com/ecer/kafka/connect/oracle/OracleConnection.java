package com.ecer.kafka.connect.oracle;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  
 * @author Erdem Cer (erdemcer@gmail.com)
 */

public class OracleConnection{
    private static HikariDataSource ds;
    private static OracleSourceConnectorConfig oracleConfig;

    public Connection connect(OracleSourceConnectorConfig oracleConfig) throws SQLException{
        if (ds == null || !OracleConnection.oracleConfig.equals(oracleConfig)) {
            HikariConfig hikariConfig = new HikariConfig();

            hikariConfig.setJdbcUrl("jdbc:oracle:thin:@"+oracleConfig.getDbHostName()+":"+oracleConfig.getDbPort()+"/"+oracleConfig.getDbName());
            hikariConfig.setUsername(oracleConfig.getDbUser());
            hikariConfig.setPassword(oracleConfig.getDbUserPassword());
            hikariConfig.setMaximumPoolSize(3);

            OracleConnection.ds = new HikariDataSource(hikariConfig);
            OracleConnection.oracleConfig = oracleConfig;
        }
        return OracleConnection.ds.getConnection();
    }

    public static void close() {
        ds.close();
    }
}