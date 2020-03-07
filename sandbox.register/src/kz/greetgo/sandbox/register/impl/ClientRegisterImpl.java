package kz.greetgo.sandbox.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.sandbox.controller.model.ClientDisplay;
import kz.greetgo.sandbox.controller.model.ClientToEdit;
import kz.greetgo.sandbox.controller.model.ClientToSave;
import kz.greetgo.sandbox.controller.model.PageFilter;
import kz.greetgo.sandbox.controller.register.ClientRegister;
import kz.greetgo.sandbox.register.dao.ClientDao;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

@Bean
public class ClientRegisterImpl implements ClientRegister {
  public BeanGetter<ClientDao> clientDao;

  @Override
  public ClientToEdit getClient(String clientId) {
    return clientDao.get().getClientDetail(clientId);

  }

  @Override
  public List<ClientDisplay> list(PageFilter pageFilter) {
//    throw new RuntimeException();
      return clientDao.get().list();
  }

  @Override
  public void saveClient(ClientToSave client) {
    throw new RuntimeException();
  }

  @Override
  public Boolean deleteClientById(String id) {
    throw new RuntimeException();
  }


}
