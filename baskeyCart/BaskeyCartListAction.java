package baskeyCart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import svc.BaskeyCartListService;
import vo.ActionForward;
import vo.Cart;

public class BaskeyCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 자동 생성된 메소드 스텁

		BaskeyCartListService baskeyCartListService = new BaskeyCartListService();
		
		ArrayList<Cart> cartList = baskeyCartListService.getCartList(request);
		
		
		int totalMoney = 0;
		int money = 0;

		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice();
			totalMoney += money;
		}
		
		/*
		 * if(cartList == null) { PrintWriter out = response.getWriter();
		 * out.print("<script>"); out.print("alert('장바구니 목록리스트에 없습니다');");
		 * out.print("history.back();"); out.print("</script>"); }
		 */
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("baskeyCartListService", baskeyCartListService);
		

		
	
		
		
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("baskeyCartList.jsp", false);// "디스패치 방식"으로 포워딩
//		ActionForward forward = new ActionForward("orderResult.bk", false);// "디스패치 방식"으로 포워딩

		return forward;
	}

}
