# Spring-cloud-alibaba

# Nacos 控制台下载地址
- https://github.com/alibaba/Nacos/releases/

# Sentinel 控制台下载地址
- https://github.com/alibaba/Sentinel/releases
- 热点规则：适用于指定参数QPS的限流，仅支持基本数据类型和String，源码：passCheck方法
- 注意：sentinel是懒加载的
#### 规则持久化
1. 拉模式：https://www.imooc.com/article/289402
2. 推模式：https://www.imooc.com/article/289464（需要改动sentinel的源码包，比较耗时间）
3. 阿里云：https://ahas.console.aliyun.com

# RocketMQ 下载地址
- 控制台：https://github.com/apache/rocketmq-externals
- 使用说明文档：https://github.com/eacdy/rocketmq-externals/blob/master/rocketmq-console/doc/1_0_0/UserGuide_CN.md
- 注意：下载完成之后需改动：
1. pom.xml->rocketmq.version为你当前使用的版本；
2. application.properties->rocketmq控制台启动端口，和rocketmq的服务端地址