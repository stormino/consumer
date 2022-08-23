# Consumer service

## Requirements

Java 11 is required to build and run this application. At runtime, the service relies on Kafka/Redpanda.    
A simpler way to set up these dependencies would be to run the already supplied
docker-compose. For further info please refer to solution README.

## How to build

To build the so-called fat jar artifact, run `./mvnw clean package`

## Execution

To run the service, just type `java -jar target/consumer-0.0.1-SNAPSHOT.jar`

## How it works

This service exposes an endpoint able to receive a batch of sensor data. The endpoint exposed can be called like this:  
```
curl -L -X POST 'http://localhost:18888/sensor' \
-H 'Content-Type: application/json' \
--data-raw '[
    {
        "sensor_id": 1,
        "value": 100,
        "timestamp": 1611165641876
    },
    {
        "sensor_id": 1,
        "value": 110,
        "timestamp": 1611165641877
    },
    {
        "sensor_id": 1,
        "value": 120,
        "timestamp": 1611165641878
    },
    {
        "sensor_id": 1,
        "value": 10,
        "timestamp": 1611165641879
    },
    {
        "sensor_id": 1,
        "value": 20,
        "timestamp": 1611165641880
    }
]'
```
Each batch of sensor data will be then sent to a message queue called `ingestion` to supply data to the extractor service.

## Implementation considerations

To quickly enable development of features such as REST endpoints and message production, the service relies on Spring Boot plus
any needed dependency. In order to provide a way to eventually interchange message broker, a `SensorDataSender` interface
has been provided.  
For example, to switch from Kafka to RabbitMQ one should implement a RabbitMQ sender using the aforementioned
interface - in addition to add the required package dependencies.
