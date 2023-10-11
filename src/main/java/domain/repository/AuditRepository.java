package domain.repository;

import domain.model.Audit;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс представляет собой репозиторий для хранения аудиторских записей.
 */
public class AuditRepository {
    List <Audit> operations = new ArrayList<Audit>();

    /**
     * Метод сохраняет операцию игрока в репозиторий.
     *
     * @param operation операция, которую необходимо сохранить.
     */
    public void saveOperation(Audit operation){
        operations.add(operation);}
    /**
     * Метод выводит информацию об аудиторских записях в репозитории в консоль.
     * Каждая запись выводится в формате:
     * Дата и время операции Тип операции (регистрация,авторизация, дебит, кредит)  Имя пользователя игрока
     */
    public void showAudit(){
        for (int i = 0; i < operations.size();i++)
             {
                 System.out.println("---------------------------------------------------------");
                 System.out.println(operations.get(i).getTime() + " " + operations.get(i).getTypeOperation()  + " " + operations.get(i).getUsername());

             }


        }
}
