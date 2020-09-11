package com.yffd.jecap.admin.domain.sys.user.service;

import com.yffd.jecap.admin.domain.constant.AdminConsts;
import com.yffd.jecap.admin.domain.exception.AdminException;
import com.yffd.jecap.admin.domain.sys.user.entity.SysUser;
import com.yffd.jecap.admin.domain.sys.user.repo.ISysUserRepo;
import com.yffd.jecap.common.base.exception.DataExistException;
import com.yffd.jecap.common.base.repository.IBaseRepo;
import com.yffd.jecap.common.base.service.AbstractBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SysUserService extends AbstractBaseService<SysUser> {
    @Autowired private ISysUserRepo sysUserRepo;

    @Override
    protected IBaseRepo getRepo() {
        return sysUserRepo;
    }

    /**
     * 添加新用户
     * @param user
     */
    @Override
    public int add(SysUser user) {
        if (null == user || StringUtils.isBlank(user.getLoginName())) throw AdminException.cast("【登录名称】不能为空").prompt();
        if (this.existByLoginName(user.getLoginName())) throw DataExistException.cast("【登录名称】已存在");
        if (StringUtils.isBlank(user.getLoginPwd())) user.setLoginPwd(AdminConsts.DEF_LOGIN_PWD);
        return this.getRepo().save(user);
    }

    /**
     * 删除用户（逻辑删除）
     * @param id
     * @return
     */
    @Override
    public int deleteById(Serializable id) {
        if (null == id) return 0;
        SysUser entity = new SysUser();
        entity.setId(id.toString());
        entity.setDelFlag(AdminConsts.DEL_FLAG_TRUE);
        return this.updateById(entity);
    }

    /**
     * 根据用户名称查询
     * @param loginName
     * @return
     */
    public SysUser getByLoginName(String loginName) {
        SysUser entity = new SysUser();
        entity.setLoginName(loginName);
        return this.getBy(entity);
    }

    /**
     * 校验账户名称是否已存在
     * @param loginName
     * @return
     */
    public boolean existByLoginName(String loginName) {
        return null != this.getByLoginName(loginName);
    }

    /**
     * 禁用账户
     * @param userId
     */
    public void disableUser(String userId) {
        if (StringUtils.isBlank(userId)) return;
        SysUser entity = new SysUser();
        entity.setId(userId);
        entity.setUserStatus(AdminConsts.DEF_DISABLED);
        this.updateById(entity);
    }

    /**
     * 启用账户
     * @param userId
     */
    public void enableUser(String userId) {
        if (StringUtils.isBlank(userId)) return;
        SysUser entity = new SysUser();
        entity.setId(userId);
        entity.setUserStatus(AdminConsts.DEF_ENABLED);
        this.updateById(entity);
    }

}
