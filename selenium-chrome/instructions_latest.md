# Selenium Grid Standalone with Chrome

<https://csb100320003adad455.blob.core.windows.net/selenium-hub/standalone-chrome-latest.tar>

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

URLs
- Point your WebDriver tests to: <http://52.224.232.217:4444/wd/hub⁠>
- (Optional) To see what is happening inside the container: <http://52.224.232.217:7900/?autoconnect=1&resize=scale&password=secret⁠>