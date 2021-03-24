package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.FeedingRule;
import technology.grameen.gk.health.api.repositories.FeedingRuleRepository;

import java.util.List;

@Service
public class FeedingRuleServiceImpl implements FeedingRuleService {

    private FeedingRuleRepository feedingRuleRepository;

    FeedingRuleServiceImpl(FeedingRuleRepository feedingRuleRepository){
        this.feedingRuleRepository = feedingRuleRepository;
    }

    @Override
    public List<FeedingRule> getAllFeedingRules() {
        return feedingRuleRepository.findAll();
    }
}
