// Copyright 2020 Kelin Inc. All rights reserved.

package com.kelin.easy.hbase;

import com.kelin.easy.hbase.common.bean.HBaseConnectionService;
import com.kelin.easy.hbase.core.HBaseService;
import com.kelin.easy.hbase.core.HBaseServiceImpl;
import com.kelin.easy.hbase.systest.FakeHBaseConnectionService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author Kelin Tan
 */
@Configuration
public class HBaseTestAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(HBaseService.class)
    @Primary
    public HBaseService createFakeHBaseService() {
        HBaseConnectionService connectionService = new FakeHBaseConnectionService();
        return new HBaseServiceImpl(connectionService);
    }
}
