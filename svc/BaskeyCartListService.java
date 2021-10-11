package svc;

import static db.Jdbcutil.close;
import static db.Jdbcutil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.Cart;
public class BaskeyCartListService {

	public ArrayList<Cart> getCartList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList"); // cartList는 어디서 셋팅 했냐 하면 CartAddService 에서 셋팅 시킨것이다
		
		
		return cartList;
		
	}
	//MemberDAO의 memberGetID 찾아봐라
	//누구누구님 의 장바구니 만들라고 하는중
	public String selectMember(String id)throws Exception{
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		String memberIdSelect = memberDAO.memberGetID(id);
		close(con);
		return memberIdSelect;
		
	}
}
