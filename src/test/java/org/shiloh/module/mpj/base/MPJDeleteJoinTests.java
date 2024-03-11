package org.shiloh.module.mpj.base;

import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.DeleteJoinWrapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.shiloh.module.sys.user.entity.Address;
import org.shiloh.module.sys.user.entity.User;
import org.shiloh.module.sys.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * mybatis-plus-join 连表删除单元测试
 *
 * @author shiloh
 * @date 2024/3/11 22:27
 */
@SpringBootTest
public class MPJDeleteJoinTests {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试连表删除 - 删除主表数据
     * <p>
     * 如果使用了MP的逻辑删除, 调用deleteJoin会执行Update语句
     *
     * @author shiloh
     * @date 2024/3/11 22:38
     */
    @Test
    public void testDeleteJoin() {
        final DeleteJoinWrapper<User> wrapper = JoinWrappers.delete(User.class)
                .leftJoin(Address.class, Address::getUserId, User::getId)
                .eq(User::getId, 1L);
        final int effectedRows = this.userMapper.deleteJoin(wrapper);
        Assertions.assertThat(effectedRows)
                .isEqualTo(1);
    }

    /**
     * 测试连表删除 - 删除全部表数据
     * <p>
     * MPJ支持都是物理删除或者都是逻辑删除, 不支持既有物理删除也有逻辑删除
     *
     * @author shiloh
     * @date 2024/3/11 22:42
     */
    @Test
    public void testDeleteAllJoin() {
        final DeleteJoinWrapper<User> wrapper = JoinWrappers.delete(User.class)
                // 删除全部的表数据（主表和副表）
                .deleteAll()
                // 删除指定的表数据
                // .delete(User.class)
                .leftJoin(Address.class, Address::getUserId, User::getId)
                .eq(User::getId, 2L);
        final int effectedRows = this.userMapper.deleteJoin(wrapper);
        Assertions.assertThat(effectedRows)
                .isEqualTo(2);
    }
}
