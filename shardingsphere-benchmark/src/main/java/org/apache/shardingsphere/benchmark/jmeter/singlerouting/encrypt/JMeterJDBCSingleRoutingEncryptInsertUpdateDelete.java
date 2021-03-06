package org.apache.shardingsphere.benchmark.jmeter.singlerouting.encrypt;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.shardingsphere.benchmark.db.jdbc.JDBCDataSourceUtil;
import org.apache.shardingsphere.benchmark.jmeter.JMeterBenchmarkBase;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JMeterJDBCSingleRoutingEncryptInsertUpdateDelete extends JMeterBenchmarkBase {

    public static DataSource dataSource;

    static {
        dataSource = JDBCDataSourceUtil.initDb((String) dbConfig.get("jdbc.benchmark.singlerouting.encrypt.ds0.datasource"),
                (String) dbConfig.get("jdbc.benchmark.singlerouting.encrypt.ds0.host"), (int) dbConfig.get("jdbc.benchmark.singlerouting.encrypt.ds0.port"),
                (String) dbConfig.get("jdbc.benchmark.singlerouting.encrypt.ds0.username"), (String) dbConfig.get("jdbc.benchmark.singlerouting.encrypt.ds0.password"));
    }

    @Override
    public SampleResult runTest(JavaSamplerContext context) {

        ResultSet rs = null;
        SampleResult results = new SampleResult();
        results.setSampleLabel("SJPerformanceMSInsert");
        results.sampleStart();
        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            String insertSql = (String) sqlConfig.get("jdbc.benchmark.singlerouting.encrypt.insert.sql");
            List insertParams = convertParams((List) sqlConfig.get("jdbc.benchmark.singlerouting.encrypt.insert.values"));
            rs = JDBCDataSourceUtil.insert(connection, insertSql, insertParams);
            rs.next();
            Long id = rs.getLong(1);

            String updateSql = (String) sqlConfig.get("jdbc.benchmark.singlerouting.encrypt.update.sql");
            List updateParams = convertParams((List) sqlConfig.get("jdbc.benchmark.singlerouting.encrypt.update.values"));
            updateParams.add(id);
            JDBCDataSourceUtil.update(connection, updateSql, updateParams);

            String deleteSql = (String) sqlConfig.get("jdbc.benchmark.singlerouting.encrypt.delete.sql");
            List deleteParams = convertParams((List) sqlConfig.get("jdbc.benchmark.singlerouting.encrypt.delete.values"));
            deleteParams.add(id);
            JDBCDataSourceUtil.delete(connection, deleteSql, deleteParams);

            results.setSuccessful(true);
        } catch (SQLException e) {
            results.setSuccessful(false);
            e.printStackTrace();
        } catch (Exception e) {
            results.setSuccessful(false);
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            results.sampleEnd();
        }

        return results;
    }
}