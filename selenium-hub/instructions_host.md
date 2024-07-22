```
docker run -d \
  --network host \
  --name hub \
  selenium/hub:3.14.0-europium
```

```
docker run -d \
  --network host \
  --name chrome \
  -e HUB_HOST=localhost \
  -e HUB_PORT=4444 \
  selenium/node-chrome-debug:3.14.0-europium
```

```
docker run -d \
  --network host \
  --name firefox \
  -e HUB_HOST=localhost \
  -e HUB_PORT=4444 \
  selenium/node-firefox-debug:3.14.0-europium
```