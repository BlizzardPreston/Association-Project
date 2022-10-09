package com.association.common.Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @Description:
 * @Author: zhangfang
 * @Date: 2019/10/29 11:11
 */
@Component
@Slf4j
public class KafkaProducer {
    @Autowired
    private KafkaTemplate slaveKafkaTemplate;

    public <T >void sendMessageAsync(String topic,String key, T message) {

        /*
         * 这里的 ListenableFuture 类是 spring 对 java 原生 Future 的扩展增强,是一个泛型接口,用于监听异步方法的回调
         * 而对于 kafka send 方法返回值而言，这里的泛型所代表的实际类型就是 SendResult<K, V>,而这里 K,V 的泛型实际上
         * 被用于 ProducerRecord<K, V> producerRecord,即生产者发送消息的 key,value 类型
         */

        ListenableFuture<SendResult<String, String>> future = slaveKafkaTemplate.send(topic,key,getMessageString(message));

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("发送消息失败:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> sendResult) {
                //System.out.println("发送结果:" + sendResult.toString());
            }
        });
    }
    public <T >void sendMessageAsync(String topic,Integer partition,String key, T message) {

        /*
         * 这里的 ListenableFuture 类是 spring 对 java 原生 Future 的扩展增强,是一个泛型接口,用于监听异步方法的回调
         * 而对于 kafka send 方法返回值而言，这里的泛型所代表的实际类型就是 SendResult<K, V>,而这里 K,V 的泛型实际上
         * 被用于 ProducerRecord<K, V> producerRecord,即生产者发送消息的 key,value 类型
         */

        ListenableFuture<SendResult<String, String>> future = slaveKafkaTemplate.send(topic,partition,key,getMessageString(message));

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("发送消息失败:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> sendResult) {
                //System.out.println("发送结果:" + sendResult.toString());
            }
        });
    }

    public <T>void sendMessageAsync(String topic, T message) {

        /*
         * 这里的 ListenableFuture 类是 spring 对 java 原生 Future 的扩展增强,是一个泛型接口,用于监听异步方法的回调
         * 而对于 kafka send 方法返回值而言，这里的泛型所代表的实际类型就是 SendResult<K, V>,而这里 K,V 的泛型实际上
         * 被用于 ProducerRecord<K, V> producerRecord,即生产者发送消息的 key,value 类型
         */
        ListenableFuture<SendResult<String, String>> future = slaveKafkaTemplate.send(topic, getMessageString(message));

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("发送消息失败:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> sendResult) {
                log.info("发送结果:" + sendResult.toString());
            }
        });
    }
    public <T >boolean sendMessageSync(String topic,String key, T message) {

        /*
         * 这里的 ListenableFuture 类是 spring 对 java 原生 Future 的扩展增强,是一个泛型接口,用于监听异步方法的回调
         * 而对于 kafka send 方法返回值而言，这里的泛型所代表的实际类型就是 SendResult<K, V>,而这里 K,V 的泛型实际上
         * 被用于 ProducerRecord<K, V> producerRecord,即生产者发送消息的 key,value 类型
         */
        String messageString = getMessageString(message);
        ListenableFuture<SendResult<String, String>> future = slaveKafkaTemplate.send(topic,key, messageString);
        try {
             future.get();
        } catch (Throwable e) {
            log.error("kafka生产同步消息失败,topic:{},key:{},message:{}",topic,key,messageString);
            return false;
        }
        return true;
    }
    public <T >boolean sendMessageSync(String topic, T message) {

        /*
         * 这里的 ListenableFuture 类是 spring 对 java 原生 Future 的扩展增强,是一个泛型接口,用于监听异步方法的回调
         * 而对于 kafka send 方法返回值而言，这里的泛型所代表的实际类型就是 SendResult<K, V>,而这里 K,V 的泛型实际上
         * 被用于 ProducerRecord<K, V> producerRecord,即生产者发送消息的 key,value 类型
         */
        String messageString = getMessageString(message);
        ListenableFuture<SendResult<String, String>> future = slaveKafkaTemplate.send(topic, messageString);
        try {
            future.get();
        } catch (Throwable e) {
            log.error("kafka生产同步消息失败,topic:{},message:{}",topic,messageString);
            return false;
        }
        return true;
    }

    private <T>String getMessageString(T message){
        String messageStr = null;
        if(message instanceof String){
            messageStr = (String) message;
        }else{
            messageStr = (String) JacksonUtils.toJsonNotNull(message);
        }
        return messageStr;
    }
}
