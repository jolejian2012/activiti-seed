package com.liwnily.activiti.seed.module.activiti.service.impl;

import com.liwnily.activiti.seed.commun.Result;
import com.liwnily.activiti.seed.module.activiti.dto.ProcessDeploymentDTO;
import com.liwnily.activiti.seed.module.activiti.service.ActProcessService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author winily
 * @date 2020/4/5
 */
@Service
public class ActProcessServiceImpl implements ActProcessService {
    private final RepositoryService repositoryService;

    public ActProcessServiceImpl(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }


    @Override
    public ProcessDeploymentDTO deploy(ProcessDeploymentDTO processDeploymentDTO) {
        try {
            // 部署流程后回返回对应部署成功的流程定义对象
            Deployment deployment = this.repositoryService.createDeployment()
                    // 设置流程定义名称
                    .name(processDeploymentDTO.getName())
                    /**
                     * 添加输入流，两个参数
                     * @param name 第一个参数是设置流程定义文件的名称
                     * @param inputStream 第二个参数输入流，从提交的文件中获取输入流，读取到上传的文件数据
                     */
                    .addInputStream(processDeploymentDTO.getFile().getOriginalFilename(), processDeploymentDTO.getFile().getInputStream())
                    // 流程定义的类别
                    .category(processDeploymentDTO.getCategory())
                    // 流程定义的key
                    .key(processDeploymentDTO.getKey())
                    // 执行部署
                    .deploy();
            return new ProcessDeploymentDTO(deployment);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ProcessDeploymentDTO> list(Integer page, Integer size, Integer order) {
        // 获取查询流程定义对对象
        DeploymentQuery deploymentQuery = this.repositoryService.createDeploymentQuery()
                // 根据流程定义部署时间排序
                .orderByDeploymenTime();
        if (order == null || order == 0) {
            // 升序
            deploymentQuery.asc();
        } else {
            // 降序
            deploymentQuery.desc();
        }
        // 从第几条开始
        int start = (page * size) - size + 1;
        // 到第几条结束
        int end = page * size;
        // 根据上面的数据进行分页查询出列表
        List<Deployment> deployments = deploymentQuery.listPage(start, end);
        List<ProcessDeploymentDTO> processDeploymentDTOList = new ArrayList<>();
        // 将 原生的 Deployment 转换为 ProcessDeploymentDTO
        deployments.forEach(it -> {
            processDeploymentDTOList.add(new ProcessDeploymentDTO(it));
        });
        return processDeploymentDTOList;
    }

    @Override
    public Result destroy(String deploymentId) {
        try {
            /**
             * 第一参数为流程定义id
             * 第二参数为是否联级删除流程定义
             * 如果第二参数为true的话所有有关这个流程定义的数据都会被删除
             * this.repositoryService.deleteDeployment(deploymentId, true);
             */

            // 输入流程定义删除流程, 若该流程有正常运行的流程或者记录，会删除失败
            this.repositoryService.deleteDeployment(deploymentId);
        } catch (Exception e) {
            return new Result().error();
        }
        return new Result().ok();
    }
}
