package pucmm.practica13;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import pucmm.practica13.model.Mensaje;
import pucmm.practica13.service.MensajeService;
import pucmm.practica13.service.MensajeServiceImpl;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Map;

import static pucmm.practica13.config.JmsConfig.notificacion_sensores;

@Component
public class Listener {
    private static Logger log = LoggerFactory.getLogger(Listener.class);

    @Autowired
    MensajeServiceImpl mensajeService;

    @JmsListener(destination = notificacion_sensores)
    public void receiveTopicMessage(final TextMessage j) throws JMSException {

        Mensaje m = new Mensaje();
        m = new Gson().fromJson(j.getText(), Mensaje.class);
        mensajeService.Crear(m);


    }

}