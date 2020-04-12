package com.liwnily.activiti.seed.module.activiti.dto;

import lombok.Data;
import org.activiti.engine.repository.Deployment;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author winily
 * @date 2020/4/12
 */
@Data
public class ProcessDeploymentDTO {
    private String id;
    private String name;
    private MultipartFile file;
    private String category;
    private String key;
    private Date deploymentTime;

    public ProcessDeploymentDTO() {
    }

    public ProcessDeploymentDTO(Deployment deployment) {
        this.setId(deployment.getId());
        this.setName(deployment.getName());
        this.setCategory(deployment.getCategory());
        this.setKey(deployment.getKey());
        this.setDeploymentTime(deployment.getDeploymentTime());
    }
}
