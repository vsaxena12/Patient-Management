#!/usr/bin/env bash
set -euo pipefail

JACOCO_XML="${1:-build/reports/jacoco/test/jacocoTestReport.xml}"
THRESH="${2:-0.70}"

# Requires xmllint (libxml2-utils). On mac: brew install libxml2
xmllint --xpath \
  "string-join(//package/class[@name and number(@line-rate) < ${THRESH}]/@name, '\n')" \
  "$JACOCO_XML" | \
  sed 's|/|.|g' | sed 's/\.class$//' | sort -u