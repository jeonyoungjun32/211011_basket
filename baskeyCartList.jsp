<%@page import="vo.Cart"%>
<%@page import="sun.security.mscapi.CKeyPairGenerator.RSA"%>
<%@page import="vo.Product"%>
<%@page import="baskeyCart.BaskeyCartListAction"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Cart> CartList = (ArrayList<Cart>) session.getAttribute("cartList"); /* 다 뽑아내야지 */
ArrayList<Product> Product = (ArrayList<Product>) session.getAttribute("Product"); /* 다 뽑아내야지 */
int totalMoney = (int)request.getAttribute("totalMoney");/* 총 금액 */
String remove = request.getParameter("cartDelete");/* 삭제 */
Member membera = (Member) session.getAttribute("Member");
%>


<%@include file="header.jsp"%>



<%-- <h2 id="basket"><%=member.getName()%>님의 장바구니 목록입니다</h2> --%>
<h2 id="basket">님의 장바구니</h2>

<%
	if (CartList.isEmpty()) {
%>
상품이 없습니다
<%
	} else {
%>
<%
	int j = 1;
for (int i = 0; i < CartList.size(); i++) {
%>

<table id="basketTable" border="1">
	<tr>
		<th>번호</th>
		<th>상품 번호</th>
		<th>상품 이름</th>
		<th>상품 종류</th>
		<th>상품 수량</th>
		<th>상품 가격</th>
		<th>쇼핑하기</th>
		<th>삭제해보자</th>
		
		
	</tr>

	<tr>
		<td><%=j++%></td>
		<td><%=CartList.get(i).getSerial_code()%></td>
		<td><%=CartList.get(i).getName()%></td>
		<%
			if (CartList.get(i).getKinds().equalsIgnoreCase("1")) {
		%>
		<td>케이크</td>
		<%
			} else if (CartList.get(i).getKinds().equalsIgnoreCase("2")) {
		%>
		<td>음료</td>
		<%
			} else if (CartList.get(i).getKinds().equalsIgnoreCase("3")) {
		%>
		<td>커피</td>
		<%
			} else if (CartList.get(i).getKinds().equalsIgnoreCase("4")) {
		%>
		<td>디저트</td>
		<%
			} else if (CartList.get(i).getKinds().equalsIgnoreCase("5")) {
		%>
		<td>아이스크림</td>
		<%
			}
		%>
		<td><%=CartList.get(i).getCount()%></td>
		<td><%=CartList.get(i).getPrice()%></td>

		
	
		<%
			if (CartList.get(i).getKinds().equalsIgnoreCase("1")) {
		%>
		<td rowspan="2"><a href="iceCakeList.bk"><input type="submit" value="쇼핑 계속하기"> </a></td>
		<%
			} else if (CartList.get(i).getKinds().equalsIgnoreCase("2")) {
		%>
		<td><a href="beverageList.bk"><input type="submit" value="쇼핑 계속하기"> </a></td>
		<%
			} else if (CartList.get(i).getKinds().equalsIgnoreCase("3")) {
		%>
		<td><a href="coffeeList.bk"><input type="submit" value="쇼핑 계속하기"> </a></td>	
		<%
			} else if (CartList.get(i).getKinds().equalsIgnoreCase("4")) {
		%>
		<td><a href="dessertList.bk"><input type="submit" value="쇼핑 계속하기"> </a></td>
		<%
			} else if (CartList.get(i).getKinds().equalsIgnoreCase("5")) {
		%>
		<td><a href="icecreamList.bk"><input type="submit" value="쇼핑 계속하기"> </a></td>
		<%
			}
		%>


		<!-- <td><a href="basketCartRemove.bk"><input type="submit" name="cartDelete" value="삭제" formaction="basketCartRemove.bk"> </a> </td> -->
		<td>
			<%-- <form action="basketCartRemove.bk?serial_code=<%=CartList.remove(i).getSerial_code() %>" method="post">?<input type="submit" value="삭제5"></form> --%>
			<a href="basketCartRemove.bk?serial_code=<%=CartList.get(i).getSerial_code()%>">장바구ㅂㅅㅋㅋㅅㅂ</a>
		</td>	

	</tr>
</table>
<%
	}
%>

<table border="1" style="margin-left: 30px;">
	<tr>
		<th>총 상품 금액</th>
		<th rowspan="2"><a href="orderResult.bk">주문하기</a> </th>

	</tr>

	<%
		for (int i = 0; i < 1; i++) {
	%>

	<tr>
		<td rowspan="2"><%=totalMoney%>원 입니다</td>

	</tr>

	<%
		}
	%>


</table>


<!-- <a href="orderResult.bk">주문리스트 보내기</a> -->
<!-- <td><a href="iceCak</form>
eList.bk"> 쇼핑 계속하기</a></td> -->
<%
	}
%>

