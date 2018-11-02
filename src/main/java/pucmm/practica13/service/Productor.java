package pucmm.practica13.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import pucmm.practica13.model.Mensaje;
import jdk.nashorn.api.scripting.JSObject;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static pucmm.practica13.config.JmsConfig.notificacion_sensores;

public class Productor {
    @Autowired
    private JmsTemplate jmsTemplate;



    public void enviarMensaje(String cola, String idDispositivo) throws JMSException {



        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection("admin", "admin");
        connection.start();


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


        Topic topic = session.createTopic(cola);
        MessageProducer producer = session.createProducer(topic);


        double temperatura = Math.round(Math.random()*100);
        double humedad =Math.round(Math.random()*100);

        Mensaje mensj = new Mensaje();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        mensj.setFechaGeneracion(format.format(new Date()));
        mensj.setHumedad(humedad);
        mensj.setTemperatura(temperatura);
        mensj.setIdDispositivo(Integer.parseInt(idDispositivo));

        System.out.println(mensj.toString());

        Gson gson = new Gson();
        String mensaje = gson.toJson(mensj);
        TextMessage message = session.createTextMessage(mensaje);
        producer.send(message);


        producer.close();
        session.close();
        connection.stop();


    }
}
