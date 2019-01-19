package net.alientec.pfm.server.data;

import net.alientec.pfm.exceptions.DataSourceNotInitializedException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class PfmUserRecordSet {
    private ArrayList<PfmUserRow> rows;
    public ArrayList<PfmUserRow> getRows() {
        return rows;
    }
    public void setRows(ArrayList<PfmUserRow> rows) {
        this.rows = rows;
    }

    public PfmUserRecordSet(){
        this.rows = new ArrayList<PfmUserRow>();
    }

    public static PfmUserRecordSet getAllRows(DataSource dataSource) throws DataSourceNotInitializedException, SQLException {
        // Method contract
        if (dataSource == null) throw new IllegalArgumentException();
        try {
            if (dataSource.getConnection() == null) throw new DataSourceNotInitializedException();
        } catch (SQLException e) {
            throw new DataSourceNotInitializedException(e);
        }

        PfmUserRecordSet result = new PfmUserRecordSet();

        // Select from DB
        String select = "SELECT user_id, username FROM pfm_users ORDER BY username";

        // DB access
        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()) {
            UUID user_id = (java.util.UUID) rs.getObject("user_id");
            String user_name = rs.getString("username");
            PfmUserRow row = PfmUserRow.fromDb(user_id, user_name);
            result.rows.add(row);
        }
        return result;
    }
}
