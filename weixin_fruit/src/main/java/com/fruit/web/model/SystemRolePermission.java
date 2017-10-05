package com.fruit.web.model;

import com.fruit.core.persistence.convention.annotation.GeneratedValue;
import com.fruit.core.persistence.convention.annotation.Id;

public class SystemRolePermission {
	
	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}