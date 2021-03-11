## Docker
To build a docker container:
1. sudo
2. docker build -t <tagName> .  
-> We now have a docker container in . called <tagName>:latest
   
A container can be run using:
1. sudo
2. docker run -dp 8080:8080 <tagName>:latest  
-> runs container detached (-d) with internal port 8080 mapped to 8080 external (p 8080:8080)

   
## Docker compose
