package bcntec.training.springboot.microservices.scalecloud.book.controller;

import bcntec.training.springboot.microservices.scalecloud.book.component.BookingComponent;
import bcntec.training.springboot.microservices.scalecloud.book.component.BookingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;


interface BookingSink {
    public static String CHECKINQ = "checkInQ";

    @Input("checkInQ")
    public MessageChannel checkInQ();

}

@EnableBinding(BookingSink.class)
@Component
public class Receiver {


    @Autowired
    BookingComponent bookingComponent;

    public Receiver() {

    }

    /**
     * public Receiver(BookingComponent bookingComponent){
     * this.bookingComponent = bookingComponent;
     * }
     *
     * @RabbitListener(queues = "CheckInQ")
     * public void processMessage(long bookingID ) {
     * bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingID);
     * }
     **/
    @ServiceActivator(inputChannel = BookingSink.CHECKINQ)
    public void accept(long bookingID) {
        bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingID);
    }
}