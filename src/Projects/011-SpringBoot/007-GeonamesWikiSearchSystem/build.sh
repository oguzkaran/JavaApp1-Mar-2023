#!/bin/bash
cd .//GeoWikiSearchRepositoryLib
rm ./target/*.jar
mvn install
cd ../GeoWikisearchAppServiceLib
rm ./target/*.jar
mvn install

cd ../GeoWikiSearchServiceApp
rm ./target/*.jar
mvn package
cd ./target

