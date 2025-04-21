#!/bin/bash
export JAVA_HOME=/nix/var/nix/profiles/per-user/runner/java-17
cd ${REPL_HOME}
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=5000"
