package baskeyCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import svc.BaskeyCartAddService;
import vo.ActionForward;
import vo.Product;

public class BaskeyCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BaskeyCartAddService baskeyCartAddService = new BaskeyCartAddService(); 
		
		int serial_code = Integer.parseInt(request.getParameter("serial_code")); //여서 null값인데 왜?!왜!!
		
		Product baskeyCart = baskeyCartAddService.geteCartBaskey(serial_code);
				
		baskeyCartAddService.addCart(request, baskeyCart);
		
		
		
		
		return new ActionForward("baskeyCartList.bk", true);
	}

}
