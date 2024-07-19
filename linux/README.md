Generate SSH Key Pair

```
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

Copy Public Key to Remote Machine

```
cat ~/.ssh/id_rsa.pub
```

Login to linux server

```
ssh username@remote_host
```

Append the copied public key to `~/.ssh/authorized_keys` file

```
echo "copied_public_key" >> ~/.ssh/authorized_keys
```
