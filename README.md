# Redis Pub/Sub

## 1. Redis Pub/Sub 란

Redis Pub/Sub은 Redis에서 제공하는 메시지 전달 방식입니다. Pub/Sub은 Publish/Subscribe의 약자로, 발행자(Publisher)와 구독자(Subscriber) 사이에 메시지를 주고받는 방식을 말합니다. 발행자는 특정 채널(Channel)에 메시지를 보내고, 구독자는 관심있는 채널을 구독하여 메시지를 받습니다. 이때, 발행자와 구독자는 서로를 알 필요가 없으며, 메시지의 특성에 따라 채널을 구분합니다.

## 2. Redis Pub/Sub 특징 

- Redis Pub/Sub은 메시지를 저장하지 않습니다. 
  - 서버거 다운되거나, 구독자가 구독을 해제하면 해당 메시지는 사라집니다. 
  - 메시지를 저장해야 하는 상황에는 Redis Pub/Sub을 사용할 수 없습니다. 
- Redis Pub/Sub은 하나의 메시지를 여러 구독자에게 동시에 전달할 수 있습니다. 
  - 같은 채널을 구독하는 모든 구독자는 같은 메시지를 받을 수 있습니다. 
  - 다수의 구독자에게 동일한 정보를 전파하고 싶은 상황에 적합합니다.
- Redis Pub/Sub은 여러 채널을 동시에 구독할 수 있습니다. 
  - 특정한 채널 이름을 지정하지 않고 패턴(Pattern)을 사용하여 해당 패턴과 일치하는 채널을 구독할 수 있습니다. 
  - 다양한 종류의 메시지를 받고 싶은 상황에 적합합니다.

## 3. Redis Pub/Sub 사용하기

- 하나 이상의 채널을 구독하고, 해당 채널로부터 보내진 메시지를 받습니다.
```redis
> subscribe channel [channel …]
"subscribe"
"channel"
(integer) 2 <- 구독자 수
```
- 특정 채널에 메시지를 보냅니다. 이때, 해당 채널을 구독하는 모든 구독자들에게 메시지가 전달됩니다.
```redis
> publish channel message
(integer) 1 <- 메시지를 받는 구독자 수
```
- 하나 이상의 채널을 구독 해제하고, 해당 채널로부터 보내진 메시지를 더 이상 받지 않습니다. 만약 인자가 없다면, 모든 채널을 구독 해제합니다.
```redis
> unsubscribe [channel [channel …]]
"unsubscribe"
"channel"
(integer) 1 <- 구독자 수
```

## 4. Redis Pub/Sub 프로젝트 설명

- spring-pub
  - Redis Pub/Sub의 발행자(Publisher) 역할을 하는 프로젝트입니다.
- spring-sub
  - Redis Pub/Sub의 구독자(Subscriber) 역할을 하는 프로젝트입니다.
- redis 
  - Redis Pub/Sub을 테스트하기 위한 redis-cli입니다.
- docker-compose.yml
