package kz.greetgo.sandbox.controller.register;

import kz.greetgo.sandbox.controller.model.ClientDisplay;
import kz.greetgo.sandbox.controller.model.ClientToEdit;
import kz.greetgo.sandbox.controller.model.ClientToSave;
import kz.greetgo.sandbox.controller.model.PageFilter;
import kz.greetgo.sandbox.controller.model.PersonRecord;

import java.util.List;

public interface ClientRegister {

  ClientToEdit getClient(String clientId);

  List<ClientDisplay> list(PageFilter pageFilter);

  void saveClient(ClientToSave clientToSave);

  Boolean deleteClientById(String id);

}
