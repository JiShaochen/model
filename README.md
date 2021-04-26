## model

> SpringBoot单体项目开发模板

### 内部集成

- mybatis
- lombok
- 基础工具类
- 异常处理体系
- 初始化sql模板
- swagger调试工具
- mybatis-plus
- JWT

### 优化记录

2021.4.15
> 添加继承抽象类，以多态思想完成类似在编员工和不在编用户不同逻辑的同步方案。

> 添加了mybatis-plus

> 集成了JWT

2021.4.23
> 解决BigDecimal序列化丢失小数点问题