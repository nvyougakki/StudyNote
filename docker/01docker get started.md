# docker get started

1. ## install

   Uninstall old versions

   ```shell
   sudo apt-get remove docker docker-engine docker.io containerd runc
   
   
   // 添加仓库
   sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu xenial stable"
   
   sudo apt-get install \
       apt-transport-https \
       ca-certificates \
       curl \
       gnupg \
       lsb-release
       
    //查看docker所有版本
   apt-cache madison docker-ce 
       
   //win10 linux子系统安装低版本
   sudo apt-get install docker-ce=17.12.1~ce-0~ubuntu
   
   
   //设置镜像仓库
   vim /etc/docker/daemon.json
   
   {
    
     "registry-mirrors": ["https://registry.docker-cn.com"]
    
   }
   
   
   wget https://raw.githubusercontent.com/jamtur01/dockerbook-code/master/code/5/sample/nginx/global.conf
   wget https://raw.githubusercontent.com/jamtur01/dockerbook-code/master/code/5/sample/nginx/nginx.conf
   
   
   //docker ru
   ```

2. 

