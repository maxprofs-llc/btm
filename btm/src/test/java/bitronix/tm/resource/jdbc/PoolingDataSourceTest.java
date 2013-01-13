package bitronix.tm.resource.jdbc;

import bitronix.tm.mock.resource.jdbc.MockitoXADataSource;
import junit.framework.TestCase;

import java.sql.Connection;

/**
 * @author Ludovic Orban
 */
public class PoolingDataSourceTest extends TestCase {

    public void testInjectedXaFactory() throws Exception {
        PoolingDataSource pds = new PoolingDataSource();
        try {
            pds.setUniqueName("pds");
            pds.setMinPoolSize(1);
            pds.setMaxPoolSize(1);
            pds.setXaDataSource(new MockitoXADataSource());

            pds.init();

            Connection connection = pds.getConnection();

            connection.close();
        } finally {
            pds.close();
        }
    }

}
