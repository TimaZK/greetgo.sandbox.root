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
import java.util.Random;

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

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "id", "asc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).id).isEqualTo(clientDisplayMockData.get(i).id);
    }
  }


  @Test
  public void sortWithIdDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "id", "desc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).id).isEqualTo(clientDisplayMockData.get(i).id);
    }
  }


  @Test
  public void sortWithFioAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "fio", "asc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).fio).isEqualTo(clientDisplayMockData.get(i).fio);
    }
  }


  @Test
  public void sortWithFioDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "fio", "desc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).fio).isEqualTo(clientDisplayMockData.get(i).fio);
    }
  }


  @Test
  public void sortWithCharAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "character", "asc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).character).isEqualTo(clientDisplayMockData.get(i).character);
    }
  }


  @Test
  public void sortWithCharDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "character", "desc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).character).isEqualTo(clientDisplayMockData.get(i).character);
    }
  }


  @Test
  public void sortWithTotalAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "totalBalanceOfAccounts", "asc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).totalBalanceOfAccounts).isEqualTo(clientDisplayMockData.get(i).totalBalanceOfAccounts);
    }
  }


  @Test
  public void sortWithTotalDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "totalBalanceOfAccounts", "desc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).totalBalanceOfAccounts).isEqualTo(clientDisplayMockData.get(i).totalBalanceOfAccounts);
    }
  }


  @Test
  public void sortWithMaxAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "maximumBalance", "asc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).maximumBalance).isEqualTo(clientDisplayMockData.get(i).maximumBalance);
    }
  }


  @Test
  public void sortWithMaxDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "maximumBalance", "desc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).maximumBalance).isEqualTo(clientDisplayMockData.get(i).maximumBalance);
    }
  }


  @Test
  public void sortWithMinAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "minimumBalance", "asc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).minimumBalance).isEqualTo(clientDisplayMockData.get(i).minimumBalance);
    }
  }


  @Test
  public void sortWithMinDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "minimumBalance", "desc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).minimumBalance).isEqualTo(clientDisplayMockData.get(i).minimumBalance);
    }
  }


  @Test
  public void paginFirstPage() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "", "", 5, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(5);
  }


  @Test
  public void paginLastPage() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "", "", 5, 3);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(5);
  }


  @Test
  public void paginRndPage() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "", "", 5, getRandomNumberInRange(0,3));
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(5);
  }


  @Test
  public void paginMoreDataThanPageSize() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      clientTestDao.get().saveClient(clientToSave);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "", "", 7, 2);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(6);
  }


  @Test
  public void addressNull() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    clientTestDao.get().saveClient(clientToSave);
    clientTestDao.get().saveClientAddress("1", "1", null);

  }


  @Test
  public void phoneNull() {
    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
//    System.out.println(clientToSave);
    clientTestDao.get().saveClient(clientToSave);
    clientTestDao.get().saveClientPhone("1", "1", null);
  }









  private static int getRandomNumberInRange(int min, int max) {

    if (min >= max) {
      throw new IllegalArgumentException("max must be greater than min");
    }

    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }



  ClientToSave rndClientToSave() {
    ClientToSave clientToSave = new ClientToSave();
    clientToSave.setLastName(generate(5));
    clientToSave.setFirstName(generate(5));
    clientToSave.setPatron(generate(5));

    return clientToSave;
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
