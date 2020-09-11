package com.yffd.jecap.admin.infrastructure.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yffd.jecap.admin.domain.sys.user.entity.SysUser;
import com.yffd.jecap.common.base.dao.mybatis.MybatisplusBaseDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao extends MybatisplusBaseDao<SysUser> {

    @Override
    default Wrapper<SysUser> getWrapper(SysUser entity) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(entity.getId())) wrapper.eq("id", entity.getId());
        if (StringUtils.isNotBlank(entity.getLoginName())) wrapper.eq("login_name", entity.getLoginName());
        if (StringUtils.isNotBlank(entity.getUserName())) wrapper.eq("user_name", entity.getUserName());

        if (wrapper.nonEmptyOfWhere()) wrapper.eq("del_flag", "0");//注意位置
        return wrapper;
    }
}
