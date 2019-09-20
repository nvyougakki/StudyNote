package com.uniware.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 10:33
 */
@Data
@Entity(name = "camp_user")
public class User {

    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_c_name")
    private String userCName;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private int mobile;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "role_id")
    private int roleId;

    //@JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "camp_user_role",
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<Role> roles;


}
