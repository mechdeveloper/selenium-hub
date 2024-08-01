```
https://csb100320003adad455.blob.core.windows.net/selenium-hub/selenium-hub-latest.tar
https://csb100320003adad455.blob.core.windows.net/selenium-hub/selenium-node-chrome-latest.tar
https://csb100320003adad455.blob.core.windows.net/selenium-hub/selenium-node-firefox-latest.tar
```

```sh
docker load -i selenium-hub-latest.tar
docker load -i selenium-node-chrome-latest.tar
docker load -i selenium-node-firefox-latest.tar
```

```sh
docker network create grid
```

```sh
docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:latest
```

```sh
docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub \
    --shm-size="2g" \
    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
    selenium/node-chrome:latest
```

```sh
docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub \
    --shm-size="2g" \
    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
    selenium/node-firefox:latest
```