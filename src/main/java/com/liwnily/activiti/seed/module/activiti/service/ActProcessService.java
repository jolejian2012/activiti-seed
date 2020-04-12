package com.liwnily.activiti.seed.module.activiti.service;

import com.liwnily.activiti.seed.commun.Result;
import com.liwnily.activiti.seed.module.activiti.dto.ProcessDeploymentDTO;

import java.util.List;

/**
 * @author winily
 * @date 2020/4/5
 */
public interface ActProcessService {
    /**
     * 上传文件部署流程
     * @param processDeploymentDTO
     * @return
     */
    ProcessDeploymentDTO deploy(ProcessDeploymentDTO processDeploymentDTO);

    /**
     * 分页查询流程定义
     * @param page 第几页
     * @param size 每页多少条
     * @param order 排序 0 循序 1 倒序
     * @return list
     */
    List<ProcessDeploymentDTO> list(Integer page, Integer size, Integer order);

    /**
     * 根据流程定义id删除流程定义
     * @param deploymentId 流程定义id
     * @return 是否成功
     */
    Result destroy(String deploymentId);
}
