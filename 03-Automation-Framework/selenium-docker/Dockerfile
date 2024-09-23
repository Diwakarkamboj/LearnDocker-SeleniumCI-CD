FROM  bellsoft/liberica-openjdk-alpine:17.0.12

#workspace

WORKDIR /home/selenium-docker

#Add required files to run the test dot below represent home directory
ADD target/docker-resources ./
#ADD pom.xml pom.xml 

#Enviorment variables
#Browser
#HUB_HOST
#TEST_SUITE
#THREAD_COUNT

#Run the test
ENTRYPOINT java -cp 'libs/*' \
						-Dselenium.grid.enabled=true \
					 	-Dselenium.grid.hubhost=${HUB_HOST}\
						-Dbrowser=${BROWSER} org.testng.TestNG \
						-threadcount ${THREAD_COUNT} test-suites/${TEST_SUITE}
						