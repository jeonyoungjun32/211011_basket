package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class BaskeyCartRemoveService {
	// int baskte_num
	public void cartRemove(HttpServletRequest request, String[] listDelete) {
		HttpSession session = request.getSession();

		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		for (int i = 0; i < listDelete.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {

//				if(listDelete[i].equals(cartList.get(j).getName())) {
//					cartList.remove(cartList.get(j));
//					break;
//				}

				System.out.println("cartDelete 값은? ㅅㅂ" + cartList);
				
				if (listDelete[i].equals(cartList.get(j).getSerial_code())) {
					cartList.remove(cartList.get(j));
					break;
				}
			}
		}
	}
}
