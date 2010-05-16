package net.umask.common.user.domain;

import javax.persistence.Entity;
import java.util.Map;
import java.util.List;


@Entity
public class User {

    private String username;
    private String password;
    private String email;
    private String salt;
    private Map<String,String> properties;
    private List<Role> roles;
}
