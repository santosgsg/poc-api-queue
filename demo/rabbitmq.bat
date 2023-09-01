@ECHO OFF
ECHO Starting rabbitmq in default configs.
docker run --rm -p 15672:15672 -p 5672:5672 rabbitmq:3-management