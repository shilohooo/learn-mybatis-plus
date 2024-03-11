package org.shiloh.module.sys.user.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.shiloh.module.sys.user.entity.Address;

/**
 * 地址信息 Mapper
 *
 * @author shiloh
 * @date 2024/3/11 22:26
 */
@Mapper
public interface AddressMapper extends MPJBaseMapper<Address> {
}
