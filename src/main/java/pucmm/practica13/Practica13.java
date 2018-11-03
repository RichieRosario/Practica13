package pucmm.practica13;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import pucmm.practica13.service.Productor;

import javax.jms.JMSException;

import java.util.Timer;
import java.util.TimerTask;

import static pucmm.practica13.config.JmsConfig.notificacion_sensores;

@SpringBootApplication
@EnableJms

public class Practica13  {

	static Productor p = new Productor();
	public static String dispositivo1 = "1";
	public static String dispositivo2 = "2";


	public static void main(String[] args) {
		SpringApplication.run(Practica13.class, args);

		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				try {
					p.enviarMensaje(notificacion_sensores,dispositivo1);
					p.enviarMensaje(notificacion_sensores,dispositivo2);
				} catch (Exception ex) {
					Thread t = Thread.currentThread();
					t.getUncaughtExceptionHandler().uncaughtException(t, ex);
				}
			}

		}, 0, 50000);
	}





}

