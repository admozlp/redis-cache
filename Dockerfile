FROM ubuntu:latest
LABEL authors="adem"

ENTRYPOINT ["top", "-b"]