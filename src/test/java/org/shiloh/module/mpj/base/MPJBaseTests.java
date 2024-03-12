package org.shiloh.module.mpj.base;

import org.shiloh.module.sys.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * MyBatisPlusJoin 单元测试基类
 *
 * @author shiloh
 * @date 2024/3/12 21:41
 */
@SpringBootTest
public class MPJBaseTests {
    @Autowired
    protected UserMapper userMapper;
}
