package org.shiloh.module.mpj.mapper;

import com.github.yulichang.interfaces.MPJBaseJoin;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.UpdateJoinWrapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.shiloh.module.mpj.base.MPJBaseTests;
import org.shiloh.module.sys.user.entity.Address;
import org.shiloh.module.sys.user.entity.User;

/**
 * MyBatisPlus 连表更新单元测试
 *
 * @author shiloh
 * @date 2024/3/12 21:39
 */
public class MPJUpdateJoinTests extends MPJBaseTests {
    /**
     * 连表更新测试
     *
     * @author shiloh
     * @date 2024/3/12 21:43
     */
    @Test
    public void testUpdateJoin() {
        final UpdateJoinWrapper<User> wrapper = JoinWrappers.update(User.class)
                // 设置要更新的字段
                .set(User::getUsername, "update-join-test")
                .set(Address::getAddress, "update-join-test")
                // 连表设置
                .leftJoin(Address.class, Address::getUserId, User::getId)
                // 更新条件
                .eq(User::getId, 3L);
        Assertions.assertThat(this.userMapper.updateJoin(null, wrapper))
                .isEqualTo(2L);
    }

    /**
     * 根据实体连表更新，wrapper 作为 where 条件
     * <p>
     * 注意：实体类只更新非空字段, 如果要更新全部字段(非空字段和空字段)，
     * <p>
     * 可以使用 {@link com.github.yulichang.base.MPJBaseMapper#updateJoinAndNull(Object, MPJBaseJoin)} 方法
     *
     * @author shiloh
     * @date 2024/3/12 21:47
     */
    @Test
    public void testUpdateJoinByEntity() {
        final User user = new User();
        user.setUsername("update join by entity");
        user.setAge(30);
        final UpdateJoinWrapper<User> wrapper = JoinWrappers.update(User.class)
                .leftJoin(Address.class, Address::getUserId, User::getId)
                .eq(User::getId, 4L);
        Assertions.assertThat(this.userMapper.updateJoin(user, wrapper))
                .isEqualTo(1L);
    }

    /**
     * 根据实体和 wrapper 连表更新
     * <p>
     * 主表根据实体更新，副表手动设置 set 语句
     *
     * @author shiloh
     * @date 2024/3/12 21:51
     */
    @Test
    public void testUpdateJoinByEntityAndWrapper() {
        final User user = new User();
        user.setUsername("update join by entity and wrapper");
        user.setAge(10);
        final UpdateJoinWrapper<User> wrapper = JoinWrappers.update(User.class)
                // 设置副表 set 语句
                .set(Address::getAddress, "update join by entity and wrapper")
                .leftJoin(Address.class, Address::getUserId, User::getId)
                .eq(User::getId, 5L);
        Assertions.assertThat(this.userMapper.updateJoin(user, wrapper))
                .isEqualTo(2L);
    }

    /**
     * 根据主表和副表实体类进行连表更新，wrapper 作为 where 条件
     *
     * @author shiloh
     * @date 2024/3/12 21:54
     */
    @Test
    public void testUpdateJoinByEntities() {
        final User user = new User();
        user.setUsername("update join by entities");
        user.setAge(40);
        final Address address = new Address();
        address.setAddress("update join by entities");
        final UpdateJoinWrapper<User> wrapper = JoinWrappers.update(User.class)
                // 设置副表更新实体，用于生成 set 语句，只更新非空字段
                .setUpdateEntity(address)
                // 设置副表更新实体，用于生成 set 语句，非空字段和空字段一起更新
                // .setUpdateEntityAndNull(address)
                .leftJoin(Address.class, Address::getUserId, User::getId)
                .eq(User::getId, 3L);
        Assertions.assertThat(this.userMapper.updateJoin(user, wrapper))
                .isEqualTo(2L);
    }
}
