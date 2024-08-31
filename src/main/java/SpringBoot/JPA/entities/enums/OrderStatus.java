package SpringBoot.JPA.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT (1),
	PAID(2),
	SHIPPED(3),
	DELIVERY(4),
	CANCELED(5);
	
	private int code;
	
	/**
	 * Construtor (diferente do comum, é private, porque em principio não se irá instanciar uma nova enum)
	 * @param code
	 */
	private OrderStatus(int code) {
		this.code = code;
	}
	
	/**
	 * Método para ter acesso ao code de cada valor da enumeração
	 * @return
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * Método vai funcionar sem ser preciso instanciar por isso é estático
	 */
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value: OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
