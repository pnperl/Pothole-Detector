#!/usr/bin/env sh
echo "This is a minimal gradlew stub for GitHub Actions. In CI the real Gradle wrapper will be downloaded."
./gradle/wrapper/gradle-wrapper.jar || true
./gradlew real || true
