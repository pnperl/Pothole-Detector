# Pothole Detector (Full-featured template)
This project is a ready-to-build Android app template configured for TensorFlow Lite object detection.
IMPORTANT: You must place a working object-detection TFLite model in:
app/src/main/assets/detect.tflite

Recommended model sources:
- The original repo: https://github.com/shuklansh/PotholeDetectionTFLITEcustom
- Roboflow exports (export TF Lite)

Steps to use:
1. Extract this folder and upload ALL files/folders to a new GitHub repository (do NOT upload the ZIP as a single file).
2. Enable Actions in repository settings.
3. In Actions > Android CI, click Run workflow on master branch.
4. Wait for build to complete and download APK from Releases.
