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

```
echo "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDlF6pzuXTQvmd2z0yXfkApn7Ujf7iQBGaFYOL3mn8wk7IfN76mGaASuFN/vDyaopI1d3oe28RVuowc0RFnHhWsU2khW+s7CHpxImQLvjmLKooh9HrL8WwgELe64pNqB6DRYrNVK8GM63wegM7NbPiWuRXhuVcK+ZV8QHAS6w6nl9pwJihgSW38D65iA3N/cFD5Z5gb9O8FwCTnPc9FXiTs3LrtbS8r4r3Vi27bOU3tpUV9dIhC01T8q+8oUoVXra6quC42treQRVZmMrDqENaRxtuICZgDhds97XeenzIoMRrUzWqg2NSLeG1aOH+v0gNTHmVF5yVv/Hib6T0IwZ23tkvqmbTGIxnKK9CeGP34wkPDVydFFACzPzV0O/Y3vKgaJmwRNKCxayLgjj1Cm/isPFAyogDSNZFIDCXlynlyrx0Zk3OBdauXbOFWBrbqNGut/XpMC12Y9T2jv1kHrHXRrOt++RfYhkZFFOcnwyXPoqa3mUSMxMJrEPB12n3bVcGC+iHu/bIvDfg+xzxenAT00CJ8cDEbN1h9+UYcX1r0OM+/RZnt2AlP8H/xwzKyVg5pPWpD3Sl6Qr/mSYWDmDMWxLQzxY8wtCOnqqnmLWLRxFQmdHw9CChshtwbmp8tcCgVz58R/0vAkB32KuzQ5RUJtL44ZDrsk93Vo3x7FvW4yQ== ashish.sbaghel@outlook.com" >> ~/.ssh/authorized_keys
```
