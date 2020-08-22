package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.HealthWeight;
import com.example.hbhims.service.HealthWeightService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/4/20 12:03
 */
@Api(description = "体重API接口")
@RestController
@RequestMapping(value = "weight", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WeightController {
    private final HealthWeightService weightService;

    public WeightController(HealthWeightService weightService) {
        this.weightService = weightService;
    }

    @ApiOperation(value = "新增体重")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PutMapping("insert")
    public JsonResult<?> insert(@RequestBody HealthWeight healthWeight) {
        HealthWeight insert = weightService.insert(healthWeight);
        return ResultTool.success(insert);
    }

    @ApiOperation(value = "删除体重")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id) {
        if (weightService.deleteById(id)) {
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新体重")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody HealthWeight healthWeight) {
        if (weightService.queryById(healthWeight.getId()) != null) {
            return ResultTool.success(weightService.update(healthWeight));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

    @ApiOperation(value = "根据userId查询所有体重或者分页查询所有用户的体重或者查询所有用户的所有体重")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isLatest", value = "是否只查询最新的体重，配合userId使用，可传入：0/1 true/false，或不传")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("query")
    public JsonResult<?> query(@RequestParam(required = false) Long userId,
                               @RequestParam(required = false) Boolean isLatest,
                               @RequestParam(required = false) Long offset,
                               @RequestParam(required = false) Long limit) {
        List<HealthWeight> healthWeights;
        if (userId != null) {
            healthWeights = weightService.queryAllByUserId(userId);
            if (isLatest != null && isLatest) {
                if (healthWeights.isEmpty()) {
                    return ResultTool.success(null);
                } else {
                    healthWeights.sort(Comparator.comparingLong(HealthWeight::getMeasureTime));
                    return ResultTool.success(healthWeights.get(healthWeights.size() - 1));
                }
            } else {
                return ResultTool.success(healthWeights);
            }
        } else {
            if (offset != null && limit != null) {
                healthWeights = weightService.queryAllByLimit(offset, limit);
            } else {
                healthWeights = weightService.queryAll();
            }
            return ResultTool.success(healthWeights);
        }
    }

}
