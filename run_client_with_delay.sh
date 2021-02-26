#!/bin/bash

curl -X GET "http://localhost:8080/waro/strategy?prize_card=10&max_card=12&mode=max&cards=4&cards=6&cards=2&delay_in_seconds=5" | jq

