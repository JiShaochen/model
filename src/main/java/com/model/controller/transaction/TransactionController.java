package com.model.controller.transaction;

import com.model.common.utils.apiresult.AbstractApiResult;
import com.model.entity.dto.transaction.TransactionDTO;
import com.model.service.transaction.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Morning JS
 * @date 2021/4/15 17:45
 * @desc 账号相关
 */


@Api(value = "/transaction", tags = "翻译")
@RestController
@RequestMapping(value = "/transcation")
public class TransactionController {

    @Resource
    TransactionService transactionService;

    @PostMapping
    @ApiOperation(value = "翻译")
    public AbstractApiResult transaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
        transactionService.transaction(transactionDTO);
        return AbstractApiResult.success();
    }

}

