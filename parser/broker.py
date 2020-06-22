import os
import json
import boto3

sns = boto3.client('sns')
topic = sns.create_topic(Name=os.getenv('SNS_TOPIC_NAME'))


def publish(message):
    sns.publish(
        TopicArn=topic['TopicArn'],
        Message=json.dumps({'default': json.dumps(message)}),
        MessageStructure='json'
    )
