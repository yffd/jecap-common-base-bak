package com.yffd.jecap.admin.domain.sys.user.service;

import com.yffd.jecap.admin.domain.sys.user.entity.SysUser;
import com.yffd.jecap.admin.domain.sys.user.repo.ISysUserRepo;
import com.yffd.jecap.common.base.repository.IBaseRepo;
import com.yffd.jecap.common.base.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService extends AbstractBaseService<SysUser> {
    @Autowired private ISysUserRepo sysUserRepo;

    @Override
    protected IBaseRepo getRepo() {
        return sysUserRepo;
    }
}
