package net.alientec.pfm.server;

import net.alientec.pfm.server.data.PfmDataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class PfmServerApplication  implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PfmServerApplication.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    //Global Variables (Horrible: to refactor)

    public static void main(String[] args)  {
        SpringApplication.run(PfmServerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        log.trace("BEGIN PfmServerApplication.run(" + strings.toString() + ")");

        // Init data source
        if (jdbcTemplate == null) {
            log.error("JDBC Environment not initialized. JdbcTemplate is NULL");
        }
        else if (jdbcTemplate.getDataSource() == null) {
            log.error("JDBC Environment not initialized. DataSource is NULL");
        }
        else {
            dataSource = jdbcTemplate.getDataSource();
            try {
                log.info("Data Source initialized.: " + dataSource.getConnection().getMetaData().getDatabaseProductName() + " V: " + dataSource.getConnection().getMetaData().getDatabaseProductVersion());

                // Init the PfmDataStore
                PfmDataStore.initialize(dataSource);
            }
            catch (SQLException e)
            {
                log.error("Could not access database information.", e);
                throw e;
            }
        }

        log.trace("END PfmServerApplication");
    }
}

