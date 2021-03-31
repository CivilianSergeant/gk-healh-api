package technology.grameen.gk.health.api.services.labtest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.LabTest;
import technology.grameen.gk.health.api.entity.LabTestDetail;
import technology.grameen.gk.health.api.projection.LabTestDetailItem;
import technology.grameen.gk.health.api.projection.LabTestListItem;
import technology.grameen.gk.health.api.repositories.LabTestRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LabTestServiceImpl implements LabTestService {

    private LabTestRepository labTestRepository;
    private LabTestResultService resultService;

    LabTestServiceImpl(LabTestRepository labTestRepository,
                       LabTestResultService resultService){
        this.labTestRepository = labTestRepository;
        this.resultService = resultService;
    }

    @Override
    @Transactional
    public LabTest saveLabTest(LabTest labTest) {

        Set<LabTestDetail> details = labTest.getDetails();
        technology.grameen.gk.health.api.entity.Service service = labTest.getService();
        service.addLabTest(labTest);
        LabTest labTest1 = labTestRepository.save(labTest);
        if(labTest1.getId() > 0){
            details.stream().map( d->{
                d.setLabTest(labTest1);
                return d;
            }).collect(Collectors.toSet());
            resultService.saveAll(details);
        }
        return labTest1;
    }

    @Override
    public List<LabTestListItem> getLabTestReports() {
        return labTestRepository.getLabTests();
    }

    @Override
    public Optional<LabTestDetailItem> getLabTestReportById(Long id) {
        return labTestRepository.findByLabTest(id);
    }
}
