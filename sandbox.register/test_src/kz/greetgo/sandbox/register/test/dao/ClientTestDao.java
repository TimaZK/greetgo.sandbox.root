package kz.greetgo.sandbox.register.test.dao;

import kz.greetgo.sandbox.controller.model.ClientDisplay;
import kz.greetgo.sandbox.controller.model.ClientToSave;
import kz.greetgo.sandbox.controller.model.PersonDisplay;
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

  @Delete("delete from client")
  void deleteAll();

  @Select("select * from Client")
  List<ClientDisplay> list();
}
