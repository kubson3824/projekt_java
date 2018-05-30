/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package akjp.projektjava.util;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDataSource;
import akjp.projektjava.exception.DataAccessException;

public class ConnectionFactory {

    private ClientDataSource ds;

    private ConnectionFactory() {
        ds = new ClientDataSource();
        ds.setDatabaseName("mydb");
        ds.setUser("app");
        ds.setPassword("app");
        ds.setPortNumber(1527);
        ds.setServerName("localhost");
    }
    
    private static class SingletonHolder {
        private static final ConnectionFactory INSTANCE = new ConnectionFactory();
    }

    public static ConnectionFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static Connection getConnection() {
        try {
            return getInstance().ds.getConnection();
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }

}
