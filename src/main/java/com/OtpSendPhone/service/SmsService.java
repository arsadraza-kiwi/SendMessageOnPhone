package com.OtpSendPhone.service;
import java.text.ParseException;
import com.OtpSendPhone.modeldto.SmsPojo;
import org.springframework.stereotype.Component;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class SmsService {
    private final String ACCOUNT_SID ="AC09db8860133404e74ed7a3c5b782612e";

    private final String AUTH_TOKEN = "5b5ef2cf9691c20aaa9c28af36a3f10e";

    private final String FROM_NUMBER = "+17067487078";

    public void send(SmsPojo sms) throws ParseException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);


        int min = 100000;
        int max = 999999;
        int number=(int)(Math.random()*(max-min+1)+min);


        String msg ="Your OTP - "+number+ " please verify this OTP in your Application by Er Md Arsad Reza";
        System.out.println(msg);

        Message message = Message.creator(new PhoneNumber(sms.getPhoneNo()), new PhoneNumber(FROM_NUMBER), msg.toLowerCase())
                .create();
        System.out.println(message);

    }

    public void receive(MultiValueMap<String, String> smscallback) {

    }
}


