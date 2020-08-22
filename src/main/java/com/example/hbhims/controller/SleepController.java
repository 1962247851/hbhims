package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.DateUtil;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.HealthSleep;
import com.example.hbhims.service.HealthSleepService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/4/20 12:03
 */
@Api(description = "睡眠质量API接口")
@RestController
@RequestMapping(value = "sleep", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SleepController {
    private final HealthSleepService sleepService;

    public SleepController(HealthSleepService sleepService) {
        this.sleepService = sleepService;
    }

    @ApiOperation(value = "记录睡眠质量", notes = "先根据userId和日期（时间戳，例如：2020-04-27 00:00:00，不包含时间，如果包含时间则自动去除时间）查询，如果存在则更新，否则插入\n" +
            "totalTime不用传，自动设置的")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PostMapping("insertOrReplace")
    public JsonResult<?> insertOrReplace(@RequestBody HealthSleep healthSleep) {
        healthSleep.setDate(DateUtil.getOnlyDate(healthSleep.getDate()));
        HealthSleep query = sleepService.queryByUserIdAndDate(healthSleep.getUserId(), healthSleep.getDate());
        healthSleep.setTotalTime(healthSleep.getEndTime() - healthSleep.getStartTime());
        if (query == null) {
            HealthSleep insert = sleepService.insert(healthSleep);
            return ResultTool.success(insert);
        } else {
            healthSleep.setId(query.getId());
            HealthSleep update = sleepService.update(healthSleep);
            return ResultTool.success(update);
        }
    }

    @ApiOperation(value = "删除睡眠质量")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id) {
        if (sleepService.deleteById(id)) {
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新睡眠质量")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody HealthSleep healthSleep) {
        if (sleepService.queryById(healthSleep.getId()) != null) {
            return ResultTool.success(sleepService.update(healthSleep));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

    @ApiOperation(value = "根据userId查询指定日期（时间戳，例如：2020-04-27 00:00:00，不包含时间，如果包含时间则自动去除时间）或者昨日的睡眠情况或者分页查询所有日期的睡眠情况",
            notes = "传userId为返回的data为单个json对象\n" +
                    "不传则返回的data为jsonArray")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("queryByDate")
    public JsonResult<?> queryByDate(@RequestParam(required = false) Long userId,
                                     @RequestParam(required = false) Long offset,
                                     @RequestParam(required = false) Long limit,
                                     @RequestParam(required = false) Long date) {
        if (userId != null) {
            HealthSleep healthSleep;
            if (date != null) {
                healthSleep = sleepService.queryByUserIdAndDate(userId, DateUtil.getOnlyDate(date));
            } else {
                healthSleep = sleepService.queryByUserIdAndDate(userId, DateUtil.getYesterdayDate());
            }
            return ResultTool.success(healthSleep);
        } else {
            List<HealthSleep> healthSleeps;
            if (offset != null && limit != null) {
                if (date != null) {
                    healthSleeps = sleepService.queryAllByDateAndLimit(DateUtil.getOnlyDate(date), offset, limit);
                } else {
                    healthSleeps = sleepService.queryAllByLimit(offset, limit);
                }
            } else {
                healthSleeps = sleepService.queryAllByDate(DateUtil.getOnlyDate(date));
            }
            return ResultTool.success(healthSleeps);
        }
    }

    @ApiOperation(value = "根据userId查询所有睡眠质量或者分页查询所有用户的睡眠质量", notes = "不传入参数则查询所有用户的所有运动记录")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("query")
    public JsonResult<?> query(@RequestParam(required = false) Long userId,
                               @RequestParam(required = false) Long offset,
                               @RequestParam(required = false) Long limit) {
        List<HealthSleep> healthSleeps;
        if (userId != null) {
            healthSleeps = sleepService.queryAllByUserId(userId);
        } else {
            if (offset != null && limit != null) {
                healthSleeps = sleepService.queryAllByLimit(offset, limit);
            } else {
                healthSleeps = sleepService.queryAll();
            }
        }
        return ResultTool.success(healthSleeps);
    }
}
