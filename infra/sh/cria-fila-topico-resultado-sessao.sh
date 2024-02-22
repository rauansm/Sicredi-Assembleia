aws --profile localstack --endpoint-url=http://localhost:4566 sqs create-queue --queue-name resultado-sessao-mensagem-whats-queue

aws --profile localstack --endpoint-url=http://localhost:4566 sns create-topic --name resultado-sessao-topic

aws --profile localstack --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:resultado-sessao-topic --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:resultado-sessao-mensagem-whats-queue --attributes RawMessageDelivery=true