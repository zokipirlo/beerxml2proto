#!/bin/bash

rm -rf ../src/main/java/beer/hapibrew/beerxml2proto/proto

java -jar wire-compiler-2.2.0-jar-with-dependencies.jar \
	--android \
	--proto_path=. \
    --java_out=../src/main/java/ \
    beer.proto
    