package org.shiloh.common.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisPlus 配置
 *
 * @author shiloh
 * @date 2023/2/5 14:57
 */
@Configuration
@MapperScan("org.shiloh.module.sys.user.mapper")
public class MyBatisPlusConfig {
    /**
     * MyBatisPlus 拦截器配置
     *
     * @author shiloh
     * @date 2023/2/5 14:58
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        final MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加内部拦截器（插件）
        // 添加分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
