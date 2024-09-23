# LearnDocker

Prerequistes for windows:

# Create account on hub.docker.com
# Download docker desktop
# you can use centos in virtual box for initial setup and basic learning 
#docker hub profile name diwakar15

Print the current working directory - pwd

List all the files & folders -  ls -al

Create directory  -  mkdir dirname

Change to directory  -  cd dirname

Create file - touch filename

Find files with the name - find / -name partialfilename

Remove file -  rm file

Remove directory - rm -r directory


Volume mapping

docker run -v c:/Users/vins/output:/usr/share

rename file name 

mv old file name new file name
mv resul.txt result.txt

cat test-result.txt

docker exec -it <container-name-or-id> bash

docker pull alpine
docker pull busybox

vi Dockerfile to add any file inside docker and press ESC to edit that file 
In order to add the code to the DockerFile press Shift+i , this will allow you to edit the DockerFile.
to save file , press Esc and than enter wq
hit escape, then shift and colon then w and q to exit

vi Dockerfile  (add below steps to install java inside docker)

FROM alpine
RUN apk add openjdk8
ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/bin
WORKDIR /home/jenkins/share/udemy
ADD Test.java Test.java
ENTRYPOINT javac Test.java && java Test

docker run -it --entrypoint=/bin/sh diwakar15/hello-world -->> to enter inside container

FROM alpine
RUN apk add openjdk8
ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/bin
WORKDIR /home/jenkins/share/udemy
ADD Test.java Test.java
ENTRYPOINT javac Test.java && java Test $NUMBER

docker run -e NUMBER=6 diwakar15/square

to change a tag name in docker images cmd is docker tag diwakar15/square:latest diwakar15/sqaure:release-2.1 (or any random number)


docker logs (name of container) --> to check the logs

ports:
        - 80:80
		
		LHS is the host port and RHS is the container port
		

docker-compose up --scale chrome=3 -d --------> to scale instances

--Running a test suite
java -cp libs/* org.testng.TestNG test-suites/vendor-portal.xml
