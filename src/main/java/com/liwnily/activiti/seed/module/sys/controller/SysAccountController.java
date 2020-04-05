package com.liwnily.activiti.seed.module.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author winily
 * @date 2020/3/30
 */
@RestController
@RequestMapping("sys")
public class SysAccountController {
    @GetMapping
    public void index() {}
}
