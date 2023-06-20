gradle clean build
docker build -t prices_to_kafka:latest -f ./src/main/docker/Dockerfile .