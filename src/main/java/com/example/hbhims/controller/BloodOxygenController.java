package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.HealthBloodOxygen;
import com.example.hbhims.service.HealthBloodOxygenService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/4/20 12:03
 */
@Api(description = "血氧API接口")
@RestController
@RequestMapping(value = "bloodOxygen", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BloodOxygenController {
    private final HealthBloodOxygenService bloodOxygenService;

    public BloodOxygenController(HealthBloodOxygenService bloodOxygenService) {
        this.bloodOxygenService = bloodOxygenService;
    }

    @ApiOperation(value = "新增血氧")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PutMapping("insert")
    public JsonResult<?> insert(@RequestBody HealthBloodOxygen healthBloodOxygen) {
        HealthBloodOxygen insert = bloodOxygenService.insert(healthBloodOxygen);
        return ResultTool.success(insert);
    }

    @ApiOperation(value = "删除血氧")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id) {
        if (bloodOxygenService.deleteById(id)) {
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新血氧")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody HealthBloodOxygen healthBloodOxygen) {
        if (bloodOxygenService.queryById(healthBloodOxygen.getId()) != null) {
            return ResultTool.success(bloodOxygenService.update(healthBloodOxygen));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

    @ApiOperation(value = "根据userId查询所有血氧或者分页查询所有用户的血氧或者查询所有用户的所有血氧")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isLatest", value = "是否只查询最新的血氧，配合userId使用，可传入：0/1 true/false，或不传")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("query")
    public JsonResult<?> query(@RequestParam(required = false) Long userId,
                               @RequestParam(required = false) Boolean isLatest,
                               @RequestParam(required = false) Long offset,
                               @RequestParam(required = false) Long limit) {
        List<HealthBloodOxygen> healthBloodOxygens;
        if (userId != null) {
            healthBloodOxygens = bloodOxygenService.queryAllByUserId(userId);
            if (isLatest != null && isLatest) {
                if (healthBloodOxygens.isEmpty()) {
                    return ResultTool.success(null);
                } else {
                    healthBloodOxygens.sort(Comparator.comparingLong(HealthBloodOxygen::getMeasureTime));
                    return ResultTool.success(healthBloodOxygens.get(healthBloodOxygens.size() - 1));
                }
            } else {
                return ResultTool.success(healthBloodOxygens);
            }
        } else {
            if (offset != null && limit != null) {
                healthBloodOxygens = bloodOxygenService.queryAllByLimit(offset, limit);
            } else {
                healthBloodOxygens = bloodOxygenService.queryAll();
            }
            return ResultTool.success(healthBloodOxygens);
        }
    }
}
