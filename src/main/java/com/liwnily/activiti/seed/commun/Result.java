package com.liwnily.activiti.seed.commun;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liwnily.activiti.seed.module.activiti.dto.ProcessDeploymentDTO;
import lombok.Data;

/**
 * 用于统一返回格式设定
 *
 * @author winily
 * @date 2020/4/5
 */
@Data
public class Result<T> {

    private String message;

    private int code;

    private T data;

    public Result ok() {
        this.setCode(0);
        this.setMessage("success");
        return this;
    }

    public Result error() {
        this.setCode(0);
        this.setMessage("error");
        return this;
    }

    public Result ok(T result) {
        this.setData(result);
        return this.ok();
    }
}
