package technology.grameen.gk.health.api.services.card_registration;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.CardRegistration;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.repositories.CardMemberRepository;
import technology.grameen.gk.health.api.repositories.CardRegistrationRepository;
import technology.grameen.gk.health.api.repositories.PatientInvoiceRepository;
import technology.grameen.gk.health.api.repositories.PatientRepository;
import technology.grameen.gk.health.api.services.PatientManageService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardRegistrationServiceImpl  implements  CardRegistrationService{

    PatientManageService patientService;
    CardRegistrationRepository cardRegistrationRepository;
    CardMemberRepository cardMemberRepository;

    CardRegistrationServiceImpl(PatientManageService patientService,
                                CardRegistrationRepository cardRegistrationRepository,
                                CardMemberRepository cardMemberRepository){

        this.patientService = patientService;
        this.cardRegistrationRepository = cardRegistrationRepository;
        this.cardMemberRepository = cardMemberRepository;
    }

    @Override
    public CardRegistration getNewCardRegistrationRequest(Patient patient) {
        return (patient.getRegistration().getId()==null)? patient.getRegistration() : null;
    }

    @Override
    @Transactional
    public Boolean register(Patient patient) throws Exception{

        CardRegistration cardRegistration = patient.getRegistration();//getNewCardRegistrationRequest(patient);

        // find patient's expired cardRegistration for renew

        if(cardRegistration != null) {
            Patient _patient = patientService.getReference(patient.getId());


            if (_patient == null) {
                throw new Exception("Patient Not found");
            }


            HealthCenter center = patient.getCenter();
            cardRegistration.setCardNumber(getCardNumber(center));
            cardRegistration.setStartDate(getRegistrationStartDate());
            cardRegistration.setExpiredDate(getRegistrationExpireDate(cardRegistration.getValidityDuration()));
            cardRegistration.setTotalServiceTaken(0);
            patient.addRegistration(cardRegistration);
            cardRegistration.setActive(true);
            cardRegistrationRepository.save(cardRegistration);

            if (cardRegistration.getId() > 0) {
                cardRegistration.getMembers()
                        .stream()
                        .map(cardMember -> {
                            cardMember.setCardRegistration(cardRegistration);

                            return cardMember;
                        }).collect(Collectors.toSet());
                cardMemberRepository.saveAll(cardRegistration.getMembers());
                return true;
            }

        }
        return false;
    }

    String getCardNumber(HealthCenter center){
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        int month = (calendar.get(Calendar.MONTH));
        int maxId = patientService.getMaxCardRegId();
        return center.getCenterCode()+"-"+ year + (((month+1)<10)? "0"+(month+1) :
                (month+1)) + ((maxId<10)? "0"+maxId : maxId);
    }

    LocalDateTime getRegistrationStartDate(){

        return LocalDateTime.now();
    }

    LocalDateTime getRegistrationExpireDate(Integer duration){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,duration);
        ZoneId zoneId = calendar.getTimeZone().toZoneId();
        return LocalDateTime.ofInstant(calendar.toInstant(),zoneId);
    }
}
