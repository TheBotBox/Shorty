# URLShortener
A simple Java URL Shortener API for android  

#  Contents 
**[Features](#features)**  
**[Implementation](#implementation)**   
**[API Usage](#api-usage)**  
**[License](#license)**    

# Features  
**a).** Simple java library for shortening URLs'.  

# Implementation 
Library is available on JCenter, simply add the following line in your app `build.gradle` 
```
implementation'the.bot.box:shorty:{latest-version}'
```  
where `{latest-version}` corresponds to latest published version <a href='https://bintray.com/boxbotbarry/maven/shorty/_latestVersion'><img src='https://api.bintray.com/packages/boxbotbarry/maven/shorty/images/download.svg'></a>

# API Usage  
```
                 Shorty shorty = new Shorty.Builder()
                        .setURL("htttp:thebotbox.online)
                        .build();
                        
                 shorty.TLDR(new Shorty.Callback() {
                     @Override
                     public void shortURL(final String url) {
                      // result shortened url 
                     }

                     @Override
                     public void onError(String error) {
                  // error while url shortening 
                     }
                 });        
```

#   License  
![alt tag](https://img.shields.io/github/license/mashape/apistatus.svg)  
```
Copyright (c) 2018 TheBotBox

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction, including without
limitation the rights to use, copy, 
modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to 
whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions 
of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE,ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
IN THE SOFTWARE.
```




