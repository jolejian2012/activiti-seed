package com.liwnily.activiti.seed.module.activiti.controller;

import com.liwnily.activiti.seed.commun.Result;
import com.liwnily.activiti.seed.module.activiti.dto.ProcessDeploymentDTO;
import com.liwnily.activiti.seed.module.activiti.service.ActProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author winily
 * @date 2020/4/5
 */
@RestController
@RequestMapping("/activiti/deployment")
@Api(tags = "流程管理")
public class ActProcessController {
    @Autowired
    private ActProcessService actProcessService;

    @PostMapping
    @ApiOperation("部署流程")
    public Result deploy(@ModelAttribute ProcessDeploymentDTO processDeploymentDTO) {
        ProcessDeploymentDTO result = this.actProcessService.deploy(processDeploymentDTO);
        return new Result<ProcessDeploymentDTO>().ok(result);
    }

    @GetMapping
    @ApiOperation("分页查询流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", type = "int", value = "第几页"),
            @ApiImplicitParam(name = "size", type = "int", value = "一页几条"),
            @ApiImplicitParam(name = "order", type = "int", value = "排序 0 顺序 1 倒序")
    })
    public Result list(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("order") Integer order) {
        List<ProcessDeploymentDTO> processDeploymentDTOList = this.actProcessService.list(page, size, order);
        return new Result<List<ProcessDeploymentDTO>>().ok(processDeploymentDTOList);
    }

    @DeleteMapping("{deploymentId}")
    @ApiOperation("删除流程定义")
    public Result destroy(@PathVariable("deploymentId") String deploymentId) {
        return this.actProcessService.destroy(deploymentId);
    }
}
