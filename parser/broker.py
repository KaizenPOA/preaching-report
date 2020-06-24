import os
import json
import boto3

sqs = boto3.client('sqs',
                   endpoint_url=os.getenv('SQS_ENDPOINT_URL'),
                   region_name=os.getenv('AWS_REGION'),
                   use_ssl=False)
print('Looking for queue: ' + os.getenv('SQS_QUEUE_NAME'))
response = sqs.get_queue_url(QueueName=os.getenv('SQS_QUEUE_NAME'))


def publish(message):
    print('Sending new report')
    sqs.send_message(
        QueueUrl=response['QueueUrl'],
        MessageBody=json.dumps(message),
        MessageAttributes={'event_type': {
            'DataType': 'String', 'StringValue': 'report_parsed_created'}},
    )
