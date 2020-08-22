package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.HealthHeight;
import com.example.hbhims.service.HealthHeightService;
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
@Api(description = "身高API接口")
@RestController
@RequestMapping(value = "height", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HeightController {
    private final HealthHeightService heightService;

    public HeightController(HealthHeightService heightService) {
        this.heightService = heightService;
    }

    @ApiOperation(value = "记录身高", notes = "如果userId已存在，则更新，否则插入")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PutMapping("insertOrReplace")
    public JsonResult<?> insertOrReplace(@RequestBody HealthHeight healthHeight) {
        HealthHeight queryByUserId = heightService.queryByUserId(healthHeight.getUserId());
        HealthHeight result;
        if (queryByUserId == null) {
            result = heightService.insert(healthHeight);
        } else {
            healthHeight.setId(queryByUserId.getId());
            result = heightService.update(healthHeight);
        }
        return ResultTool.success(result);
    }

    @ApiOperation(value = "删除身高")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id) {
        if (heightService.deleteById(id)) {
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新身高")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody HealthHeight healthHeight) {
        if (heightService.queryById(healthHeight.getId()) != null) {
            return ResultTool.success(heightService.update(healthHeight));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

    @ApiOperation(value = "根据userId查询身高或者分页查询所有用户的身高或者查询所有用户的所有身高")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("query")
    public JsonResult<?> query(@RequestParam(required = false) Long userId,
                               @RequestParam(required = false) Long offset,
                               @RequestParam(required = false) Long limit) {
        if (userId != null) {
            HealthHeight healthHeight = heightService.queryByUserId(userId);
            return ResultTool.success(healthHeight);
        } else {
            List<HealthHeight> healthHeights;
            if (offset != null && limit != null) {
                healthHeights = heightService.queryAllByLimit(offset, limit);
            } else {
                healthHeights = heightService.queryAll();
            }
            return ResultTool.success(healthHeights);
        }
    }
}
