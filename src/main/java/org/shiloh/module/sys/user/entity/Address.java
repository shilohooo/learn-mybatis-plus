package org.shiloh.module.sys.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 地址实体
 *
 * @author shiloh
 * @date 2024/3/11 22:02
 */
@Data
@TableName("AddressInfo")
public class Address {
    /**
     * 主键
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 城市
     */
    @TableField("City")
    private String city;

    /**
     * 地址
     */
    @TableField("Address")
    private String address;

    /**
     * @see User#getId()
     */
    @TableField("UserId")
    private Long userId;

    @TableLogic
    @TableField("Deleted")
    private Boolean deleted;
}
