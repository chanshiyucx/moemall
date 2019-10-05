# MoeMall

萌购商城，新手上路，练习项目 U•ェ•U。

## 技术栈

| 技术             | 版本   | 说明             |
| ---------------- | ------ | ---------------- |
| Spring Boot      | 2.1.8  | 容器+MVC 框架    |
| Spring Security  | 5.1.6  | 认证和授权框架   |
| MySql            | 8.0.17 | 关系型数据库     |
| MyBatis          | 4.1.5  | ORM 框架         |
| MyBatisGenerator | 2.1.5  | 数据层代码生成   |
| PageHelper       | 1.2.12 | MyBatis 分页插件 |
| Druid            | 1.1.10 | 数据库连接池     |
| JWT              | 0.9.0  | JWT 登录支持     |
| Lombok           | 1.18.8 | 简化对象封装工具 |
| Swagger-UI       | 2.9.2  | 文档生产工具     |
| Elasticsearch    | -      | 搜索引擎         |
| RabbitMq         | -      | 消息队列         |
| Redis            | -      | 分布式缓存       |
| Docker           | -      | 应用容器引擎     |

## 通用服务

| 项目           | 描述           |
| -------------- | -------------- |
| moemall-common | 通用的工具类库 |
| moemall-mbg    | 通用的代码生成 |
| moemall-admin  | 后台管理模块   |

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

访问连接：`http://IP:8848/nacos/`
