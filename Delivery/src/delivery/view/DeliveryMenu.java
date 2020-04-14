package delivery.view;

import java.util.ArrayList;
import java.util.Scanner;

import delivery.controller.AdminController;
import delivery.controller.CustomerController;
import delivery.controller.OwnerController;
import delivery.model.vo.BlackList;
import delivery.model.vo.Customer;
import delivery.model.vo.OrderMenu;
import delivery.model.vo.Owner;

public class DeliveryMenu {

	private Scanner sc;
	private AdminController ac;
	private CustomerController cc;
	private OwnerController oc;
	static String a;

	public DeliveryMenu() {
		sc = new Scanner(System.in);
		ac = new AdminController();
		cc = new CustomerController();
		oc = new OwnerController();
	}

	public void Menu() {

		while (true) {

			System.out.println("배달 프로그램 ");
			System.out.println("1. 관리자");
			System.out.println("2. 점주");
			System.out.println("3. 고객");
			System.out.println("4. 회원가입(점주, 고객)");
			System.out.print("선택 : ");

			int select = sc.nextInt();
			switch (select) {

			case 1:
				loginAdmin(); // 아디 비번 admin 접속 함수
				break;
			case 2:
				oc.loginOwner(this.loginOwner()); // 점주 로그인 함수
				break;
			case 3:
				cc.loginCustomer(this.loginCustomer()); // 고객 로그인함수
				break;
			case 4:
				Signup();
				break;
			default:
				System.out.println("잘못누르셨습니다.");

			}
		}

	}

	// 관리자로 로그인 함수
	// 아이디 admin 비밀번호 admin

	public void loginAdmin() {

		System.out.print("아이디 입력");
		String admin = sc.next();
		if (admin.equals("admin")) {
			System.out.print("비밀번호 입력");
			String pass = sc.next();
			if (pass.equals("admin")) {
				System.out.println("로그인 성공");
				AdminMenu();
			}

		} else {
			System.out.println("로그인 실패");
		}

	}

	// 점주(가게)로 로그인하기위한 함수

	public Owner loginOwner() {
		Owner owner = new Owner();
		System.out.print("점주 아이디 입력");
		a = sc.next();
		owner.setStrId(a);
		System.out.print("점주 비밀번호 입력");
		owner.setStrPwd(sc.next());
		return owner;

	}

	// 고객로 로그인하기 위한함수

	public Customer loginCustomer() {
		Customer customer = new Customer();
		System.out.print("고객 아이디 입력");
		customer.setCusId(sc.next());
		System.out.print("고객 비밀번호 입력");
		customer.setCusPwd(sc.next());

		return customer;
	}

	// 회원 가입 메뉴 (1. 점주 회원가입 2. 고객 회원가입)
	public void Signup() {
		do {

			System.out.println("────회원가입 메뉴────");
			System.out.println("1.점주 회원가입");
			System.out.println("2.고객 회원가입");
			System.out.print("선택 > ");

			switch (sc.nextInt()) {
			case 1:
				oc.insertOwner(this.SignUpOwner());
				break;
			case 2:
				cc.insertCustomer(this.SignUpCustomer());
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);
	}

	// 점주 회원가입에서 OwnerController에서 처리하는
	// insertOwner함수의 매개변수 입력받는 함수

	public Owner SignUpOwner() {

		Owner owner = new Owner();

		System.out.print("점주 이름 > ");
		owner.setCeoName(sc.next());

		System.out.print("점주 아이디 > ");
		owner.setStrId(sc.next());

		System.out.print("비밀번호 > ");
		owner.setStrPwd(sc.next());

		System.out.print("가게 이름> ");
		owner.setStrName(sc.next());

		System.out.print("가게 주소 > ");
		sc.nextLine();
		owner.setStrAddr(sc.nextLine());

		System.out.print("가게 전화번호 > ");
		owner.setStrPhone(sc.next());

		System.out.print("카테고리 > ");
		owner.setCategory(sc.next());

		return owner;
	}

	// 고객 회원가입에서 CustomerController에서 처리하는
	// insertCustomer함수의 매개변수 입력받는 함수

	private Customer SignUpCustomer() {

		Customer customer = new Customer();

		System.out.print("회원 이름 > ");
		customer.setCusName(sc.next());

		System.out.print("아이디 > ");
		customer.setCusId(sc.next());

		System.out.print("비밀번호 > ");
		customer.setCusPwd(sc.next());

		System.out.print("주소 > ");
		sc.nextLine();
		customer.setCusAddr(sc.nextLine());

		System.out.print("전화번호 > ");
		customer.setCusPhone(sc.next());

		return customer;
	}

	// 관리자 메뉴 (1. 회원관리 2. 가게관리)
	private void AdminMenu() {
		do {
			System.out.println("────관리자 메뉴────");
			System.out.println("1.회원 관리 메뉴");
			System.out.println("2.가게 관리 메뉴");
			System.out.println("3.이전 메뉴로 가기");
			System.out.print("선택 > ");

			switch (sc.nextInt()) {
			case 1:
				CustomerManageMenu();
				AdminMenu();
				break;
			case 2:
				StoreManageMenu();
				AdminMenu();
				break;
			case 3:
				Menu();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				AdminMenu();
				break;
			}

		} while (true);

	}

	// 관리자 메뉴 안에있는 회원관리 메뉴

	private void CustomerManageMenu() {

		do {
			System.out.println("────회원 관리 메뉴────");
			System.out.println("1. 회원 전체 출력");
			System.out.println("2. 회원 검색 (회원 번호)");
			System.out.println("3. 전체 주문 내역");
			System.out.println("4. 블랙리스트 전체출력");
			System.out.println("5. 블랙리스트 검색 (점주 아이디)");
			System.out.print("선택 > ");

			switch (sc.nextInt()) {
			case 1:
				ac.selectAllCus();
				break;
			case 2:
				ac.searchByNo(this.inputByNo());
				break;
			case 3:
				ac.selectAllOrder();
				break;
			case 4:
				ac.selectAllBlack();
				break;
			case 5:
				break;
			case 6:
				AdminMenu();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);

	}

	// 관리자 메뉴 안에있는 가게 관리 메뉴

	private void StoreManageMenu() {
		do {

			System.out.println("────가게 관리 메뉴────");
			System.out.println("1. 가게 전체 출력");
			System.out.println("2. 가게 검색");
			System.out.println("3. 가게 삭제");
			System.out.println("4. 가게 메뉴 확인");
			System.out.println("5. 가게 매출 순위");
			System.out.println("6. 블랙 리스트 관리");

			// 관리 -> 삭제 ,
			// System.out.println("7. 블랙 리스트 삭제");

			// 승인 반려 delete

			System.out.print("선택 > ");

			//

			switch (sc.nextInt()) {
			case 1:
				ac.selectAllStore();
				break;
			case 2:
				ac.searchStore(this.searchStoreNo());
				break;
			case 3:
				ac.deleteStore(this.deleteStoreNo());
				break;
			case 4:
				ac.selectAllMenu();
				break;
			case 5:
				break;
			case 6:
				ac.insertBlackList(this.insertBlackList());
				break;
			case 7:
				ac.deleteBlackList(this.deleteBlackListNo());
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);

	}

	public int searchStoreNo() {
		System.out.println("찾으실 가게를 입력해주세요");
		return sc.nextInt();
	}

	private int deleteStoreNo() {
		System.out.println("지우실 가게를 번호해주세요");
		return sc.nextInt();
	}

	private BlackList insertBlackList() {
		BlackList blacklist = new BlackList();

		System.out.print("점주 아이디 : ");
		blacklist.setStrId(sc.next());

		System.out.print("키워드 : ");
		blacklist.setKeyword(sc.next());

		return blacklist;
	}

	private int deleteBlackListNo() {
		System.out.println("지우실 블랙리스트번호를 입력 해주세요");
		return sc.nextInt();
	}

	public void OwnerMenu() {

		do {

			System.out.println("────점주 모드────");
			System.out.println("1.전체 메뉴 출력");
			System.out.println("2.메뉴 추가");
			System.out.println("3.메뉴 삭제");
			System.out.println("4.메뉴 수정");
			System.out.println("5.주문내역 리스트"); // 주문내역 OrderMenu 출력 로그인한 점주꺼
			System.out.println("6.주문 내역 처리"); // 초기값 N ,
			System.out.println("7.날짜별 총수입"); // 배달완료내역 배달여부가 Y인 것들을 GROUP BY 묶으면 해결
			System.out.print("메뉴 선택 > ");

			switch (sc.nextInt()) {
			case 1:
				oc.selectAllStoreMenu(a);
				break;
			case 2:
				oc.insertMenu(this.intputMenu());
				break;
			case 3:
				oc.deleteMenu(this.deleteMenuNo());
				break;
			case 4:
				oc.updateMenu(this.modifyMenu());
				break;
			case 5:
				oc.SelectOrderAllList(a);
				break;
			case 6:
				oc.DeliveryUpdate(this.inputDelivery());
				break;
			case 7:
				oc.SelectDateMoney(a);

				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);

	}

	private int deleteMenuNo() {
		oc.selectAllStoreMenu(a);
		System.out.println("삭제할 메뉴NO를 입력해주세요");
		return sc.nextInt();
	}

	private delivery.model.vo.Menu modifyMenu() {
		delivery.model.vo.Menu menu = new delivery.model.vo.Menu();
		oc.selectAllStoreMenu(a);
		System.out.println("  == 메뉴 수정 ==");
		System.out.println("수정할 메뉴No를 입력해주세요");
		menu.setMenuNo(sc.nextInt());

		System.out.println("메뉴 이름 : ");
		menu.setMenuName(sc.next());

		System.out.println("가격 ");
		menu.setPrice(sc.nextInt());

		return menu;
	}

	private delivery.model.vo.Menu intputMenu() {
		delivery.model.vo.Menu menu = new delivery.model.vo.Menu();

		System.out.print("점주 아이디 : ");
		menu.setStrId(sc.next());

		System.out.print("메뉴 이름 : ");
		menu.setMenuName(sc.next());

		System.out.print("메뉴 가격 : ");
		menu.setPrice(sc.nextInt());

		System.out.print("카테고리 : ");
		menu.setCategory(sc.next());

		return menu;
	}

	public void CustomerMenu() {

		do {
			System.out.println("────사용자 모드────");
			System.out.println("1. 주문하기"); // 주문하기 -> 주문 -> Ordermenu ->
			System.out.println("2. 장바구니 확인");
			System.out.println("3. 신고하기");
			System.out.println("0. 메인메뉴로 가기");
			System.out.print("메뉴 선택 > ");

			switch (sc.nextInt()) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				System.out.println();
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);

	}

	// -----------------------------------------------------
	// ArrayList 출력 및 전달 메세지 출력 함수

	public void displayOwnerList(ArrayList<Owner> ownerList) {
		System.out.println("가게정보입니다.");
		for (Owner owner : ownerList) {
			System.out.println(owner.toString());
		}
	}

	public void displayMenuList(ArrayList<delivery.model.vo.Menu> menuList) {
		System.out.println("메뉴 정보입니다.");
		for (delivery.model.vo.Menu menu : menuList) {
			System.out.println(menu.toString());
		}
	}

	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);
	}

	public void displayOwner(Owner owner) {
		System.out.println(owner.toString());

	}

	public void displaySuccess(String message) {
		System.out.println("서비스 성공 : " + message);

	}

	public void OwnerLoginSuccess(String message) {
		System.out.println("점주 메뉴 로그인 : " + message);

	}

	public void CustomerLoginSuccess(String message) {
		System.out.println("고객 메뉴 로그인 : " + message);

	}

	public void OwnerLoginFail(String message) {
		System.out.println("점주 메뉴 로그인 실패 : " + message);

	}

	public void CustomerLoginFail(String message) {
		System.out.println("고객 메뉴 로그인 실패 : " + message);

	}

	public void displayAllCus(ArrayList<Customer> list) {

		System.out.println("고객 정보입니다.");
		for (Customer customer : list) {
			System.out.println(customer.toString());
		}

	}

	public void displayAllBlack(ArrayList<BlackList> bList) {
		System.out.println("<전체 블랙리스트 조회결과>");
		System.out.println("점주아이디/컴플레인키워드/컴플레인번호");
		for (BlackList black : bList) {
			System.out.println(black.toString());
		}
	}

	public void diplayOneBlack(BlackList blackList) {
		System.out.println("<블랙리스트 조회결과>");
		System.out.println(blackList.toString());
	}

	public void displayOneCus(Customer customer) {
		System.out.println("<회원 정보 조회결과>");
		System.out.println(customer.toString());
	}

	public int inputByNo() {
		System.out.print("조회할 회원 번호를 입력 > ");
		return sc.nextInt();
	}

	public String inputId() {
		System.out.println("조회할 아이디 입력 > ");
		return sc.next();
	}

	public void displayAllOrder(ArrayList<OrderMenu> list) {
		System.out.println("<전체 주문 내역 조회결과>");
		for (OrderMenu order : list) {
			System.out.println(order.toString());
		}
	}

	public void diplayOrderList(ArrayList<OrderMenu> list) {
		System.out.println("<전체 주문내역 조회 결과>");
		for (OrderMenu orderMenu : list) {
			System.out.println(orderMenu.toString());
		}
	}

	public OrderMenu inputDelivery() {
		oc.SelectOrderAllList(a);
		OrderMenu oMenu = new OrderMenu();
		System.out.print("배송 상태를 변경할 주문 내역 번호 선택 > ");
		oMenu.setOrderNo(sc.nextInt());
		System.out.print("주문 배송 상태 선택 (완료 - Y / 미완료 - N) > ");
		oMenu.setDelivery(sc.next());
		oMenu.setStrId(a);
		return oMenu;
	}

	public void diplayMoneyList(ArrayList<OrderMenu> list) {
		System.out.println("<전체 주문내역 조회 결과>");
		for (OrderMenu orderMenu : list) {
			System.out.println(orderMenu.printString());
		}

	}

}