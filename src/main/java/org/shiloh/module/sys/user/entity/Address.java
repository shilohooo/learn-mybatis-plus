package org.shiloh.module.sys.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 地址实体
 *
 * @author shiloh
 * @date 2024/3/11 22:02
 */
@Data
@TableName("tb_address")
public class Address {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 城市
     */
    private String city;

    /**
     * 地址
     */
    private String address;

    /**
     * @see User#getId()
     */
    private Long userId;

    @TableLogic
    private Boolean deleted;
}
