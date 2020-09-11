package com.yffd.jecap.admin.interfaces.controller;

import com.yffd.jecap.admin.application.service.user.SysUserAppService;
import com.yffd.jecap.admin.domain.sys.user.entity.SysUser;
import com.yffd.jecap.common.base.result.RtnResult;
import com.yffd.jecap.common.base.web.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统-用户模块")
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserAppService userAppService;

    @ApiOperation(value = "添加")
    @PostMapping("/add")
    public RtnResult add(@RequestBody SysUser model) {
        return this.userAppService.add(null);
    }

}
