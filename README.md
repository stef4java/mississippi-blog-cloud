## 简介
后端工程实践培训示例

### mississippi名称的由来
mississippi，取自【老友记】Ross美黑那一集，老友记是一部情景喜剧。大家可以看下，一定会喜欢的。

## 项目结构
```shell
.
├── mississippi-blog-application            -- 后端服务
│     ├── mississippi-blog-admin            -- blog管理后台父工程
│     │     ├── mississippi-blog-admin-api  -- blog管理后台:公共bean、远程调用接口feign
│     │     └── mississippi-blog-admin-biz  -- blog管理后台应用:controllrt, application
│     └── mississippi-blog-portal           -- blog前台应用:给web端、移动端...提供接口
├── mississippi-blog-common                 -- 公共包
│     ├── mississippi-blog-common-base      -- 公共类
│     └── mississippi-blog-common-util      -- 工具类
├── mississippi-blog-job                    -- 定时任务
├── mississippi-blog-model                  -- 基础bean
├── mississippi-blog-service                -- 业务层
└── doc
      ├── db                                -- 数据库脚本
      └── deploy.sh                         -- 启动/停止、重启命令
```

## 🔜快速开始
1. 执行'/doc/db/1schema.sql'创建数据库
2. 执行'/doc/db/2mississippi_blog.sql'创建数据表
3. 修改数据库账号/密码: `mississippi-blog-admin`下对应环境下的配置文件,默认环境dev
4. 启动应用`MississippiBlogAdminApplication`
5. API文档链接: [http://127.0.0.1:8081/doc.html]()

