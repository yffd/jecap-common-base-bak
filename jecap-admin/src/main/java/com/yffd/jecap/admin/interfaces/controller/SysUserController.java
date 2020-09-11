package com.yffd.jecap.admin.interfaces.controller;

import com.yffd.jecap.admin.application.service.SysUserAppService;
import com.yffd.jecap.admin.domain.sys.user.entity.SysUser;
import com.yffd.jecap.common.base.result.RtnResult;
import com.yffd.jecap.common.base.web.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "系统-用户模块")
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserAppService userAppService;

    @ApiOperation(value = "分页查询", consumes = "application/x-www-form-urlencoded")
    @PostMapping(value = "/listPage")
    public RtnResult listPage(@RequestBody SysUser entity) {
        return this.userAppService.getPage(entity, DEF_PAGE_NUM, DEF_PAGE_SIZE);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/getDetail")
    public RtnResult getDetail(String userId) {
        if (StringUtils.isBlank(userId)) return RtnResult.FAIL("【用户ID】不能为空");
        return this.userAppService.getById(userId);
    }

    @ApiOperation(value = "添加")
    @PostMapping("/add")
    public RtnResult add(@RequestBody SysUser model) {
        this.userAppService.add(model);
        return RtnResult.OK();
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public RtnResult update(@RequestBody SysUser model) {
        if (StringUtils.isBlank(model.getId())) return RtnResult.FAIL("【用户ID】不能为空");
        return this.userAppService.updateById(model);
    }

    @ApiOperation(value = "删除", consumes = "application/x-www-form-urlencoded")
//    @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "body", dataTypeClass = String.class)
    @PostMapping("/delete")
    public RtnResult delete(String userId) {
        if (StringUtils.isBlank(userId)) return RtnResult.FAIL("【用户ID】不能为空");
        return this.userAppService.deleteById(userId);
    }


}
