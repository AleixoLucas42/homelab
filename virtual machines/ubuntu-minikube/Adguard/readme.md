# Adguard
AdGuard Home is a web-wide ad blocking and tracking DNS server. Its purpose is to allow you to control your entire network and devices without having to install a program.

## Setup
- wget `https://github.com/AdguardTeam/AdGuardHome/releases/download/v0.107.23/AdGuardHome_linux_amd64.tar.gz`
- tar -vxf AdGuardHome_*.tar.gz
- sudo mv AdGuardHome /opt/AdGuardHome
- sudo chown -R root:root /opt/AdGuardHome
- sudo chmod -R o-rwx /opt/AdGuardHome
- sudo apt install acl (optional [ can ensure that any files created in the AdGuardHome directory also follow the permissions we set above])
- sudo setfacl -d -m o::--- /opt/AdGuardHome
- sudo /opt/AdGuardHome/AdGuardHome -s install

## Block list configured
- [Bloqueia páginas e serviços de mineração](https://github.com/zangadoprojets/pi-hole-block-list/raw/main/Miningpages.txt)
- [Bloqueia páginas com conteúdo XXX Porn](https://github.com/zangadoprojets/pi-hole-block-list/raw/main/Pornpages.txt)
- [Bloqueia telemetria do SO Windows e outros Sistemas](https://github.com/zangadoprojets/pi-hole-block-list/raw/main/Telemetry.txt)
- [Bloqueia domínios com vírus](https://github.com/zangadoprojets/pi-hole-block-list/raw/main/Malicious.txt)
- [Bloqueia domínios com ransomware](https://github.com/zangadoprojets/pi-hole-block-list/raw/main/ransomware.txt)
- [Bloqueia domínios com e-mail spam](https://github.com/zangadoprojets/pi-hole-block-list/raw/main/spam.mails.txt)
- [Block Ads Youtube](https://github.com/zangadoprojets/pi-hole-block-list/raw/main/youtube.txt)
- [Some of these list pack](https://firebog.net)

## Usefull links
- [Download Adguard](https://github.com/AdguardTeam/AdGuardHome/releases/tag/v0.107.23)
- [Adguard site](https://adguard.com/pt_br/welcome.html)
- [Lista de Bloqueio (Blocklist) para dns](https://github.com/zangadoprojets/pi-hole-blocklist)
- [Another lists](https://firebog.net/)