package kz.greetgo.sandbox.register.impl;

import java.util.Comparator;
import java.util.Date;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.sandbox.controller.model.*;
import kz.greetgo.sandbox.controller.register.ClientRegister;
import kz.greetgo.sandbox.register.test.dao.ClientTestDao;
import kz.greetgo.sandbox.register.test.util.ParentTestNg;
import kz.greetgo.util.RND;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;

public class ClientRegisterImplTest extends ParentTestNg {

  public BeanGetter<ClientTestDao> clientTestDao;
  public BeanGetter<ClientRegister> clientRegister;

  @BeforeMethod
  public void deleteAll() {
    clientTestDao.get().deleteAll();
    clientTestDao.get().deleteAllCharm();
  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_Id_asc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "id", "asc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId));

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_Id_desc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "id", "desc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId).reversed());

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_fio_asc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "fio", "asc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId));

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_fio_desc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "fio", "desc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId).reversed());

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_character_asc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "character", "asc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId));

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_character_desc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "character", "desc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId).reversed());

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_total_balance_asc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "totalBalanceOfAccounts", "asc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId));

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_total_balance_desc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "totalBalanceOfAccounts", "desc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId).reversed());

  }

  //TODO смотри выше

  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_maximum_balance_asc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "maximumBalance", "asc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId));

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_maximum_balance_desc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "maximumBalance", "desc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId).reversed());

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_minimum_balance_asc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "minimumBalance", "asc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId));

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_sort_with_minimum_balance_desc() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "minimumBalance", "desc", 100, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    assertThat(clientDisplayArr).isSortedAccordingTo(Comparator.comparing(ClientDisplay::getId).reversed());

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_pagination_first_page() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "", "", 5, 0);

    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(5);

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_pagination_last_page() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "", "", 5, 3);


    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(5);

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_pagination_random_page() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "", "", 5, getRandomNumberInRange(0,3));


    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(5);

  }


  @Test(expectedExceptions = RuntimeException.class)
  public void test_pagination_more_data_than_pagesize() {

    saveClientWithData();
    PageFilter pageFilter = new PageFilter("", "", "", 7, 2);


    //

      List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(6);

  }


  @Test(expectedExceptions = NullPointerException.class)
  public void test_save_client_with_null_address() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveClientAddress("1", "1", null);

    //

      ClientToEdit client = clientRegister.get().getClient(clientToSave.id);

    //

    assertThat(client.getFactAddress()).isNull();
    assertThat(client.getRegAddress()).isNull();
  }


  @Test(expectedExceptions = NullPointerException.class)
  public void test_save_client_with_null_phone() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveClientPhone("1", "1", null);

    //

    ClientToEdit client = clientRegister.get().getClient(clientToSave.id);

    //

    assertThat(client.getPhones()).isNull();
  }


  @Test(expectedExceptions = NullPointerException.class)
  public void test_client_detailIs_not_null() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);

    //

      ClientToEdit client = clientRegister.get().getClient(clientToSave.id);

    //

    assertThat(client).isNotNull();
    assertThat(client.getId()).isNotNull();
    assertThat(client.getLastName()).isNotNull();
    assertThat(client.getFirstName()).isNotNull();
    assertThat(client.getPatron()).isNotNull();
    assertThat(client.getCharm()).isNotNull();
    assertThat(client.getGender()).isNotNull();
    assertThat(client.getRegAddress()).isNotNull();
    assertThat(client.getFactAddress()).isNotNull();
    assertThat(client.getBirthDay()).isNotNull();
    assertThat(client.getPhones()).isNotNull();
  }


  @Test(expectedExceptions = NullPointerException.class)
  public void test_client_detailIs_null() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);

    //

      ClientToEdit client = clientRegister.get().getClient(null);

    //

    assertThat(client).isNull();

  }


  @Test(expectedExceptions = NullPointerException.class)
  public void test_save_client_with_null_charm() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);

    //

      ClientToEdit client = clientRegister.get().getClient(clientToSave.id);

    //

    assertThat(client.getCharm()).isNull();
  }


  @Test(expectedExceptions = NullPointerException.class)
  public void test_balance_null_value() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    PageFilter pageFilter = new PageFilter("", "", "", 5, 0);

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveAccountDatas("1", clientToSave.id, null, null);

    //

      List<ClientDisplay> list = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < list.size(); i++) {
      assertThat(list.get(i).totalBalanceOfAccounts).isNull();
      assertThat(list.get(i).maximumBalance).isNull();
      assertThat(list.get(i).minimumBalance).isNull();
    }
  }


  @Test(expectedExceptions = NullPointerException.class)
  public void test_save_client_with_address() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");
    Address address = rndAddress();

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveClientAddress("1", "1", address);

    //

      ClientToEdit client = clientRegister.get().getClient(clientToSave.id);

    //

    assertThat(client.getFactAddress()).isNotNull();
    assertThat(client.getRegAddress()).isNotNull();

  }


  @Test(expectedExceptions = NullPointerException.class)
  public void test_save_client_with_phone() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");
    Phones phone = rndPhones();

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveClientPhone("1", "1", phone);

    //

      ClientToEdit client = clientRegister.get().getClient(clientToSave.id);

    //

    assertThat(client.getPhones()).isNotNull();

  }


  @Test(expectedExceptions = NullPointerException.class)
  public void test_save_client_with_all_values() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");
    Address address = rndAddress();
    Phones phone = rndPhones();

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveClientAddress("1", "1", address);
    clientTestDao.get().saveClientPhone("1", "1", phone);

    //

      ClientToEdit client = clientRegister.get().getClient(clientToSave.id);

    //

    assertThat(client.getPhones()).isNotNull();
    assertThat(client.getFactAddress()).isNotNull();
    assertThat(client.getRegAddress()).isNotNull();


  }



  private static int getRandomNumberInRange(int min, int max) {

    if (min >= max) {
      throw new IllegalArgumentException("max must be greater than min");
    }

    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }



  Charm rndCharm() {
    Charm charm = new Charm();
    charm.setName(generate(5));

    return charm;
  }


  ClientToSave rndClientToSave() {
    ClientToSave clientToSave = new ClientToSave();
    clientToSave.setLastName(generate(5));
    clientToSave.setFirstName(generate(5));
    clientToSave.setPatron(generate(5));
    clientToSave.setGender(Gender.MALE);
    clientToSave.setBirthDay(new Date());

    return clientToSave;
  }


  Address rndAddress() {
    Address address = new Address();
    address.setStreet(generate(10));
    address.setHouse(RND.plusInt(1));
    address.setFlat(RND.plusInt(1));
    address.setType(AddressType.FACT);

    return address;
  }


  Phones rndPhones() {
    Phones phone = new Phones();
    phone.setId(generate(1));
    phone.setNumber(generate(11));
    phone.setType(PhoneType.MOBILE);

    return phone;
  }


  void saveClientWithData() {
    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));

      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
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
