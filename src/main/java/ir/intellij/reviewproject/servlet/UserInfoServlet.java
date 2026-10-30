package ir.intellij.reviewproject.servlet;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.intellij.reviewproject.dao.UserInfoDAO;
import ir.intellij.reviewproject.dto.UserInfoRequestDTO;
import ir.intellij.reviewproject.dto.UserInfoResponseDTO;
import ir.intellij.reviewproject.repository.UserInfoRepository;
import ir.intellij.reviewproject.service.UserInfoService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "userInfoServlet", value = {"/userinfo/*"})
public class UserInfoServlet extends HttpServlet {

    private ClassPathXmlApplicationContext applicationContext;

    private UserInfoService userInfoService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        this.applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.userInfoService = this.applicationContext.getBean("userInfoService", UserInfoService.class);
        this.objectMapper = this.applicationContext.getBean("objectMapper", ObjectMapper.class);
    }


    @Override
    public void destroy() {
        if (Optional.ofNullable(this.applicationContext).isPresent()) this.applicationContext.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        UserInfoResponseDTO userInfoResponseDTOOne = new UserInfoResponseDTO(1L, "postgres", "John Doe", (short) 34);
        UserInfoResponseDTO userInfoResponseDTOTwo = new UserInfoResponseDTO(2L, "mysql", "John Doe", (short) 30);

        List<UserInfoResponseDTO> userInfoResponseDTOS = new ArrayList<>();
        userInfoResponseDTOS.add(userInfoResponseDTOOne);
        userInfoResponseDTOS.add(userInfoResponseDTOTwo);

        this.objectMapper.writeValue(resp.getWriter(), userInfoResponseDTOS);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!"application/json".equalsIgnoreCase(req.getContentType())) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Content type must be application/json");
            return;
        }


        UserInfoRequestDTO userInfoRequestDTO;

        try {
            userInfoRequestDTO = this.objectMapper.readValue(req.getReader(), UserInfoRequestDTO.class);
        } catch (JsonParseException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON body");
            return;
        }

        UserInfoResponseDTO userInfoResponseDTO = userInfoService.create(userInfoRequestDTO);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        objectMapper.writeValue(resp.getWriter(), userInfoResponseDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
