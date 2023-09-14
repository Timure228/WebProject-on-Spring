package com.example.start.Service;

import com.example.start.Model.Scp;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public interface ScpService {
    List<Scp> getAllScps();

    void saveScp(Scp scp);

    Scp getScpById(long id);

    void deleteScp(long id);

    Page<Scp> findPaginated(int pageNr, int pageSize);
}
