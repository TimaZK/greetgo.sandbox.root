package kz.greetgo.sandbox.register.impl;

import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.sandbox.controller.model.*;
import kz.greetgo.sandbox.controller.register.ClientRegister;
import kz.greetgo.sandbox.register.test.dao.ClientTestDao;
import kz.greetgo.sandbox.register.test.util.ParentTestNg;
import kz.greetgo.util.RND;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ClientRegisterImplTest extends ParentTestNg {

  public BeanGetter<ClientTestDao> clientTestDao;
  public BeanGetter<ClientRegister> clientRegister;

  @BeforeMethod
  public void deleteAll() {
    clientTestDao.get().deleteAll();
  }


  @Test
  public void sortWithIdAsc() {

    List<ClientDisplay> clientDisplaysArr = new ArrayList<>();
    for (int i=1; i<101; i++) {

      String id = Integer.toString(i);
      String surname = generate(10);
      String name = generate(10);
      String patronymic = generate(10);
      ClientDisplay clientDisplay = new ClientDisplay();
      clientDisplay.id = id;
      clientDisplay.fio = surname + ' ' + ' ' + name + ' ' + patronymic;

      clientDisplaysArr.add(clientDisplay);

      ClientToSave clientToSave = new ClientToSave();
      clientToSave.setId(id);
      clientToSave.setLastName(surname);
      clientToSave.setFirstName(name);
      clientToSave.setPatron(patronymic);

      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(id, id, 9999f, "100");

    }

    PageFilter pageFilter = new PageFilter("", "id", "asc", 100, 0);


    //

    List<ClientDisplay> clientDisplay = clientRegister.get().list(pageFilter);

    //


    for (int i=0; i<100; i++) {
      assertThat(clientDisplaysArr.get(i).id).isEqualTo(clientDisplay.get(i).id);
    }

  }




  @Test
  public void clientWithNullValueTest() {
    clientRegister.get().saveClient(null);
  }


  private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
  private static final SecureRandom RANDOM = new SecureRandom();

  public static String generate(int count) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; ++i) {
      sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
    }
    return sb.toString();
  }



}
