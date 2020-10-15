package io.jayms.dbsc.interfaces.model;

public enum DatabaseType {

    SQLITE("org.sqlite.SQLiteDataSource"),
    ORACLE("oracle.jdbc.pool.OracleDataSource");

    private String dataSourceClassName;

    private DatabaseType(String dataSourceClassName) {
        this.dataSourceClassName = dataSourceClassName;
    }

    public String getDataSourceClassName() {
        return dataSourceClassName;
    }
}
