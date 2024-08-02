<https://csb100320003adad455.blob.core.windows.net/selenium-hub/nginx.tar>

Import Image
```sh
docker load -i nginx.tar
```

```sh
docker run -d -p 8080:80 --name web nginx
```

<http://localhost:8080>