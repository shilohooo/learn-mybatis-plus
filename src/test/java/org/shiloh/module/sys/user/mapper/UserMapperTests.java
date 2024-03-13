package org.shiloh.module.sys.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.shiloh.module.sys.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 系统用户信息 Mapper 单元测试
 *
 * @author shiloh
 * @date 2023/2/4 16:53
 */
@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试查询所有用户信息
     *
     * @author shiloh
     * @date 2023/2/4 16:53
     */
    @Test
    public void testSelectAllUsers() {
        // 传 null 代表没有查询参数
        final List<User> users = this.userMapper.selectList(null);
        assertThat(users).isNotEmpty();
    }

    /**
     * 测试插入一条用户数据
     *
     * @author shiloh
     * @date 2023/2/4 17:11
     */
    @Test
    public void testInsertUser() {
        final User user = new User();
        user.setUsername("老李头");
        user.setEmail("lixiaolei595@gmail.com");
        user.setSex("男");
        user.setAge(25);
        final int effectedRows = this.userMapper.insert(user);
        assertThat(effectedRows).isEqualTo(1);
        assertThat(user.getId()).isNotNull();
    }

    /**
     * 测试根据 ID 删除用户
     *
     * @author shiloh
     * @date 2023/2/4 17:17
     */
    @Test
    public void testDeleteUserById() {
        final int effectedRows = this.userMapper.deleteById(6);
        assertThat(effectedRows).isEqualTo(1);
    }

    /**
     * 测试更新用户信息
     *
     * @author shiloh
     * @date 2023/2/4 17:18
     */
    @Test
    public void testUpdateUser() {
        final User user = new User();
        user.setId(5L);
        user.setUsername("Robot01");
        // 更新时会跳过值为 null 的字段
        final int effectRows = this.userMapper.updateById(user);
        assertThat(effectRows).isEqualTo(1);
    }

    /**
     * 测试使用 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper} 构建查询条件，查询用户信息
     * <p>
     * {@link QueryWrapper} 的缺点：字段名称为硬编码
     *
     * @author shiloh
     * @date 2023/2/5 14:20
     */
    @Test
    public void testSelectUserByQueryWrapper() {
        // 查询性别为：男的用户信息
        assertThat(this.userMapper.selectList(new QueryWrapper<User>().eq("Sex", "男")))
                .isNotEmpty();
        // 查询年龄在 20 - 30 之间的用户信息
        assertThat(this.userMapper.selectList(new QueryWrapper<User>().between("Age", 20, 30)))
                .isNotEmpty();
        // 查询用户名包含字母 "o" 的用户信息
        assertThat(this.userMapper.selectList(new QueryWrapper<User>().like("Username", "o")))
                .isNotEmpty();
        // 查询性别为 "男" / "女" 的用户信息
        assertThat(
                this.userMapper.selectList(
                        new QueryWrapper<User>()
                                .eq("Sex", "男")
                                .or()
                                .eq("Sex", "女")
                )
        )
                .isNotEmpty();
        // 查询性别为 "男"，且年龄大于等于20岁的用户信息
        assertThat(
                this.userMapper.selectList(
                        new QueryWrapper<User>()
                                .eq("Sex", "男")
                                .ge("Age", 20)
                )
        )
                .isNotEmpty();
        // 查询所有用户信息，按照年龄降序排序
        assertThat(this.userMapper.selectList(new QueryWrapper<User>().orderByDesc("Age")))
                .isNotEmpty();
    }

    /**
     * 测试使用 {@link com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper} 构建查询条件，查询用户信息
     * <p>
     * {@link com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper} 对于字段名称无需硬编码，
     * 仅需要使用方法引用的方式指定实体字段名称，框架会自动映射为表字段名称
     *
     * @author shiloh
     * @date 2023/2/5 14:37
     */
    @Test
    public void testSelectUserByLambdaQueryWrapper() {
        // 查询性别为：男的用户信息
        assertThat(this.userMapper.selectList(new LambdaQueryWrapper<User>().eq(User::getSex, "男")))
                .isNotEmpty();
        // 查询年龄在 20 - 30 之间的用户信息
        assertThat(this.userMapper.selectList(new LambdaQueryWrapper<User>().between(User::getAge, 20, 30)))
                .isNotEmpty();
        // 查询用户名包含字母 "o" 的用户信息
        assertThat(this.userMapper.selectList(new LambdaQueryWrapper<User>().like(User::getUsername, "o")))
                .isNotEmpty();
        // 查询性别为 "男" / "女" 的用户信息
        assertThat(
                this.userMapper.selectList(
                        new LambdaQueryWrapper<User>()
                                .eq(User::getSex, "男")
                                .or()
                                .eq(User::getSex, "女")
                )
        )
                .isNotEmpty();
        // 查询性别为 "男"，且年龄大于等于20岁的用户信息
        assertThat(
                this.userMapper.selectList(
                        new LambdaQueryWrapper<User>()
                                .eq(User::getSex, "男")
                                .ge(User::getAge, 20)
                )
        )
                .isNotEmpty();
        // 查询所有用户信息，按照年龄降序排序
        assertThat(this.userMapper.selectList(new LambdaQueryWrapper<User>().orderByDesc(User::getAge)))
                .isNotEmpty();
    }

    /**
     * 测试使用 {@link QueryWrapper} 构建查询条件，更新用户信息
     *
     * @author shiloh
     * @date 2023/2/5 14:48
     */
    @Test
    public void testUpdateUserByQueryWrapper() {
        final User user = new User();
        user.setId(5L);
        user.setUsername("Bruce Lee");
        assertThat(this.userMapper.update(user, new QueryWrapper<User>().eq("Id", user.getId())))
                .isEqualTo(1);
    }

    /**
     * 测试使用 {@link com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper} 更新用户信息
     * <p>
     * {@link UpdateWrapper} 缺点：字段名称硬编码
     *
     * @author shiloh
     * @date 2023/2/5 14:51
     */
    @Test
    public void testUpdateUserByUpdateWrapper() {
        assertThat(
                this.userMapper.update(
                        // 第一个参数为 entity，如果传 null 则代表使用第二个参数 updateWrapper 来执行更新操作
                        null,
                        new UpdateWrapper<User>()
                                .set("Age", 30)
                                .eq("Id", 5)
                )
        )
                .isEqualTo(1);
    }

    /**
     * 测试使用 {@link com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper} 更新用户信息
     *
     * @author shiloh
     * @date 2023/2/5 14:55
     */
    @Test
    public void testUpdateUserByLambdaUpdateWrapper() {
        assertThat(
                this.userMapper.update(
                        null,
                        new LambdaUpdateWrapper<User>()
                                .set(User::getSex, "女")
                                .eq(User::getId, 5L)
                )
        )
                .isEqualTo(1);
    }

    /**
     * 测试分页查询
     *
     * @author shiloh
     * @date 2023/2/5 15:00
     */
    @Test
    public void testSelectUserByPage() {
        // limit index, rows
        // index = (index - 1) * rows
        final Page<User> page = new Page<>(1L, 3L);
        this.userMapper.selectPage(page, null);
        assertThat(page).isNotNull();
        // 总页数
        assertThat(page.getPages()).isGreaterThan(0);
        // 总记录数
        assertThat(page.getTotal()).isGreaterThan(0);
        // 分页数据列表
        assertThat(page.getRecords()).isNotEmpty();
        // 是否还有上一页
        assertThat(page.hasPrevious()).isFalse();
        // 是否还有下一页
        assertThat(page.hasNext()).isTrue();
    }

    /**
     * 测试根据 ID 查询用户年龄
     *
     * @author shiloh
     * @date 2023/2/5 15:13
     */
    @Test
    public void testSelectAgeById() {
        assertThat(this.userMapper.selectAgeById(5L))
                .isNotNull();
    }
}