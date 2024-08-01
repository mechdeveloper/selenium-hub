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
    --account-name <storage-account-name> \
    --container-name <container-name> \
    --name <blob-name> \
    --file <path-to-local-file>
```