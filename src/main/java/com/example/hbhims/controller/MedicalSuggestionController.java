package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.CustomMedicalSuggestion;
import com.example.hbhims.entity.MedicalSuggestion;
import com.example.hbhims.service.MedicalSuggestionService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/4/20 12:03
 */
@Api(description = "医疗意见和建议API接口")
@RestController
@RequestMapping(value = "medicalSuggestion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MedicalSuggestionController {

    private final MedicalSuggestionService medicalSuggestionService;

    public MedicalSuggestionController(MedicalSuggestionService medicalSuggestionService) {
        this.medicalSuggestionService = medicalSuggestionService;
    }

    @ApiOperation(value = "新增医疗意见和建议")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PutMapping("insert")
    public JsonResult<?> insert(@RequestBody MedicalSuggestion medicalSuggestion) {
        MedicalSuggestion insert = medicalSuggestionService.insert(medicalSuggestion);
        return ResultTool.success(insert);
    }

    @ApiOperation(value = "删除医疗意见和建议")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id) {
        if (medicalSuggestionService.deleteById(id)) {
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新医疗意见和建议")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody MedicalSuggestion medicalSuggestion) {
        if (medicalSuggestionService.queryById(medicalSuggestion.getId()) != null) {
            return ResultTool.success(medicalSuggestionService.update(medicalSuggestion));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

    @ApiOperation(value = "根据userId查询所有收到的医疗意见和建议或者分页查询userId收到的医疗意见和建议", notes = "返回样例" +
            "{\n" +
            "  \"success\": true,\n" +
            "  \"errorCode\": 200,\n" +
            "  \"errorMsg\": \"成功\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"professionalId\": 1,\n" +
            "      \"userId\": 2,\n" +
            "      \"time\": 1588945862145,\n" +
            "      \"content\": \"测试1\",\n" +
            "      \"evaluationScore\": 4,\n" +
            "      \"evaluationTime\": 1588945862145\n" +
            "    }\n" +
            "  ]\n" +
            "}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数，从0开始"),
            @ApiImplicitParam(name = "size", value = "每页的个数，大于1")
    })
    @GetMapping("queryReceive")
    public JsonResult<?> queryReceive(@RequestParam Long userId,
                                      @RequestParam(required = false) Integer page,
                                      @RequestParam(required = false) Integer size) {
        if (page != null && size != null) {
            List<CustomMedicalSuggestion> medicalSuggestions = medicalSuggestionService.queryAllByUserIdAndPage(userId, page, size);
            return ResultTool.success(medicalSuggestions);
        } else {
            List<CustomMedicalSuggestion> medicalSuggestions = medicalSuggestionService.queryAllByUserId(userId);
            return ResultTool.success(medicalSuggestions);
        }
    }

    @ApiOperation(value = "根据userId查询所有收到的医疗意见和建议或者分页查询userId收到的医疗意见和建议", notes = "返回样例" +
            "{\n" +
            "  \"success\": true,\n" +
            "  \"errorCode\": 200,\n" +
            "  \"errorMsg\": \"成功\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"professionalId\": 1,\n" +
            "      \"userId\": 2,\n" +
            "      \"time\": 1588945862145,\n" +
            "      \"content\": \"测试1\",\n" +
            "      \"evaluationScore\": 4,\n" +
            "      \"evaluationTime\": 1588945862145\n" +
            "    }\n" +
            "  ]\n" +
            "}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数，从0开始"),
            @ApiImplicitParam(name = "size", value = "每页的个数，大于1")
    })
    @GetMapping("querySend")
    public JsonResult<?> querySend(@RequestParam Long professionalId,
                                   @RequestParam(required = false) Integer page,
                                   @RequestParam(required = false) Integer size) {
        if (page != null && size != null) {
            List<CustomMedicalSuggestion> medicalSuggestions = medicalSuggestionService.queryAllByProfessionalIdAndPage(professionalId, page, size);
            return ResultTool.success(medicalSuggestions);
        } else {
            List<CustomMedicalSuggestion> medicalSuggestions = medicalSuggestionService.queryAllByProfessionalId(professionalId);
            return ResultTool.success(medicalSuggestions);
        }
    }

}
