

# Linux下安装

- 安装c语言依赖

  yum -y install gcc automake autoconf libtool make

- 下载包

- tar zvxf 解压
- 编译   make MALLOC=libc
- 安装  make PREFIX=/usr/local/redis install

![1569055749206](.\pic\1569055749206.png)

- ./redis-server  启动redis服务端

## 配置

复制解压目录下的redis.conf到redis安装目录

vi redis.conf

- 改为守护进程模式，no改为yes

![1569056309958](.\pic\1569056309958.png)

- 端口配置

  ![1569056429989](.\pic\1569056429989.png)

- 设置远程可访问：注释69行

  ![1569056568118](.\pic\1569056568118.png)

- database 16  默认16个数据库

- 数据持久化条件

  ![1569056788792](.\pic\1569056788792.png)

- dbfilename dump.rdb 本地数据库文件名

- 配置密码 

  ![1569057386443](.\pic\1569057386443.png)