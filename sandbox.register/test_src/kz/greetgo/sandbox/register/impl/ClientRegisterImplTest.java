package kz.greetgo.sandbox.register.impl;

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


  @Test
  public void sortWithIdAsc() {

    //TODO сделай форики одинаковыми и попробуй вынести функцию создания массива людей
    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));

      //TODO Вынести в одну функцию типо saveClientWithData
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    //TODO не нужно вытаскивать моковые данные из чтобы проверить сортировку используй компараторы и функции класса AssertThat

    //   assertThat(pageOfClients.clientsListOfPage).isSortedAccordingTo(Comparator.comparing(ClientRecord::getMinBalance).reversed());

    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    //TODO PageFilter должен быть выше
    PageFilter pageFilter = new PageFilter("", "id", "asc", 100, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //

    for (int i = 0; i < 20; i++) {
      assertThat(clientDisplayArr.get(i).id).isEqualTo(clientDisplayMockData.get(i).id);
    }
  }


  @Test
  public void sortWithIdDesc() {

    //TODO смотри выше

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithFioAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithFioDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithCharAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithCharDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithTotalAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithTotalDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithMaxAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithMaxDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithMinAsc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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

  //TODO смотри выше

  @Test
  public void sortWithMinDesc() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    //TODO Не используешь значени функции - удали
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //
    //TODO смотри выше

    PageFilter pageFilter = new PageFilter("", "", "", 5, 0);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(5);
  }


  //TODO смотри выше
  @Test
  public void paginLastPage() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "", "", 5, 3);
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(5);
  }

  //TODO смотри выше
  @Test
  public void paginRndPage() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
      clientTestDao.get().saveAccountDatas(Integer.toString(i), clientToSave.id, 9999f, "100");
    }
    List<ClientDisplay> clientDisplayMockData = clientTestDao.get().list();


    //

    PageFilter pageFilter = new PageFilter("", "", "", 5, getRandomNumberInRange(0,3));
    List<ClientDisplay> clientDisplayArr = clientRegister.get().list(pageFilter);

    //


    assertThat(clientDisplayArr.size()).isEqualTo(5);
  }

  //TODO смотри выше
  @Test
  public void paginMoreDataThanPageSize() {

    for (int i = 1; i < 21; i++) {
      ClientToSave clientToSave = rndClientToSave();
      clientToSave.setId(Integer.toString(i));
      Charm charm = rndCharm();
      charm.setId(Integer.toString(i));
      clientTestDao.get().saveCharm(charm);
      clientTestDao.get().saveClient(clientToSave, charm.id);
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
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveClientAddress("1", "1", null);

    //TODO ты не ничего не проверяешь здесь
  }


  @Test
  public void phoneNull() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveClientPhone("1", "1", null);
    //TODO ты не ничего не проверяешь здесь
  }


  @Test
  public void clientDetailIsNotNull() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);

    //

      ClientDisplay clientDisplay1 = clientRegister.get().getClient(clientToSave.id);

    //
    //TODO Мало проверять один обьект на IsNotNull
    assertThat(clientDisplay1).isNotNull();
  }


  @Test

  public void clientDetailIsNull() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);

    //

      ClientDisplay clientDisplay1 = clientRegister.get().getClient(null);

    //
    //TODO ТЫ не должен сохранять NULL человека

    assertThat(clientDisplay1).isNull();
  }



  @Test
  public void clientAllValuesWithoutIdAndFioNullSaved() {

    //TODO Этот тест не нужен вообще, ты не проверяешь тут модель которую не нужно вытаскивать в клиент в 1 экземпляре

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");
    PageFilter pageFilter = new PageFilter("", "id", "asc", 100, 0);

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);

    //

    ClientDisplay clientDisplay1 = clientRegister.get().getClient(clientToSave.id);

    //

    assertThat(clientDisplay1.fio).isNotNull();
    assertThat(clientDisplay1.age).isNull();
    assertThat(clientDisplay1.character).isNull();
    assertThat(clientDisplay1.totalBalanceOfAccounts).isNull();
    assertThat(clientDisplay1.maximumBalance).isNull();
    assertThat(clientDisplay1.minimumBalance).isNull();

  }


  @Test
  public void clientSaveWithNullCharm() {

    //TODO Нельзя сохранять NULL данные

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);

    //

    ClientDisplay clientDisplay1 = clientRegister.get().getClient(clientToSave.id);

    //

    assertThat(clientDisplay1.character).isNull();
  }


  @Test
  public void balanceNullValue() {

    //TODO Нельзя сохранять NULL данные


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


  @Test
  public void saveClientWithAddress() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");
    Address address = rndAddress();

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveClientAddress("1", "1", address);

    //TODO Нету проверки

  }


  @Test
  public void saveClientWithPhone() {

    ClientToSave clientToSave = rndClientToSave();
    clientToSave.setId("1");
    Charm charm = rndCharm();
    charm.setId("1");
    Phones phone = rndPhones();

    clientTestDao.get().saveCharm(charm);
    clientTestDao.get().saveClient(clientToSave, charm.id);
    clientTestDao.get().saveClientPhone("1", "1", phone);
    //TODO Нету проверки

  }


  @Test
  public void saveClientWithAllValues() {

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
    //TODO Нету проверки


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
