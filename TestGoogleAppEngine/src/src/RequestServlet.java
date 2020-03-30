package src;

import java.util.Collection;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(RequestServlet.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws IOException {

        String request = "ERROR";
        String hash = (String)getRequestParams(req).get("hash");
        String name = (String)getRequestParams(req).get("name");
        String hashSSN = (String)getRequestParams(req).get("hashSSN");
        String date = (String)getRequestParams(req).get("date");

        Map<String, String> data = new HashMap<String,String>();
        data.put("hash", hash);
        data.put("name", name);
        data.put("hashSSN", hashSSN);

        Block newBlock = new Block(data, "test", 005);

        Write.writeBlock(newBlock);
        System.out.println("hash = " + hash + ", name = " + name);
        //logger.log(Level.ALL, "hash = " + hash + ", name = " + name);

        rsp.getWriter().print(hash);



    }

    public Map<String,Object> getRequestParams(
            HttpServletRequest  req) {
        Map<String, String[]> paramsRaw = req.getParameterMap();
        Map<String, Object> params = new HashMap<String, Object>();

        for (String key : paramsRaw.keySet()) {
            params.put(key, paramsRaw.get(key)[0]);
        }

        return (params);
    }

}
