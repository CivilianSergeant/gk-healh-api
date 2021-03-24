package technology.grameen.gk.health.api.services.card_registration;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.CardMember;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.repositories.CardMemberRepository;
import technology.grameen.gk.health.api.requests.CardMemberPatient;

@Service
public class CardMemberServiceImpl implements CardMemberService {

    private CardMemberRepository cardMemberRepository;

    public CardMemberServiceImpl(CardMemberRepository cardMemberRepository) {
        this.cardMemberRepository = cardMemberRepository;
    }

    @Override
    public CardMember updateMember(CardMember member) {
        return cardMemberRepository.save(member);
    }
}
