FROM 063473290800.dkr.ecr.us-east-1.amazonaws.com/base-image/java:v10.3

RUN mkdir -p /artifact; mkdir -p /security

#FILL IN: Make sure that generated path points to correct JAVA module and executable
ADD nebula-playground-application/target/nebula-playground-application-*-exec.jar /artifact/etp-core-service.jar

#FILL IN: Make sure that generated path points to correct JAVA module with configuration
COPY nebula-playground-application/target/classes/*.* /conf/
#COPY additional resources if needed

ENTRYPOINT ["/starter.py"]
