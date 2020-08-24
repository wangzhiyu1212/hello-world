package com.example.helloworld.dao.shardingAlgorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

@Slf4j
public class PreciseShardingAlgorithmImpl implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        String dbName = "ds";
        Long val = shardingValue.getValue();
        Integer index = Integer.valueOf(String.valueOf(shardingValue.getValue()% 4 / 2));
        log.info("the index is " + index);
        dbName = dbName + index;
        log.info("the dbName is " + dbName);
        for (String each : availableTargetNames) {
            if (each.equals(dbName)) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
