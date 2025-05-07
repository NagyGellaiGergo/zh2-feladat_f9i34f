package hu.pte.mik.prog4.zh2.repository;

import javax.sql.DataSource;
import java.sql.Connection;

public abstract class Repository {

    private static DataSource dataSource;

    protected Connection getConnection() {
        throw new UnsupportedOperationException();
    }

    private static DataSource getDataSource() {
        throw new UnsupportedOperationException();
    }

}
