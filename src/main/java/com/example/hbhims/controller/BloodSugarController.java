package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.HealthBloodSugar;
import com.example.hbhims.service.HealthBloodSugarService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/4/20 12:03
 */
@Api(description = "血糖API接口")
@RestController
@RequestMapping(value = "bloodSugar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BloodSugarController {
    private final HealthBloodSugarService bloodSugarService;

    public BloodSugarController(HealthBloodSugarService bloodSugarService) {
        this.bloodSugarService = bloodSugarService;
    }

    @ApiOperation(value = "新增血糖")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PutMapping("insert")
    public JsonResult<?> insert(@RequestBody HealthBloodSugar healthBloodPressure) {
        HealthBloodSugar insert = bloodSugarService.insert(healthBloodPressure);
        return ResultTool.success(insert);
    }

    @ApiOperation(value = "删除血糖")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id) {
        if (bloodSugarService.deleteById(id)) {
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新血糖")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody HealthBloodSugar healthBloodSugar) {
        if (bloodSugarService.queryById(healthBloodSugar.getId()) != null) {
            return ResultTool.success(bloodSugarService.update(healthBloodSugar));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

    @ApiOperation(value = "根据userId查询所有血糖或者分页查询所有用户的血糖或者查询所有用户的所有血糖")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isLatest", value = "是否只查询最新的血糖，配合userId使用，可传入：0/1 true/false，或不传")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("query")
    public JsonResult<?> query(@RequestParam(required = false) Long userId,
                               @RequestParam(required = false) Boolean isLatest,
                               @RequestParam(required = false) Long offset,
                               @RequestParam(required = false) Long limit) {
        List<HealthBloodSugar> healthBloodSugars;
        if (userId != null) {
            healthBloodSugars = bloodSugarService.queryAllByUserId(userId);
            if (isLatest != null && isLatest) {
                if (healthBloodSugars.isEmpty()) {
                    return ResultTool.success(null);
                } else {
                    healthBloodSugars.sort(Comparator.comparingLong(HealthBloodSugar::getMeasureTime));
                    return ResultTool.success(healthBloodSugars.get(healthBloodSugars.size() - 1));
                }
            } else {
                return ResultTool.success(healthBloodSugars);
            }
        } else {
            if (offset != null && limit != null) {
                healthBloodSugars = bloodSugarService.queryAllByLimit(offset, limit);
            } else {
                healthBloodSugars = bloodSugarService.queryAll();
            }
            return ResultTool.success(healthBloodSugars);
        }
    }
}
