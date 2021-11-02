package com.model.controller.model;

import com.model.common.queue.RedisDelayQueueUtil;
import com.model.common.queue.dto.DemoQueueDTO;
import com.model.common.user.UserThreadLocalDTO;
import com.model.common.utils.apiresult.AbstractApiResult;
import com.model.common.utils.exception.ExceptionManager;
import com.model.common.utils.page.PageParam;
import com.model.entity.model.Account;
import com.model.entity.vo.CourseVO;
import com.model.service.model.ModelService;
import com.model.service.syncmodel.abstrcat.SyncModelAbstract;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    RedisDelayQueueUtil redisDelayQueueUtil;

    @GetMapping(value = "/test")
    @ApiOperation(value = "测试接口是否能正常通过")
    public AbstractApiResult test() {
        Account threadLocal = UserThreadLocalDTO.getThreadLocal();
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread name is " + name + "   accountId :" + threadLocal.getId());
        System.out.println("=====================================");
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

    @GetMapping(value = "/redis/test")
    @ApiOperation(value = "测试redis是否可用")
    public AbstractApiResult testRedis() {
        redisTemplate.opsForValue().set("test", "少臣");
        return AbstractApiResult.success(redisTemplate.opsForValue().get("test"));
    }

    @GetMapping(value = "/redisson/test")
    @ApiOperation(value = "redisson测试")
    public AbstractApiResult testRedisson() {
        redisTemplate.opsForValue().get("test");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("orderId", "100");
        DemoQueueDTO demoQueueDTO = new DemoQueueDTO();
        demoQueueDTO.setId(1L);
        demoQueueDTO.setName("少臣");
        for (int i = 0; i < 10; i++) {
            redisDelayQueueUtil.addDelayQueue(demoQueueDTO, 3 * (i+1), TimeUnit.SECONDS);
        }
        return AbstractApiResult.success(redisTemplate.opsForValue().get("test"));
    }

}