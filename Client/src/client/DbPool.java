package client;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.UniversalConnectionPoolAdapter;
import oracle.ucp.UniversalConnectionPoolException;
import oracle.ucp.admin.UniversalConnectionPoolManager;
import oracle.ucp.admin.UniversalConnectionPoolManagerImpl;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;


public class DbPool {
    private UniversalConnectionPoolManager mgr;
    private PoolDataSource pds;
    private Connection conn;
        
    public DbPool(String dburl, String dbuser, String dbpass) throws SQLException, UniversalConnectionPoolException {
        mgr = UniversalConnectionPoolManagerImpl.getUniversalConnectionPoolManager();        

        pds = PoolDataSourceFactory.getPoolDataSource();
        pds.setConnectionPoolName("mgr_pool");
        pds.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
        pds.setURL(dburl);
        pds.setUser(dbuser);
        pds.setPassword(dbpass);

        mgr.createConnectionPool((UniversalConnectionPoolAdapter)pds);        
    }
    

    public void Close() throws SQLException {
        if (!conn.isClosed()){
            conn.close();
            conn=null;
            //System.out.println("Conn closed.");
        }

    }

    public void Destroy() throws SQLException {
         try {
            pds.removeConnectionAffinityCallback();
            mgr.purgeConnectionPool("mgr_pool");
            mgr.destroyConnectionPool("mgr_pool");
        } catch (UniversalConnectionPoolException e) {
        }
    }    
    
    public Connection OpenConnection() throws SQLException {
        conn = pds.getConnection();        
        return conn;
    }
    
}
