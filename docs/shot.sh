#!/bin/sh
# Renders mockup.html to app-screens.png (README banner).
google-chrome --headless=new --no-sandbox --disable-gpu --hide-scrollbars \
  --force-device-scale-factor=2 --window-size=1208,856 \
  --screenshot="$(dirname "$0")/app-screens.png" \
  --allow-file-access-from-files \
  "file://$(cd "$(dirname "$0")" && pwd)/mockup.html"
