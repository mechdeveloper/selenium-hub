# Install Docker on RHEL

Download the following rpm files for the Docker Engine, CLI, containerd, and Docker Compose

Download URL: <https://download.docker.com/linux/rhel/8/x86_64/stable/Packages/>

```sh
containerd=containerd.io-1.7.19-3.1.el8.x86_64.rpm
docker_ce=docker-ce-27.1.1-1.el8.x86_64.rpm
docker_ce_cli=docker-ce-cli-27.1.1-1.el8.x86_64.rpm 
docker_buildx_plugin=docker-buildx-plugin-0.16.1-1.el8.x86_64.rpm
docker_compose_plugin=docker-compose-plugin-2.29.1-1.el8.x86_64.rpm

# Download Files
curl -o $containerd https://download.docker.com/linux/rhel/8/x86_64/stable/Packages/$containerd
curl -o $docker_ce https://download.docker.com/linux/rhel/8/x86_64/stable/Packages/$docker_ce
curl -o $docker_ce_cli https://download.docker.com/linux/rhel/8/x86_64/stable/Packages/$docker_ce_cli
curl -o $docker_buildx_plugin https://download.docker.com/linux/rhel/8/x86_64/stable/Packages/$docker_buildx_plugin
curl -o $docker_compose_plugin https://download.docker.com/linux/rhel/8/x86_64/stable/Packages/$docker_compose_plugin
```

Upload file to azure storage blob container
```sh
account=csb100320003adad455
container_name=docker
az storage blob delete-batch --account-name $account --source $container_name
az storage blob upload --account-name $account --container-name $container_name --name $containerd --file $containerd
az storage blob upload --account-name $account --container-name $container_name --name $docker_ce --file $docker_ce
az storage blob upload --account-name $account --container-name $container_name --name $docker_ce_cli --file $docker_ce_cli
az storage blob upload --account-name $account --container-name $container_name --name $docker_buildx_plugin --file $docker_buildx_plugin
az storage blob upload --account-name $account --container-name $container_name --name $docker_compose_plugin --file $docker_compose_plugin
```

URLs
```sh
rm *.rpm
curl -o $containerd https://csb100320003adad455.blob.core.windows.net/docker/$containerd
curl -o $docker_ce https://csb100320003adad455.blob.core.windows.net/docker/$docker_ce
curl -o $docker_ce_cli https://csb100320003adad455.blob.core.windows.net/docker/$docker_ce_cli
curl -o $docker_buildx_plugin https://csb100320003adad455.blob.core.windows.net/docker/$docker_buildx_plugin
curl -o $docker_compose_plugin https://csb100320003adad455.blob.core.windows.net/docker/$docker_compose_plugin
```


Download Required Dependencies
```sh
wget http://mirror.centos.org/centos/8/BaseOS/x86_64/os/Packages/container-selinux-2.167.0-1.module_el8.3.0+570+f3e1bb7e.noarch.rpm
wget http://mirror.centos.org/centos/8/BaseOS/x86_64/os/Packages/libcgroup-0.41-19.el8.x86_64.rpm
```

Uninstall old versions
```sh
sudo yum remove docker \
  docker-client \
  docker-client-latest \
  docker-common \
  docker-latest \
  docker-latest-logrotate \
  docker-logrotate \
  docker-engine \
  podman \
  runc
```

Install Docker Engine
```sh
rpm -qa | grep docker
sudo yum remove docker-ce docker-ce-cli containerd.io
sudo yum install --nobest --disablerepo=* ./$containerd \
  ./$docker_ce \
  ./$docker_ce_cli \
  ./$docker_buildx_plugin \
  ./$docker_compose_plugin

sudo dnf install *.rpm --disablerepo '*'
```


Start Docker
```sh
sudo systemctl daemon-reload
sudo systemctl enable docker
sudo systemctl start docker
```

Add your user to the docker group.
```sh
sudo usermod -aG docker $USER
```

