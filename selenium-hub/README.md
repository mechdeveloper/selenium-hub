# Deploy Selenium Hub and Nodes

Create a Docker Network

```
docker network create \
  --subnet=172.18.0.0/16 \
  grid
```

Start the Selenium Hub container using the created network

```
docker run -d \
  --network grid \
  --ip 172.18.0.2 \
  --name hub \
  --restart always \
  -p 4444:4444 \
  selenium/hub:3.14.0-europium
```

Start the Selenium Node Chrome using the created network

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

Start the Selenium Node Firefox using the created network

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

URLS to validate selenium hub

```
http://<hostname>:4444/grid/console
http://<hostname>:4444/wd/hub/status
http://<hostname>:4444/wd/hub
```

```
http://52.224.232.217:4444/grid/console
http://52.224.232.217:4444/wd/hub
http://52.224.232.217:4444/wd/hub/status
```

## Option: Deploy Selenium Hub and Nodes with Host Network

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

```
http://localhost:4444/grid/console
http://localhost:4444/wd/hub/status
http://localhost:4444/wd/hub
```


## Docker Compose to simplify deployment

Create a `docker-compose.yml` file with the following content:

```yml
version: '3'
services:
  selenium-hub:
    image: selenium/hub:3.14.0-europium
    container_name: selenium-hub
    ports:
      - "4444:4444"
    networks:
      - selenium-grid

  chrome:
    image: selenium/node-chrome-debug:3.14.0-europium
    container_name: selenium-node-chrome
    environment:
      - HUB_HOST=selenium-hub
      - HUB_PORT=4444
    depends_on:
      - selenium-hub
    networks:
      - selenium-grid

  firefox:
    image: selenium/node-firefox-debug:3.14.0-europium
    container_name: selenium-node-firefox
    environment:
      - HUB_HOST=selenium-hub
      - HUB_PORT=4444
    depends_on:
      - selenium-hub
    networks:
      - selenium-grid

networks:
  selenium-grid:
    driver: bridge

```

Then, run the following command in the directory where the `docker-compose.yml` file is located:
```
docker-compose up -d
```