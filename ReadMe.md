## Echo HTTP Listener

Prerequisites:
- JDK 11
- sbt 1.4.x or higher

Once inside the project folder use the following command to run the code:
```
sbt run
```

This project listens to the server on port `9532` on path `"/echo"` and returns the request details as the 
HTTP response in JSON format. The HTTP response contains there Request details:

- The request path
- All headers
- Any Cookies
- The requesting IP

How to test:

- Use a client to hit the endpoint localhost:9532/echo

Expected output:

```
{
  "requestPath": "http://localhost:9532/echo",
  "headers": [
    "Timeout-Access: <function1>",
    "Host: localhost:9532",
    "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:101.0) Gecko/20100101 Firefox/101.0",
    "Accept: text/html, application/xhtml+xml, application/xml;q=0.9, image/avif, image/webp, */*;q=0.8",
    "Accept-Language: en-US, en;q=0.5",
    "Accept-Encoding: gzip, deflate, br",
    "DNT: 1",
    "Connection: keep-alive",
    "Cookie: Phpstorm-f154d066=fb8aea0b-7981-4c60-b932-521ef818a078; jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDc5NTAzNTgsImNvbnRlbnQiOiJlSnc5enJ0dXd6QU1CZEIvNFd3RmVqa1BUL0dTSVVDN2RTcUtncGFvUksxa0c1SThGSUgvdldxVGRpSEFBL0xpM21ESmxLQzdRVy9NdEl6bDViRjZDeDFZdzFGS0pablNMV2U2bFR1MkoyZlpnTWdWQ3BTdE05Q0E4eW1YWjR4VVg4N1RkYXdVOEYvNmVRNlVpV3hsaXVoRHRVSzVISC9HeGxMbElVem1zeDUwRGtPbUJuekVDNTE4b1BFZWdmZHU3TmZmbFdoM3lQZVdDV0cyVEdzbDJPRkF4RFFPUmxqTHQ3cDFtNC81VW9NanhZRlN2dm81US9mNjFrRCt5b1ZpYjZNZm9TdHBvVDk2d3JGbXAwZUZkVjIvQVE2Slczdz0ifQ.1ELGBTWGdV4JQjMfgOrLAJ1BIgMFAqWanAK7cmWBXXE",
    "Upgrade-Insecure-Requests: 1",
    "Sec-Fetch-Dest: document",
    "Sec-Fetch-Mode: navigate",
    "Sec-Fetch-Site: cross-site",
    "Sec-GPC: 1"
  ],
  "cookies": [
    "Phpstorm-f154d066=fb8aea0b-7981-4c60-b932-521ef818a078",
    "jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDc5NTAzNTgsImNvbnRlbnQiOiJlSnc5enJ0dXd6QU1CZEIvNFd3RmVqa1BUL0dTSVVDN2RTcUtncGFvUksxa0c1SThGSUgvdldxVGRpSEFBL0xpM21ESmxLQzdRVy9NdEl6bDViRjZDeDFZdzFGS0pablNMV2U2bFR1MkoyZlpnTWdWQ3BTdE05Q0E4eW1YWjR4VVg4N1RkYXdVOEYvNmVRNlVpV3hsaXVoRHRVSzVISC9HeGxMbElVem1zeDUwRGtPbUJuekVDNTE4b1BFZWdmZHU3TmZmbFdoM3lQZVdDV0cyVEdzbDJPRkF4RFFPUmxqTHQ3cDFtNC81VW9NanhZRlN2dm81US9mNjFrRCt5b1ZpYjZNZm9TdHBvVDk2d3JGbXAwZUZkVjIvQVE2Slczdz0ifQ.1ELGBTWGdV4JQjMfgOrLAJ1BIgMFAqWanAK7cmWBXXE"
  ],
  "requestingIP": "localhost"
}
```
