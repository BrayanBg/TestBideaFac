package com.test.bideafac.model.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.test.bideafac.exception.Errorstatus;
import com.test.bideafac.model.entity.BookRequest;
import com.test.bideafac.model.repository.IBookRequestDAO;
import com.test.bideafac.model.service.IBookRequestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class BookRequestService implements IBookRequestService {

    Logger logger = Logger.getLogger(BookRequestService.class.getName());

    @Autowired
    IBookRequestDAO bookRequestDAO ;

    @Override
    public String reservaCasa(BookRequest bookRequest) throws Errorstatus {
        logger.info("Start BookRequest -> " + bookRequest);
        if(bookRequest.getHouseId().isEmpty() || bookRequest.getHouseId() == null){
            JSONObject json = new JSONObject();
            json.put("statusCode",400);
            json.put("error", "Bad Request");
            json.put("message", "required property 'houseId'");
            throw new Errorstatus(json.toString());
        }
        if(bookRequest.getDiscountCode() != null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId",bookRequest.getId());
            jsonObject.put("houseId",bookRequest.getHouseId());
            jsonObject.put("discountCode",bookRequest.getDiscountCode());
            JSONObject jsonObjectResponse = getAnswer(jsonObject);
            System.out.println(jsonObjectResponse.toString());
            if(!jsonObjectResponse.getBoolean("status")){
                JSONObject json = new JSONObject();
                json.put("statusCode",409);
                json.put("error", "Conflict");
                json.put("message", "invalid discount");
                throw new Errorstatus(json.toString());
            }
        }
        bookRequestDAO.save(bookRequest);

        JSONObject json = new JSONObject();
        json.put("statusCode",200);
        json.put("message", "Book Accepted");
        System.out.println(json.toString());
        return json.toString();
    }

    protected JSONObject getAnswer(JSONObject jsonObject) throws Errorstatus {
        JSONObject res = new JSONObject();
        logger.info("API EXTERNA -> " + jsonObject.toString());
        try{
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("https://622271e2666291106a26a17c.mockapi.io/discount/v1/new")
                    .header("Content-Type", "application/json")
                    .body(jsonObject.toString())
                    .asString();
            res = new JSONObject(response.getBody());
            logger.info("Respuesta API EXTERNA -> " + res.toString());
        }catch (Exception e){
            JSONObject json = new JSONObject();
            json.put("statusCode",500);
            json.put("error", "API-FAILED");
            json.put("message", "SERVER ERROR EXTERNAL API");
            throw new Errorstatus(json.toString());
        }
        return res;
    }

}
