# Spring-cloud-alibaba

|  模块名称   | 端口 |
|  ----  | ----  |
| user-center  | 1000 |
| content-center  | 2000 |
| gateway  | 3000 |

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

# Spring Cloud Stream
- 一个用于构建消息驱动的微服务框架
- 知识点：
1. 微服务集成了stream，然后stream的binder创建了两个binding（output(消息生产者)/input(消息消费者)）

# Spring Cloud Gateway
- 核心概念
1. Route 路由
2. Predicate 即Jdk8的Predicate，实现路由的匹配条件
3. Filter 过滤器