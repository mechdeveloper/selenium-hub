# Selenium Grid Standalone with Chrome

<https://csb100320003adad455.blob.core.windows.net/selenium-hub/standalone-chrome-latest.tar>
<https://csb100320003adad455.blob.core.windows.net/selenium-hub/seleniarm-standalone-chromium.tar>

Import Image
```sh
docker load -i standalone-chrome-latest.tar
```

Run container with port mapping
```sh
docker run --name standalone-chrome -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-chrome:latest
```

Run container with attached host network
```sh
docker run --name standalone-chrome -d --network host --shm-size="2g" selenium/standalone-chrome:latest
```

Add Host
```sh
docker run --name standalone-chrome --add-host mycustomhost:192.168.1.100 -d --network host --shm-size="2g" selenium/standalone-chrome:latest
```

# seleniarm/standalone-chromium
```sh
docker pull seleniarm/standalone-chromium
docker save -o seleniarm-standalone-chromium.tar seleniarm/standalone-chromium
```
```sh
docker load -i seleniarm-standalone-chromium.tar
docker run --name standalone-chrome -d --network host --shm-size="2g" seleniarm/standalone-chromium:latest
````

```
```sh
stroageaccountname=csb100320003adad455
containername="selenium-hub"
az storage blob upload \
    --account-name $stroageaccountname \
    --container-name $containername \
    --name seleniarm-standalone-chromium.tar \
    --file seleniarm-standalone-chromium.tar
```
```


URLs
- Point your WebDriver tests to: <http://hostname:4444>
- (Optional) To see what is happening inside the container: <http://hostname:7900/?autoconnect=1&resize=scale&password=secret⁠>