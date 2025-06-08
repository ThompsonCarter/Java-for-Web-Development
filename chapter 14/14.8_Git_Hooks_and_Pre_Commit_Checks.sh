
#!/usr/bin/env bash
mvn -q test && mvn -q spotless:check || { echo "Pre-commit failed"; exit 1; }
    