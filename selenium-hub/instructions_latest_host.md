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
docker run -d --network host --name hub selenium/hub:latest
```

```sh
docker run -d \
    --network host \
    --name chrome \
    -e SE_EVENT_BUS_HOST=localhost \
    --shm-size="2g" \
    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
    selenium/node-chrome:latest
```

```sh
docker run -d \
    -e SE_EVENT_BUS_HOST=localhost \
    --network host \
    --name firefox \
    --shm-size="2g" \
    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
    selenium/node-firefox:latest
```