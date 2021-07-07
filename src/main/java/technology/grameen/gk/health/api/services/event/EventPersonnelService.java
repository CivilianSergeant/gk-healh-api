package technology.grameen.gk.health.api.services.event;

import technology.grameen.gk.health.api.entity.EventPersonnel;

public interface EventPersonnelService {

    final static String MAIN="main";
    final static String ASSISTANT="assistant";


    EventPersonnel addEventPersonnel(EventPersonnel eventPersonnel);
}
