#!/usr/bin/env bash
set -euo pipefail
repo=$(cd "$(dirname "$0")/.." && pwd)
workspace="$repo/1.7.3-LTS"
build="$repo/build"
if [ -n "${JAVA_HOME:-}" ]; then
    javac="$JAVA_HOME/bin/javac"
    jar="$JAVA_HOME/bin/jar"
else
    javac=javac
    jar=jar
fi
if ! "$javac" -version 2>&1 | grep -q 'javac 1.8\.'; then
    echo 'Set JAVA_HOME to a Java 8 JDK. On Apple Silicon, configure the maintained LWJGL 2 libraries in Prism; see PRISM-MACOS.md.' >&2
    exit 1
fi
mkdir -p "$build"
# Recreate only this script's generated class directory; never overwrite tracked MCP binaries.
rm -rf "$build/client"
mkdir -p "$build/client"
cd "$workspace"
find src/minecraft -name '*.java' | LC_ALL=C sort > "$build/client-sources.txt"
"$javac" -encoding UTF-8 -g -classpath 'jars/bin/minecraft.jar:jars/bin/jinput.jar:jars/bin/lwjgl.jar:jars/bin/lwjgl_util.jar' \
    -sourcepath src/minecraft -d "$build/client" @"$build/client-sources.txt" conf/patches/Start.java conf/patches/in.java
"$jar" cf "$build/beta-1.7.3-qol-patch.jar" -C "$build/client" .
echo "Built $build/beta-1.7.3-qol-patch.jar"
