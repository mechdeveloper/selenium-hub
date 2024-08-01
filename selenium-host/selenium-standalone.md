Install Java 11
```sh
sudo yum install java-11-openjdk
```

```sh
java -version
```

Download Selenium Server
```sh
version=4.23.0
fileName=selenium-server-$version.jar
curl -o $fileName https://csb100320003adad455.blob.core.windows.net/selenium-hub/$fileName
```

```sh
version=4.23.0
fileName=selenium-server-$version.jar
scp $fileName azureuser@40.117.210.94:
```


Standalone 

Standalone combines all Grid components seamlessly into one. Running a Grid in Standalone mode gives you a fully functional Grid with a single command, within a single process. Standalone can only run on a single machine.

```sh
java -jar selenium-server-4.23.0.jar standalone
```

After starting successfully the Grid in Standalone mode, point your WebDriver tests to http://localhost:4444.

Configure as a service

```sh
sudo mkdir /opt/selenium/
sudo mv selenium-server-4.23.0.jar /opt/selenium/
```

```sh
sudo vi /etc/systemd/system/selenium-standalone.service
```

```service
[Unit]
Description=Selenium Hub
After=network.target

[Service]
User=azureuser
ExecStart=/usr/bin/java -jar /opt/selenium/selenium-server-4.23.0.jar standalone
Restart=always

[Install]
WantedBy=multi-user.target
```

```sh
sudo systemctl stop selenium-standalone
sudo systemctl daemon-reload

sudo systemctl start selenium-standalone
sudo systemctl enable selenium-standalone
```

```sh
sudo systemctl status selenium-standalone
```

Open Firewall port

```sh
sudo firewall-cmd --zone=public --add-port=4444/tcp --permanent
sudo firewall-cmd --reload
sudo firewall-cmd --zone=public --list-ports
```


Install chrome driver
```sh
wget https://storage.googleapis.com/chrome-for-testing-public/127.0.6533.88/linux64/chromedriver-linux64.zip
unzip chromedriver-linux64.zip 
chmod +x chromedriver
sudo mv chromedriver-linux64/chromedriver /usr/local/bin/
```

```sh
sudo mkdir /opt/selenium/chrome/
sudo mv chromedriver-linux64/chromedriver /opt/selenium/chrome/
chmod +x  /opt/selenium/chrome/chromedriver
ls -al /opt/selenium/chrome/

Update Path
echo $PATH
export PATH=$PATH:/opt/selenium/chrome

chromedriver --version
```

Upload to azure storage
```sh
stroageaccountname=csb100320003adad455
containername="selenium-hub"
fileToUpload=chromedriver-linux64.zip
az storage blob upload \
    --account-name $stroageaccountname \
    --container-name $containername \
    --name $fileToUpload \
    --file $fileToUpload
```

File link
```
https://csb100320003adad455.blob.core.windows.net/selenium-hub/chromedriver-linux64.zip
```


Install Chrome
```
wget https://csb100320003adad455.blob.core.windows.net/selenium-hub/google-chrome-stable_current_x86_64.rpm
sudo yum install ./google-chrome-stable_current_x86_64.rpm
google-chrome --version
```
