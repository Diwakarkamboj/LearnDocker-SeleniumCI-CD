FROM  bellsoft/liberica-openjdk-alpine:17.0.12

# install curl and jq
RUN apk add curl jq

#workspace

WORKDIR /home/selenium-docker

#Add required files to run the test dot below represent home directory
ADD target/docker-resources ./
ADD runner.sh				runner.sh
#ADD pom.xml pom.xml 

RUN dos2unix runner.sh

#start the runner.sh
ENTRYPOINT sh runner.sh