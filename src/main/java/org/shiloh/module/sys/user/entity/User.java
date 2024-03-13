package org.shiloh.module.sys.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

/**
 * 系统用户信息实体
 * {@link TableName} 表名称注解，标识实体类对应的表
 *
 * @author shiloh
 * @date 2023/2/4 16:50
 */
@Data
@TableName("UserInfo")
public class User {
    /**
     * ID
     * {@link TableId} 主键注解：value = 数据库表主键字段名称，type = 主键类型，auto = 主键自增
     *
     * @see com.baomidou.mybatisplus.annotation.IdType
     */
    @TableId(value = "Id", type = AUTO)
    private Long id;

    /**
     * 用户名
     * {@link TableField} 字段注解（非主键），value = 数据库表字段名称
     */
    @TableField("Username")
    private String username;

    /**
     * 性别：未知 / 男 / 女
     */
    @TableField("Sex")
    private String sex;

    /**
     * 年龄
     */
    @TableField("Age")
    private Integer age;

    /**
     * 电子邮箱
     */
    @TableField("Email")
    private String email;

    /**
     * 逻辑删除标识
     * <p>
     * {@link TableLogic} 逻辑删除字段处理注解
     * <p>
     * {@code true} = 逻辑删除，{@code false} = 逻辑未删除
     */
    @TableLogic
    @TableField("Deleted")
    private Boolean deleted;
}
