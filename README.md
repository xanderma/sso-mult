# sso-mult
本程序演示了使用SpringSession共享Session来实现多实例登录的情况

# 简介

当网站流量变大时，也许是一个微信后台商城，这时一台Tomcat已经不能满足需求了，就需要多台Tomcat来共同实现登录。

使用SpringSession是实现Session共享的一种方式，它将Session集中管理存放到Redis中，使用也十分简单。

也可以使用Tomcat自带的Session共享，但没有存放到Redis中通用。

# 相关代码

单实例登录代码：https://github.com/xanderma/sso-single

多实例登录代码：https://github.com/xanderma/sso-mult

单点登录代码：https://github.com/xanderma/sso

# 启动程序

1、配置以下host
```
127.0.0.1 tomcat1.com
127.0.0.1 tomcat2.com
127.0.0.1 nginx.com
```

2、安装Redis，端口为6379

3、安装nginx，并配置以下负载均衡，参考http://blog.csdn.net/zhangskd/article/details/50187407
```
http {  
    upstream cluster {  
        server tomcat1.com:8080;  
        server tomcat2.com:8081;
    } 
   
    server {  
        listen 80;  
        location / {  
            proxy_pass http://cluster;  
        }  
    }  
} 
```

4、启用 SsoMultApplication.java （默认是使用8080端口启动）

5、再使用8081端口启动一次 SsoMultApplication.java（勾掉"Single instance only"，并配置program arguments为"--server.port=8081"）

6、访问http://nginx.com 输入任意用户名登录

# 原理
访问http://nginx.com访问nginx，然后nginx通过负载均衡将请求加权分给任意一个Tomcat处理，而SpringSession将请求拦截，使所有Tomcat都使用Redis中的Session。
