package baskeyCart;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import svc.BaskeyCartRemoveService;
import vo.ActionForward;

public class BaskeyCartRemoveAction implements Action {


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 장바구니에 있는걸 삭제
		//baskeyCartList.jsp에서 쓸라고 remove 씀  빨리 만들자
		//adminProductDeletePro.bg 이거 사용하자
//		HttpSession session = request.getSession(); 
		
		//자 장바구니에 있는 리스트중 삭제 하는거닌깐

		String cartDelete[]	 = request.getParameterValues("serial_code");
		
		 ActionForward forword = null;
		
		BaskeyCartRemoveService cartDeleteService = new BaskeyCartRemoveService();
		
		if(cartDelete != null) {
			cartDeleteService.cartRemove(request, cartDelete);
			forword = new ActionForward("baskeyCartList.bk", false);
			System.out.println("삭제 성공 " + cartDelete);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('삭제할 상품이 없습니다.');");
			out.print("history.back();");
			out.print("</script>");
			System.out.println("실패한 cartDelete 값은? " + cartDelete);
		}
		
		return forword;
	}

}











