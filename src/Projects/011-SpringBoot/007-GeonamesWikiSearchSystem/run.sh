#!/bin/bash
cd ./GeoWikiSearchServiceApp/target
java -jar GeoWikiSearchServiceApp-1.0.0.jar --spring.profiles.active=$1
