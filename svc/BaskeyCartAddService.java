package svc;

import static db.Jdbcutil.close;
import static db.Jdbcutil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import vo.Cart;
import vo.Product;

public class BaskeyCartAddService {

	public Product geteCartBaskey(int serial_code) {
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);

		Product product = productDAO.selectBaskeyCart(serial_code);

		close(con);

		return product;
	}

	public void addCart(HttpServletRequest request, Product baskeyCart) {

		HttpSession session = request.getSession();

		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		//로그인 할시 이용가능
		
		
		// 장바구니 담기가 처음이라 session영역에 없으면!!
		if (cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;

		// 상품과 장바구니에 이름이 같으면 장바구니 안에 있는 상품이 +1증가인
//		System.out.println("장바구니 크기"+cartList.size()); //장바구니 크기는 올라가는데 제품 크기는 안올라간다 ㅡㅡ
		
		//왜 장바구니 크기가 정해 져있지?? 이러면 CartList가 문제인데?
//		System.out.println("제품 크기"+baskeyCart);//제품크기는 안올라간다
		
		//제품을 담아도 1개 밖에 없으니 index1 , size1이 나오지 
		
		for (int i = 0; i < cartList.size(); i++) {
			if (baskeyCart.getName().equals(cartList.get(i).getName())) {
				isNewCart = false;
				break;
			}
		}

		if (isNewCart == true) {
			Cart cart = new Cart();

				cart.setSerial_code(baskeyCart.getSerial_code());
				cart.setName(baskeyCart.getName());
				cart.setCount(baskeyCart.getCount());//여길로 줘야지 ㅅㅂ 
				cart.setPrice(baskeyCart.getPrice());
				cart.setKinds(baskeyCart.getChoice()); 		//종류

				cartList.add(cart);
		}
	}
}
