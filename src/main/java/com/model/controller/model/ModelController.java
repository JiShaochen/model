package com.model.controller.model;

import com.model.common.utils.apiresult.AbstractApiResult;
import com.model.common.utils.exception.ExceptionManager;
import com.model.common.utils.page.PageParam;
import com.model.entity.vo.CourseVO;
import com.model.service.model.ModelService;
import com.model.service.syncmodel.abstrcat.SyncModelAbstract;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Morning JS
 * @date 2020/12/7 16:46
 * @desc 模板controller
 */
@Api(value = "/model", tags = "模板模块")
@RestController
@RequestMapping(value = "/model")
public class ModelController {

    @Resource
    ModelService modelService;

    // 可以通过这种方式将其注入到map中。
    @Resource
    Map<String, SyncModelAbstract> syncModelService;

    @Resource
    ExceptionManager exceptionManager;

    @GetMapping(value = "/test")
    @ApiOperation(value = "测试接口是否能正常通过")
    public AbstractApiResult test() {
        return AbstractApiResult.success();
    }

    @GetMapping(value = "/test/error")
    @ApiOperation(value = "测试异常是否能使用")
    public AbstractApiResult testError() {
        throw exceptionManager.createByCode("ERROR_0001");
//        return AbstractApiResult.success();
    }

    @GetMapping(value = "/get")
    @ApiOperation(value = "get请求测试")
    public AbstractApiResult getTest() {
        return AbstractApiResult.success(modelService.getTest());
    }

    @GetMapping(value = "/get/one")
    @ApiOperation(value = "get请求获取一个对象测试")
    public AbstractApiResult getOne() {
        return AbstractApiResult.success(modelService.getOne());
    }

    @PostMapping(value = "/post")
    @ApiOperation(value = "post新增接口测试")
    public AbstractApiResult postTest(@RequestBody CourseVO courseVO) {
        modelService.postTest(courseVO);
        return AbstractApiResult.success();
    }

    @GetMapping(value = "/get/list")
    @ApiOperation(value = "getList分页查询测试")
    public AbstractApiResult postList(@ModelAttribute PageParam pageParam) {
        return AbstractApiResult.success(modelService.postList(pageParam));
    }

    @GetMapping(value = "/sync/test")
    @ApiOperation(value = "测试不同服务同步数据")
    public AbstractApiResult testSync() {
        syncModelService.get(SyncModelAbstract.TYPE_B).SyncModelData("1.2.3.4.5.6.7");
        syncModelService.get(SyncModelAbstract.TYPE_A).SyncModelData("1.2.3.4.5.6.7");
        return AbstractApiResult.success();
    }

}