package org.shiloh.module.sys.user.entity.dto;

import lombok.Data;

/**
 * 用户信息 DTO
 *
 * @author shiloh
 * @date 2024/3/11 22:22
 */
@Data
public class UserDto {
    /**
     * 用户 ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 城市
     */
    private String city;

    /**
     * 详细地址
     */
    private String address;
}
