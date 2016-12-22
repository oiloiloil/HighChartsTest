package test.highcharts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getData")
public class HighChartsData extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// count: 傳入count，回傳圖上第count個點的座標(JSON格式)
		int count = Integer.parseInt(req.getParameter("count"));
		int x = (int) (((count + 1) % 4 > 1 ? 1 : -1) * Math.floor((count -1) / 4 + 1));
		int y = (int) ((count % 4 > 1 ? -1 : 1) * Math.floor(count / 4 + 1));

		PrintWriter out = res.getWriter();
		out.print("{\"x\":" + x + ",\"y\":" + y + "}");
	}
}
