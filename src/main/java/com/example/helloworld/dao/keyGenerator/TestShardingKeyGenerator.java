package com.example.helloworld.dao.keyGenerator;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;
import java.util.UUID;

@Slf4j
public class TestShardingKeyGenerator  implements ShardingKeyGenerator {
    @Override
    public Comparable<?> generateKey() {
        String idString = UUID.randomUUID().toString();
        Long id = Long.valueOf(idString.hashCode());
        log.info(String.valueOf(Math.abs(id)));
        return Math.abs(id);
    }

    @Override
    public String getType() {
        return "TestShardingKeyGenerator";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }

}
