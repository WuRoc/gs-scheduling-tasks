/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.schedulingtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static int i = 0;
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime2() {
        log.info("The time is now2 {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime3() {
        log.info("The time is now3 {}", i++);
    }

    @Scheduled(cron = "0 0 16 * * ?")
    public void reportCurrentTime4() {
        log.info("The time is now4 {}", i++);
    }

    /**
     * @Description: GMT 格林威治标准时间
     * @Param: null
     * @return: null
     * @Author: XiaoShuMu
     * @Date: 2021/8/20
     */
    @Scheduled(zone = "GMT-8:00",cron = "0 57 16 * * ?")
    public void reportCurrentTime5() {
        log.info("The time is now5 {}", i++);
    }



}
