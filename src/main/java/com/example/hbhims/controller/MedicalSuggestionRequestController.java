package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.entity.CustomMedicalSuggestionRequest;
import com.example.hbhims.entity.MedicalSuggestionRequest;
import com.example.hbhims.service.MedicalSuggestionRequestService;
import com.example.hbhims.service.PushService;
import io.swagger.annotations.*;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author qq1962247851
 * @date 2020/4/20 12:03
 */
@Api(description = "医疗意见和建议请求API接口")
@RestController
@RequestMapping(value = "medicalSuggestionRequest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MedicalSuggestionRequestController {

    private final MedicalSuggestionRequestService medicalSuggestionRequestService;
    private final PushService pushService;

    public MedicalSuggestionRequestController(MedicalSuggestionRequestService medicalSuggestionRequestService, PushService pushService) {
        this.medicalSuggestionRequestService = medicalSuggestionRequestService;
        this.pushService = pushService;
    }

    @ApiOperation(value = "新增医疗意见和建议请求")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @PutMapping("insert")
    public JsonResult<?> insert(@RequestBody MedicalSuggestionRequest medicalSuggestionRequest) {
        MedicalSuggestionRequest insert = medicalSuggestionRequestService.insert(medicalSuggestionRequest);
        try {
            pushService.newMedicalSuggestionRequest(insert);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return ResultTool.success(insert);
    }

    @ApiOperation(value = "删除医疗意见和建议请求")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 999, message = "失败"),
            @ApiResponse(code = 1001, message = "参数无效")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "完成还是撤回（整数，0或1），0代表撤回，1代表完成。不传的话默认是完成1，不同的类型会发送不同的消息推送（安卓APP）")
    })
    @DeleteMapping("delete")
    public JsonResult<?> delete(@RequestParam Long id, @RequestParam(required = false, defaultValue = "1") Integer type) {
        MedicalSuggestionRequest queryById = medicalSuggestionRequestService.queryById(id);
        if (medicalSuggestionRequestService.deleteById(id)) {
            try {
                if (type == 1) {
                    pushService.finishMedicalSuggestionRequest(queryById);
                } else if (type == 0) {
                    pushService.recallMedicalSuggestionRequest(queryById);
                } else {
                    return ResultTool.fail(ResultCode.PARAM_NOT_VALID);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            return ResultTool.success();
        } else {
            return ResultTool.fail();
        }
    }

    @ApiOperation(value = "更新医疗意见和建议请求")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 4001, message = "数据不存在")
    })
    @PostMapping("update")
    public JsonResult<?> update(@RequestBody MedicalSuggestionRequest medicalSuggestionRequest) {
        if (medicalSuggestionRequestService.queryById(medicalSuggestionRequest.getId()) != null) {
            return ResultTool.success(medicalSuggestionRequestService.update(medicalSuggestionRequest));
        } else {
            return ResultTool.fail(ResultCode.DATA_NOT_EXIST);
        }
    }

    @ApiOperation(value = "根据userId查询所有发出的医疗意见和建议请求或者分页查询userId发出的医疗意见和建议请求")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数，从0开始"),
            @ApiImplicitParam(name = "size", value = "每页的个数，大于1")
    })
    @GetMapping("querySend")
    public JsonResult<?> querySend(@RequestParam Long userId,
                                   @RequestParam(required = false) Integer page,
                                   @RequestParam(required = false) Integer size) {
        if (page != null && size != null) {
            List<CustomMedicalSuggestionRequest> medicalSuggestions = medicalSuggestionRequestService.queryAllByUserIdAndPage(userId, page, size);
            return ResultTool.success(medicalSuggestions);
        } else {
            List<CustomMedicalSuggestionRequest> medicalSuggestions = medicalSuggestionRequestService.queryAllByUserId(userId);
            return ResultTool.success(medicalSuggestions);
        }
    }

    @ApiOperation(value = "根据userId查询所有收到的医疗意见和建议或者分页查询userId收到的医疗意见和建议")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数，从0开始"),
            @ApiImplicitParam(name = "size", value = "每页的个数，大于1")
    })
    @GetMapping("queryReceive")
    public JsonResult<?> queryReceive(@RequestParam Long professionalId,
                                      @RequestParam(required = false) Integer page,
                                      @RequestParam(required = false) Integer size) {
        if (page != null && size != null) {
            List<CustomMedicalSuggestionRequest> medicalSuggestions = medicalSuggestionRequestService.queryAllByProfessionalIdAndPage(professionalId, page, size);
            return ResultTool.success(medicalSuggestions);
        } else {
            List<CustomMedicalSuggestionRequest> medicalSuggestions = medicalSuggestionRequestService.queryAllByProfessionalId(professionalId);
            return ResultTool.success(medicalSuggestions);
        }
    }

}
