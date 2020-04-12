package com.liwnily.activiti.seed;

import com.liwnily.activiti.seed.commun.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ActivitiSeedApplicationTests {

    @Test
    void contextLoads() {
        long startTime = System.nanoTime(); // 获取开始时间

        List<Result> list1 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Result ok = new Result().ok();
            list1.add(ok);
        }
        System.out.println(list1.size());
        long endTime = System.nanoTime(); // 获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

}
