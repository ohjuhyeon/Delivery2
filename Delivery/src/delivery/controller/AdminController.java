package delivery.controller;

import java.util.ArrayList;

import delivery.model.service.AdminService;
import delivery.model.vo.BlackList;
import delivery.model.vo.Customer;
import delivery.model.vo.Menu;
import delivery.model.vo.OrderMenu;
import delivery.model.vo.Owner;
import delivery.view.DeliveryMenu;
import myException.DeliveryException;

public class AdminController {

	public void selectAllStore() {
		DeliveryMenu menu = new DeliveryMenu();
		ArrayList<Owner> ownerList;
		ownerList = new AdminService().selectAllStore();
		if (!ownerList.isEmpty()) {
			menu.displayOwnerList(ownerList);
		} else {
			menu.displayError("가게 전체 조회 실패 ");
		}

	}

	public void searchStore(int inputStoreNo) {
		DeliveryMenu menu = new DeliveryMenu();
		Owner owner;

		owner = new AdminService().searchStore(inputStoreNo);
		if (owner != null)
			menu.displayOwner(owner);
	}

	public void deleteStore(int deleteStoreNo) {
		DeliveryMenu menu = new DeliveryMenu();
		int result;

		result = new AdminService().deleteStore(deleteStoreNo);
		if (result > 0) {
			menu.displaySuccess("회원 탈퇴 성공");
		} else {
			menu.displayError("회원탈퇴 실패");
		}

	}

	public void selectAllMenu() {

		DeliveryMenu menu = new DeliveryMenu();
		ArrayList<Menu> menuList;
		menuList = new AdminService().selectAllMenu();
		if (!menuList.isEmpty()) {
			menu.displayMenuList(menuList);
		} else {
			menu.displayError("메뉴 전체 조회 실패 ");
		}

	}

	public void insertBlackList(BlackList insertBlackList) {
		DeliveryMenu menu = new DeliveryMenu();
		int result;
		result = new AdminService().insertBlackList(insertBlackList);
		if (result > 0) {
			menu.displaySuccess("블랙리스트 등록 성공.");
		} else {
			menu.displayError("블랙리스트 등록 실패!!");
		}

	}

	public void deleteBlackList(int deleteBlackListNo) {
		DeliveryMenu menu = new DeliveryMenu();
		int result;

		result = new AdminService().deleteBlackList(deleteBlackListNo);
		if (result > 0) {
			menu.displaySuccess("블랙리스트 삭제 성공");
		} else {
			menu.displayError("블랙리스트 삭제 실패");
		}

	}

	public void selectAllCus() {
		DeliveryMenu Menu = new DeliveryMenu();
		ArrayList<Customer> list;

		list = new AdminService().selectAllCus();
		if (!list.isEmpty()) {
			Menu.displayAllCus(list);
		} else {
			System.out.println("전체 회원 조회 실패");
		}

	}

	public void searchByNo(int inputByNo) {

		DeliveryMenu dMenu = new DeliveryMenu();
		Customer customer;
		try {
			customer = new AdminService().searchByNo(inputByNo);
			if (customer != null) {
				dMenu.displayOneCus(customer);
			} else {
				System.out.println(inputByNo + "번 회원 조회 실패");
			}
		} catch (DeliveryException e) {
			e.printStackTrace();
		}

	}

	public void selectAllOrder() {

		DeliveryMenu dMenu = new DeliveryMenu();
		ArrayList<OrderMenu> list;
		try {
			list = new AdminService().selectAllOrder();
			if (!list.isEmpty()) {
				dMenu.displayAllOrder(list);
			} else {
				dMenu.displayError("전체 주문내역 조회 실패");
			}
		} catch (DeliveryException e) {
			e.printStackTrace();
		}
	}

	public void selectAllBlack() {
		DeliveryMenu dMenu = new DeliveryMenu();
		ArrayList<BlackList> list;
		try {
			list = new AdminService().selectAllBlack();
			if (!list.isEmpty()) {
				dMenu.displayAllBlack(list);
			} else {
				dMenu.displayError("블랙리스트 조회 실패");
			}
		} catch (DeliveryException e) {
			e.printStackTrace();
		}

	}

}
