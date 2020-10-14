package org.apache.shardingsphere.benchmark.db.shardingjdbc;

public enum ShardingConfigType {

    FULLROUTING_ENCRYPT_SHARDINGJDBC_CONFIG,
    FULLROUTING_MASTER_SLAVE_SHARDINGJDBC_CONFIG,
    FULLROUTING_SHARDING_SHARDINGJDBC_CONFIG,
    FULLROUTING_SHARDING_MASTERSLAVE_SHARDINGJDBC_CONFIG,
    RANGEROUTING_ENCRYPT_SHARDINGJDBC_CONFIG,
    RANGEROUTING_MASTER_SLAVE_SHARDINGJDBC_CONFIG,
    RANGEROUTING_SHARDING_SHARDINGJDBC_CONFIG,
    RANGEROUTING_SHARDING_MASTERSLAVE_SHARDINGJDBC_CONFIG,
    SINGLEROUTING_ENCRYPT_SHARDINGJDBC_CONFIG,
    SINGLEROUTING_MASTER_SLAVE_SHARDINGJDBC_CONFIG,
    SINGLEROUTING_SHARDING_SHARDINGJDBC_CONFIG,
    SINGLEROUTING_SHARDING_MASTERSLAVE_SHARDINGJDBC_CONFIG,
    FULLROUTING_SMALLSHARDS_SHARDING_SHARDINGJDBC_CONFIG,
    FULLROUTING_SMALLSHARDS_SHARDING_MASTERSLAVE_ENCRYPT_SHARDINGJDBC_CONFIG,

}