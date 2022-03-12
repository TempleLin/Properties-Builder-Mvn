package builders;

//Properties builder for Hibernate.
public class HibPropsBuilder extends PropertiesBuilder{
    public HibPropsBuilder() {
        super();
    }

    //JDBC Database connection settings:
    public HibPropsBuilder setConDriveClass(DRIVER value) {
        switch (value) {
            case MySql -> setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            case Oracle -> setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
            case SQLServer -> setProperty("hibernate.connection.driver_class", "com.microsoft.jdbc.sqlserver.SqlServerDriver");
            case PostgreSQL -> setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        }
        return this;
    }

    //URL to database: (WARNING: at IntelliJ, "&" character might get converted to "&amp" automatically. App will fail if happens.)
    public HibPropsBuilder setConUrl(String value) {
        properties.setProperty("hibernate.connection.url", value);
        return this;
    }

    //Username to the database:
    public HibPropsBuilder setConUsername(String value) {
        properties.setProperty("hibernate.connection.username", value);
        return this;
    }
    //Password to the database:
    public HibPropsBuilder setConPassword(String value) {
        properties.setProperty("hibernate.connection.password", value);
        return this;
    }
    //JDBC connection pool settings ... using built-in test pool:
    public HibPropsBuilder setConPoolSize(int value) {
        properties.setProperty("hibernate.connection.pool_size", Integer.toString(value));
        return this;
    }
    /*
    hbm2ddl.auto is used to validate and exports schema DDL to the database when the SessionFactory is created.
        If the value is CREATE then the hibernate first drops the existing tables data and structure,
            then creates new tables and executes the operations on the newly created tables.
            The only problem with the value “create” is, we lose existing table data.
        If the value is update then, Hibernate checks for the table and columns.
            If a table doesn’t exist then it creates new tables and where as if a column doesn’t exist it creates new columns for it.
            But in the case of value “update” hibernate doesn’t drop any existing table, so that we don’t lose existing table data.
        The value “create-drop” is given for unit testing the hibernate co
        In this statement, its property is set to "update". Therefore, table with columns will get generated if doesn't exist.
            And if exists, Hibernate won't let lose existing values but updates them.
     */
    public HibPropsBuilder set_hbm2ddl_auto(HBM2DDL_AUTO value) {
        switch (value) {
            case CREATE-> properties.setProperty("hibernate.hbm2ddl.auto", "create");
            case UPDATE-> properties.setProperty("hibernate.hbm2ddl.auto", "update");
            case VALIDATE-> properties.setProperty("hibernate.hbm2ddl.auto", "validate");
            case CREATE_DROP-> properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        }
        return this;
    }

    //Select our SQL dialect. Each database has its own dialect. Often uses the MySQL dialect.
    public HibPropsBuilder setDialect(DIALECT value) {
        //(Using MYSQL 5 or above version server is required. Otherwise, "hibernate.hbm2ddl.auto" won't work.)
//        ex. MySQLDialect won't work with hibernate.hbm2ddl.auto.
        switch (value) {
            case MySQLDialect -> properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            case MySQL55Dialect -> properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
            case PostgreSQL -> properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            case MySQLInnoDBDialect -> properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
            case MySQLMyISAMDialect -> properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLMyISAMDialect");
            case SQLServerDialect -> properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        }
        return this;
    }

    //Echo the SQL to stdout. When Hibernate executes, it'll print out the SQL when sending to database.
    public HibPropsBuilder setShowSQL(boolean value) {
        properties.setProperty("hibernate.show_sql", Boolean.toString(value));
        return this;
    }

    //Set the current session context. If set to thread, the session context will use the threaded model.
    public HibPropsBuilder setCurrContextClass(CURR_CONTEXT value) {
        switch (value) {
            case JTA -> properties.setProperty("hibernate.current_session_context_class", "jta");
            case THREAD -> properties.setProperty("hibernate.current_session_context_class", "thread");
            case MANAGED -> properties.setProperty("hibernate.current_session_context_class", "managed");
        }
        return this;
    }

    public enum HBM2DDL_AUTO {
        VALIDATE, UPDATE, CREATE, CREATE_DROP
    }//hbm2ddl_auto
    public enum DIALECT {
        MySQLDialect,
        MySQL55Dialect,
        MySQLInnoDBDialect,         //MySQL with InnoDB
        MySQLMyISAMDialect,        //MySQL with MyISAM
        PostgreSQL,
        SQLServerDialect          //Microsoft SQL Server
    } //org.hibernate.dialect
    public enum CURR_CONTEXT {
        JTA, THREAD, MANAGED
    } //hibernate.current_session_context_class
    public enum DRIVER {
        MySql, PostgreSQL, Oracle, SQLServer
    } //hibernate.connection.driver_class
}
