FROM alpine:3.12

RUN apk --no-cache add openjdk11 bash

EXPOSE 9000

CMD ["./gcloud-one-scala"]
