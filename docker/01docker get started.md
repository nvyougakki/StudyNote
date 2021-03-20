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
   ```

2. 

