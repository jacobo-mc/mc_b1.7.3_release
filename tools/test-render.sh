#!/usr/bin/env bash
set -euo pipefail
repo=$(cd "$(dirname "$0")/.." && pwd)
: "${LWJGL_NATIVE_DIR:?Set LWJGL_NATIVE_DIR to the matching platform native library directory}"
java_bin="${JAVA_HOME:+$JAVA_HOME/bin/}java"
javac_bin="${JAVA_HOME:+$JAVA_HOME/bin/}javac"
classpath="$repo/build/client:$repo/1.7.3-LTS/jars/bin/*"
mkdir -p "$repo/build/tests"
"$javac_bin" -encoding UTF-8 -cp "$classpath" -d "$repo/build/tests" "$repo/tests/QolRenderTests.java" "$repo/tests/QolNativeWindowTests.java"
cd "$repo"
for float_colors in false true; do
    "$java_bin" -Dorg.lwjgl.opengl.Display.allowSoftwareOpenGL=true -Dminecraft.macosFloatColors="$float_colors" \
        -Djava.library.path="$LWJGL_NATIVE_DIR" -cp "$repo/build/tests:$classpath" net.minecraft.src.QolRenderTests
done
"$java_bin" -Dorg.lwjgl.opengl.Display.allowSoftwareOpenGL=true -Dminecraft.nativeWindow=true \
    -Djava.library.path="$LWJGL_NATIVE_DIR" -cp "$repo/build/tests:$classpath" net.minecraft.src.QolNativeWindowTests
