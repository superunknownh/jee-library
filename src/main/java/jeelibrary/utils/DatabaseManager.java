package jeelibrary.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    public DatabaseManager(Database database) {
        this.database = database;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (this.database == Database.SQL_SERVER) {
            return getSqlServerConnection();
        } else if (this.database == Database.MYSQL) {
            return getMySQLConnection();
        }
        return null;
    }

    public String getTable() {
        if (this.database == Database.SQL_SERVER) {
            return SQLSERVER_TABLE_NAME;
        } else if (this.database == Database.MYSQL) {
            return MYSQL_TABLE_NAME;
        }
        return null;
    }

    private Connection getSqlServerConnection() throws ClassNotFoundException, SQLException {
        Class.forName(SQLSERVER_DRIVER);
        String connectionString = String.format("jdbc:%s://%s:%d;databaseName=%s;user=%s;password=%s",
                SQLSERVER_JDBC, SQLSERVER_DATABASE_HOST, SQLSERVER_DATABASE_PORT, SQLSERVER_DATABASE_NAME, SQLSERVER_USER_NAME, SQLSERVER_USER_PASSWORD);
        System.out.println(connectionString);
        return DriverManager.getConnection(connectionString);
    }

    private Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
        Class.forName(MYSQL_DRIVER);
        String connectionString = String.format("jdbc:%s://%s:%d/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                MYSQL_JDBC, MYSQL_DATABASE_HOST, MYSQL_DATABASE_PORT, MYSQL_DATABASE_NAME);
        System.out.println(connectionString);
        return DriverManager.getConnection(connectionString, MYSQL_USER_NAME, MYSQL_USER_PASSWORD);
    }

    public static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String SQLSERVER_JDBC = "sqlserver";
    public static final String MYSQL_JDBC = "mysql";

    public static final String SQLSERVER_DATABASE_HOST = "192.168.0.11";
    public static final String MYSQL_DATABASE_HOST = "localhost";

    public static final int SQLSERVER_DATABASE_PORT = 1433;
    public static final int MYSQL_DATABASE_PORT = 3306;

    public static final String SQLSERVER_DATABASE_NAME = "JEELibrary";
    public static final String MYSQL_DATABASE_NAME = "JEELibrary";

    public static final String SQLSERVER_TABLE_NAME = "dbo.Student";
    public static final String MYSQL_TABLE_NAME = "student";

    public static final String SQLSERVER_USER_NAME = "sa";
    public static final String MYSQL_USER_NAME = "root";

    public static final String SQLSERVER_USER_PASSWORD = "H0l@";
    public static final String MYSQL_USER_PASSWORD = "";

    private final Database database;

    public enum Database {
        SQL_SERVER,
        MYSQL
    }
}
