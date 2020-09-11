package com.yffd.jecap.admin.domain.sys.user.service;

import com.alibaba.fastjson.JSON;
import com.yffd.jecap.admin.AdminBaseTest;
import com.yffd.jecap.admin.domain.sys.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class SysUserServiceTest extends AdminBaseTest {
    @Autowired
    private SysUserService sysUserDomainService;

    @Test
    public void addTest() {
        SysUser entity = new SysUser();
        entity.setUserName("李四-123");
        this.sysUserDomainService.add(entity);
    }

    @Test
    public void getListTest() {
        SysUser entity = new SysUser();
        entity.setUserName("李四");
        List<SysUser> list = this.sysUserDomainService.getList(entity);
        System.out.println(JSON.toJSONString(list));
    }
}
