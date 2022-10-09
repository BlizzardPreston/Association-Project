package com.association.College_project.kafkaComsumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xinjianCHEN
 * @date 2022/8/19 10:47
 */

@Slf4j
@Component
public class comsuner {
    /**
     * 数据处理
     *  yml配置批量且自动提交为false
     *  enable-auto-commit: false
     *        # 测试配置为5条 批量推送
     *       max-poll-records: 5
     *
     *       type: batch
     *
     * @param messages
     * @param acknowledgment
     */
    @KafkaListener(topics = "topic", groupId = "${spring.kafka.consumer.group-id}")
    public void consumerMessage(List<String> messages, Acknowledgment acknowledgment) {
        messages.forEach(message -> {
            log.info("*****************开始处理数据*************************************");
            log.info("当前处理数据message:{}", message);
//            electronicTag alarmMessage = JSON.parseObject(message, electronicTag.class);
            if (true) {
                log.info("当前数据解析后{}", "json");
                return;
            }
        });
//        acknowledgment.acknowledge();
    }

    /**
     *
     * 数据接受测试
     *
     * 单个推送 即不配置
     * # max-poll-records: 5
     */
//    @KafkaListener(topics = "capital_topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listener(ConsumerRecord<?, ?> record) {
        log.info("收到消息 ---> " + record.value().toString());
    }
}
