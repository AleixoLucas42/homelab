## Wazuh Configuration Assessment
I'm just taking notes about how/what I've fixed in Configuration Assessment section.


## CIS Microsoft Windows 10 Enterprise Benchmark v1.12.0
\*I managed to reach 80% of compliance. Configurations done:

| ID    |                                                   Title                                                   | Fix Method |
| ----- | --------------------------------------------------------------------------------------------------------- | ---------- |
| 15500 | Ensure 'Enforce password history' is set to '24 or more password(s)'.                                     | GPO        |
| 15500 | Ensure 'Enforce password history' is set to '24 or more password(s)'.                                     | GPO        |
| 15502 | Ensure 'Minimum password age' is set to '1 or more day(s)'.                                               | GPO        |
| 15503 | Ensure 'Minimum password length' is set to '14 or more character(s)'.                                     | GPO        |
| 15505 | Ensure 'Relax minimum password length limits' is set to 'Enabled'.                                        | GPO        |
| 15506 | Ensure 'Account lockout duration' is set to '15 or more minute(s)'.                                       | GPO        |
| 15507 | Ensure 'Account lockout threshold' is set to '5 or fewer invalid logon                                    | GPO        |
| 15508 | Ensure 'Reset account lockout counter after' is set to '15 or more minute(s)'.                            | GPO        |
| 15510 | Ensure 'Accounts: Block Microsoft accounts' is set to 'Users can't add or[...]                            | GPO        |
| 15510 | Ensure 'Accounts: Block Microsoft accounts' is set to 'Users can't add or[...]                            | GPO        |
| 15513 | Configure 'Accounts: Rename administrator account'.                                                       | GPO        |
| 15514 | Configure 'Accounts: Rename guest account'.                                                               | GPO        |
| 15517 | Ensure 'Devices: Allowed to format and eject removable media' is set to 'Admi[...]                        | GPO        |
| 15518 | Ensure 'Devices: Prevent users from installing printer drivers' is set to 'Enabled                        | GPO        |
| 15523 | Ensure 'Domain member: Maximum machine account password age' is set to[...]                               | GPO        |
| 15525 | Ensure 'Interactive logon: Do not require CTRL+ALT+DEL' is set to 'Disable[...]                           | GPO        |
| 15526 | Ensure 'Interactive logon: Don't display last signed-in' is set to 'Enabled'.                             | GPO        |
| 15527 | Ensure 'Interactive logon: Machine account lockout threshold' is set to '10 o[...]                        | GPO        |
| 15528 | Ensure 'Interactive logon: Machine inactivity limit' is set to '900 or fewer seco[...]                    | GPO        |
| 15531 | Ensure 'Interactive logon: Number of previous logons to cache (in case do[...]                            | GPO        |
| 15544 | Ensure 'Network access: Do not allow anonymous enumeration of SAM acco[...]                               | GPO        |
| 15545 | Ensure 'Network access: Do not allow storage of passwords and credentia[...]                              | GPO        |
| 15575 | Ensure 'Bluetooth Audio Gateway Service (BTAGService)' is set to 'Disabled'.                              | GPO        |
| 15576 | Ensure 'Bluetooth Support Service (bthserv)' is set to 'Disabled'.                                        | GPO        |
| 15577 | Ensure 'Downloaded Maps Manager (MapsBroker)' is set to 'Disabled'.                                       | GPO        |
| 15578 | Ensure 'Geolocation Service (lfsvc)' is set to 'Disabled'.                                                | GPO        |
| 15582 | Ensure 'Link-Layer Topology Discovery Mapper (lltdsvc)' is set to 'Disabled'.                             | GPO        |
| 15591 | Ensure 'Print Spooler (Spooler)' is set to 'Disabled'.                                                    | GPO        |
| 15592 | Ensure 'Problem Reports and Solutions Control Panel Support (wercplsupport)'[...]                         | GPO        |
| 15597 | Ensure 'Remote Procedure Call (RPC) Locator (RpcLocator)' is set to 'Disabled'                            | GPO        |
| 15604 | Ensure 'SSDP Discovery (SSDPSRV)' is set to 'Disabled'.                                                   | GPO        |
| 15605 | Ensure 'UPnP Device Host (upnphost)' is set to 'Disabled'.                                                | GPO        |
| 15607 | Ensure 'Windows Error Reporting Service (WerSvc)' is set to 'Disabled'.                                   | GPO        |
| 15611 | Ensure 'Windows Push Notifications System Service (WpnService)' is set to 'Di[...]                        | GPO        |
| 15623 | Ensure 'Windows Firewall: Domain: Logging: Name' is set to '%SystemRoot%\Sy[...]                          | GPO        |
| 15624 | Ensure 'Windows Firewall: Domain: Logging: Size limit (KB)' is set to '16,384 KB[...]                     | GPO        |
| 15625 | Ensure 'Windows Firewall: Domain: Logging: Log dropped packets' is set to 'Yes'.                          | GPO        |
| 15626 | Ensure 'Windows Firewall: Domain: Logging: Log successful connections' is set[...]                        | GPO        |
| 15645 | Ensure 'Audit Credential Validation' is set to 'Success and Failure'.                                     | GPO        |
| 15646 | Ensure 'Audit Application Group Management' is set to 'Success and Failure'.                              | GPO        |
| 15648 | Ensure 'Audit User Account Management' is set to 'Success and Failure'.                                   | GPO        |
| 15649 | Ensure 'Audit PNP Activity' is set to include 'Success'.                                                  | GPO        |
| 15650 | Ensure 'Audit Process Creation' is set to include 'Success'.                                              | GPO        |
| 15651 | Ensure 'Audit Account Lockout' is set to include 'Failure'.                                               | GPO        |
| 15652 | Ensure 'Audit Group Membership' is set to include 'Success'.                                              | GPO        |
| 15655 | Ensure 'Audit Other Logon/Logoff Events' is set to 'Success and Failure'.                                 | GPO        |
| 15657 | Ensure 'Audit Detailed File Share' is set to include 'Failure'.                                           | GPO        |
| 15658 | Ensure 'Audit File Share' is set to 'Success and Failure'.                                                | GPO        |
| 15659 | Ensure 'Audit Other Object Access Events' is set to 'Success and Failure'.                                | GPO        |
| 15660 | Ensure 'Audit Removable Storage' is set to 'Success and Failure'.                                         | GPO        |
| 15663 | Ensure 'Audit Authorization Policy Change' is set to include 'Success'.                                   | GPO        |
| 15664 | Ensure 'Audit MPSSVC Rule-Level Policy Change' is set to 'Success and Failure'.                           | GPO        |
| 15665 | Ensure 'Audit Other Policy Change Events' is set to include 'Failure'.                                    | GPO        |
| 15666 | Ensure 'Audit Sensitive Privilege Use' is set to 'Success and Failure'.                                   | GPO        |
| 15667 | Ensure 'Audit IPsec Driver' is set to 'Success and Failure'.                                              | GPO        |
| 15668 | Ensure 'Audit Other System Events' is set to 'Success and Failure'.                                       | GPO        |
| 15669 | Ensure 'Audit Security State Change' is set to include 'Success'.                                         | GPO        |
| 15670 | Ensure 'Audit Security System Extension' is set to include 'Success'.                                     | GPO        |
| 15671 | Ensure 'Audit System Integrity' is set to 'Success and Failure'.                                          | GPO        |
| 15672 | Ensure 'Prevent enabling lock screen camera' is set to 'Enabled'.                                         | GPO        |
| 15673 | Ensure 'Prevent enabling lock screen slide show' is set to 'Enabled'.                                     | GPO        |
| 15674 | Ensure 'Allow users to enable online speech recognition services' is set to 'Dis[...]                     | GPO        |
| 15675 | Ensure 'Allow Online Tips' is set to 'Disabled'.                                                          | GPO        |
| 15703 | Ensure 'Turn off multicast name resolution' is set to 'Enabled'.                                          | GPO        |
| 15708 | Ensure 'Turn off Microsoft Peer-to-Peer Networking Services' is set to 'Enable[...]                       | GPO        |
| 15709 | Ensure 'Prohibit installation and configuration of Network Bridge on your DNS[...]                        | GPO        |
| 15710 | Ensure 'Prohibit use of Internet Connection Sharing on your DNS domain netw[...]                          | GPO        |
| 15711 | Ensure 'Require domain users to elevate when setting a network's location'[...]                           | GPO        |
| 15713 | Disable IPv6 (Ensure TCPIP6 Parameter 'DisabledComponents' is set to '0xff[...]                           | REG        |
| 15714 | Ensure 'Configuration of wireless settings using Windows Connect Now' is set[...]                         | GPO        |
| 15715 | Ensure 'Prohibit access of the Windows Connect Now wizards' is set to 'Enabl[...]                         | GPO        |
| 15716 | Ensure 'Minimize the number of simultaneous connections to the Internet or a[...]                         | GPO        |
| 15717 | Ensure 'Prohibit connection to non-domain networks when connected to domain authe[...]                    | GPO        |
| 15718 | Ensure 'Allow Windows to automatically connect to suggested open hotspots[...]                            | GPO        |
| 15719 | Ensure 'Allow Print Spooler to accept client connections' is set to 'Disabled'.                           | GPO        |
| 15722 | Ensure 'Turn off notifications network usage' is set to 'Enabled'.                                        | GPO        |
| 15723 | Ensure 'Include command line in process creation events' is set to 'Enabled'.                             | GPO        |
| 15724 | *Ensure 'Encryption Oracle Remediation' is set to 'Enabled: Force Updated Clie[...]                       | GPO        |
| 15725 | *Ensure 'Remote host allows delegation of non-exportable credentials' is set to[...]                      | GPO        |
| 15734 | Ensure 'Configure registry policy processing: Do not apply during periodic bac[..]                        | GPO        |
| 15735 | Ensure 'Configure registry policy processing: Process even if the Group Policy[...]                       | GPO        |
| 15736 | Ensure 'Continue experiences on this device' is set to 'Disabled'.                                        | GPO        |
| 15738 | Ensure 'Turn off access to the Store' is set to 'Enabled'.                                                | GPO        |
| 15739 | Ensure 'Turn off downloading of print drivers over HTTP' is set to 'Enabled'.                             | GPO        |
| 15740 | Ensure 'Turn off handwriting personalization data sharing' is set to 'Enabled'.                           | GPO        |
| 15741 | Ensure 'Turn off handwriting recognition error reporting' is set to 'Enabled'.                            | GPO        |
| 15742 | Ensure 'Turn off Internet Connection Wizard if URL connection is referring to Mic[...]                    | GPO        |
| 15743 | Ensure 'Turn off Internet download for Web publishing and online ordering wiza[...]                       | GPO        |
| 15744 | Ensure 'Turn off printing over HTTP' is set to 'Enabled'.                                                 | GPO        |
| 15745 | Ensure 'Turn off Registration if URL connection is referring to Microsoft.com' is[...]                    | GPO        |
| 15746 | Ensure 'Turn off Search Companion content file updates' is set to 'Enabled'.                              | GPO        |
| 15747 | Ensure 'Turn off the "Order Prints" picture task' is set to 'Enabled'.                                    | GPO        |
| 15748 | Ensure'Turn off the "Publish to Web" task for files and folders' is set to 'Enabled'.                     | GPO        |
| 15749 | Ensure 'Turn off the Windows Messenger Customer Experience Improvement [...]                              | GPO        |
| 15750 | Ensure 'Turn off Windows Customer Experience Improvement Program' is set to[...]                          | GPO        |
| 15751 | Ensure 'Turn off Windows Error Reporting' is set to 'Enabled'.                                            | GPO        |
| 15753 | Ensure 'Enumeration policy for external devices incompatible with Kernel DMA[...]                         | GPO        |
| 15754 | *Ensure 'Disallow copying of user input methods to the system account for sign[...]                       | GPO        |
| 15755 | Ensure 'Block user from showing account details on sign-in' is set to 'Enabled'.                          | GPO        |
| 15756 | Ensure 'Do not display network selection UI' is set to 'Enabled'.                                         | GPO        |
| 15757 | Ensure 'Do not enumerate connected users on domain-joined computers' is set[...]                          | GPO        |
| 15759 | Ensure 'Turn off app notifications on the lock screen' is set to 'Enabled'.                               | GPO        |
| 15760 | Ensure 'Turn off picture password sign-in' is set to 'Enabled'.                                           | GPO        |
| 15762 | Ensure 'Allow Clipboard synchronization across devices' is set to 'Disabled'.                             | GPO        |
| 15763 | Ensure 'Allow upload of User Activities' is set to 'Disabled'.                                            | GPO        |
| 15764 | Ensure 'Allow network connectivity during connected-standby (on battery)' is[...]                         | GPO        |
| 15764 | Ensure 'Allow network connectivity during connected-standby (on battery)' is set[...]                     | GPO        |
| 15765 | Ensure 'Allow network connectivity during connected-standby (plugged in)' is [...]                        | GPO        |
| 15769 | Ensure 'Configure Solicited Remote Assistance' is set to 'Disabled'.                                      | GPO        |
| 15770 | *Ensure 'Enable RPC Endpoint Mapper Client Authentication' is set to 'Enabled'.                           | GPO        |
| 15772 | Ensure 'Microsoft Support Diagnostic Tool: Turn on MSDT interactive communication with support [...]      | GPO        |
| 15773 | Ensure 'Enable/Disable PerfTrack' is set to 'Disabled'.                                                   | GPO        |
| 15774 | Ensure 'Turn off the advertising ID' is set to 'Enabled'.                                                 | GPO        |
| 15775 | Ensure 'Enable Windows NTP Client' is set to 'Enabled'.                                                   | GPO        |
| 15778 | Ensure 'Prevent non-admin users from installing packaged Windows apps' is [...]                           | GPO        |
| 15779 | Ensure 'Let Windows apps activate with voice while the system is locked' is set [...]                     | GPO        |
| 15780 | Ensure 'Allow Microsoft accounts to be optional' is set to 'Enabled'.                                     | GPO        |
| 15781 | Ensure 'Block launching Universal Windows apps with Windows Runtime API access from hosted [...]          | GPO        |
| 15782 | Ensure 'Disallow Autoplay for non-volume devices' is set to 'Enabled'.                                    | GPO        |
| 15783 | Ensure 'Set the default behavior for AutoRun' is set to 'Enabled: Do not execute any autorun [...]        | GPO        |
| 15784 | Ensure 'Turn off Autoplay' is set to 'Enabled: All drives'.                                               | GPO        |
| 15785 | Ensure 'Configure enhanced anti-spoofing' is set to 'Enabled'.                                            | GPO        |
| 15787 | Ensure 'Turn off cloud consumer account state content' is set to 'Enabled'.                               | GPO        |
| 15788 | Ensure 'Turn off cloud optimized content' is set to 'Enabled'.                                            | GPO        |
| 15789 | Ensure 'Turn off Microsoft consumer experiences' is set to 'Enabled'.                                     | GPO        |
| 15790 | Ensure 'Require pin for pairing' is set to 'Enabled: First Time' OR 'En[...]                              | GPO        |
| 15791 | Ensure 'Do not display the password reveal button' is set to 'Enabled'.                                   | GPO        |
| 15793 | Ensure 'Prevent the use of security questions for local accounts' is set to 'Enabled'.                    | GPO        |
| 15794 | Ensure 'Allow Diagnostic Data' is set to 'Enabled: Diagnostic data off (not recommended)' or [...]        | REG        |
| 15795 | Ensure 'Configure Authenticated Proxy usage for the Connected User Experience and Telemetry [...]         | GPO        |
| 15796 | Ensure 'Disable OneSettings Downloads' is set to 'Enabled'.                                               | GPO        |
| 15797 | Ensure 'Do not show feedback notifications' is set to 'Enabled'.                                          | GPO        |
| 15798 | Ensure 'Enable OneSettings Auditing' is set to 'Enabled'.                                                 | GPO        |
| 15799 | Ensure 'Limit Diagnostic Log Collection' is set to 'Enabled'.                                             | REG        |
| 15800 | Ensure 'Limit Dump Collection' is set to 'Enabled'.                                                       | REG        |
| 15801 | Ensure 'Toggle user control over Insider builds' is set to 'Disabled'.                                    | GPO        |
| 15804 | Ensure 'Application: Specify the maximum log file size (KB)' is set to 'Enabled: 32,768 or greater'.      | GPO        |
| 15806 | Ensure 'Security: Specify the maximum log file size (KB)' is set to 'Enabled: 196,608 or greater'.        | GPO        |
| 15808 | Ensure 'Setup: Specify the maximum log file size (KB)' is set to 'Enabled: 32,768 or greater'.            | GPO        |
| 15810 | Ensure 'System: Specify the maximum log file size (KB)' is set to 'Enabled: 32,768 or greater'.           | GPO        |
| 15814 | Ensure 'Prevent the computer from joining a homegroup' is set to 'Enabled'.                               | GPO        |
| 15815 | Ensure 'Turn off location' is set to 'Enabled'.                                                           | GPO        |
| 15816 | Ensure 'Allow Message Service Cloud Sync' is set to 'Disabled'.                                           | GPO        |
| 15820 | Ensure 'Configure Attack Surface Reduction rules' is set to 'Enabled'.                                    | GPO        |
| 15821 | *Ensure 'Configure Attack Surface Reduction rules: Set the state for each ASR rule' is configured.        | GPO        |
| 15823 | Ensure 'Enable file hash computation feature' is set to 'Enabled'.                                        | GPO        |
| 15828 | Ensure 'Configure Watson events' is set to 'Disabled'.                                                    | GPO        |
| 15829 | Ensure 'Scan removable drives' is set to 'Enabled'.                                                       | GPO        |
| 15830 | Ensure 'Turn on e-mail scanning' is set to 'Enabled'.                                                     | GPO        |
| 15831 | Ensure 'Configure detection for potentially unwanted applications' is set to 'Enabled: Block'.            | GPO        |
| 15833 | Ensure 'Enable news and interests on the taskbar' is set to 'Disabled'.                                   | GPO        |
| 15865 | Ensure 'Configure Windows Defender SmartScreen' is set to 'Enabled: Warn and prevent bypass'.             | GPO        | 
| 15867 | Ensure 'Prevent bypassing Windows Defender SmartScreen prompts for sites' is set to 'Enabled'.            | GPO        | 
| 15868 | Ensure 'Enables or disables Windows Game Recording and Broadcasting' is set to 'Disabled'.                | GPO        | 
| 15869 | Ensure 'Allow suggested apps in Windows Ink Workspace' is set to 'Disabled'.                              | GPO        | 
| 15870 | Ensure 'Allow Windows Ink Workspace' is set to 'Enabled: On, but disallow access above lock' OR [...]     | GPO        | 
| 15874 | Ensure 'Sign-in and lock last interactive user automatically after a restart' is set to 'Disabled'.       | GPO        | 
| 15879 | *Ensure 'Disallow Digest authentication' is set to 'Enabled'.                                             | GPO        | 
| 15883 | Ensure 'Disallow WinRM from storing RunAs credentials' is set to 'Enabled'.                               | GPO        | 
| 15884 | Ensure 'Allow Remote Shell Access' is set to 'Disabled'.                                                  | GPO        | 
| 15887 | Ensure 'Prevent users from modifying settings' is set to 'Enabled'.                                       | GPO        | 
| 15891 | Ensure 'Remove access to "Pause updates" feature' is set to 'Enabled'.                                    | GPO        | 
| 15893 | Ensure 'Select when Preview Builds and Feature Updates are received' is set to 'Enabled: 180 or [...]     | GPO        |
| 15622 | Ensure 'Windows Firewall: Domain: Settings: Display a notification' is set to 'No'.                       | GPO        |
| 15630 | Ensure 'Windows Firewall: Private: Settings: Display a notification' is set to 'No'.                      | GPO        |
| 15638 | Ensure 'Windows Firewall: Public: Settings: Display a notification' is set to 'No'.                       | GPO        |
| 15647 | Ensure 'Audit Security Group Management' is set to include 'Success'.                                     | GPO        |
| 15653 | Ensure 'Audit Logoff' is set to include 'Success'.                                                        | GPO        |
| 15654 | Ensure 'Audit Logon' is set to 'Success and Failure'.                                                     | GPO        |
| 15656 | Ensure 'Audit Special Logon' is set to include 'Success'.                                                 | GPO        |
| 15661 | Ensure 'Audit Audit Policy Change' is set to include 'Success'.                                           | GPO        |
| 15662 | Ensure 'Audit Authentication Policy Change' is set to include 'Success'.                                  | GPO        |
| 15704 | Ensure 'Enable Font Providers' is set to 'Disabled'.                                                      | GPO        |
| 15705 | Ensure 'Enable insecure guest logons' is set to 'Disabled'.                                               | GPO        |
| 15726 | Ensure 'Turn On Virtualization Based Security' is set to 'Enabled'.                                       | GPO        |
| 15727 | Ensure 'Turn On Virtualization Based Security: Select Platform Security Level' is set [...]               | GPO        |
| 15728 | Ensure 'Turn On Virtualization Based Security: Virtualization Based Protection of Code[...]               | GPO        |
| 15729 | Ensure 'Turn On Virtualization Based Security: Require UEFI Memory Attributes Table' is set [...]         | GPO        |
| 15730 | Ensure 'Turn On Virtualization Based Security: Credential Guard Configuration' is set to [...]            | GPO        |
| 15731 | Ensure 'Turn On Virtualization Based Security: Secure Launch Configuration' is set to 'Enabled'.          | GPO        |
| 15732 | Ensure 'Prevent device metadata retrieval from the Internet' is set to 'Enabled'.                         | GPO        |
| 15834 | Ensure 'Prevent the usage of OneDrive for file storage' is set to 'Enabled'.                              | GPO        |
| 15836 | Ensure 'Do not allow passwords to be saved' is set to 'Enabled'.                                          | GPO        |
| 15839 | Ensure 'Do not allow COM port redirection' is set to 'Enabled'.                                           | GPO        |
| 15840 | Ensure 'Do not allow drive redirection' is set to 'Enabled'.                                              | GPO        |
| 15842 | Ensure 'Do not allow LPT port redirection' is set to 'Enabled'.                                           | GPO        |
| 15843 | Ensure 'Do not allow supported Plug and Play device redirection' is set to 'Enabled'.                     | GPO        |
| 15844 | Ensure 'Always prompt for password upon connection' is set to 'Enabled'.                                  | GPO        |
| 15846 | Ensure 'Require use of specific security layer for remote (RDP) connections' is set to 'Enabled: SSL'.    | GPO        |
| 15849 | Ensure 'Set time limit for active but idle Remote Desktop Services sessions' is set to [...]              | GPO        |
| 15850 | Ensure 'Set time limit for disconnected sessions' is set to 'Enabled: 1 minute'.                          | GPO        |
| 15852 | Ensure 'Prevent downloading of enclosures' is set to 'Enabled'.                                           | GPO        |
| 15853 | Ensure 'Allow Cloud Search' is set to 'Enabled: Disable Cloud Search'.                                    | GPO        |
| 15854 | Ensure 'Allow Cortana' is set to 'Disabled'.                                                              | GPO        |
| 15855 | Ensure 'Allow Cortana above lock screen' is set to 'Disabled'.                                            | GPO        |
| 15857 | Ensure 'Allow search and Cortana to use location' is set to 'Disabled'.                                   | GPO        |
| 15567 | Ensure 'User Account Control: Admin Approval Mode for the Built-in Administrator account'[...]            | GPO        |