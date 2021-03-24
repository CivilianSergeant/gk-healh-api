package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.entity.FeedingRule;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.FeedingRuleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feeding-rules")
public class FeedingRuleController{

    private FeedingRuleService feedingRuleService;

    FeedingRuleController(FeedingRuleService feedingRuleService){
        this.feedingRuleService = feedingRuleService;
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getAllRules(){
        return new ResponseEntity<>(
                new EntityCollectionResponse<>(HttpStatus.OK.value(),
                        feedingRuleService.getAllFeedingRules()),HttpStatus.OK);
    }
}
