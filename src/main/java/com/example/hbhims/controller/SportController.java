package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.DateUtil;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.HealthSport;
import com.example.hbhims.service.HealthSportService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/4/20 12:03
 */
@Api(description = "运动记录API接口")
@RestController
@RequestMapping(value = "sport", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SportController {
    private final HealthSportService sportService;

    public SportController(HealthSportService sportService) {
        this.sportService = sportService;
    }

    @ApiOperation(value = "记录运动记录", notes = "先根据userId和日期（时间戳，例如：2020-04-27 00:00:00，不包含时间，如果包含时间则自动去除时间）查询，如果存在则更新，否则插入\n" +
            "只需要传userId、date、stepValue，其余自动计算\n" +
            "calorie = stepValue / 20F\n (cal)" +
            "distance = stepValue * 0.7F / 1000 (km)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PutMapping("insertOrReplace")
    public JsonResult<?> insertOrReplace(@RequestBody HealthSport healthSport) {
        healthSport.setDate(DateUtil.getOnlyDate(healthSport.getDate()));
        HealthSport query = sportService.queryByUserIdAndDate(healthSport.getUserId(), healthSport.getDate());
        healthSport.setCalorie(healthSport.getStepValue() / 20F);
        healthSport.setDistance(healthSport.getStepValue() * 0.7F / 1000);
        if (query == null) {
            HealthSport insert = sportService.insert(healthSport);
            return ResultTool.success(insert);
        } else {
            healthSport.setId(query.getId());
            HealthSport update = sportService.update(healthSport);
            return ResultTool.success(update);
        }
    }

    @ApiOperation(value = "删除运动记录")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id) {
        if (sportService.deleteById(id)) {
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新运动记录")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody HealthSport healthSport) {
        if (sportService.queryById(healthSport.getId()) != null) {
            return ResultTool.success(sportService.update(healthSport));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

    @ApiOperation(value = "根据userId查询某个时间段内的运动记录或者分页查询所有用户某个时间段内的运动记录",
            notes = "如果只传入一个时间戳，比如只传入start则表示从start到现在的记录，只传入end表示end之前的记录\n" +
                    "如果两个都不传入则默认查询今天的\n\n" +
                    "如果不传任何参数则默认查询所有用户的今日运动记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start", value = "起始时间戳（毫秒级）"),
            @ApiImplicitParam(name = "end", value = "截止时间戳（毫秒级）")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("queryByDate")
    public JsonResult<?> queryByDate(@RequestParam(required = false) Long userId,
                                     @RequestParam(required = false) Long offset,
                                     @RequestParam(required = false) Long limit,
                                     @RequestParam(required = false) Long date) {
        if (userId != null) {
            HealthSport healthSport;
            if (date != null) {
                healthSport = sportService.queryByUserIdAndDate(userId, DateUtil.getOnlyDate(date));
            } else {
                healthSport = sportService.queryByUserIdAndDate(userId, DateUtil.getYesterdayDate());
            }
            return ResultTool.success(healthSport);
        } else {
            List<HealthSport> healthSleeps;
            if (offset != null && limit != null) {
                if (date != null) {
                    healthSleeps = sportService.queryAllByDateAndLimit(DateUtil.getOnlyDate(date), offset, limit);
                } else {
                    healthSleeps = sportService.queryAllByLimit(offset, limit);
                }
            } else {
                healthSleeps = sportService.queryAllByDate(DateUtil.getOnlyDate(date));
            }
            return ResultTool.success(healthSleeps);
        }
    }

    @ApiOperation(value = "根据userId查询所有运动记录或者分页查询所有用户的运动记录", notes = "不传入参数则查询所有用户的所有运动记录")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("query")
    public JsonResult<?> query(@RequestParam(required = false) Long userId,
                               @RequestParam(required = false) Long offset,
                               @RequestParam(required = false) Long limit) {
        List<HealthSport> healthSports;
        if (userId != null) {
            healthSports = sportService.queryAllByUserId(userId);
        } else {
            if (offset != null && limit != null) {
                healthSports = sportService.queryAllByLimit(offset, limit);
            } else {
                healthSports = sportService.queryAll();
            }
        }
        return ResultTool.success(healthSports);
    }
}
