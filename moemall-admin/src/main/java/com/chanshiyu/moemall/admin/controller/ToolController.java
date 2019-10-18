package com.chanshiyu.moemall.admin.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.chanshiyu.moemall.service.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author SHIYU
 * @date 2019/10/14 18:43
 * @description 通用工具
 */
@Slf4j
@Api(tags = "通用工具")
@RestController
@RequestMapping("/tool")
public class ToolController {

    private static final String uploadUrl = "https://sm.ms/api/v2/upload";

    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public CommonResult<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String path = System.getProperty("java.io.tmpdir") + "/" + IdUtil.simpleUUID() + file.getOriginalFilename();
        File convFile = new File(path);
        file.transferTo(convFile);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("smfile", convFile);
        String result = HttpUtil.post(uploadUrl, paramMap);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        if (!jsonObject.getStr("code").equals("success")) {
            return CommonResult.failed("上传失败");
        }
        JSONObject data = jsonObject.getJSONObject("data");
        log.info("jsonObject: {}", jsonObject);
        String imgUrl = data.getStr("url");
        return CommonResult.ok(imgUrl);
    }

}
