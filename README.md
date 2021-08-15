# Build

mvn clean package && docker build -t org.romit.learning/javaee-concurrency .

# RUN

docker rm -f javaee-concurrency || true && docker run -d -p 8080:8080 -p 4848:4848 --name javaee-concurrency
org.romit.learning/javaee-concurrency 