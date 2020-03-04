package kz.greetgo.sandbox.register.test.dao;

import kz.greetgo.sandbox.controller.model.Address;
import kz.greetgo.sandbox.controller.model.ClientDisplay;
import kz.greetgo.sandbox.controller.model.ClientToSave;
import kz.greetgo.sandbox.controller.model.PersonDisplay;
import kz.greetgo.sandbox.controller.model.Phones;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClientTestDao {
  @Insert("insert into Client "
    + "values (#{client.id}, #{client.lastName}, #{client.firstName}, #{client.patron})")
  void saveClient(@Param("client") ClientToSave client
  );

  @Insert("insert into client_account values (#{id}, #{clientId}, #{money}, #{number})")
  void saveAccountDatas(@Param("id") String id,
                        @Param("clientId") String clientId,
                        @Param("money") Float money,
                        @Param("number") String number);

  @Insert("insert into client_addr values (#{id}, #{clientId}, #{address.type}, #{address.street}, #{address.house}, #{address.flat})")
  void saveClientAddress(@Param("id") String id,
                         @Param("clientId") String clientId,
                         @Param("address")Address address);

  @Delete("delete from client")
  void deleteAll();

  @Select("select * from Client")
  List<ClientDisplay> list();


  @Insert("insert into client_phone values (#{id}, #{clientId}, #{phone.number}, #{phone.type})")
  void saveClientPhone(@Param("id") String id,
                       @Param("clientId") String clientId,
                       @Param("phone") Phones phone);

  @Select("select client.id, surname||' '||name||' '||patronymic as fio from client where (#{id})")
  ClientDisplay getClientDetails(@Param("id") String id);

}
