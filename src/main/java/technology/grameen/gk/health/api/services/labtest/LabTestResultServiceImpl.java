package technology.grameen.gk.health.api.services.labtest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.LabTestDetail;
import technology.grameen.gk.health.api.repositories.LabTestResultRepository;

import java.util.List;
import java.util.Set;

@Service
public class LabTestResultServiceImpl implements LabTestResultService {

    LabTestResultRepository resultRepository;

    LabTestResultServiceImpl(LabTestResultRepository resultRepository){
        this.resultRepository = resultRepository;
    }

    @Override
    @Transactional
    public List<LabTestDetail> saveAll(Set<LabTestDetail> details) {
        return resultRepository.saveAll(details);
    }
}
