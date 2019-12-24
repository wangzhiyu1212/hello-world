//package com.example.helloworld.sharding;
//
//import java.util.Collection;
//
//import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
//import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
//
//public class PreciseShardingAlgorithmImpl implements PreciseShardingAlgorithm<Long> {
//	@Override
//    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
//        String dbName = "ds";
//        Long val = shardingValue.getValue();
//        dbName += val;
//        for (String each : availableTargetNames) {
//            if (each.equals(dbName)) {
//                return each;
//            }
//        }
//        throw new IllegalArgumentException();
//    }
//}
