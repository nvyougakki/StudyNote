package com.uniware.bean;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @ClassName Role
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 16:28
 */
@Data
@Entity(name = "camp_role")
public class Role {

    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "role_name")
    private String roleName;


}
