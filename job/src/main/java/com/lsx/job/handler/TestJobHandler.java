package com.lsx.job.handler;


import com.lsx.job.feign.TyreFeign;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ldc
 * @description 测试定时任务
 * @create 2019-01-28 15:07
 */
@Component
@JobHandler(value = "dailyCalculateJobHandler")
public class TestJobHandler extends IJobHandler {

    @Resource
    private TyreFeign tyreFeign;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("测试定时任务");
//        pbDueFeign.calculate();
        tyreFeign.test(1L);
        return ReturnT.SUCCESS;
    }
}
