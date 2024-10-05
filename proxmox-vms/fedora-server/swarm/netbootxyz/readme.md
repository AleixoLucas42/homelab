## NETBOOTXYZ
netboot.xyz enables you to boot into many types of operating systems using lightweight tooling to get you up and running as soon as possible.

## Setup
- I had to change the [windows.ipxe](windows.ipxe) to make custom to my lab
- I created a new SMB share on my TrueNAS and mount as CIFS in swarm cluster so my netbootxyz container can mount as volume
  - This way I can manipulate files from windows explorer, and also, when I pull some image in netbootxyz, the iso go to my SMB
- I created a service account on my Zentyal server to connect this SMB as rw
- I made this two files for init script to start windows setup from my SMB (you can check how they work on windows.ipxe file)
#### winpeshl.ini
```powershell
[LaunchApps]
"auto.bat"
```
#### auto.bat
```cmd
@echo off
echo Initializing network
wpeinit

echo Connecting to Shared Drive
net use \\10.11.12.247\netbootxyz /user:ALEIXOHOME\sa-netbootxyz password

echo Starting installer
\\10.11.12.247\netbootxyz\win\x64\win10_22h2_english\setup.exe

echo Press any key to continue
pause

```
## Deploy stack
> docker stack deploy -c docker-compose.yaml netbootxyz
- https://app.netbootxyz.aleixohome.lan
- https://netbootxyz.aleixohome.lan

## This links helped me a lot to setup and understand 
- [Official website](https://netboot.xyz/)
- https://a-t-engineering.com/en/pxe-network-boot-using-netboot-xyz-under-docker/
- https://technotim.live/posts/netbootxyz-tutorial/
- https://thunderysteak.github.io/windows-setup-driver-injection
- https://rpi4cluster.com/pxe-windows-10/
