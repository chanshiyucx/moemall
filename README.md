# myshop

[Spring Cloud Alibaba 实战](https://www.funtl.com/zh/spring-cloud-alibaba-myshop/)

## 通用服务

| 项目                   | 描述           |
| ---------------------- | -------------- |
| myshop-dependencies    | 统一的依赖管理 |
| myshop-commons         | 通用的工具类库 |
| myshop-commons-domain  | 通用的领域模型 |
| myshop-commons-mapper  | 通用的数据访问 |
| myshop-commons-service | 通用的业务逻辑 |
| myshop-database        | 通用的代码生成 |

## Cloud

| 服务名称   | 服务端口 | 服务说明          |
| ---------- | -------- | ----------------- |
| MySQL      | 3306     | 数据库 8.0.17     |
| Redis      | 26379    | 数据缓存          |
| Nacos      | 8848     | 注册发现/配置中心 |
| Jenkins    | 8080     | 持续交付          |
| SkyWalking | 8080     | 链路追踪          |
| RocketMQ   | 8080     | 消息队列          |
| Sentinel   | 8080     | 熔断降级          |
| Nginx      | 80       | 反向代理/负载均衡 |

## Services

| 服务名称                                 | 服务端口 | 服务说明       |
| ---------------------------------------- | -------- | -------------- |
| 以下为通用服务                           |          |                |
| myshop-service-gateway                   | 9000     | 服务网关       |
| myshop-service-reg                       | 9501     | 用户注册       |
| myshop-service-sso                       | 9502     | 单点登录       |
| myshop-service-cache                     | 9503     | 缓存服务       |
| myshop-service-oss                       | 9504     | 文件上传       |
| myshop-service-forget                    | 9505     | 忘记密码       |
| myshop-service-search                    | 9506     | 全文检索       |
| myshop-service-email                     | 9507     | 邮件服务       |
| 以下为服务提供者                         |          |                |
| myshop-service-provider-content-category | 10101    | 内容分类提供者 |
| myshop-service-provider-content          | 10102    | 内容服务提供者 |
| myshop-service-provider-item-cat         | 10103    | 商品分类提供者 |
| myshop-service-provider-item-desc        | 10104    | 商品详情提供者 |
| myshop-service-provider-item             | 10105    | 商品服务提供者 |
| myshop-service-provider-order            | 10106    | 订单服务提供者 |
| myshop-service-provider-order-item       | 10107    | 订单项提供者   |
| myshop-service-provider-order-shipping   | 10108    | 购物车提供者   |
| 以下为服务消费者                         |          |                |
| myshop-service-consumer-content-category | 10201    | 内容分类消费者 |
| myshop-service-consumer-content          | 10202    | 内容服务消费者 |
| myshop-service-consumer-item-cat         | 10203    | 商品分类消费者 |
| myshop-service-consumer-item-desc        | 10204    | 商品详情消费者 |
| myshop-service-consumer-item             | 10205    | 商品服务消费者 |
| myshop-service-consumer-order            | 10206    | 订单服务消费者 |
| myshop-service-consumer-order-item       | 10207    | 订单项消费者   |
| myshop-service-consumer-order-shipping   | 10208    | 购物车消费者   |

## Nacos Docker

- [官方文档](https://nacos.io/zh-cn/docs/quick-start-docker.html)
- [Github](https://github.com/nacos-group/nacos-docker)

```bash
# clone 项目
git clone https://github.com/nacos-group/nacos-docker.git
cd nacos-docker

# 启动：单机模式 Derby
docker-compose -f example/standalone-derby.yaml up

# 启动：单机模式 Mysql
docker-compose -f example/standalone-mysql.yaml up

# 停止：使用哪个配置启动就用哪个关闭
docker-compose -f example/standalone-derby.yaml down
```

访问连接：`http://127.0.0.1:8848/nacos/`
