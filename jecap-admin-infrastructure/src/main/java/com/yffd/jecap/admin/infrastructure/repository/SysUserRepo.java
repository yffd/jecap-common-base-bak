package com.yffd.jecap.admin.infrastructure.repository;

import com.yffd.jecap.admin.domain.sys.user.entity.SysUser;
import com.yffd.jecap.admin.domain.sys.user.repo.ISysUserRepo;
import com.yffd.jecap.admin.infrastructure.dao.SysUserDao;
import com.yffd.jecap.common.base.dao.IBaseDao;
import com.yffd.jecap.common.base.repository.AbstractBaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SysUserRepo extends AbstractBaseRepo<SysUser> implements ISysUserRepo {
    @Autowired private SysUserDao sysUserDao;

    @Override
    protected IBaseDao<SysUser> getDao() {
        return sysUserDao;
    }

}
