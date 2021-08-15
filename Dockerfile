FROM airhacks/glassfish
COPY ./target/javaee-concurrency.war ${DEPLOYMENT_DIR}
