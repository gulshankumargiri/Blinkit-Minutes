package com.blinkit.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.blinkit.config.MapperHandling;
import com.blinkit.entity.CustomerEntity;
import com.blinkit.entity.OTPEntity;
import com.blinkit.entity.OrderEntity;
import com.blinkit.entity.Order_ItemEntity;
import com.blinkit.entity.ProductEntity;
import com.blinkit.repository.CustomerRepository;
import com.blinkit.repository.OrderItemRepository;
import com.blinkit.repository.OrderRepository;
import com.blinkit.repository.ProductRepository;
import com.blinkit.requestDTO.OrderRequest;
import com.blinkit.requestDTO.Order_ItemRequest;
import com.blinkit.response.OrderItem_Response;
import com.blinkit.response.Order_Response;

@Service
@Profile("qa")
public class OrdersService {

//	these fields have to maintain to perform order...

//	private long orderId;
//	private String orderStatus;
//	private int finalPrice;
//	private OTPEntity otpEntity;
//	private CustomerEntity customerEntity;
//	private List<Order_ItemEntity> itemEntities;

	// i am getting from request..
//	private Long customerId;
//	private List<Order_ItemRequest> items;
//	              |
	// private Long productId;
	// private Integer quantity;

	final MapperHandling handling;
	final CustomerRepository customerRepository;
	final ProductRepository productRepository;
	final OrderRepository orderRepository;

	OrdersService(MapperHandling handling, CustomerRepository customerRepository, ProductRepository productRepository,
			OrderItemRepository itemRepository, OrderRepository orderRepository) {
		this.handling = handling;
		this.customerRepository = customerRepository;
		this.productRepository = productRepository;
		this.orderRepository = orderRepository;
	}

	public Order_Response createOrder(OrderRequest orderRequest) {

		CustomerEntity customer = customerRepository.findById(orderRequest.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		OrderEntity order = new OrderEntity();

		List<OrderItem_Response> listItem = new ArrayList<OrderItem_Response>();

		List<Order_ItemEntity> itemList = new ArrayList<>();

		int finalPrice = 0;

		for (Order_ItemRequest item : orderRequest.getItems()) {

			ProductEntity product = productRepository.findById(item.getProductId())
					.orElseThrow(() -> new RuntimeException("Product not found"));

			// Check stock
			if (product.getProductQnt() < item.getQuantity()) {
				throw new RuntimeException(product.getProductName() + " is out of stock");
			}

			// Reduce stock
			int remainingQty = product.getProductQnt() - item.getQuantity();
			product.setProductQnt(remainingQty);
			productRepository.save(product);

			// Create new order item (IMPORTANT)
			Order_ItemEntity entity = new Order_ItemEntity();

			int totalPrice = product.getProductPrice() * item.getQuantity();

			entity.setItemQnt(item.getQuantity());
			entity.setItemTotalPrice(totalPrice);
			entity.setProductEntity(product);

			finalPrice += totalPrice;

			itemList.add(entity);

			OrderItem_Response itemss = new OrderItem_Response();
			itemss.setProductName(product.getProductName());
			itemss.setQuantity(item.getQuantity());
			itemss.setTotalPrice(totalPrice);
			listItem.add(itemss);
		}

		// Generate OTP
		OTPEntity otp = new OTPEntity();
		otp.setOtp(generateOtp());
		otp.setStatus("PENDING");

		// Set Order Details
		order.setCustomerEntity(customer);
		order.setOtpEntity(otp);
		order.setOrderStatus("SHIPPED");
		order.setFinalPrice(finalPrice);

		// Set Bidirectional Mapping
		order.setItemEntities(itemList);

		for (Order_ItemEntity item : itemList) {
			item.setOrderEntity(order);
		}

		// Save Order (Cascade saves OTP & Order Items)
		order = orderRepository.save(order);
		Order_Response response = handling.getOrderResponse(order);
		response.setOtp(otp.getOtp());
		response.setItems(listItem);

		return response;
	}

	// generate otp

	private static final SecureRandom random = new SecureRandom();

	private static int generateOtp() {
		return 100000 + random.nextInt(900000);
	}

	// verify otp

}
