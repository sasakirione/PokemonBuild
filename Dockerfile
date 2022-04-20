FROM alpine:3.12

COPY ./gcloud-one-scala-1.0-SNAPSHOT ./gcloud-one-scala

WORKDIR ./gcloud-one-scala/bin

RUN apk --no-cache add openjdk11 bash

EXPOSE 9000

CMD ["./gcloud-one-scala"]
