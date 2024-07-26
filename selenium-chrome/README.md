# Selenium Standalone Chrome

DockerHub: https://hub.docker.com/r/selenium/standalone-chrome

```sh
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-chrome:latest
```

- Point your WebDriver tests to <http://localhost:4444⁠>
- (Optional) To see what is happening inside the container, head to <http://localhost:7900/?autoconnect=1&resize=scale&password=secret⁠>.


Export Image
```sh
docker save -o standalone-chrome-latest.tar selenium/standalone-chrome:latest
```

Copy files from remote server
```sh
scp azureuser@52.224.232.217:/home/azureuser/standalone-chrome-latest.tar .
```

Upload file to azure storage blob container
```sh
az storage blob upload \
  --account-name csb100320003adad455 \
  --container-name selenium-hub \
  --name standalone-chrome-latest.tar \
  --file standalone-chrome-latest.tar
```

Import Image
```sh
docker load -i standalone-chrome-latest.tar
```

