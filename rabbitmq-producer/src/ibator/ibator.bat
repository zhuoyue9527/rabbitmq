@ECHO OFF
CD /D %~sdp0
java -jar ../sacoolibator3.8.2.jar -configfile IbatorConfig.xml -overwrite | more
pause