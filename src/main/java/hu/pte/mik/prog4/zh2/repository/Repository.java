package hu.pte.mik.prog4.zh2.repository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Repository {

    private static final String JNDI_DATASOURCE_NAME = "jdbc/MariaDB";
    private static final String ROOT_CONTEXT = "java:comp/env";

    private static DataSource dataSource;

    protected Connection getConnection() throws SQLException, NamingException {
        return getDataSource().getConnection();
    }

    private static DataSource getDataSource() throws NamingException {

        if (dataSource == null) {
            Context context = new InitialContext();
            Context ctx = (Context) context.lookup(ROOT_CONTEXT);
            dataSource = (DataSource) ctx.lookup(JNDI_DATASOURCE_NAME);
        }

        return dataSource;
    }

}
