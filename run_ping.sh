#!/bin/bash

set -e 

curl -X GET "http://localhost:8080/waro/ping" | jq
