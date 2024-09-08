package com.picpay2.picpay.services;

import com.picpay2.picpay.client.NotificationClient;
import com.picpay2.picpay.entities.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
   @Autowired
   private NotificationClient notificationClient;

   private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

   public final void sendNotification(Transfer transfer) {
      try {
         logger.info("Sending notification...");
         ResponseEntity<Void> response = this.notificationClient.sendNotification(transfer);

         if(response.getStatusCode().isError()) {
            logger.error("Error while sending notification, status code is not OK");
         }
      } catch (Exception e) {
         logger.error("Error while sending notification", e);
      }
   }
}
