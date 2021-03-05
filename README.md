# java-atcrowdfunding
尚筹网实战项目，第一个java项目，学习记录
- [后续malla实战项目](https://github.com/jacklmjie/java-my-mall-learning)

## 目标-思路-代码
### 课程内容
```bash
开发工具 spring-tools-4使用
基于 Maven 的 MyBatis 逆向工程
父工程依赖管理
Spring 整合 MyBatis-配置数据源-配置AOP的事务
配置日志
配置spring-web-mvc,jsp和ajax
后台用户登录,md5加密
权限拦截器
基于注解的异常映射
用户分页实现-基于页面直接访问
角色分页实现-基于ajax
用户角色分配
spring-security 内存版和数据库版
使用配置类代替xml配置文件
未认证请求跳转到登录页-注销登录
基于角色或权限实现访问控制-指定403页面-放行静态资源等
密码基于SpringSecurity 提供的加密接口-基于带盐值的加密
找不到 bean 的问题解决方案，1.两个容器合为1个，2.改源码，初始化找不到容器跳过
页面元素的权限控制
spring-boot
Preference-General-Workspce-txt file encoding默认改为utf-8
spring-boot-maven-plugin,插件可打包成一个可执行的jar包
java -jar xxxx.jar 命令行启动spring-boot
SpringBootApplication默认扫描，当前启动类所在的，
配置文件有properties和yml两种，如果两者都有相同配置，默认读取properties为主
```
### 踩坑经验
```bash
本地maven插件的使用
tomact要在本地下载后，基于插件
maven moudle子工程不加载，重新导入
<>不适配，项目属性java版本改为1.8
@RestController注解=@ResponseBody+@Controller
AssignHandler没有加@Controller注解，页面404，找不到
js缓存，Maven Clean重新加载
```
### 资料
- [Spring Tool Suite 4 自动提示功能](https://blog.csdn.net/weixin_40816738/article/details/94998794)
- [STS（Spring-Tool-Suite）常用快捷键汇总](https://blog.csdn.net/weixin_43731571/article/details/94641881)
- [菜单没有SPRING BEAN CONFIGURATION FILE选项](https://my.oschina.net/startstorm/blog/4523329)
- [添加tomcat 服务](https://blog.csdn.net/qijianglin/article/details/82967628?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param)

### 工具
```bash
entity工程-lombok
dev-tools 可以加依赖，每次调试不用重新启动，改完即可生效
switch hosts工具
session共享，解决session不互通问题
阿里云oss
支付沙箱环境
内网穿透natapp
```

### 未解决问题
```bash
vs code 基于maven子模块的项目创建
```
