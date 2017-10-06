## Java消息中间件

> 原课程地址：http://www.imooc.com/learn/856


----

### **为什么使用消息中间件**

**案例**
<img src="images/136.png">

<img src="images/138.png">

<img src="images/139.png">

**使用消息中间件的好处**

1. 解耦
2. 异步
3. 横向扩展
4. 安全可靠
5. 顺序保证
6. 等等...


### **消息中间件概述**

**什么是中间件**
非底层操作系统软件，非业务应用软件，不是直接给最终用户使用的，不能直接给客户带来价值的软件称为中间件。

**什么是消息中间件**
关注于数据的发送和接收，利用高效可靠的异步消息传递机制集成分布式系统。

<img src="images/145.png">

**什么是JMS？**
java消息服务（Java Message Service）即JMS，是一个Java平台关于面向消息中间件的API，用于在两个应用程序之间，或分布式系统中发送消息，进行异步通信

**什么是AMQP？**
AMQP（advanced message queuing protocol）是一个统一消息服务的应用层标准，基于此协议的客户端与消息中间件可传递消息，并不受客户端/中间件不同产品，不同开发语言的限制

<img src="images/148.png">

**常见消息中间件**

**activeMQ** 是Apache出品，最流行的，能力强劲的开源消息总线。ActiveMQ 是一个完全支持JMS1.1和J2EE 1.4规范的 JMS Provider实现，尽管JMS规范出台已经是很久的事情了，但是JMS在当今的J2EE应用中间仍然扮演着特殊的地位。

**Kafka**是LinkedIn开源的分布式发布-订阅消息系统，目前归属于Apache定级项目。Kafka主要特点是基于Pull的模式来处理消息消费，追求高吞吐量，一开始的目的就是用于日志收集和传输。0.8版本开始支持复制，不支持事务，对消息的重复、丢失、错误没有严格要求，适合产生大量数据的互联网服务的数据收集业务。

**RabbitMQ**是使用Erlang语言开发的开源消息队列系统，基于AMQP协议来实现。AMQP的主要特征是面向消息、队列、路由（包括点对点和发布/订阅）、可靠性、安全。AMQP协议更多用在企业系统内，对数据一致性、稳定性和可靠性要求很高的场景，对性能和吞吐量的要求还在其次。

**RocketMQ**是阿里开源的消息中间件，它是纯Java开发，具有高吞吐量、高可用性、适合大规模分布式系统应用的特点。RocketMQ思路起源于Kafka，但并不是Kafka的一个Copy，它对消息的可靠传输及事务性做了优化，目前在阿里集团被广泛应用于交易、充值、流计算、消息推送、日志流式处理、binglog分发等场景。

**常见消息中间件对比**
<img src="images/155.png">

> 推荐个博客：
阿里中间件团队博客
http://jm.taobao.org/

Kafka、RabbitMQ、RocketMQ消息中间件的对比 —— 消息发送性能
http://jm.taobao.org/%2F2016%2F04%2F01%2Fkafka-vs-rabbitmq-vs-rocketmq-message-send-performance%2F

### **JMS规范**

**Java消息服务**
java消息服务（Java Message Service）即JMS，是一个Java平台关于面向消息中间件的API，用于在两个应用程序之间，或分布式系统中发送消息，进行异步通信

**JMS相关概念**

1. 提供者：实现JMS规范的消息中间件服务器
2. 客户端：发送或接收消息的应用程序
3. 生产者/发布者：创建并发送消息的客户端
4. 消费者/订阅者：接收并处理消息的客户端
5. 消息：应用程序之间传递的数据内容
6. 消息模式：在客户端之间传递消息的方式，JMS中定义了主题和队列两种模式

**JMS消息模式 --- 队列模式：**

+ 客户端包括生产者和消费者
+ 队列中的消息只能被一个消费者消费
+ 消费者可以随时消费队列中的消息

<img src="images/160.png">


**JMS消息模式 --- 主题模型：**

+ 客户端包括生产者和消费者
+ 主题中的消息被所有订阅者消费
+ 消费者不能消费订阅之前就发送到主题中的消息

<img src="images/162.png">

**JMS编码接口**

|接口|描述|
|:---|:---|
|ConnectionFactory接口（连接工厂）|用户用来创建与JMS提供者连接的被管对象。|
|Connection接口（连接）|连接代表了应用程序和消息服务器之间的通信链路。|
|Destination接口（目标）|目标是一个包装了消息目标标识符的被管对象，消息目标是指消息发布和接收的地点，或者是队列，或者是主题。JMS管理员创建这些对象，然后用户通过JNDI发现它们。|
|MessageConsumer接口（消息消费者）|由会话创建的对象，用于接收发送到目标的消息。|
|MessageProducer接口（消息生产者）|由会话创建的对象，用于发送消息到目标。|
|Message接口（消息）|是在消费者和生产者之间传送的对象，也就是说从一个应用程序创建送到另一个应用程序。|
|Session接口（会话）|表示一个单线程的上下文，用于发送和接收消息。|

<img src="images/165.png">

**安装activeMQ**

下载地址：http://activemq.apache.org/activemq-5151-release.html
安装过程见网上：http://blog.csdn.net/jiuqiyuliang/article/details/47160259
整合spring文档：http://activemq.apache.org/spring-support.html

**Spring 继承JMS连接ActiveMQ**

+ ConnectionFactory用于管理连接的连接工厂
+ JmsTemplate用于发送和接收消息的模板类
+ MessageListener 消息监听器


**ActiveMQ集群的目的**

+ 实现高可用，以排除单点故障引起的服务中断
+ 实现负载均衡，以提升效率为更多的客户提供服务

**集群方式**

> activemq集群 官方文档介绍：
http://activemq.apache.org/clustering.html

1. 客户端集群：让多个消费者消费同一个队列
2. Broker clusters：多个Broker之间同步消息
3. Master slave：实现高可用

<img src="images/175.png">
<img src="images/176.png">
<img src="images/177.png">
<img src="images/178.png">
<img src="images/179.png">
<img src="images/180.png">

<img src="images/181.png">
<img src="images/182.png">
<img src="images/183.png">
<img src="images/184.png">
<img src="images/185.png">
<img src="images/186.png">
<img src="images/187.png">
<img src="images/188.png">
<img src="images/189.png">
<img src="images/190.png">

<img src="images/191.png">
<img src="images/192.png">
<img src="images/193.png">
<img src="images/194.png">
<img src="images/195.png">
<img src="images/196.png">
<img src="images/197.png">
<img src="images/198.png">
<img src="images/199.png">
<img src="images/200.png">
<img src="images/201.png">
<img src="images/202.png">
<img src="images/203.png">
<img src="images/204.png">






### **JMS代码演练**
