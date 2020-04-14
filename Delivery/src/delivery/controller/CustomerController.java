package delivery.controller;

import delivery.model.service.CustomerService;
import delivery.model.vo.Customer;
import delivery.view.DeliveryMenu;

public class CustomerController {

	public void insertCustomer(Customer signUpCustomer) {

		DeliveryMenu menu = new DeliveryMenu();
		int result;
		result = new CustomerService().insertCustomer(signUpCustomer);
		if (result > 0) {
			menu.displaySuccess("고객 등록 성공.");
		} else {
			menu.displayError("고객 등록 실패!!");
		}

	}

	public void loginCustomer(Customer loginCustomer) {
		DeliveryMenu menu = new DeliveryMenu();
		loginCustomer = new CustomerService().loginCustomer(loginCustomer);
		if (loginCustomer != null) {
			menu.CustomerLoginSuccess(loginCustomer.getCusName() + "고객님 반갑습니다.");
			new DeliveryMenu().CustomerMenu();
		} else {
			menu.CustomerLoginFail("아이디나 비밀번호를 확인해주세요");
		}

	}

}
