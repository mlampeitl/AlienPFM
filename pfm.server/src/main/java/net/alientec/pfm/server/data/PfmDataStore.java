package net.alientec.pfm.server.data;

import net.alientec.pfm.data.PfmUser;
import net.alientec.pfm.exceptions.DataSourceNotInitializedException;
import net.alientec.pfm.exceptions.PfmSQLException;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PfmDataStore {

    private static DataSource dataSource;

    private static void setDataSource(DataSource ds){
        dataSource = ds;
    }
    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection() throws PfmSQLException, DataSourceNotInitializedException {
        try {
            if(dataSource == null) throw new DataSourceNotInitializedException();
            return dataSource.getConnection();
        }
        catch (SQLException e)
        {
            throw new PfmSQLException(e);
        }
    }

    public static void initialize(DataSource ds) throws IllegalArgumentException {
        //Method contract
        if(ds == null) throw new IllegalArgumentException();

        // initialize the data source object
        setDataSource(ds);
    }

    public static List<PfmUser> getPfmUsers() throws Exception {
        PfmUserRecordSet rs = PfmUserRecordSet.getAllRows(dataSource);
        List<PfmUser> result = new ArrayList<PfmUser>();

        for(PfmUserRow row : rs.getRows()){
            PfmUser u = new PfmUser();
            u.setUserId(row.getUserId());
            u.setUsername(row.getUsername());
            result.add(u);
        }

        return result;
    }
}
