package org.shiloh.module.sys.user.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.shiloh.module.sys.user.entity.User;

/**
 * 系统用户信息 Mapper
 *
 * @author shiloh
 * @date 2023/2/4 16:51
 */
@Mapper
public interface UserMapper extends MPJBaseMapper<User> {
    /**
     * 根据 ID 查询用户年龄
     *
     * @param id ID
     * @return 用户年龄
     * @author shiloh
     * @date 2023/2/5 15:12
     */
    Integer selectAgeById(@Param("id") Long id);
}
