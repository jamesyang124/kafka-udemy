#! /bin/bash

docker run --rm -it -d \
    -p 2181:2181 -p 3030:3030 -p 8081:8081 \
    -p 8082:8082 -p 8083:8083 -p 9092:9092 \
    -e ADV_HOST=127.0.0.1 \
    landoop/fast-data-dev

#docker run --rm -it \
#    -p 3181:3181 -p 3040:3040 -p 7081:7081 \
#    -p 7082:7082 -p 7083:7083 -p 7092:7092 \
#    -e ZK_PORT=3181 -e WEB_PORT=3040 -e REGISTRY_PORT=8081 \
#    -e REST_PORT=7082 -e CONNECT_PORT=7083 -e BROKER_PORT=7092 \
#    -e ADV_HOST=127.0.0.1 \
#    landoop/fast-data-dev

# for kafka monitoring tool
#docker run --rm -it --net=host landoop/fast-data-dev bash
