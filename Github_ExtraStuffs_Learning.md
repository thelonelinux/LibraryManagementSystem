# EXTRA USEFUL STUFF RELATED TO DEVELOPMENT LEARNING

##  GITHUB RELATED
### Problem Statement : Sometimes when we try to do git clone we copy paste url from repo to git bash. And get below errors.
* HP@VICKY-LENOVE-X1 MINGW64 ~/Desktop (main)
* $ git clone hhttps://github.com/thelonelinux/LibraryManagementSystem.git
* Cloning into 'LibraryManagementSystem'...
* fatal: protocol 'https' is not supported

* HP@VICKY-LENOVE-X1 MINGW64 ~/Desktop (main)
* $ git clone http://github.com/thelonelinux/LibraryManagementSystem.git
* Cloning into 'LibraryManagementSystem'...
* fatal: protocol 'http' is not supported

* NOTE - Here we get errors like http, https is not supported, Actually it comes because our paste command which we do by Ctrl+v
* Or by right click and paste. That also used to add special character (^). So it gives such error.

#### Resolution : do git clone and then paste by using "insert" key in your laptop (windoows). Else shift+Left/right arrow to paste.
* Doing this way to paste the url repo link we will not get that error.