```
docker network create \
  --subnet=172.18.0.0/16 \
  grid
```

```
docker run -d \
  --network grid \
  --ip 172.18.0.2 \
  --name hub \
  --restart always \
  -p 4444:4444 \
  selenium/hub:3.14.0-europium
```

```
docker run -d \
  --network grid \
  --ip 172.18.0.3 \
  --name chrome \
  --restart always \
  -e HUB_HOST=172.18.0.2 \
  -e HUB_PORT=4444 \
  selenium/node-chrome-debug:3.14.0-europium
```

```
docker run -d \
  --network grid \
  --ip 172.18.0.4 \
  --name firefox \
  --restart always \
  -e HUB_HOST=172.18.0.2 \
  -e HUB_PORT=4444 \
  selenium/node-firefox-debug:3.14.0-europium
```