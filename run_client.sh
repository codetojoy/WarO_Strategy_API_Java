#!/bin/bash

curl -X GET "http://localhost:8080/waro/strategy?prizeCard=10&maxCard=12&mode=max&cards=4&cards=6&cards=2" | jq

