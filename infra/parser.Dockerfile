FROM python:3.8.3-alpine

WORKDIR /app

COPY ./parser/requirements.txt /app/requirements.txt

RUN apk add --no-cache --virtual .build-deps build-base gcc musl-dev python3-dev libffi-dev openssl-dev \
  && pip install --no-cache-dir -r requirements.txt \
  && apk del .build-deps build-base gcc musl-dev python3-dev libffi-dev openssl-dev

COPY ./parser /app

ENTRYPOINT [ "python3" ]
CMD ["app.py", "--host=0.0.0.0"]