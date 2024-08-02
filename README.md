# Build your project

```
mvn clean install
```

# Run your tests

```
mvn clean test
```

Upload to Azure
```sh
stroageaccountname=csb100320003adad455
containername="selenium-hub"
az storage blob upload \
    --account-name $stroageaccountname \
    --container-name $containername \
    --name nginx.tar \
    --file nginx.tar
```

