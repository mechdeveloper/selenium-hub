# Install Docker on RHEL

Download the following rpm files for the Docker Engine, CLI, containerd, and Docker Compose

Download URL: <https://download.docker.com/linux/rhel/8/x86_64/stable/Packages/>

```sh
rhelVersion=9
containerd=containerd.io-1.7.19-3.1.el9.x86_64.rpm
docker_ce=docker-ce-27.1.1-1.el9.x86_64.rpm
docker_ce_cli=docker-ce-cli-27.1.1-1.el9.x86_64.rpm
docker_buildx_plugin=docker-buildx-plugin-0.16.1-1.el9.x86_64.rpm
docker_compose_plugin=docker-compose-plugin-2.29.1-1.el9.x86_64.rpm
docker_ce_rootless_extras=docker-ce-rootless-extras-27.1.1-1.el9.x86_64.rpm

# Download Files
curl -o $containerd https://download.docker.com/linux/rhel/$rhelVersion/x86_64/stable/Packages/$containerd
curl -o $docker_ce https://download.docker.com/linux/rhel/$rhelVersion/x86_64/stable/Packages/$docker_ce
curl -o $docker_ce_cli https://download.docker.com/linux/rhel/$rhelVersion/x86_64/stable/Packages/$docker_ce_cli
curl -o $docker_buildx_plugin https://download.docker.com/linux/rhel/$rhelVersion/x86_64/stable/Packages/$docker_buildx_plugin
curl -o $docker_compose_plugin https://download.docker.com/linux/rhel/$rhelVersion/x86_64/stable/Packages/$docker_compose_plugin
curl -o $docker_ce_rootless_extras https://download.docker.com/linux/rhel/$rhelVersion/x86_64/stable/Packages/$docker_ce_rootless_extras
```

Upload file to azure storage blob container
```sh
account=csb100320003adad455
container_name=docker
az storage blob upload-batch \
    --account-name $account \
    --destination $container_name \
    --source ./docker-rpm/
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

Install Docker Engine
```sh
sudo yum install \
  ./$containerd \
  ./$docker_ce \
  ./$docker_ce_cli \
  ./$docker_buildx_plugin \
  ./$docker_compose_plugin \
  ./$docker_ce_rootless_extras

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
newgrp docker
```

