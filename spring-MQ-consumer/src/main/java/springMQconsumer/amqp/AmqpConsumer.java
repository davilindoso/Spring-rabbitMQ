package springMQconsumer.amqp;

public interface AmqpConsumer<T> {
	void consumer(T t);
}
