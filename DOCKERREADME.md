## Docker
To build a docker container:
1. sudo
2. docker build -t <tagName> .  
-> We now have a docker container in . called <tagName>:latest
   
A container can be run using:
1. sudo
2. docker run -dp 8080:8080 <tagName>:latest  
-> runs container detached (-d) with internal port 8080 mapped to 8080 external (p 8080:8080)

Port mapping via "EXPOSE" does not work. EXPOSE is more like a friendly reminder.
   
## Docker compose
Here port mapping via
ports:
    - 5006:5006
works

## application.properties
do not set server.adress=locahost  
do set it to 0.0.0.0, for some reason, it does not like localhost!!!!
