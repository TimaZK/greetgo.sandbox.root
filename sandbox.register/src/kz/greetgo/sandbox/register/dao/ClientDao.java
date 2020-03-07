package kz.greetgo.sandbox.register.dao;

import kz.greetgo.sandbox.controller.model.ClientDisplay;
import kz.greetgo.sandbox.controller.model.ClientToEdit;
import kz.greetgo.sandbox.controller.model.ClientToSave;
import kz.greetgo.sandbox.controller.model.PersonDisplay;
import kz.greetgo.sandbox.controller.model.PersonRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClientDao {
  @Select("select client.id, surname||' '||name||' '||patronymic as fio " +
    "from Client inner join client_account on client.id = client_account.client limit 5")
  List<ClientDisplay> list();

  @Select("select id, surname, name, patronymic, gender, birth_date, charm from client "
    + "where id = #{clientId} and actual = 1")
  ClientToEdit getClientDetail(@Param("clientId") String clientId);

  @Insert("insert into Client "
    + "values (#{client.id}, #{client.surname}, #{client.name}, #{client.patronymic})")
  void saveClient(@Param("client") ClientToSave client
  );
}
