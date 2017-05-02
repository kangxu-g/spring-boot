package springboot.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@ApiIgnore
public class AppErrorController implements ErrorController
{

    private final static String ERROR_PATH = "/error";

    @Autowired
    private Configuration configuration; //freeMarker configuration

    /**
     * Supports the HTML Error View
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public String errorHtml(HttpServletRequest request)
    {
        String content = null;
        Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        try
        {

            // TODO 需要判断statusCode跳转到相应的错误页面
            Template t = configuration.getTemplate("error/404.ftl");
            content = FreeMarkerTemplateUtils.processTemplateIntoString(t, new HashMap<String,Object>());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (TemplateException e)
        {
            e.printStackTrace();
        }

        return content;
    }

    /**
     * Returns the path of the error page.
     * @return the error path
     */
    @Override
    public String getErrorPath()
    {
        return ERROR_PATH;
    }

}