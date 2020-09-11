package com.yffd.jecap.admin.domain.sys.user.service;

import com.alibaba.fastjson.JSON;
import com.yffd.jecap.admin.BaseTest;
import com.yffd.jecap.admin.domain.sys.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class SysUserServiceTest extends BaseTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void addTest() {
        SysUser entity = new SysUser();
        entity.setLoginName("lisi");
        entity.setUserName("李四-123");
        this.sysUserService.add(entity);
    }

    @Test
    public void updateByIdTest() {
        SysUser old = new SysUser();
        old.setId("1303982227998240769");
        SysUser entity = new SysUser();
//        entity.setId("1303982227998240769");
        entity.setUserName("李四-abc");
        this.sysUserService.updateById(entity);

        this.sysUserService.updateBy(old, entity);
    }

    @Test
    public void deleteByIdTest() {
        this.sysUserService.deleteById("1303982227998240769");
    }

    @Test
    public void getListTest() {
        SysUser entity = new SysUser();
        entity.setUserName("李四");
        List<SysUser> list = this.sysUserService.getList(entity);
        System.out.println(JSON.toJSONString(list));
    }
}
