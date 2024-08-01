```sh
stroageaccountname=csb100320003adad455
containername="selenium-hub"
az storage blob upload \
    --account-name $stroageaccountname \
    --container-name $containername \
    --name <blob-name> \
    --file <path-to-local-file>
```

```sh
stroageaccountname=csb100320003adad455
containername="podman-rpm"
az storage blob upload-batch \
    --account-name $stroageaccountname \
    --destination $containername \
    --source ./podman/
```