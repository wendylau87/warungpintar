package com.warungpintar.simpleapi.service;

import com.warungpintar.simpleapi.model.Greet;

import java.util.List;

public interface FileService {
    public boolean save(Greet greet);

    public List<Greet> readAll();
}
