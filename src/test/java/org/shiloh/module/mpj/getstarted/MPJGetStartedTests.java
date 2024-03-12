package org.shiloh.module.mpj.getstarted;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.shiloh.module.mpj.base.MPJBaseTests;
import org.shiloh.module.sys.user.entity.Address;
import org.shiloh.module.sys.user.entity.User;
import org.shiloh.module.sys.user.entity.dto.UserDto;

import java.util.List;

/**
 * mybatis-plus-join 单元测试
 *
 * @author shiloh
 * @date 2024/3/11 22:27
 */
public class MPJGetStartedTests extends MPJBaseTests {
    /**
     * 关联查询测试
     *
     * @author shiloh
     * @date 2024/3/11 22:29
     */
    @Test
    public void testSelect() {
        // 推荐使用带 class 类型的构造器
        // MPJLambdaWrapper类的泛型必须是主表类型, 并且要用主表对应的Mapper调用
        final MPJLambdaWrapper<User> wrapper = new MPJLambdaWrapper<>(User.class)
                // 查询 User 表全部字段
                .selectAll(User.class)
                // 查询地址表中的 city、address 字段
                .select(Address::getCity, Address::getAddress)
                .leftJoin(Address.class, Address::getUserId, User::getId);
        final List<UserDto> users = this.userMapper.selectJoinList(UserDto.class, wrapper);
        Assertions.assertThat(users)
                .isNotEmpty();
        users.forEach(System.out::println);
    }
}
