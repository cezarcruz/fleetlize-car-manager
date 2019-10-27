package com.fleetlize.webapp.gateways.jms;

import com.fleetlize.webapp.configurations.JmsParams;
import com.fleetlize.webapp.entities.Car;
import com.fleetlize.webapp.gateways.jms.mapper.CarCreationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarCreationNotifier {

    private JmsTemplate jmsTemplateTopic;
    private JmsParams jmsParams;
    private CarCreationMapper carCreationMapper;

    public CarCreationNotifier(final JmsTemplate jmsTemplateTopic,
                               final JmsParams jmsParams,
                               final CarCreationMapper carCreationMapper) {
        this.jmsTemplateTopic = jmsTemplateTopic;
        this.jmsParams = jmsParams;
        this.carCreationMapper = carCreationMapper;
    }

    public void notify(final Car car) {

        log.info("notify car creation stream");
        log.debug("notify car creation in topic {}", jmsParams.getCarCreation());

        final var from = carCreationMapper.from(car);

        log.debug("notify car creation message {}", from);

        jmsTemplateTopic.convertAndSend(jmsParams.getCarCreation(), from.toString());
    }

}
