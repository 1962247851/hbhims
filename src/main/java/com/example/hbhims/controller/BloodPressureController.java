package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.HealthBloodPressure;
import com.example.hbhims.service.HealthBloodPressureService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/4/20 12:03
 */
@Api(description = "血压API接口")
@RestController
@RequestMapping(value = "bloodPressure", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BloodPressureController {
    private final HealthBloodPressureService bloodPressureService;

    public BloodPressureController(HealthBloodPressureService bloodPressureService) {
        this.bloodPressureService = bloodPressureService;
    }

    @ApiOperation(value = "新增血压")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PutMapping("insert")
    public JsonResult<?> insert(@RequestBody HealthBloodPressure healthBloodPressure) {
        HealthBloodPressure insert = bloodPressureService.insert(healthBloodPressure);
        return ResultTool.success(insert);
    }

    @ApiOperation(value = "删除血压")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id) {
        if (bloodPressureService.deleteById(id)) {
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新血压")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody HealthBloodPressure healthBloodPressure) {
        if (bloodPressureService.queryById(healthBloodPressure.getId()) != null) {
            return ResultTool.success(bloodPressureService.update(healthBloodPressure));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

    @ApiOperation(value = "根据userId查询所有血压或者分页查询所有用户的血压或者查询所有用户的所有血压")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isLatest", value = "是否只查询最新的血压，配合userId使用，可传入：0/1 true/false，或不传")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("query")
    public JsonResult<?> query(@RequestParam(required = false) Long userId,
                               @RequestParam(required = false) Boolean isLatest,
                               @RequestParam(required = false) Long offset,
                               @RequestParam(required = false) Long limit) {
        List<HealthBloodPressure> healthBloodPressures;
        if (userId != null) {
            healthBloodPressures = bloodPressureService.queryAllByUserId(userId);
            if (isLatest != null && isLatest) {
                if (healthBloodPressures.isEmpty()) {
                    return ResultTool.success(null);
                } else {
                    healthBloodPressures.sort(Comparator.comparingLong(HealthBloodPressure::getMeasureTime));
                    return ResultTool.success(healthBloodPressures.get(healthBloodPressures.size() - 1));
                }
            } else {
                return ResultTool.success(healthBloodPressures);
            }
        } else {
            if (offset != null && limit != null) {
                healthBloodPressures = bloodPressureService.queryAllByLimit(offset, limit);
            } else {
                healthBloodPressures = bloodPressureService.queryAll();
            }
            return ResultTool.success(healthBloodPressures);
        }
    }
}
