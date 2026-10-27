#!/usr/bin/env bash
set -euo pipefail
repo=$(cd "$(dirname "$0")/.." && pwd)
bash "$repo/tools/build-client.sh"
java_bin="${JAVA_HOME:+$JAVA_HOME/bin/}java"
javac_bin="${JAVA_HOME:+$JAVA_HOME/bin/}javac"
classpath="$repo/build/client:$repo/1.7.3-LTS/jars/bin/*"
mkdir -p "$repo/build/tests"
"$javac_bin" -encoding UTF-8 -cp "$classpath" -d "$repo/build/tests" "$repo/tests/QolTests.java" "$repo/tests/QolInventoryTests.java"
"$java_bin" -Djava.awt.headless=true -cp "$repo/build/tests:$classpath" net.minecraft.src.QolTests
"$java_bin" -Djava.awt.headless=true -cp "$repo/build/tests:$classpath" net.minecraft.src.QolInventoryTests
