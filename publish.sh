#!/usr/bin/env bash
set -euo pipefail

msg=${1:-"Update solutions"}

git add .

git commit -m "$msg" || {
  echo "No changes to commit."
  exit 0
}

git push
