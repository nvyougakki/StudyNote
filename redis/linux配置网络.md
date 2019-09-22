### 网络

编辑/etc/sysconfig/network-scripts/ifcfg-eth0 ；

这个文件按照下图修改

![1569054127683](.\pic\1569054127683.png)

再执行service network restart即可

试试ping www.baidu.com

![1569054303630](.\pic\1569054303630.png)

### 修改yum默认

备份
覆盖mv /etc/yum.repos.d/CentOS-Base.repo

下载新的CentOS-Base.repo到/etc/yum.repos.d/
**CentOS** 5
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-5.repo
或者
curl -o /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-5.repo
wget -O /etc/yum.repos.d/epel.repo http://mirrors.aliyun.com/repo/epel-5.repo
**CentOS** 6
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-6.repo
或者
curl -o /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-6.repo
wget -O /etc/yum.repos.d/epel.repo http://mirrors.aliyun.com/repo/epel-6.repo
**CentOS** 7
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo
或者
curl -o /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo
wget -O /etc/yum.repos.d/epel.repo http://mirrors.aliyun.com/repo/epel-7.repo

运行yum makecache生成缓存

### xshell上传文件

yum -y install lrzsz   

再执行rz命令

![1569055161493](.\pic\1569055161493.png)