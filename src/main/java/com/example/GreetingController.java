package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by baizongjie on 2017/5/2.
 */
@RestController
public class GreetingController {

    private static final String template = "hello, %s";
    private final AtomicInteger counter  = new AtomicInteger();

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name){

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMXBean.getHeapMemoryUsage();
        Long MB = 1024L * 1024L;
        return usage.getUsed() / MB + "MB/" + usage.getMax() / MB + "MB";
        //return new Greeting(counter.incrementAndGet(), String.format(template,name)).toString();
    }

    private class Greeting{
        private Integer count;
        private String name;

        public Greeting(Integer count, String name){
            this.count = count;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + "[" + count + "]";
        }
    }
}

