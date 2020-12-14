package com.itheima.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;


    public static final String SESSION_USER_KRY = "_user";


    /*** 用户权限 */
    private Set<String> authorities;




}
