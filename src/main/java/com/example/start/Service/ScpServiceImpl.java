package com.example.start.Service;

import com.example.start.Model.Scp;
import com.example.start.Repository.ScpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScpServiceImpl implements ScpService{
    @Autowired
    private ScpRepository scpRepository;

    @Override
    public List<Scp> getAllScps() {
        return scpRepository.findAll();
    }

    @Override
    public void saveScp(Scp scp) {
        this.scpRepository.save(scp);
    }

    @Override
    public Scp getScpById(long id) {
        Optional<Scp> optional = scpRepository.findById(id);
        Scp scp = null;
        if (optional.isPresent())
            scp = optional.get();
        else throw new RuntimeException("SCP NOT FOUND FOR ID" + id);
        return scp;
    }

    @Override
    public void deleteScp(long id) {
        this.scpRepository.deleteById(id);
    }

    @Override
    public Page<Scp> findPaginated(int pageNr, int pageSize) {
        Pageable pageable = PageRequest.of(pageNr - 1, pageSize);
        return this.scpRepository.findAll(pageable);
    }
}
