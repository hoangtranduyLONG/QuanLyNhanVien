package service;

import model.Manage;

import java.util.List;

public interface ManageService extends GeneralService<Manage>{
    List<Manage> findAllByClass(int classId);
    List<Manage> findAllByNameContains(String name);
}
