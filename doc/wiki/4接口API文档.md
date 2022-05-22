# API文档规范性
## 前后端分离文档规范的必要性
* 一杯茶，一包烟，一个接口调一天
* 撸码一分钟，对接三小时(Android，iOS，mini，pc,etc...)

## 注意点
* 安全性:
> API即是系统资源，验证身份(IP白名单,app key, app security)
防重放攻击、限流

* 兼容性
> 区别版本，考虑旧版本下线
> 区别域名 /api/

* RESTful风格

* 易用性:
> 入参，出参，成功，失败示例，错误码，异常码清晰


##参考资料:
RESTful API 设计指南:https://www.ruanyifeng.com/blog/2014/05/restful_api.html