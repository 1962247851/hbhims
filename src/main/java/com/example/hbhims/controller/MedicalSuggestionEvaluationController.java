package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.MedicalSuggestionEvaluation;
import com.example.hbhims.service.MedicalSuggestionEvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author qq1962247851
 * @date 2020/4/20 12:03
 */
@Api(description = "医疗意见和建议评分API接口")
@RestController
@RequestMapping(value = "medicalSuggestionEvaluation", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MedicalSuggestionEvaluationController {

    private final MedicalSuggestionEvaluationService suggestionEvaluationService;

    public MedicalSuggestionEvaluationController(MedicalSuggestionEvaluationService suggestionEvaluationService) {
        this.suggestionEvaluationService = suggestionEvaluationService;
    }

    @ApiOperation(value = "新增医疗意见和建议评分")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PutMapping("insert")
    public JsonResult<?> insert(@RequestBody MedicalSuggestionEvaluation medicalSuggestionEvaluation) {
        MedicalSuggestionEvaluation insert = suggestionEvaluationService.insert(medicalSuggestionEvaluation);
        return ResultTool.success(insert);
    }

    @ApiOperation(value = "删除医疗意见和建议评分")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id) {
        if (suggestionEvaluationService.deleteById(id)) {
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新医疗意见和建议评分")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody MedicalSuggestionEvaluation medicalSuggestionEvaluation) {
        if (suggestionEvaluationService.queryById(medicalSuggestionEvaluation.getId()) != null) {
            return ResultTool.success(suggestionEvaluationService.update(medicalSuggestionEvaluation));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

}
